/**
 * @file ActionUtils
 * @author peter.szocs
 * @version 1.0
 * 
 * Contains utility methods needed by Struts Actions.
 */


package com.vh.locker.util;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.octo.captcha.module.config.CaptchaModuleConfigHelper;
import com.octo.captcha.module.struts.CaptchaServicePlugin;
import com.octo.captcha.service.CaptchaService;
import com.opensymphony.module.sitemesh.RequestConstants;
import com.vh.locker.ejb.User;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class ActionUtils {
	
  private static Logger log = Logger.getLogger(ActionUtils.class);
  private static final boolean IS_DEBUG = log.isDebugEnabled();



  /**
   * Puts the Throwable object into session, and returns
   * 'error' global ActionForward (see struts-config.xml, global forwards).
   * 
   * @param HttpServletRequest
   * @param Throwable
   * @return ActionForward under key 'error'
   */
  public static ActionForward handleThrowable(HttpServletRequest req, Throwable e, ActionMapping mapping) {
    setThrowable(req, e);
    return mapping.findForward("error");
  }



  /**
   * Puts the Throwable object into session.
   * 
   * @param HttpServletRequest
   * @param Throwable
   */
  public static void setThrowable(HttpServletRequest req, Throwable e) {
    req.getSession().setAttribute(Constants_Scope.GLOBALERRORS_KEY, e);
  }



  /**
   * Returns the Throwable object from session.
   * 
   * @param HttpServletRequest
   * @return Throwable
   */
  public static Throwable getThrowable(HttpServletRequest req) {
    return (Throwable) req.getSession().getAttribute(Constants_Scope.GLOBALERRORS_KEY);
  }



  /**
   * Checks whether the session has expired.
   * 
   * @param HttpServletRequest
   * @return boolean session status
   */
  public static boolean sessionExpired(HttpServletRequest req) {
    return (getUserFromSession(req)==null);
  }



  /**
   * Returns the userId from session.
   * 
   * @param HttpServletRequest
   * @return Long the userId
   */
  public static Long getUserId(HttpServletRequest req) {
    return getUserFromSession(req).getId();
  }



  /**
   * Returns the User from session.
   * 
   * @param HttpServletRequest
   * @return User the authenticated user
   */
  public static User getUserFromSession(HttpServletRequest req) {
    return (User) req.getSession().getAttribute(Constants_Scope.USER_KEY);
  }



  /**
   * Puts the User into session.
   * 
   * @param HttpServletRequest
   * @param User the authenticated user
   */
  public static void setUserIntoSession(HttpServletRequest req, User usr) {
    req.getSession().setAttribute(Constants_Scope.USER_KEY, usr);
  }



  /**
   * Changes the user's locale.
   * 
   * @param HttpServletRequest
   * @param String locale the desired locale
   * @return Locale the desired java.util.Locale
   */
  public static Locale changeLocale(HttpServletRequest req, String locale) {
    if(IS_DEBUG) log.debug("New locale="+locale);
    Locale loc = Locale.US;
    if((locale!=null) && (!locale.equalsIgnoreCase("en_US"))) loc = new Locale(locale.substring(0, locale.indexOf("_")), locale.substring(locale.indexOf("_")+1));
    return loc;
  }
  
  

  /**
   * Return cookie value for the requested cookie name.
   * 
   * @param HttpServletRequest
   * @param String cookieName the requested cookie's name
   * @return String the cookieValue (null if not found)
   */  
  public static String getCookie(HttpServletRequest request, String cookieName) {
    String cookieValue = null; 
    Cookie[] mySiteCookies = request.getCookies();
    if(mySiteCookies!=null) {
      for(int i=0; i<mySiteCookies.length; i++) {
        Cookie c = mySiteCookies[i];
        //if(IS_DEBUG) log.debug(c.getName()+"="+c.getValue());
        if(c.getName().equals(cookieName)) {
          cookieValue = c.getValue();
          break;
        }
      }
    } else {
      if(IS_DEBUG) log.debug("request.getCookies() is NULL");
    }
    return cookieValue;      
  }



  /**
   * Update cookies at login.
   * 
   * @param String username
   * @param String password
   * @param String remember
   */  
  public static void updateCookies(String username, String password, String remember, HttpServletResponse response) {
    
    //create cookies
    if((remember!=null) && (remember.equalsIgnoreCase("on"))) {
      Cookie cookie = new Cookie(Constants.COOKIE_REMEMBER, remember);
      cookie.setMaxAge(365 * 24 * 60 * 60);
      response.addCookie(cookie);

      cookie = new Cookie(Constants.COOKIE_USERNAME, username);
      cookie.setMaxAge(365 * 24 * 60 * 60);
      response.addCookie(cookie);
                
      if(Constants.COOKIE_STOREPASSWORD) {
        cookie = new Cookie(Constants.COOKIE_PASSWORD, password); 
        cookie.setMaxAge(365 * 24 * 60 * 60);
        response.addCookie(cookie);
      }
      if(IS_DEBUG) log.debug("Cookies created: "+username+", "+password+", "+remember);
      
    //delete cookies
    } else { 
      Cookie cookie = new Cookie(Constants.COOKIE_REMEMBER, null);
      cookie.setMaxAge(0);
      response.addCookie(cookie);

      cookie = new Cookie(Constants.COOKIE_USERNAME, null);
      cookie.setMaxAge(0);
      response.addCookie(cookie);
              
      if(Constants.COOKIE_STOREPASSWORD) {
        cookie = new Cookie(Constants.COOKIE_PASSWORD, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
      }                
      if(IS_DEBUG) log.debug("Cookies deleted");
    }
  }



  /**
   * Return current date.
   * 
   * @return Date the current date
   */  
  public static java.util.Date getCurrentDate() {
    return new java.util.Date(System.currentTimeMillis());      
  }



  /**
   * Applies the decorator for the next page.  Puts the decorator with the 
   * given name under the request scope attribute '__sitemesh__decorator', as
   * defined in com.opensymphony.module.sitemesh.RequestConstants.
   * 
   * @param req the request
   * @param decorator the name of the decorator to be applied
   */
  public static void setDecorator(HttpServletRequest req, String decorator) {
    req.setAttribute(RequestConstants.DECORATOR, decorator);
  }
  
  
  
  /**
   * Returns the name of the decorator from request scope.  The decorator to be used
   * for the next page is defined under the request scope attribute '__sitemesh__decorator',
   * as defined in com.opensymphony.module.sitemesh.RequestConstants.
   *  
   * @param req the request
   * @return String the name of the decorator to be applied
   */
  public static String getDecorator(HttpServletRequest req) {
    return (String)req.getAttribute(RequestConstants.DECORATOR);
  }



  /**
   * Returns whether SSO is enabled.
   * 
   * @param HttpServletRequest
   * @return boolean the sso enabled value.
   */
  public static boolean isSSOEnabled(HttpServletRequest req) {
    boolean ssoEnabled = false;
    try {
      ssoEnabled = ((Boolean) req.getSession().getAttribute(Constants_Scope.SSOENABLED_KEY)).booleanValue();
    } catch(Exception e) {
      log.debug("Caught Exception in isSSOEnabled(): "+e.getMessage());
    }
    return ssoEnabled;
  }



  /**
   * Puts the SSO enabled value into session.
   * 
   * @param HttpServletRequest
   * @param boolean enabled whether sso is enabled.
   */
  public static void setSSOEnabledIntoSession(HttpServletRequest req, boolean enabled) {
    req.getSession().setAttribute(Constants_Scope.SSOENABLED_KEY, new Boolean(enabled));
  }



  /**
   * This method is called to validate a captcha response.
   * Note:    THE MAIN PROBLEM WITH VALIDATING CAPTCHA THRU JSON IS THAT THE
   *          RENDERED CAPTCHA REMAINS THE SAME.  IT IS POSSIBLE TO HAVE ROBOTS
   *          RUNNING ALGORITHMS AGAINST THE SAME CAPTCHA IN A LOOP.  THUS, IT'S SAFER
   *          TO VALIDATE A CAPTCHA ON THE ACTION, THEN REDIRECT BACK TO THE JSP,
   *          WHICH IN TURN WILL GENERATE A NEW CAPTCHA.
   * 
   * @param String captchaResponse   the non-empty String the user typed in as the reponse to the captcha
   * @return boolean                 returns whether the response is valid.  True iff correct response.
   */
  public static boolean validateCaptcha(String captchaResponse, HttpServletRequest req) {
    String captchaID = CaptchaModuleConfigHelper.getId(req);
    if(IS_DEBUG) log.debug("Captcha response for captchaID " + captchaID + ": " + captchaResponse);
    CaptchaService service = CaptchaServicePlugin.getInstance().getService();
    Boolean isResponseCorrect = Boolean.FALSE;
    isResponseCorrect = service.validateResponseForID(captchaID, captchaResponse);
    return isResponseCorrect.booleanValue();
  }


}