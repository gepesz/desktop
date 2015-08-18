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
import java.net.SocketException;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.vh.locker.ejb.User;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  Peter.Szocs
 * @version 1.0
 */
public class FileUploader {

  private static Logger log=Logger.getLogger(FileUploader.class);

  /**
   * Uploads the given formFile into /home/< userName >/< path >/theFile.
   * 
   * @param theFile The formFile to be uploaded
   * @param path The path under /home/< userName >/ where the file will be uploaded.
   * @param session HttpSession the session
   * @throws Exception
   */
	public static void upload(FormFile theFile, String path, HttpSession session) throws Exception {
		if(log.isDebugEnabled()) log.debug("inside");

    try {
      //construct filePath
      log.debug(theFile.getFileName());
      log.debug(Constants.FILEUPLOAD_PREFIX+((User)session.getAttribute(Constants_Scope.USER_KEY)).getUserName());
      
	    String filePath = Constants.FILEUPLOAD_PREFIX+((User)session.getAttribute(Constants_Scope.USER_KEY)).getUserName()+"/zdocs/"+path+"/"+theFile.getFileName().trim().replace(' ','_');
      if(log.isDebugEnabled()) log.debug("Uploading "+filePath);
			
      //write out file
      InputStream stream = theFile.getInputStream();
	    OutputStream bos = new FileOutputStream(filePath);
		  int bytesRead = 0;
		  byte[] buffer = new byte[Constants.FILEUPLOAD_BUFFER];
		  while((bytesRead = stream.read(buffer, 0, Constants.FILEUPLOAD_BUFFER)) != -1) {
			  bos.write(buffer, 0, bytesRead);
		  }
      bos.close();
      stream.close();
    } catch(Exception ex) {
      log.error("Error while uploading: "+ex.getMessage());
      throw ex;
    }
	}
    

  /**
   * Downloads the file at filePath.  Note: filePath must be full file path on the system!
   * 
   * @param filePath the full file path
   * @param request HttpServletRequest the request
   * @param response HttpServletResponse the response
   * @throws Exception
   */
  public static void download(String filePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(log.isDebugEnabled()) log.debug("inside");
    MimetypesFileTypeMap mimes = new MimetypesFileTypeMap(request.getSession().getServletContext().getResourceAsStream("WEB-INF/lib/mime.types"));        
    try {
      if(filePath==null) throw new Exception("No filePath entered (filePath=null)");
      File f = new File(filePath);
      if(!f.exists() || f.isDirectory()) throw new Exception("The requested file does not exist.");
      if(log.isDebugEnabled()) log.debug("Downloading filename="+f.getPath()+", content-type="+mimes.getContentType(f));
      
      //set response headers
      response.setContentType(mimes.getContentType(f));
      response.setContentLength((int)f.length());
      if(response.containsHeader("Cache-Control")) response.setHeader("Cache-Control", "");
      if(response.containsHeader("Pragma")) response.setHeader("Pragma", "");      
      if(response.containsHeader("Content-Disposition")) response.setHeader("Content-Disposition", "attachment;filename=" + f.getName());
      else response.addHeader("Content-Disposition", "attachment;filename=" + f.getName());
        
      //write out file
      byte[] buffer = new byte[Constants.FILEDOWNLOAD_BUFFER];
      int r = 0;
      FileInputStream fin = new FileInputStream(f);
      OutputStream out = response.getOutputStream();
      while((r = fin.read(buffer, 0, Constants.FILEDOWNLOAD_BUFFER)) != -1) {
        out.write(buffer, 0, r);
      }
     
      //close buffer
      try {
        fin.close();
        out.flush();
        out.close();
      } catch(Exception e) {
        log.error("Error while closing buffer: "+e.getMessage());
        e.printStackTrace();
      }
    } catch(SocketException se) {
      if(log.isDebugEnabled()) log.debug("Download cancelled by user");         
    } catch(Exception ex) {
      String msg = ex.getMessage();
      if(msg!=null) {
        response.setContentType("text/html");
        response.setContentLength(msg.length());
        PrintWriter out = response.getWriter();
        out.println(msg);
        out.flush();
        out.close();
      }
    }      
  }

}
