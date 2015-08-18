/**
 * @file StartPhone
 * @author peter.szocs
 * @version 1.0
 * 
 * Start action for 'phone.'
 */


package com.vh.locker.action.inside;

import java.util.Collection;

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
import com.vh.locker.service.ContactService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class StartPhone extends BaseInsideAction {

  private static Logger log = Logger.getLogger(StartPhone.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside)");

    //get phone coll from db
    ContactService csv = (ContactService) getService(Constants.SERVICEKEY_CONTACT);
    Collection phoneColl = csv.findContactByUser(ActionUtils.getUserId(request));
    releaseService(Constants.SERVICEKEY_CONTACT, csv);
    request.setAttribute("phoneColl", phoneColl);

    return mapping.findForward("success");
  }
}