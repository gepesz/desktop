/**
 * @file MusicService
 * @author peter.szocs
 * 
 * Service methods related to user music files.
 */


package com.vh.locker.service;

import java.util.Collection;
import java.util.Date;

import com.vh.locker.ejb.Album;
import com.vh.locker.ejb.Artist;
import com.vh.locker.ejb.FileType;
import com.vh.locker.ejb.Genre;
import com.vh.locker.ejb.Mixes;
import com.vh.locker.ejb.MusicFile;
import com.vh.locker.ejb.RelMusicMixes;
import com.vh.locker.service.exception.ServiceException;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public interface MusicService extends Service {


  /**
   * MusicFile
   */
  public MusicFile createMusicFile(String artist, String songTitle, String albumTitle, long length, Date dateCreated, String link, long nofPlayed, String genre, String ext, Long userId) throws ServiceException;

  public boolean deleteMusicFiles(String[] songIds, Long userId) throws ServiceException;

  public boolean updateMusicFile(Long id, String artist, String songTitle, String albumTitle, String genre, Long userId) throws ServiceException;

  public MusicFile findMusicFileById(Long id) throws ServiceException;
      
  public Collection findMusicFileByUser(Long userId) throws ServiceException;

  public Collection findMusicFileByAlbum(Long albumId) throws ServiceException;

  public Collection findMusicFileByArtist(Long artistId) throws ServiceException;

  public Collection findMusicFileByGenre(Long genreId) throws ServiceException;

  public Collection findMusicFileByMix(Long mixId) throws ServiceException;

  public Collection findMostRecentMusicFile(Long userId) throws ServiceException;



  /**
   * Album
   */
  public Album createAlbum(String desc, Long userId) throws ServiceException;

  public boolean deleteAlbums(String[] albumIds, Long userId) throws ServiceException;
    
  public Album findAlbumById(Long id) throws ServiceException;
  
  public Collection findAlbumByUser(Long userId) throws ServiceException;



  /**
   * Artist
   */
  public Artist createArtist(String desc, Long userId) throws ServiceException;

  public boolean deleteArtists(String[] artistIds, Long userId) throws ServiceException;
    
  public Artist findArtistById(Long id) throws ServiceException;
  
  public Collection findArtistByUser(Long userId) throws ServiceException;



  /**
   * Mixes
   */  
  public Long createMixes(String title, long length, Date dateCreated, long nofPlayed, Long genreId) throws ServiceException;

  public boolean deleteMixes(String[] mixIds, Long userId) throws ServiceException;

  public boolean updateMixes(Long mixId, String title, long length, Long genreId) throws ServiceException;

  public Mixes findMixesById(Long id) throws ServiceException;

  public Collection findMixesByUser(Long userId) throws ServiceException;

  public Collection findMixesByGenre(Long genreId) throws ServiceException;



  /**
   * RelMusicMixes
   */  
  public RelMusicMixes createRelMusicMixes(Long musicFileId, Long mixesId, long orderInMix) throws ServiceException;

  public boolean deleteRelMusicMixes(Long musicFileId, Long mixesId) throws ServiceException;

  public boolean updateRelMusicMixes(Long musicFileId, Long mixesId, long newOrderInMix) throws ServiceException;

  public RelMusicMixes findRelMusicMixesByMusicIdMixesId(Long musicFileId, Long mixesId) throws ServiceException;

  public Collection findRelMusicMixesByMix(Long mixId) throws ServiceException;



  /**
   * Genre
   */  
  public Genre createGenre(String desc, Long userId) throws ServiceException;

  public boolean deleteGenres(String[] genreIds, Long userId) throws ServiceException;

  public Genre findGenreById(Long id) throws ServiceException;

  public Collection findGenreByUser(Long userId) throws ServiceException;

  public Genre findGenreByDescUser(String desc, Long userId) throws ServiceException;


  /**
   * FileType
   */  
  public FileType createFileType(String desc) throws ServiceException;

  public FileType findFileTypeById(Long id) throws ServiceException;

  public FileType findFileTypeByDesc(String desc) throws ServiceException;

  public Collection findAllFileTypes() throws ServiceException;

  
}
