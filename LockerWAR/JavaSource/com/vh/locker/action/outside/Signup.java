/**
 * @file Signup
 * @author peter.szocs
 * @version 2.0
 * 
 * Signs up new user.
 */


package com.vh.locker.action.outside;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.base.BaseOutsideAction;
import com.vh.locker.bean.outside.SignupForm;
import com.vh.locker.ejb.User;
import com.vh.locker.service.UserService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.MessageUtils;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class Signup extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(Signup.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    String errorMsg = ""; // contains the actual error msg
    SignupForm signupForm = (SignupForm) form;

    // validating the captcha response
    boolean isCaptchaCorrect = ActionUtils.validateCaptcha(signupForm.getCaptcha(), request);

    if(isCaptchaCorrect) {
      if(IS_DEBUG) log.debug("Captcha response is correct, creating new user");
      UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);
      User theUser = uss.createUser(signupForm, ActionUtils.getCurrentDate());
      uss.createInitialShortCutsForNewUser(theUser.getId()); // create default shortcuts for the new user account
      releaseService(Constants.SERVICEKEY_USER, uss);
	  if(IS_DEBUG) log.debug("New user account and initial shortCuts sucessfully created for user: "+signupForm.getUserName());
	  ActionUtils.setUserIntoSession(request, theUser); // put newly created user into session so that Login succeeds
    } else {
      if(IS_DEBUG) log.debug("Captcha response is incorrect, forwarding back to jsp to show captcha failed error");
      errorMsg = MessageUtils.getMessage("resources", "errors.captcha", request);
    }

    if("".equals(errorMsg)) return mapping.findForward("success");
    else {
      request.setAttribute("errorMsg",   errorMsg);
      request.setAttribute("signupForm", signupForm);
	  ActionUtils.setDecorator(request, "outside");
      return mapping.findForward("failure");
    }
  }
}