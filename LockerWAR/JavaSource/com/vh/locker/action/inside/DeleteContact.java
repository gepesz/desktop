/**
 * @file DeleteContact
 * @author peter.szocs
 * @version 1.0
 * 
 * Deletes contacts that the user selected.
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
import com.vh.locker.bean.inside.GridForm;
import com.vh.locker.service.ContactService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class DeleteContact extends BaseInsideAction {

  private static Logger log = Logger.getLogger(DeleteContact.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    GridForm gridForm = (GridForm) request.getAttribute("gridForm");
    String[] id = gridForm.getId();
    ContactService csv = (ContactService) getService(Constants.SERVICEKEY_CONTACT);
    csv.deleteContacts(id);
    Collection phoneColl = csv.findContactByUser(ActionUtils.getUserId(request));    
    releaseService(Constants.SERVICEKEY_CONTACT, csv);
    request.setAttribute("phoneColl", phoneColl);
    
    return mapping.findForward("success");
  }
}
