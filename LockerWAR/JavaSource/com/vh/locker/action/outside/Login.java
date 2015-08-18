/**
 * @file Login
 * @author peter.szocs
 * @version 1.0
 * 
 * Login action which authenticates user and puts User into session.
 */


package com.vh.locker.action.outside;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.base.BaseOutsideAction;
import com.vh.locker.ejb.User;
import com.vh.locker.service.ServiceManager;
import com.vh.locker.service.UserService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.MessageUtils;
import com.vh.locker.util.MusicUtils;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class Login extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(Login.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //if(IS_DEBUG) log.debug("inside");

    //get username & password from request
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String remember = request.getParameter("remember");    
    boolean ssoEnabled = ActionUtils.isSSOEnabled(request);
    if(IS_DEBUG) {
      log.debug("SSO enabled="+ssoEnabled);
      log.debug("username="+username);
      log.debug("password="+password);
      log.debug("remember="+remember);
    }
    User theUser = null;

    //ssoEnabled: get user from request
    if(ssoEnabled) {
    	
      UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);    
      theUser = uss.findUserByUserName( request.getRemoteUser() ); //request.getRemoteUser() returns the username
      releaseService(Constants.SERVICEKEY_USER, uss);
    
    //sso disabled: authenticate user through login form
    } else {
    
      //check if this is a refresh (F5) from inside
      if((username==null) || ("".equals(username))) {
        theUser = ActionUtils.getUserFromSession(request);
        if(theUser!=null) { //yes, this is a refresh (F5) from inside
          if(IS_DEBUG) log.debug("User in session already, fetching shortCuts from database");
          UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);
          request.setAttribute("shortCuts", uss.findShortCutByUser(theUser.getId()));
          releaseService(Constants.SERVICEKEY_USER, uss);
          return mapping.findForward("success");
        } 
      }
      //authenticating the user
      UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);
      theUser = uss.authenticate(username, password);
      releaseService(Constants.SERVICEKEY_USER, uss);

    }
    
    //successful authentication
    if(theUser!=null) {
      if(IS_DEBUG) log.debug("User '"+theUser.getUserName()+"' successfully authenticated");
      log.debug("isSSOEnabled="+ActionUtils.isSSOEnabled(request));
      ActionUtils.updateCookies(username, password, remember, response);
      UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);
      uss.updateLoginInfo(theUser);
      request.setAttribute("shortCuts", uss.findShortCutByUser(theUser.getId()));
      this.setLocale(request, uss.getUserLocale(theUser));
      releaseService(Constants.SERVICEKEY_USER, uss);
      ActionUtils.setUserIntoSession(request, theUser);
    } else {
      if(IS_DEBUG) log.debug("User authentication failed, returning to login.jsp");
      request.setAttribute("errorMsg", MessageUtils.getMessage("resources", "errors.password", request));
      request.setAttribute("username", username);
      ActionUtils.setDecorator(request, "outside");
      return mapping.findForward("failure");
    }
		
    return mapping.findForward("success");
  }
}