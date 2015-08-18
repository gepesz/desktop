/**
 * @file UpdateContact
 * @author peter.szocs
 * @version 1.0
 * 
 * Creates/Updates contact information.
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
import com.vh.locker.bean.inside.ContactForm;
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
public class UpdateContact extends BaseInsideAction {

  private static Logger log = Logger.getLogger(UpdateContact.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    ContactForm contactForm = (ContactForm) form;
    Long contactId          = contactForm.getContactId();
    String contactName      = contactForm.getContactName();
    String contactNickName  = contactForm.getContactNickName();
    String contactPhone     = contactForm.getContactPhone();
    String contactEmail     = contactForm.getContactEmail();    
    //if(IS_DEBUG) log.debug("contactId="+contactId);
    
    //insert new contact, retrieve new phoneColl from db
    ContactService csv = (ContactService) getService(Constants.SERVICEKEY_CONTACT);
    if(!csv.updateContact(contactId, contactName, contactNickName, contactPhone, contactEmail)) csv.createContact(contactName, contactNickName, contactPhone, contactEmail, ActionUtils.getUserId(request));
    Collection phoneColl = csv.findContactByUser(ActionUtils.getUserId(request));
    releaseService(Constants.SERVICEKEY_CONTACT, csv);
    request.setAttribute("phoneColl", phoneColl);

    return mapping.findForward("success");
  }
}
