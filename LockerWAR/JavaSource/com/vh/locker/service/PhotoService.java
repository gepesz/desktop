/**
 * @file PhotoService
 * @author peter.szocs
 * 
 * Service methods related to user photos.
 */


package com.vh.locker.service;

import java.util.Collection;
import java.util.Date;

import com.vh.locker.ejb.Photo;
import com.vh.locker.ejb.PhotoAlbum;
import com.vh.locker.ejb.RelPhotoAlbum;
import com.vh.locker.service.exception.ServiceException;


/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public interface PhotoService extends Service {


  /**
   * Photo
   */
  public Photo createPhoto(String desc, String link, Long userId) throws ServiceException;

  public boolean updatePhoto(Long id, String desc, String link) throws ServiceException;
    
  public Photo findPhotoById(Long id) throws ServiceException;

  public Collection findPhotoByAlbum(Long albumId) throws ServiceException;
  
  public Collection findPhotoByUser(Long userId) throws ServiceException;


  /**
   * PhotoAlbum
   */
  public PhotoAlbum createPhotoAlbum(String title, String desc, Date dateCreated, long nofVisits, Long userId) throws ServiceException;

  public boolean updatePhotoAlbum(Long id, String title, String desc) throws ServiceException;
    
  public PhotoAlbum findPhotoAlbumById(Long id) throws ServiceException;

  public Collection findPhotoAlbumByUser(Long userId) throws ServiceException;


  /**
   * RelPhotoAlbum
   */
  public RelPhotoAlbum createRelPhotoAlbum(Long photoId, Long albumId, long orderInAlbum) throws ServiceException;

  public boolean updateRelPhotoAlbum(Long photoId, Long photoAlbumId, long newOrderInAlbum) throws ServiceException;

  public RelPhotoAlbum findRelPhotoAlbumById(Long photoId, Long photoAlbumId) throws ServiceException;

}
