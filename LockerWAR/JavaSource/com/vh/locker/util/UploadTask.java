/**
 * @file FileUploader
 * @author peter.szocs
 * @version 1.0
 * 
 * File upload utility class.
 */

package com.vh.locker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  Peter.Szocs
 * @version 1.0
 */
public class UploadTask implements Runnable, Serializable {
  private Logger log=Logger.getLogger(UploadTask.class);
  private FormFile theFile;
  private String path;
  private float sum;
  private int percent;
  private boolean running;
  private boolean started;

  //constructor
  public UploadTask(FormFile theFile, String path) {
    this.theFile=theFile;
    this.path=path;
    sum = 0;
    percent = 0;
    running = false;
    started = false;
  }

  //setter, getter methods
  public synchronized int getPercent() {
    if(!started) return 0;
    else return percent;
  }

  public synchronized void setPercent(float p) {
    percent = Math.round(100*p);
    //if((percent==100) && isRunning()) percent=99;
  }

  public synchronized boolean isRunning() {
    return running;
  }

  public synchronized void setRunning(boolean running) {
    this.running = running;
  }

  public synchronized boolean isStarted() {
    return started;
  }

  public synchronized void setStarted(boolean started) {
    this.started = started;
  }


  //the upload takes place here
  protected void work() {
    try {
      if(theFile!=null) {    
        //construct filePath, fileSize
        int fileSize = theFile.getFileSize();
        if(fileSize==0) fileSize=1;
        String filePath = path+"/"+theFile.getFileName();
        if(log.isDebugEnabled()) log.debug("Uploading file: "+filePath+", filesize: "+fileSize/1000+"KB");
			
        //write out file
        InputStream stream = theFile.getInputStream();
        OutputStream bos = new FileOutputStream(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[Constants.FILEUPLOAD_BUFFER];
        while(isRunning() && ((bytesRead = stream.read(buffer, 0, Constants.FILEUPLOAD_BUFFER)) != -1)) {
          bos.write(buffer, 0, bytesRead);
          sum+=bytesRead;
          setPercent(sum/fileSize);
        }
        bos.close();
        stream.close();
      }
    } catch(Exception ex) {
      setRunning(false);
      log.error("Error while uploading: "+ex.getMessage());
      ex.printStackTrace();
    }
  }

  public void run() {
    try {
      setStarted(true);
      setRunning(true);
      work();
	  } finally {
      setRunning(false);
    }
  }
      
}
