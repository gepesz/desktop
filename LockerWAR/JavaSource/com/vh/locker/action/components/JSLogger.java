/**
 * @file JSLogger
 * @author peter.szocs
 * @version 1.0
 * 
 * This file is called from Javascript to log messages on the server using log4j.
 */

package com.vh.locker.action.components;

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

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class JSLogger extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(JSLogger.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //if(IS_DEBUG) log.debug("inside");

    String level = request.getParameter("level");
    String msg   = request.getParameter("msg");
    if((level!=null) && (msg!=null)) {
      int logLevel = Integer.parseInt(level);
      switch (logLevel) {
        case 0: if(IS_DEBUG) log.debug(msg); break;
        case 1: if(log.isInfoEnabled()) log.info(msg); break;
        case 2: log.warn(msg);  break;
        case 3: log.error(msg); break;
        case 4: log.fatal(msg); break;
        default: if(IS_DEBUG) log.debug(msg); break;
      }
    }
    
    return mapping.findForward("success");
  }
}