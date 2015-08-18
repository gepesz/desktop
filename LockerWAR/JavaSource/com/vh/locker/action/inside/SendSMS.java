/**
 * @file SendSMS
 * @author peter.szocs
 * @version 1.0
 * 
 * Send SMS to a contact.
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
import com.vh.locker.bean.inside.SmsForm;
import com.vh.locker.ejb.User;
import com.vh.locker.service.ContactService;
import com.vh.locker.service.EmailService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class SendSMS extends BaseInsideAction {

  private static Logger log = Logger.getLogger(SendSMS.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    SmsForm smsForm = (SmsForm) form;
    String contactIds   = smsForm.getContactIds();
    String contactNames = smsForm.getContactNames();
    String smsSubject   = smsForm.getSmsSubject();
    String smsMsg       = smsForm.getSmsMsg();

    //send sms
    if((contactIds!=null) && (contactNames!=null)) {
      String[] contactIdArr = contactIds.split(",");
      String[] contactNameArr = contactNames.split(",");
      if(IS_DEBUG) for(int i=0;i<contactIdArr.length;i++) {
        log.debug("contactIds["+i+"]="+contactIdArr[i].trim());
        log.debug("contactNames["+i+"]="+contactNameArr[i].trim());      
      }
      EmailService ems = (EmailService) getService(Constants.SERVICEKEY_EMAIL);
      ems.sendSMS(contactIdArr, contactNameArr, smsSubject, smsMsg, ActionUtils.getUserId(request));
      releaseService(Constants.SERVICEKEY_EMAIL, ems);
    } else {
      log.debug("No SMS sent, because contactIds=<"+contactIds+">, contactNames=<"+contactNames+">");
    }
    
    //get phone coll from db
    ContactService csv = (ContactService) getService(Constants.SERVICEKEY_CONTACT);    
    Collection phoneColl = csv.findContactByUser(ActionUtils.getUserId(request));
    releaseService(Constants.SERVICEKEY_CONTACT, csv);
    request.setAttribute("phoneColl", phoneColl);

    return mapping.findForward("success");
  }
}