/**
 * @file StartupServlet
 * @author peter.szocs
 * @version 2.0
 * 
 * This servlet is used to initialize parameters at server startup.
 */


package com.vh.locker.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.octo.captcha.module.struts.CaptchaServicePlugin;
import com.octo.captcha.service.ManageableCaptchaService;
import com.vh.locker.service.ServiceManager;
import com.vh.locker.service.UserService;
import com.vh.locker.util.Constants;
import com.vh.locker.util.Constants_Scope;
import com.vh.locker.util.EJBHomeCache;



/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class StartupServlet extends HttpServlet implements Constants {
	
  private static Logger log=Logger.getLogger(StartupServlet.class);
  private static boolean IS_DEBUG = log.isDebugEnabled();
    
  public void service(HttpServletRequest req, HttpServletResponse  resp) throws ServletException, IOException {}	



  private void initCaptcha() {
    try {
		
      //setting the captchas' image type
	    if(IS_DEBUG) log.debug("Initializing captcha plugin...");
      ManageableCaptchaService manageable = (ManageableCaptchaService)CaptchaServicePlugin.getInstance().getService();
      manageable.setCaptchaEngineClass("com.octo.captcha.engine.image.gimpy.BaffleListGimpyEngine");
	  /*
	  The available captchaEngineClasses are in WEB-INF/lib/jcaptcha-all-XXX.jar, under the 
	  package name com.octo.engine.image.gimpy.

	  Available captchaEngineClasses:
	  com.octo.engine.image.gimpy.BaffleListGimpyEngine
	  com.octo.engine.image.gimpy.BasicGimpyEngine
	  com.octo.engine.image.gimpy.BasicListGimpyEngine             -- doesn't work
	  com.octo.engine.image.gimpy.DefaultGimpyEngine               -- this is the default if nothing is set
	  com.octo.engine.image.gimpy.DeformedBaffleListGimpyEngine
	  com.octo.engine.image.gimpy.DoubleRandomListGimpyEngine
	  com.octo.engine.image.gimpy.FilteredBaffleListGimpyEngine
	  com.octo.engine.image.gimpy.FilteredDoubleRandomListGimpyEngine
	  com.octo.engine.image.gimpy.FilteredGimpyEngine
	  com.octo.engine.image.gimpy.FilteredListGimpyEngine
	  com.octo.engine.image.gimpy.MultipleGimpyEngine              -- doesn't work
	  com.octo.engine.image.gimpy.SimpleListImageCaptchaEngine     -- works but gives exception in jboss
	  */
	    if(IS_DEBUG) log.debug("CaptchaServicePlugin initialized");

    } catch(Exception e) {
      log.error("Error while initializing CaptchaServicePlugin: "+e.toString());
      e.printStackTrace();
    }		
  }



  private void initApplicationScope() {
    try {
      if(IS_DEBUG) log.debug("Setting up application scope...");
      ServletContext context = this.getServletContext();
      UserService usr = (UserService) ServiceManager.acquire(Constants.SERVICEKEY_USER);
      context.setAttribute(Constants_Scope.ALL_APPLICATIONS_KEY,  usr.findAllApplications());
      context.setAttribute(Constants_Scope.ALL_SKINS_KEY,         usr.findAllSkins());
      context.setAttribute(Constants_Scope.ALL_LANGUAGES_KEY,     usr.findAllLanguages());
      ServiceManager.release(Constants.SERVICEKEY_USER, usr);
      if(IS_DEBUG) log.debug("Application scope initialized:\n" +
                              Constants_Scope.ALL_APPLICATIONS_KEY + ":\tallApplications [inside]\n" + 
                              Constants_Scope.ALL_SKINS_KEY + ":\tallSkins [inside]\n" + 
                              Constants_Scope.ALL_LANGUAGES_KEY + ":\tallLanguages [outside/inside]\n");
    } catch(Exception e) {
      log.error("Error while initializing application scope: "+e.toString());
      e.printStackTrace();
    }
  }



  private void cacheHomes() {
    try {
      if(IS_DEBUG) log.debug("Caching EJB homes...");  
      EJBHomeCache.lookup(Album_HOME);
      EJBHomeCache.lookup(Application_HOME);
      EJBHomeCache.lookup(Artist_HOME);
      EJBHomeCache.lookup(Contact_HOME);
      EJBHomeCache.lookup(Country_HOME);
      EJBHomeCache.lookup(FileType_HOME);
      EJBHomeCache.lookup(Genre_HOME);
      EJBHomeCache.lookup(Language_HOME);
      EJBHomeCache.lookup(Mixes_HOME);
      EJBHomeCache.lookup(MusicFile_HOME);
      EJBHomeCache.lookup(Photo_HOME);
      EJBHomeCache.lookup(PhotoAlbum_HOME);
      EJBHomeCache.lookup(RelMusicMixes_HOME);
      EJBHomeCache.lookup(RelPhotoAlbum_HOME);
      EJBHomeCache.lookup(SecretQuestion_HOME);
      EJBHomeCache.lookup(ShortCut_HOME);
      EJBHomeCache.lookup(Skin_HOME);
      EJBHomeCache.lookup(User_HOME);
      EJBHomeCache.lookup(UserStatus_HOME);
      EJBHomeCache.lookup(UserType_HOME);
      if(IS_DEBUG) log.debug("EJB homes cached");
    } catch(Exception e) {
      log.error("Error while caching homes: "+e.toString());
      e.printStackTrace();
    }		
  }

	
	
	
  public void init() throws ServletException {
    try {
      initCaptcha();
      initApplicationScope();
      cacheHomes();
    } catch(Exception e) {
      log.error("Error in StartupServlet.init(): "+e.toString());
      e.printStackTrace();  
    }    
  }	
    
}