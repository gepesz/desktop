/**
 * @file CloseApp
 * @author peter.szocs
 * @version 1.0
 * 
 * This action closes an application inside ZLocker.
 */


package com.vh.locker.action.inside;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.base.BaseInsideAction;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class CloseApp extends BaseInsideAction {

  private static Logger log = Logger.getLogger(CloseApp.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG()) log.debug("inside");

    //TaskBarUtils.removeTask(request);
    //request.getSession().removeAttribute("allGenreColl");

    return mapping.findForward("success");
  }
}
