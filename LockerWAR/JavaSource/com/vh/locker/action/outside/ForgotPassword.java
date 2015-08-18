/**
 * @file ForgotPassword
 * @author peter.szocs
 * @version 1.0
 * 
 * Authenticates user, then sends email with forgotten password.
 */


package com.vh.locker.action.outside;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.base.BaseOutsideAction;
import com.vh.locker.bean.outside.ForgotPwdForm;
import com.vh.locker.ejb.User;
import com.vh.locker.service.EmailService;
import com.vh.locker.service.MusicService;
import com.vh.locker.service.UserService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.MessageUtils;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class ForgotPassword extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(ForgotPassword.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    String errorMsg = ""; // contains the actual error msg
    String errorKey = ""; // contains the error type: 0 for captcha error, 1 for username error
    ForgotPwdForm forgotPwdForm = (ForgotPwdForm) form;
    String userName = forgotPwdForm.getUsername();

    // validating the captcha response
    boolean isCaptchaCorrect = ActionUtils.validateCaptcha(forgotPwdForm.getCaptcha(), request);

    // captcha response is CORRECT
    if(isCaptchaCorrect) {
				
      if(IS_DEBUG) log.debug("Captcha response is correct, validating if user '"+userName+"' exists...");
	    UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);
	    User u = uss.findUserByUserName(userName);
	    releaseService(Constants.SERVICEKEY_USER, uss);
	  
      // user does not exist with specified userName: show error on jsp
      if(u==null) {
        if(IS_DEBUG) log.debug("User '"+userName+"' does not exist, forwarding back to jsp to show username error");
        errorMsg = MessageUtils.getMessage("resources", "errors.username.nonexistent", request);
        errorKey = "1";
      // user found: email the password to the secondary email address of the user, and forward to 'success'
      } else {
        if(IS_DEBUG) log.debug("User '"+userName+"' found, sending password email...");
        EmailService ems = (EmailService) getService(Constants.SERVICEKEY_EMAIL);
        ems.sendForgotPasswordEmail(u, request);
        releaseService(Constants.SERVICEKEY_EMAIL, ems);
      }
	
    // captcha response is INCORRECT
    } else {
      
      if(IS_DEBUG) log.debug("Captcha response is incorrect, forwarding back to jsp to show captcha failed error");
      errorMsg = MessageUtils.getMessage("resources", "errors.captcha", request);
      errorKey = "0";

    }

    if("".equals(errorMsg)) return mapping.findForward("success");
    else {
	    request.setAttribute("errorMsg", errorMsg);
	    request.setAttribute("errorKey", errorKey);
	    request.setAttribute("username", userName);      
      return mapping.findForward("failure");
    }
  }
}