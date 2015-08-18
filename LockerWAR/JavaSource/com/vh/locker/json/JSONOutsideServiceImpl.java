/**
 * @file JSONOutsideServiceImpl
 * @author peter.szocs
 * @version 1.0
 * 
 * JSON java methods for the outside of the application.
 * These methods are called from outside using JSON.
 */

package com.vh.locker.json;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.octo.captcha.module.config.CaptchaModuleConfigHelper;
import com.octo.captcha.module.struts.CaptchaServicePlugin;
import com.octo.captcha.service.CaptchaService;
import com.vh.locker.base.BaseJSONServiceImpl;
import com.vh.locker.service.ServiceManager;
import com.vh.locker.service.UserService;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.Constants;
import com.vh.locker.util.Constants_Scope;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class JSONOutsideServiceImpl extends BaseJSONServiceImpl {

  private static Logger log = Logger.getLogger(JSONOutsideServiceImpl.class);
  private static boolean IS_DEBUG = log.isDebugEnabled();

  /**
   * The constructor.  Simply puts the session into a protected variable.
   * @param session
   */
  public JSONOutsideServiceImpl(HttpSession session) {
    super(session);
  }


  /**
   * This method is called to check userName availability (ie whether a userName is still available).
   * Called from signup.jsp.
   * 
   * @param String userName   the userName to check for availability
   * @return boolean          whether the userName is still available.   True iff userName is still available.
   */
  public boolean checkUserName(String userName) throws ServiceException {
    boolean available = false;
    UserService uss = (UserService) ServiceManager.acquire(Constants.SERVICEKEY_USER);
    available = uss.checkUserName(userName);
    ServiceManager.release(Constants.SERVICEKEY_USER, uss);
    return available;
  }



  /**
   * This method is called to select the user's locale (language).
   * It's used both from inside and outside.
   * It basically updates the java.util.Locale object in the user's session.
   * 
   * @param String localeString   the localeString is the String representation of the desired locale, eg: 'en_US' or 'fr_FR'
   * @return boolean              true IFF Locale object in session got successfully changed
   */
  public boolean selectLocale(String localeString) throws ServiceException {
	boolean locUpdated = false;
	if(localeString!=null) {
	  Locale loc = new Locale(localeString.substring(0, localeString.indexOf("_")), localeString.substring(localeString.indexOf("_")+1));
	  session.setAttribute(Constants_Scope.LOCALE_KEY, loc);
	  if(IS_DEBUG) log.debug("New locale="+localeString);
      locUpdated = true;
	}
	return locUpdated;
  }



  /**
   * This method is called to validate a captcha response.
   * WARNING: (1) ONLY WORKS FOR THE FIRST TIME WHEN IT'S CALLED!!  THAT IS,
   *          THE METHOD WORKS AS EXPECTED ON THE FIRST CALL.  AFTER THAT
   *          THE REQUEST BECOMES INVALID (NEW REQUEST) AND THEREFORE THE METHOD 
   *          GIVES INVALID CAPTCHAID EXCEPTION.
   * 
   *          (2) THE MAIN PROBLEM WITH VALIDATING CAPTCHA THRU JSON IS THAT THE
   *          RENDERED CAPTCHA REMAINS THE SAME.  IT IS POSSIBLE TO HAVE ROBOTS
   *          RUNNING ALGORITHMS AGAINST THE SAME CAPTCHA IN A LOOP.  THUS, IT'S SAFER
   *          TO VALIDATE A CAPTCHA ON THE ACTION, THEN REDIRECT BACK TO THE JSP,
   *          WHICH IN TURN WILL GENERATE A NEW CAPTCHA.
   * 
   * @param String captchaResponse   the non-empty String the user typed in as the reponse to the captcha
   * @return boolean                 returns whether the response is valid.  True iff correct response.
   */
  public boolean validateCaptcha(String captchaResponse, HttpServletRequest request) throws ServiceException {
    String captchaID = CaptchaModuleConfigHelper.getId(request);
    if(IS_DEBUG) log.debug("Captcha response for captchaID " + captchaID + ": " + captchaResponse);
    CaptchaService service = CaptchaServicePlugin.getInstance().getService();
    Boolean isResponseCorrect = Boolean.FALSE;
    isResponseCorrect = service.validateResponseForID(captchaID, captchaResponse);
    return isResponseCorrect.booleanValue();
  }

}