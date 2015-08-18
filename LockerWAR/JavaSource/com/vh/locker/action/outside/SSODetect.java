/**
 * @file SSODetect
 * @author peter.szocs
 * @version 1.0
 * 
 * Detects whether SSO is enabled and if so, who is the logged in user.
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
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants_Scope;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class SSODetect extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(SSODetect.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    boolean ssoEnabled = false;
		
    if(request.getUserPrincipal()!=null) {
      String userName = request.getRemoteUser();
      if(IS_DEBUG) log.debug("SSO enabled, userName="+userName);
      if((userName!=null) && (!"".equals(userName))) {
        ssoEnabled = true;
        request.getSession().setAttribute(Constants_Scope.LASTPAGE_KEY, "/outside/Login.do");
      }			
    } else {
      if(IS_DEBUG) log.debug("SSO disabled, forwarding to login.jsp");
    }
    ActionUtils.setSSOEnabledIntoSession(request, ssoEnabled);

    return mapping.findForward("success");
  }
}