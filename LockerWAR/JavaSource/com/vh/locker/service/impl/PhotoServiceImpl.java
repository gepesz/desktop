/**
 * @file PhotoServiceImpl
 * @author peter.szocs
 * 
 * Service methods related to user photos.
 */


package com.vh.locker.service.impl;

import java.util.Collection;
import java.util.Date;

import javax.ejb.FinderException;

import org.apache.log4j.Logger;

import com.vh.locker.base.BaseServiceImpl;
import com.vh.locker.ejb.Photo;
import com.vh.locker.ejb.PhotoAlbum;
import com.vh.locker.ejb.PhotoAlbumHome;
import com.vh.locker.ejb.PhotoHome;
import com.vh.locker.ejb.RelPhotoAlbum;
import com.vh.locker.ejb.RelPhotoAlbumHome;
import com.vh.locker.ejb.RelPhotoAlbumKey;
import com.vh.locker.ejb.User;
import com.vh.locker.service.PhotoService;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.EJBHomeCache;


/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class PhotoServiceImpl extends BaseServiceImpl implements PhotoService {

  private static Logger log=Logger.getLogger(PhotoServiceImpl.class);
  private final boolean IS_DEBUG = log.isDebugEnabled();
  
  //homes:
  private PhotoHome         mPhotoHome         = null;
  private PhotoAlbumHome    mPhotoAlbumHome    = null;
  private RelPhotoAlbumHome mRelPhotoAlbumHome = null;
  
  


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Photo:

  /**
   * @see com.vh.locker.service.PhotoService#createPhoto(String, String, Long)
   */
  public Photo createPhoto(String desc, String link, Long userId) throws ServiceException {
    User aUser = null;
    Photo ejb = null;
    try {
      if(userId!=null) aUser = findUserById(userId);
      ejb = getPhotoHome().create(null, desc, link, aUser);
    } catch(Exception e) {
      log.error("Photo could not be created: "+e.toString());
      throw new ServiceException("Photo could not be created: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.PhotoService#updatePhoto(Long, String, String)
   */
  public boolean updatePhoto(Long id, String desc, String link) throws ServiceException {
    boolean updated = false;
    try {
      Photo p = getPhotoHome().findByPrimaryKey(id);
      updated = p.update(desc, link);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("Photo with id=" + id + " could not be found");    
    } catch(Exception e) {
      log.error("Photo "+id+" could not be updated: "+e.toString());
      throw new ServiceException("Photo "+id+" could not be updated: "+e.getMessage());
    }
    return updated;  
  }

  /**
   * @see com.vh.locker.service.PhotoService#findPhotoById(Long)
   */    
  public Photo findPhotoById(Long id) throws ServiceException {
    Photo ejb = null;
    try {
      ejb = getPhotoHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("Photo with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findPhotoById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findPhotoById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;  
  }

  /**
   * @see com.vh.locker.service.PhotoService#findPhotoByAlbum(Long)
   */    
  public Collection findPhotoByAlbum(Long albumId) throws ServiceException {
    Collection list = null;
    try {
      list = getPhotoHome().findByAlbum(albumId);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("Photo collection with albumId=" + albumId + " could not be found");
    } catch(Exception e) {
      log.error("findPhotoByAlbum with albumId=" + albumId + " error: "+e.toString());
      throw new ServiceException("findPhotoByAlbum with albumId=" + albumId + " error: "+e.getMessage());
    }
    return list;    
  }

  /**
   * @see com.vh.locker.service.PhotoService#findPhotoByUser(Long)
   */    
  public Collection findPhotoByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getPhotoHome().findByUser(userId);
    } catch(Exception e) {
      log.error("findPhotoByUser error: "+e.toString());
      throw new ServiceException("findPhotoByUser error: "+e.getMessage());
    }
    return list;
  }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// PhotoAlbum:

  /**
   * @see com.vh.locker.service.PhotoService#createPhotoAlbum(String title, String desc, Date dateCreated, long nofVisits, Long userId)
   */
  public PhotoAlbum createPhotoAlbum(String title, String desc, Date dateCreated, long nofVisits, Long userId) throws ServiceException {
    User aUser = null;
    PhotoAlbum ejb = null;
    try {
      if(userId!=null) aUser = findUserById(userId);
      ejb = getPhotoAlbumHome().create(null, title, desc, dateCreated, nofVisits, aUser);
    } catch(Exception e) {
      log.error("PhotoAlbum could not be created: "+e.toString());
      throw new ServiceException("PhotoAlbum could not be created: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.PhotoService#updatePhotoAlbum(Long, String, String)
   */
  public boolean updatePhotoAlbum(Long id, String title, String desc) throws ServiceException {
    boolean updated = false;
    try {
      PhotoAlbum pa = getPhotoAlbumHome().findByPrimaryKey(id);
      updated = pa.update(title, desc);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("PhotoAlbum with id=" + id + " could not be found");    
    } catch(Exception e) {
      log.error("PhotoAlbum "+id+" could not be updated: "+e.toString());
      throw new ServiceException("PhotoAlbum "+id+" could not be updated: "+e.getMessage());
    }
    return updated;      
  }

  /**
   * @see com.vh.locker.service.PhotoService#findPhotoAlbumById(Long)
   */    
  public PhotoAlbum findPhotoAlbumById(Long id) throws ServiceException {
    PhotoAlbum ejb = null;
    try {
      ejb = getPhotoAlbumHome().findByPrimaryKey(id);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("PhotoAlbum with id=" + id + " could not be found");
    } catch(Exception e) {
      log.error("findPhotoAlbumById with id=" + id + " error: "+e.toString());
      throw new ServiceException("findPhotoAlbumById with id=" + id + " error: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.PhotoService#findPhotoAlbumByUser(Long)
   */
  public Collection findPhotoAlbumByUser(Long userId) throws ServiceException {
    Collection list = null;
    try {
      list = getPhotoAlbumHome().findByUser(userId);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("PhotoAlbum collection with userId=" + userId + " could not be found");
    } catch(Exception e) {
      log.error("findPhotoAlbumByUser with userId=" + userId + " error: "+e.toString());
      throw new ServiceException("findPhotoAlbumByUser with userId=" + userId + " error: "+e.getMessage());
    }
    return list;
  }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// RelPhotoAlbum:

  /**
   * @see com.vh.locker.service.PhotoService#createRelPhotoAlbum(Long photoId, Long albumId, long orderInAlbum)
   */
  public RelPhotoAlbum createRelPhotoAlbum(Long photoId, Long albumId, long orderInAlbum) throws ServiceException {
    RelPhotoAlbum ejb = null;
    try {
      ejb = getRelPhotoAlbumHome().create(photoId, albumId, orderInAlbum);
    } catch(Exception e) {
      log.error("RelPhotoAlbum could not be created: "+e.toString());
      throw new ServiceException("RelPhotoAlbum could not be created: "+e.getMessage());
    }
    return ejb;      
  }

  /**
   * @see com.vh.locker.service.PhotoService#updateRelPhotoAlbum(Long photoId, Long albumId, long orderInAlbum)
   */
  public boolean updateRelPhotoAlbum(Long photoId, Long photoAlbumId, long newOrderInAlbum) throws ServiceException {
    boolean updated = false;
    try {
      RelPhotoAlbum rel = getRelPhotoAlbumHome().findByPrimaryKey( new RelPhotoAlbumKey(photoId, photoAlbumId) );
      updated = rel.update(newOrderInAlbum);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("RelPhotoAlbum with photoId=" + photoId + ", photoAlbumId=" + photoAlbumId + " could not be found");    
    } catch(Exception e) {
      log.error("updateRelPhotoAlbumById with photoId=" + photoId + ", photoAlbumId=" + photoAlbumId + " could not be updated: "+e.toString());
      throw new ServiceException("updateRelPhotoAlbumById with photoId=" + photoId + ", photoAlbumId=" + photoAlbumId + " could not be updated: "+e.getMessage());
    }
    return updated;      
  }

  /**
   * @see com.vh.locker.service.PhotoService#findRelPhotoAlbumById(Long, Long)
   */    
  public RelPhotoAlbum findRelPhotoAlbumById(Long photoId, Long photoAlbumId) throws ServiceException {
    RelPhotoAlbum ejb = null;
    try {
      RelPhotoAlbumKey key = new RelPhotoAlbumKey(photoId, photoAlbumId);
      ejb = getRelPhotoAlbumHome().findByPrimaryKey(key);
    } catch(FinderException fe) {
      if(IS_DEBUG) log.debug("RelPhotoAlbum with photoId=" + photoId + ", photoAlbumId=" + photoAlbumId + " could not be found");
    } catch(Exception e) {
      log.error("findRelPhotoAlbumById with photoId=" + photoId + ", photoAlbumId=" + photoAlbumId + " error: "+e.toString());
      throw new ServiceException("findRelPhotoAlbumById with photoId=" + photoId + ", photoAlbumId=" + photoAlbumId + " error: "+e.getMessage());
    }
    return ejb;         
  }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Getting EJB Homes:


  private synchronized PhotoHome getPhotoHome() throws ServiceException {
    if(mPhotoHome == null) {
      try {
        mPhotoHome = (PhotoHome)EJBHomeCache.lookup(Photo_HOME);
      } catch(Exception e) {
        log.error("PhotoHome cannot be initiated: "+e.toString());
        throw new ServiceException("PhotoHome cannot be initiated: "+e.getMessage());
      }
    }
    return mPhotoHome;
  }

  private synchronized PhotoAlbumHome getPhotoAlbumHome() throws ServiceException {
    if(mPhotoAlbumHome == null) {
      try {
        mPhotoAlbumHome = (PhotoAlbumHome)EJBHomeCache.lookup(PhotoAlbum_HOME);
      } catch(Exception e) {
        log.error("PhotoAlbumHome cannot be initiated: "+e.toString());
        throw new ServiceException("PhotoAlbumHome cannot be initiated: "+e.getMessage());
      }
    }
    return mPhotoAlbumHome;
  }

  private synchronized RelPhotoAlbumHome getRelPhotoAlbumHome() throws ServiceException {
    if(mRelPhotoAlbumHome == null) {
      try {
        mRelPhotoAlbumHome = (RelPhotoAlbumHome)EJBHomeCache.lookup(RelPhotoAlbum_HOME);
      } catch(Exception e) {
        log.error("RelPhotoAlbumHome cannot be initiated: "+e.toString());
        throw new ServiceException("RelPhotoAlbumHome cannot be initiated: "+e.getMessage());
      }
    }
    return mRelPhotoAlbumHome;
  }

}
