package com.vh.locker.servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.SocketException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vh.locker.util.Constants;

		
public class BulkDownloadServlet extends HttpServlet {
	
  private static Logger log=Logger.getLogger(BulkDownloadServlet.class);
  private MimetypesFileTypeMap mimes;
  	
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    doGet(request, response);	
  }	
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(log.isDebugEnabled()) log.debug("inside");
    
    try {
      //check user permissions
      if(request.getSession()==null) throw new Exception("Your session has expired.");
      
      //set response headers
      response.setContentType("application/zip");
      //response.setContentLength((int)f.length());
      if(response.containsHeader("Cache-Control")) response.setHeader("Cache-Control", "");
      if(response.containsHeader("Pragma")) response.setHeader("Pragma", "");      
      if(response.containsHeader("Content-Disposition")) response.setHeader("Content-Disposition", "attachment;filename=ZDocs.zip");
      else response.addHeader("Content-Disposition", "attachment;filename=ZDocs.zip");

      //these are the files to include in the ZIP file
      String[] filenames = new String[]{"C:/California_Love.mp3", "C:/Kevin_Lyttle_-_Turn_me_on.mp3"};
      //String[] filenames = (String[])request.getAttribute("filenames");
      if(filenames==null) throw new Exception("No filenames entered (filenames=null)");      
      ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
      
      //write out files  
      byte[] buffer = new byte[Constants.FILEDOWNLOAD_BUFFER];
      for(int i=0; i<filenames.length; i++) {
        FileInputStream in = new FileInputStream(filenames[i]);
        out.putNextEntry(new ZipEntry(filenames[i]));
        int len;
        while((len = in.read(buffer)) > 0) {
          out.write(buffer, 0, len);
        }
        out.closeEntry();
        in.close();
      }
      out.close();
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