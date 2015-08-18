/**
 * @file FileUtils
 * @author peter.szocs
 * @version 1.0
 * 
 * File utility methods.
 */



package com.vh.locker.util;

import java.io.File;

import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.vh.locker.ejb.FileType;
import com.vh.locker.ejb.FileTypeHome;
import com.vh.locker.ejb.MusicFile;
import com.vh.locker.service.MusicService;
import com.vh.locker.service.ServiceManager;
import com.vh.locker.service.exception.ServiceException;



/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  Peter.Szocs
 * @version 1.0
 */
public class FileUtils {

  private static Logger log = Logger.getLogger(FileUtils.class);

  //homes:
  private static FileTypeHome mFileTypeHome   = null;  
  

  /**
   * Validates a formFile for (1) file type; (2) length.
   * 
   * @param formFile the formFile
   * @return String the error msg/empty string if validation ok.
   * @throws ServiceException
   */
  public static String validateFileTypeLength(FormFile theFile, HttpServletRequest req) throws ServiceException {
    String errorMsg="FormFile is null";
    try {
      if(theFile!=null) {
        String fileName = theFile.getFileName();
        if(fileName.lastIndexOf(".")>0) {
          String ext = fileName.substring(fileName.lastIndexOf(".")+1);
          if((ext!=null) && (!ext.equals(""))) try {
            FileType aFileType = getFileTypeHome().findByDesc(ext);
            if(theFile.getFileSize()<=(1000000*Constants.MAXFILESIZE)) errorMsg="";
            else errorMsg=MessageUtils.getMessage(Constants.LABELS, "errors.maxfilesize", new Integer(Constants.MAXFILESIZE), req);
          } catch(FinderException fe) {
            log.info("Filetype not supported: "+ext);
            errorMsg=MessageUtils.getMessage(Constants.LABELS, "errors.filetype.unsupported", ext, req);
          } catch(Exception ex) {
            log.error("Problem validating "+fileName+": "+ex.toString());
            throw new ServiceException("Problem validating "+fileName+": "+ex.getMessage());
          }
          else errorMsg=MessageUtils.getMessage(Constants.LABELS, "errors.filetype.unsupported", ext, req);
        } else {
          errorMsg=MessageUtils.getMessage(Constants.LABELS, "errors.filetype.unsupported", req);
        }
      }
    } catch(Exception ex) {
      log.error(ex);
      throw new ServiceException(ex.toString());
    }
    return errorMsg;
  }


  /**
   * Validates a formFile for (1) length.
   * 
   * @param formFile the formFile
   * @return boolean whether the file is ok.
   * @throws ServiceException
   */
  public static boolean validateFileLength(FormFile theFile) throws ServiceException {
    boolean isValid=false;
    if(theFile!=null) {
      try {
        if(theFile.getFileSize()<=(1000000*Constants.MAXFILESIZE)) isValid=true;
      } catch(Exception ex) {
        log.error("Problem length validating formFile "+theFile.getFileName()+": "+ex.toString());
        throw new ServiceException("Problem length validating formFile "+theFile.getFileName()+": "+ex.getMessage());
      }
    }
    return isValid;
  }


  /**
   * Return whether formFile is a new file for the user.
   * 
   * @param formFile the formFile
   * @return boolean True if file exists, false if this is a new file.
   * @throws ServiceException
   */
  public static boolean doesFileExist(FormFile theFile, String path, HttpServletRequest req) throws ServiceException {
    boolean exists=false;
    if(theFile!=null) {      
      String filePath = Constants.FILEUPLOAD_PREFIX+ActionUtils.getUserFromSession(req).getUserName()+"/zdocs/"+path+"/"+theFile.getFileName().trim().replace(' ','_');
      //if(log.isDebugEnabled()) log.debug("filePath="+filePath);
      File f=new File(filePath);      
      exists=f.exists();
    }
    return exists;
  }



  /**
   * Construct filePath for file with given id.
   * 
   * @param fileId Long the file id
   * @return String the filePath on the file system.  Returns "" if no file found.
   * @throws ServiceException
   */
  public static String constructFilePath(Long fileId) throws ServiceException {
    String filePath = "";
    if(fileId!=null) {
      MusicService mcs = (MusicService) ServiceManager.acquire(Constants.SERVICEKEY_MUSIC);
      MusicFile mp3 = mcs.findMusicFileById(fileId);
      ServiceManager.release(Constants.SERVICEKEY_MUSIC, mcs);            
      filePath = Constants.FILEUPLOAD_PREFIX+mp3.getUser().getUserName()+"/zdocs/music/"+mp3.getLink();
      //if(log.isDebugEnabled()) log.debug("filePath="+filePath);
    }
    return filePath;
  }



  /**
   * Returns file extension.
   * 
   * @param formFile the formFile
   * @return String ext the file extension/empty String on no extension.
   * @throws ServiceException
   */
  public static String getFileExtension(FormFile theFile) throws ServiceException {
    String ext="";
    if(theFile!=null) {
      String fileName = theFile.getFileName();
      if(fileName.lastIndexOf(".")>0) ext = fileName.substring(fileName.lastIndexOf(".")+1);
    }
    return ext;
  }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Getting EJB Homes:

  private static synchronized FileTypeHome getFileTypeHome() throws ServiceException {
    if(mFileTypeHome == null) {
      try {
        mFileTypeHome = (FileTypeHome)EJBHomeCache.lookup(Constants.FileType_HOME);
      } catch(Exception e) {
        log.error("FileTypeHome cannot be initiated: "+e.toString());
        throw new ServiceException("FileTypeHome cannot be initiated: "+e.getMessage());
      }
    }
    return mFileTypeHome;
  }

}
