/**
 * @file Logout
 * @author peter.szocs
 * @version 1.0
 * 
 * Logout action that logs the user out of the system.
 * Note: MUST BE OUTSIDE ACTION BECAUSE NO MORE SESSION CHECKING
 *       NEEDED TO BE PERFORMED ON THIS ACTION (OTHERWISE
 *       INFINITE LOOP IF THIS ACTION EXTENDS BASEINSIDEACTION BECAUSE
 *       THEY WOULD BE CALLING EACH OTHER)!!
 */


package com.vh.locker.action.outside;

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
import com.vh.locker.bean.outside.LoginForm;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class Logout extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(Logout.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("Invalidating user session...");
        
    String cookieRemember = ActionUtils.getCookie(request, Constants.COOKIE_REMEMBER);
    if(cookieRemember!=null) {
      LoginForm loginForm = (LoginForm) form;
      loginForm.setRemember(cookieRemember);
      loginForm.setUsername( ActionUtils.getCookie(request, Constants.COOKIE_USERNAME) );
      if(Constants.COOKIE_STOREPASSWORD) loginForm.setPassword( ActionUtils.getCookie(request, Constants.COOKIE_PASSWORD) );
      request.setAttribute("loginform", loginForm);
      if(IS_DEBUG) log.debug("Form prepopulated");       
    }    
    request.getSession().invalidate();
    
    return mapping.findForward("success");
  }
}