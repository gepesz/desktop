/**
 * @file ViewLocale
 * @author peter.szocs
 * @version 1.0
 * 
 * Populate action for locale.jsp.
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
import com.vh.locker.service.UserService;
import com.vh.locker.util.Constants;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class ViewLocale extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(ViewLocale.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    // populating drop-down menus
    UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);
    request.setAttribute("allLanguageColl", uss.findAllLanguages());
    releaseService(Constants.SERVICEKEY_USER, uss);

    return mapping.findForward("success");
  }
}