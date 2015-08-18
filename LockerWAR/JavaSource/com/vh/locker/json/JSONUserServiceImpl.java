/**
 * @file JSONUserServiceImpl
 * @author peter.szocs
 * @version 1.0
 * 
 * JSON accesses the methods in UserService through this accessor java class.
 */

package com.vh.locker.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vh.locker.base.BaseJSONServiceImpl;
import com.vh.locker.bean.json.ShortCut;
import com.vh.locker.ejb.Photo;
import com.vh.locker.service.PhotoService;
import com.vh.locker.service.ServiceManager;
import com.vh.locker.service.UserService;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.FileUploader;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class JSONUserServiceImpl extends BaseJSONServiceImpl {

  private static Logger log = Logger.getLogger(JSONUserServiceImpl.class);
  private static boolean IS_DEBUG = log.isDebugEnabled();

  /**
   * The constructor.  Simply puts the session into a protected variable.
   * @param session
   */
  public JSONUserServiceImpl(HttpSession session) {
    super(session);
  }


  /**
   * This method is called when saving out shortcuts locations.
   * Called right before logout action is called.
   * 
   * @param ShortCut[] arr  The ShortCut array to save
   * @return boolean        whether the save was successful.  True iff successful save.
   */
  public boolean saveShortCuts(ShortCut[] arr) throws ServiceException {
    //if(IS_DEBUG) log.debug("Start saveShortCuts()...");
    boolean saved = false;
    UserService uss = (UserService) ServiceManager.acquire(Constants.SERVICEKEY_USER);

    //delete user's old shortcuts from database
    uss.deleteShortCutsForUser(userId);

    //create user's new shortcuts in database    
    if(arr != null) {
      if(IS_DEBUG) log.debug("ShortCut array.length="+arr.length);      
      for(int i=0; i<arr.length; i++) {
        //log.debug("Bean "+i+": ["+arr[i].getDesc()+", "+arr[i].getIcon()+", "+arr[i].getAppId()+", "+arr[i].getX()+", "+arr[i].getY()+"]");
        uss.createShortCut(arr[i].getDesc(), arr[i].getIcon(), arr[i].getX(), arr[i].getY(), new Long(arr[i].getAppId()), userId);
      }
      saved = true;
    }

    //release service, log result
    ServiceManager.release(Constants.SERVICEKEY_USER, uss);    
    if(IS_DEBUG && saved) log.debug("ShortCuts created for user "+userId);
    
    return saved;
  }


  /**
   * This method is called to return to JS the available photos of a user.
   * Called from desktopProps to populate the wallpaper select box.
   * 
   * @return Object[]   array of Strings, representing the available photos (ie list of filenames)
   */
  public Object[] getWallpapers() throws ServiceException {    
    if(IS_DEBUG) log.debug("Start getWallpapers()...");
    ArrayList arr = new ArrayList();
    
    //get all photos a user has from database
    PhotoService photoSvc = (PhotoService) ServiceManager.acquire(Constants.SERVICEKEY_PHOTO);
    Collection allPhotos = photoSvc.findPhotoByUser(this.userId);
    Iterator it = allPhotos.iterator();
    while(it.hasNext()) {
      Photo photo = (Photo)it.next();
      arr.add(photo.getLink());
    }

    //release service, log size of wallpaper collection
    ServiceManager.release(Constants.SERVICEKEY_PHOTO, photoSvc);
    if(IS_DEBUG) log.debug("Wallpaper array size: "+arr.size());
    
    return arr.toArray();
  }


  /**
   * Uploads the given formFile into /home/< userName >/< targetPath >/theFile.
   * 
   * @param sourceFile  The file to be uploaded from the user's machine
   * @param targetPath  The path under /home/< userName >/ where the file will be uploaded.
   * @return boolean    True if the file upload is successful.
   **/
  public boolean uploadFile(String sourceFile, String targetPath) throws ServiceException {    
    try {
      int i = sourceFile.lastIndexOf("\\");
      if(i<0) i = sourceFile.lastIndexOf("/");
      String name = sourceFile.substring(i+1);
      String targetFile = Constants.FILEUPLOAD_PREFIX+this.userName+"/zdocs/"+targetPath+"/"+name.trim().replace(' ','_');
      if(IS_DEBUG) {
        log.debug("Source file: "+sourceFile);
        log.debug("Target file: "+targetFile);
      }             
      //write out file
      InputStream stream = new FileInputStream(sourceFile);
      OutputStream bos = new FileOutputStream(targetFile);
      int bytesRead = 0;
      byte[] buffer = new byte[Constants.FILEUPLOAD_BUFFER];
      while((bytesRead = stream.read(buffer, 0, Constants.FILEUPLOAD_BUFFER)) != -1) {
        bos.write(buffer, 0, bytesRead);
      }
      bos.close();
      stream.close();
      //create photo in database (desc and link both default to filename)
      this.createPhoto(name, name);
    } catch(Exception e) {
      log.error("Error while uploading: "+e.toString());
      throw new ServiceException(e.getMessage());
    }
    return true;
  }


  /**
   * Creates a photo in the database.
   * Called before/after uploading a new photo file.
   * 
   * @param desc  The photo desc
   * @param link  The photo filename on the filepath
   **/
  public void createPhoto(String desc, String link) throws ServiceException {    
    PhotoService photoSvc = (PhotoService) ServiceManager.acquire(Constants.SERVICEKEY_PHOTO);
    photoSvc.createPhoto(desc, link, this.userId);
    ServiceManager.release(Constants.SERVICEKEY_PHOTO, photoSvc);
  }

}