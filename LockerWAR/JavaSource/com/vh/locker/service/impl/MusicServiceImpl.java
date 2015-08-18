/**
 * @file MusicServiceImpl
 * @author peter.szocs
 * 
 * Service methods related to user music files.
 */


package com.vh.locker.service.impl;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import org.apache.log4j.Logger;

import com.vh.locker.base.BaseServiceImpl;
import com.vh.locker.ejb.Album;
import com.vh.locker.ejb.AlbumHome;
import com.vh.locker.ejb.Artist;
import com.vh.locker.ejb.ArtistHome;
import com.vh.locker.ejb.FileType;
import com.vh.locker.ejb.FileTypeHome;
import com.vh.locker.ejb.Genre;
import com.vh.locker.ejb.GenreHome;
import com.vh.locker.ejb.Mixes;
import com.vh.locker.ejb.MixesHome;
import com.vh.locker.ejb.MusicFile;
import com.vh.locker.ejb.MusicFileHome;
import com.vh.locker.ejb.RelMusicMixes;
import com.vh.locker.ejb.RelMusicMixesHome;
import com.vh.locker.ejb.RelMusicMixesKey;
import com.vh.locker.ejb.User;
import com.vh.locker.service.MusicService;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.Constants;
import com.vh.locker.util.EJBHomeCache;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class MusicServiceImpl extends BaseServiceImpl implements MusicService {

  private static Logger log=Logger.getLogger(MusicServiceImpl.class);
  
  // homes:
  private AlbumHome           mAlbumHome          = null;
  private ArtistHome          mArtistHome         = null;
  private GenreHome           mGenreHome          = null;
  private MusicFileHome       mMusicFileHome      = null;
  private MixesHome           mMixesHome          = null;
  private RelMusicMixesHome   mRelMusicMixesHome  = null;
  private FileTypeHome        mFileTypeHome       = null;
  


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// MusicFile:

  /**
   * @see com.vh.locker.service.music.MusicService#createMusicFile(String, String, String, long, Date, String, long, Long, Long, Long)
   */
  public MusicFile createMusicFile(String artist, String songTitle, String albumTitle, long length, Date dateCreated, String link, long nofPlayed, String genre, String ext, Long userId) throws ServiceException {
    MusicFile ejb = null;
    Album anAlbum = null;
    Artist anArtist = null;
    Genre aGenre = null;
    FileType aFileType = null;
    User aUser = null;
    try {
      if((albumTitle==null) || (albumTitle.trim().length()==0)) anAlbum = getAlbumHome().findByPrimaryKey(new Long(1));
      else try {
        anAlbum = getAlbumHome().findByDescUser(albumTitle, userId);
      } catch(FinderException fe) {
        anAlbum = createAlbum(albumTitle, userId);
      }
      if(artist!=null) try {
        anArtist = getArtistHome().findByDescUser(artist, userId);
      } catch(FinderException fe) {
        anArtist = createArtist(artist, userId);
      }
      if((genre==null) || (genre.trim().length()==0)) aGenre = getGenreHome().findByPrimaryKey(new Long(1));
      else try {
        aGenre = getGenreHome().findByDescUser(genre, userId);
      } catch(FinderException fe) {
        aGenre = createGenre(genre, userId);
      }
      if(ext!=null) aFileType = getFileTypeHome().findByDesc(ext);
      if(userId!=null) aUser = findUserById(userId);
      ejb = getMusicFileHome().create(new Long(0), anArtist, songTitle, anAlbum, length, dateCreated, link, nofPlayed, aGenre, aFileType, aUser);
    } catch(Exception e) {
      log.error("MusicFile could not be created: "+e.toString());
      throw new ServiceException("MusicFile could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#deleteMusicFiles(String[], Long)
   */
  public boolean deleteMusicFiles(String[] songIds, Long userId) throws ServiceException {
    boolean deleted = false;
    try {
      User user = findUserById(userId);
      String userName = user.getUserName();
      for(int i=0;i<songIds.length;i++) {
        Long id = new Long(songIds[i]);
        MusicFile mp3 = findMusicFileById(id);
        File f = new File(Constants.FILEUPLOAD_PREFIX+userName+"/zdocs/music/"+mp3.getLink());
        f.delete();
        mp3.remove();
      }
      deleted=true;
    } catch(Exception e) {
      log.error("MusicFiles could not be deleted: "+e.toString());
      throw new ServiceException("MusicFiles could not be deleted: "+e.getMessage());
    }
    return deleted;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#updateMusicFile(Long, String, String, String, String, Long)
   */
  public boolean updateMusicFile(Long id, String artist, String songTitle, String albumTitle, String genre, Long userId) throws ServiceException {
    boolean updated = false;
    MusicFile mp3 = null;
    Artist anArtist = null;
    Album anAlbum = null;
    Genre aGenre = null;
    try {
      mp3 = getMusicFileHome().findByPrimaryKey(id);
      if(artist!=null) try {
        anArtist = getArtistHome().findByDescUser(artist, userId);
      } catch(FinderException fe) {
        anArtist = createArtist(artist, userId);
      }        
      if((albumTitle==null) || (albumTitle.trim().length()==0)) anAlbum = getAlbumHome().findByPrimaryKey(new Long(1));
      else try {
        anAlbum = getAlbumHome().findByDescUser(albumTitle, userId);
      } catch(FinderException fe) {
        anAlbum = createAlbum(albumTitle, userId);
      }
      if((genre==null) || (genre.trim().length()==0)) aGenre = getGenreHome().findByPrimaryKey(new Long(1));
      else try {
        aGenre = getGenreHome().findByDescUser(genre, userId);
      } catch(FinderException fe) {
        aGenre = createGenre(genre, userId);
      }      
      
      updated = mp3.update(anArtist, songTitle, anAlbum, aGenre);
    } catch(Exception e) {
      log.error("MusicFile could not be updated: "+e.toString());
      throw new ServiceException("MusicFile could not be updated: "+e.getMessage());
    }
    return updated;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMusicFileById(Long)
   */  
  public MusicFile findMusicFileById(Long id) throws ServiceException {
    MusicFile ejb = null;
    try {
      ejb = getMusicFileHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("MusicFile with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findMusicFileById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findMusicFileById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMusicFileByUser(Long)
   */  
  public Collection findMusicFileByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getMusicFileHome().findByUser(userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("MusicFile with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findMusicFileByUser with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findMusicFileByUser with userId=" + userId + " error: "+e.getMessage());
    }
    return list;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMusicFileByAlbum(Long)
   */  
  public Collection findMusicFileByAlbum(Long albumId) throws ServiceException {
    Collection list = null;
    try {
      list = getMusicFileHome().findByAlbum(albumId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("MusicFile with albumId=" + albumId + " could not be found");
    } catch(Exception e) {
      log.error("findMusicFileByAlbum with albumId=" + albumId + " error: "+e.toString());
      throw new ServiceException("findMusicFileByAlbum with albumId=" + albumId + " error: "+e.getMessage());
    }
    return list;          
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMusicFileByArtist(Long)
   */  
  public Collection findMusicFileByArtist(Long artistId) throws ServiceException {
    Collection list = null;
    try {
      list = getMusicFileHome().findByArtist(artistId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("MusicFile with artistId=" + artistId + " could not be found");
    } catch(Exception e) {
      log.error("findMusicFileByArtist with artistId=" + artistId + " error: "+e.toString());
      throw new ServiceException("findMusicFileByArtist with artistId=" + artistId + " error: "+e.getMessage());
    }
    return list;              
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMusicFileByGenre(Long)
   */  
  public Collection findMusicFileByGenre(Long genreId) throws ServiceException {
    Collection list = null;
    try {
      list = getMusicFileHome().findByGenre(genreId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("MusicFile with genreId=" + genreId + " could not be found");
    } catch(Exception e) {
      log.error("findMusicFileByGenre with genreId=" + genreId + " error: "+e.toString());
      throw new ServiceException("findMusicFileByGenre with genreId=" + genreId + " error: "+e.getMessage());
    }
    return list;              
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMusicFileByMix(Long)
   */  
  public Collection findMusicFileByMix(Long mixId) throws ServiceException {
    Collection list = null;
    try {
      list = getMusicFileHome().findByMix(mixId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("MusicFile with mixId=" + mixId + " could not be found");
    } catch(Exception e) {
      log.error("findMusicFileByMix with mixId=" + mixId + " error: "+e.toString());
      throw new ServiceException("findMusicFileByMix with mixId=" + mixId + " error: "+e.getMessage());
    }
    return list;                    
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMostRecentMusicFile(Long)
   */  
  public Collection findMostRecentMusicFile(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getMusicFileHome().findMostRecent(userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Most recent MusicFiles could not be found");
    } catch(Exception e) {
      log.error("findMostRecentMusicFile error: "+e.toString());
      throw new ServiceException("findMostRecentMusicFile error: "+e.getMessage());
    }
    return list;  
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Album:

  /**
   * @see com.vh.locker.service.music.MusicService#createAlbum(Long, String, Long)
   */
  public Album createAlbum(String desc, Long userId) throws ServiceException {
    Album ejb = null;
    User aUser = null;
    try {
      if(userId!=null) aUser=findUserById(userId);
      ejb = getAlbumHome().create(new Long(0), desc, aUser);
    } catch(Exception e) {
      log.error("Album could not be created: "+e.toString());
      throw new ServiceException("Album could not be created: "+e.getMessage());
    }
    return ejb;         
  }

  /**
   * @see com.vh.locker.service.music.MusicService#deleteAlbums(String[], Long)
   */
  public boolean deleteAlbums(String[] albumIds, Long userId) throws ServiceException {
    boolean deleted = false;
    try {
      for(int i=0;i<albumIds.length;i++) {
        Long albumId = new Long(albumIds[i]);
        Collection mp3Coll = findMusicFileByAlbum(albumId);
        deleteMp3s(mp3Coll, userId);
        findAlbumById(albumId).remove();
      }
      deleted=true;
    } catch(Exception e) {
      log.error("Delete albums error: "+e.toString());
      throw new ServiceException("Delete albums error: "+e.getMessage());
    }
    return deleted;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findAlbumById(Long)
   */     
  public Album findAlbumById(Long id) throws ServiceException {
    Album ejb = null;
    try {
      ejb = getAlbumHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Album with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findAlbumById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findAlbumById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;        
  }
    
  /**
   * @see com.vh.locker.service.music.MusicService#findAlbumByUser(Long)
   */    
  public Collection findAlbumByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getAlbumHome().findByUser(userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Album with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findAlbumByUser with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findAlbumByUser with userId=" + userId + " error: "+e.getMessage());
    }
    return list;          
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Artist:

  /**
   * @see com.vh.locker.service.music.MusicService#createArtist(String, Long)
   */
  public Artist createArtist(String desc, Long userId) throws ServiceException {
    Artist ejb = null;
    User aUser = null;
    try {
      if(userId!=null) aUser=findUserById(userId);
      ejb = getArtistHome().create(new Long(0), desc, aUser);
    } catch(Exception e) {
      log.error("Artist could not be created: "+e.toString());
      throw new ServiceException("Artist could not be created: "+e.getMessage());
    }
    return ejb;               
  }
    
  /**
   * @see com.vh.locker.service.music.MusicService#deleteArtists(String[], Long)
   */
  public boolean deleteArtists(String[] artistIds, Long userId) throws ServiceException {
    boolean deleted = false;
    try {
      for(int i=0;i<artistIds.length;i++) {
        Long artistId = new Long(artistIds[i]);
        Collection mp3Coll = findMusicFileByArtist(artistId);
        deleteMp3s(mp3Coll, userId);
        findArtistById(artistId).remove();
      }
      deleted=true;
    } catch(Exception e) {
      log.error("Delete artist error: "+e.toString());
      throw new ServiceException("Delete artist error: "+e.getMessage());
    }
    return deleted;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findArtistById(Long)
   */
  public Artist findArtistById(Long id) throws ServiceException {
    Artist ejb = null;
    try {
      ejb = getArtistHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Artist with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findArtistById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findArtistById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;        
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findArtistByUser(Long)
   */
  public Collection findArtistByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getArtistHome().findByUser(userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Artist with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findArtistByUser with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findArtistByUser with userId=" + userId + " error: "+e.getMessage());
    }
    return list;                
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Mixes:

  /**
   * @see com.vh.locker.service.music.MusicService#createMixes(String, long, Date, long)
   */
  public Long createMixes(String title, long length, Date dateCreated, long nofPlayed, Long genreId) throws ServiceException {
    Long id = null;
    Genre genre = null;
    try {
      if(genreId!=null) genre = getGenreHome().findByPrimaryKey(genreId);
      Mixes ejb = getMixesHome().create(new Long(0), title, length, dateCreated, nofPlayed, genre);
      id = ejb.getId();
    } catch(Exception e) {
      log.error("Mixes could not be created: "+e.toString());
      throw new ServiceException("Mixes could not be created: "+e.getMessage());
    }
    return id;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#deleteMixes(String[], Long)
   */
  public boolean deleteMixes(String[] mixIds, Long userId) throws ServiceException {
    boolean deleted = false;
    try {
      for(int i=0;i<mixIds.length;i++) {
        Long mixId = new Long(mixIds[i]);
        //remove rels
        Collection relColl = findRelMusicMixesByMix(mixId);
        if((relColl!=null) && (relColl.size()>0)) {
          Iterator it = relColl.iterator();
          while(it.hasNext()) {
            RelMusicMixes rel = (RelMusicMixes) it.next();
            rel.remove();
          }
        }
        findMixesById(mixId).remove();
      }
      deleted=true;
    } catch(Exception e) {
      log.error("Delete mix error: "+e.toString());
      throw new ServiceException("Delete mix error: "+e.getMessage());
    }
    return deleted;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#updateMixes(Long, String, long)
   */
  public boolean updateMixes(Long mixId, String title, long length, Long genreId) throws ServiceException {
    boolean updated = false;
    Mixes mix = null;
    Genre genre = null;
    try {
      mix = getMixesHome().findByPrimaryKey(mixId);      
      if(genreId!=null) genre = getGenreHome().findByPrimaryKey(genreId);
      updated = mix.update(title, length, genre);
    } catch(Exception e) {
      log.error("Mixes could not be updated: "+e.toString());
      throw new ServiceException("Mixes could not be updated: "+e.getMessage());
    }
    return updated;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMixesById(Long)
   */  
  public Mixes findMixesById(Long id) throws ServiceException {
    Mixes ejb = null;
    try {
      ejb = getMixesHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Mixes with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findMixesById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findMixesById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMixesByUser(Long)
   */  
  public Collection findMixesByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getMixesHome().findByUser(userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Mixes with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findMixesByUser with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findMixesByUser with userId=" + userId + " error: "+e.getMessage());
    }
    return list;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findMixesByGenre(Long)
   */  
  public Collection findMixesByGenre(Long genreId) throws ServiceException {
    Collection list = null;
    try {
      list = getMixesHome().findByGenre(genreId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Mixes with genreId=" + genreId + " could not be found");
    } catch(Exception e) {
      log.error("findMixesByGenre with genreId=" + genreId + " error: "+e.toString());
      throw new ServiceException("findMixesByGenre with genreId=" + genreId + " error: "+e.getMessage());
    }
    return list;            
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// RelMusicMixes:

  /**
   * @see com.vh.locker.service.music.MusicService#createRelMusicMixes(Long, Long, long)
   */
  public RelMusicMixes createRelMusicMixes(Long musicFileId, Long mixesId, long orderInMix) throws ServiceException {
    RelMusicMixes ejb = null;
    try {
      ejb = getRelMusicMixesHome().create(musicFileId, mixesId, orderInMix);
    } catch(Exception e) {
      log.error("RelMusicMixes could not be created: "+e.toString());
      throw new ServiceException("RelMusicMixes could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#deleteRelMusicMixes(Long, Long)
   */
  public boolean deleteRelMusicMixes(Long musicFileId, Long mixesId) throws ServiceException {
    boolean deleted = false;
    try {
      findRelMusicMixesByMusicIdMixesId(musicFileId, mixesId).remove();
      deleted=true;
    } catch(Exception e) {
      log.error("Delete RelMusicMixes error: "+e.toString());
      throw new ServiceException("Delete RelMusicMixes error: "+e.getMessage());
    }
    return deleted;    
  }

  /**
   * @see com.vh.locker.service.music.MusicService#updateRelMusicMixes(Long, Long, long)
   */
  public boolean updateRelMusicMixes(Long musicFileId, Long mixesId, long newOrderInMix) throws ServiceException {
    boolean updated = false;
    RelMusicMixes ejb = null;
    try {
      RelMusicMixesKey key = new RelMusicMixesKey(musicFileId, mixesId);
      ejb = getRelMusicMixesHome().findByPrimaryKey(key);
      updated = ejb.update(newOrderInMix);
    } catch(Exception e) {
      log.error("RelMusicMixes could not be updated: "+e.toString());
      throw new ServiceException("RelMusicMixes could not be updated: "+e.getMessage());
    }
    return updated;          
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findRelMusicMixesByMusicIdMixesId(Long, Long)
   */  
  public RelMusicMixes findRelMusicMixesByMusicIdMixesId(Long musicFileId, Long mixesId) throws ServiceException {
    RelMusicMixes ejb = null;
    try {
      RelMusicMixesKey key = new RelMusicMixesKey(musicFileId, mixesId);
      ejb = getRelMusicMixesHome().findByPrimaryKey(key);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("RelMusicMixes with musicFileId=" + musicFileId + ", mixesId=" + mixesId + " could not be found");
    } catch(Exception e) {
      log.error("findRelMusicMixesById with musicFileId=" + musicFileId + ", mixesId=" + mixesId + " error: "+e.toString());
      throw new ServiceException("findRelMusicMixesById with musicFileId=" + musicFileId + ", mixesId=" + mixesId + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findRelMusicMixesByMix(Long)
   */  
  public Collection findRelMusicMixesByMix(Long mixId) throws ServiceException {
    Collection list = null;
    try {
      list = getRelMusicMixesHome().findByMix(mixId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("RelMusicMixes with mixId=" + mixId + " could not be found");
    } catch(Exception e) {
      log.error("findRelMusicMixesByMix with mixId=" + mixId + " error: "+e.toString());
      throw new ServiceException("findRelMusicMixesByMix with mixId=" + mixId + " error: "+e.getMessage());
    }
    return list;                  
  }

  
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Genre:

  /**
   * @see com.vh.locker.service.music.MusicService#createGenre(String)
   */
  public Genre createGenre(String desc, Long userId) throws ServiceException {
    Genre ejb = null;
    User aUser = null;
    try {
      if(userId!=null) aUser=findUserById(userId);
      ejb = getGenreHome().create(new Long(0), desc, aUser);
    } catch(Exception e) {
      log.error("Genre could not be created: "+e.toString());
      throw new ServiceException("Genre could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#deleteGenres(String[], Long)
   */
  public boolean deleteGenres(String[] genreIds, Long userId) throws ServiceException {
    boolean deleted = false;
    try {
      for(int i=0;i<genreIds.length;i++) {
        Long genreId = new Long(genreIds[i]);
        //remove mixes
        Collection mixColl = findMixesByGenre(genreId);
        if((mixColl!=null) && (mixColl.size()>0)) {
          Iterator it = mixColl.iterator();
          while(it.hasNext()) {
            Mixes mix = (Mixes) it.next();
            //remove rels
            Collection relColl = findRelMusicMixesByMix(mix.getId());
            if((relColl!=null) && (relColl.size()>0)) {
              Iterator it2 = relColl.iterator();
              while(it2.hasNext()) {
                RelMusicMixes rel = (RelMusicMixes) it2.next();
                rel.remove();
              }
            }            
            mix.remove();
          }
        }
        //remove songs
        Collection mp3Coll = findMusicFileByGenre(genreId);
        deleteMp3s(mp3Coll, userId);
        findGenreById(genreId).remove();
      }
      deleted=true;
    } catch(Exception e) {
      log.error("Delete genre error: "+e.toString());
      throw new ServiceException("Delete genre error: "+e.getMessage());
    }
    return deleted;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findGenreById(Long)
   */  
  public Genre findGenreById(Long id) throws ServiceException {
    Genre ejb = null;
    try {
      ejb = getGenreHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Genre with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findGenreById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findGenreById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findGenreByUser(Long)
   */  
  public Collection findGenreByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getGenreHome().findByUser(userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Genre collection with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findGenreById collection with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findGenreById collection with userId=" + userId + " error: "+e.getMessage());
    }
    return list;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findGenreByDescUser(String, Long)
   */  
  public Genre findGenreByDescUser(String desc, Long userId) throws ServiceException{
    Genre ejb = null;
    try {
      ejb = getGenreHome().findByDescUser(desc, userId);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("Genre with desc="+desc+", userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findGenreById with desc="+desc+", userId=" + userId + "  error: "+e.toString());
      throw new ServiceException("findGenreById with desc="+desc+", userId=" + userId + "  error: "+e.getMessage());
    }
    return ejb;      
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// FileType:

  /**
   * @see com.vh.locker.service.music.MusicService#createFileType(String)
   */
  public FileType createFileType(String desc) throws ServiceException {
    FileType ejb = null;
    try {
      ejb = getFileTypeHome().create(new Long(0), desc);
    } catch(Exception e) {
      log.error("FileType could not be created: "+e.toString());
      throw new ServiceException("FileType could not be created: "+e.getMessage());
    }
    return ejb;
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findFileTypeById(Long)
   */  
  public FileType findFileTypeById(Long id) throws ServiceException {
    FileType ejb = null;
    try {
      ejb = getFileTypeHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("FileType with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findFileTypeById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findFileTypeById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findFileTypeByDesc(String)
   */    
  public FileType findFileTypeByDesc(String desc) throws ServiceException {
    FileType ejb = null;
    try {
      ejb = getFileTypeHome().findByDesc(desc);
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("FileType with desc=" + desc + " could not be found");
    } catch(Exception e) {
      log.error("findFileTypeByDesc with desc=" + desc + " error: "+e.toString());
      throw new ServiceException("findFileTypeByDesc with desc=" + desc + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.music.MusicService#findAllFileTypes()
   */    
  public Collection findAllFileTypes() throws ServiceException {
    Collection list = null;
    try {
      list = getFileTypeHome().findAll();
    } catch(FinderException fe) {
      if(log.isDebugEnabled()) log.debug("All FileType collection could not be found");
    } catch(Exception e) {
      log.error("All FileType collection error: "+e.toString());
      throw new ServiceException("All FileType collection error: "+e.getMessage());
    }
    return list;      
  }
  

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Helper methods:


  /**
   * This is a helper method to delete mp3 files from both the file system AND the database.
   * 
   * @param Collection mp3Coll collection of MusicFiles: the to be deleted mp3s
   * @param Long userId the userId
   */
  private void deleteMp3s(Collection mp3Coll, Long userId) throws Exception {
    String userName = findUserById(userId).getUserName();
    if((mp3Coll!=null) && (mp3Coll.size()>0)) {
      Iterator it = mp3Coll.iterator();
      while(it.hasNext()) {
        MusicFile mp3 = (MusicFile) it.next();
        File f = new File(Constants.FILEUPLOAD_PREFIX+userName+"/zdocs/music/"+mp3.getLink());
        f.delete();
        mp3.remove();            
      }
    }
  }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Getting EJB Homes:


  private synchronized AlbumHome getAlbumHome() throws ServiceException {
    if(mAlbumHome == null) {
      try {
        mAlbumHome = (AlbumHome)EJBHomeCache.lookup(Album_HOME);
      } catch(Exception e) {
        log.error("AlbumHome cannot be initiated: "+e.toString());
        throw new ServiceException("AlbumHome cannot be initiated: "+e.getMessage());
      }
    }
    return mAlbumHome;
  }

  private synchronized ArtistHome getArtistHome() throws ServiceException {
    if(mArtistHome == null) {
      try {
        mArtistHome = (ArtistHome)EJBHomeCache.lookup(Artist_HOME);
      } catch(Exception e) {
        log.error("ArtistHome cannot be initiated: "+e.toString());
        throw new ServiceException("ArtistHome cannot be initiated: "+e.getMessage());
      }
    }
    return mArtistHome;
  }

  private synchronized GenreHome getGenreHome() throws ServiceException {
    if(mGenreHome == null) {
      try {
        mGenreHome = (GenreHome)EJBHomeCache.lookup(Genre_HOME);
      } catch(Exception e) {
        log.error("GenreHome cannot be initiated: "+e.toString());
        throw new ServiceException("GenreHome cannot be initiated: "+e.getMessage());
      }
    }
    return mGenreHome;
  }

  private synchronized MusicFileHome getMusicFileHome() throws ServiceException {
    if(mMusicFileHome == null) {
      try {
          mMusicFileHome = (MusicFileHome)EJBHomeCache.lookup(MusicFile_HOME);
      } catch(Exception e) {
        log.error("MusicFileHome cannot be initiated: "+e.toString());
        throw new ServiceException("MusicFileHome cannot be initiated: "+e.getMessage());
      }
    }
    return mMusicFileHome;
  }

  private synchronized MixesHome getMixesHome() throws ServiceException {
    if(mMixesHome == null) {
      try {
          mMixesHome = (MixesHome)EJBHomeCache.lookup(Mixes_HOME);
      } catch(Exception e) {
        log.error("MixesHome cannot be initiated: "+e.toString());
        throw new ServiceException("MixesHome cannot be initiated: "+e.getMessage());
      }
    }
    return mMixesHome;
  }

  private synchronized RelMusicMixesHome getRelMusicMixesHome() throws ServiceException {
    if(mRelMusicMixesHome == null) {
      try {
          mRelMusicMixesHome = (RelMusicMixesHome)EJBHomeCache.lookup(RelMusicMixes_HOME);
      } catch(Exception e) {
        log.error("RelMusicMixesHome cannot be initiated: "+e.toString());
        throw new ServiceException("RelMusicMixesHome cannot be initiated: "+e.getMessage());
      }
    }
    return mRelMusicMixesHome;
  }

  private synchronized FileTypeHome getFileTypeHome() throws ServiceException {
    if(mFileTypeHome == null) {
      try {
          mFileTypeHome = (FileTypeHome)EJBHomeCache.lookup(FileType_HOME);
      } catch(Exception e) {
        log.error("FileTypeHome cannot be initiated: "+e.toString());
        throw new ServiceException("FileTypeHome cannot be initiated: "+e.getMessage());
      }
    }
    return mFileTypeHome;
  }

}
