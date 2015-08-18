/**
 * @file ViewSettings
 * @author peter.szocs
 * @version 2.0
 * 
 * View action for settings page.
 */


package com.vh.locker.action.inside;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.base.BaseInsideAction;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class ViewSettings extends BaseInsideAction {

  private static Logger log = Logger.getLogger(ViewSettings.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //if(IS_DEBUG) log.debug("inside");

    return mapping.findForward("success");
  }
}