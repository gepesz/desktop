package com.vh.locker.servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.SocketException;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vh.locker.util.Constants;
import com.vh.locker.util.FileUtils;

		
public class DownloadServlet extends HttpServlet {
	
  private static Logger log=Logger.getLogger(DownloadServlet.class);
  private MimetypesFileTypeMap mimes;
  	
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    doGet(request, response);	
  }	
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(log.isDebugEnabled()) log.debug("inside");
    
    try {
      //check user permissions
      if(request.getSession()==null) throw new Exception("Your session has expired.");

      //check the file...
      String fileId = (String)request.getParameter("id");
      if(fileId==null) throw new Exception("No fileId entered (id=null)");
      String filename = FileUtils.constructFilePath(new Long(fileId));
      File f = new File(filename);
      if(!f.exists() || f.isDirectory()) throw new Exception("The requested file does not exist.");
      if(log.isDebugEnabled()) log.debug("filename="+f.getPath()+", content-type="+mimes.getContentType(f));
      
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
    
  public void init() throws ServletException {
    try {	
      mimes = new MimetypesFileTypeMap(getServletContext().getResourceAsStream("WEB-INF/lib/mime.types"));
    } catch(Exception e) {
      log.error("Couldn't load mime.types file: "+e.getMessage());	  
    }
  }	
  
}