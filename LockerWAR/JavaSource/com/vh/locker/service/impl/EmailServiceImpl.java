/**
 * @file EmailServiceImpl
 * @author peter.szocs
 * 
 * Email functionality implementation.
 */


package com.vh.locker.service.impl;

import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.vh.locker.base.BaseServiceImpl;
import com.vh.locker.ejb.User;
import com.vh.locker.service.ContactService;
import com.vh.locker.service.EmailService;
import com.vh.locker.service.ServiceManager;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.Constants;
import com.vh.locker.util.MessageUtils;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class EmailServiceImpl extends BaseServiceImpl implements EmailService {

  private static Logger log=Logger.getLogger(EmailServiceImpl.class);
  private final boolean IS_DEBUG = log.isDebugEnabled();


  /**
   * @see com.vh.locker.service.EmailService#sendForgotPasswordEmail(User)
   */
  public void sendForgotPasswordEmail(User user, HttpServletRequest request) throws ServiceException {
    try {
      String fromName = MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.from", request);
      String fromAddr = "webmaster@zlocker.com";
      String toName   = user.getFirstName();
      String toAddr   = user.getEmail();
      String subject  =      MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.subject", request);
      String body     = "\n"+MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.body.header", request)+user.getFirstName()+","+"\n\n";

      body+=MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.body.main", request)+"\n\n";
      body+=MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.body.username", request) + user.getUserName() +"\n";
      body+=MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.body.password", request) + user.getPassword() +"\n\n";
      body+=MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.body.thanks", request)+"\n\n";
      body+=MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.body.cheers", request)+"\n";
      body+=MessageUtils.getMessage("resources", "com.vh.email.forgotpassword.body.staff", request);
    
      if(IS_DEBUG) log.debug("body="+body);
      sendEmail(fromName, fromAddr, toName, toAddr, subject, body);      
    } catch(Exception e) {
      log.error("Could not send forgot pwd email: "+e.toString());
      throw new ServiceException("Could not send forgot pwd email:"+e.getMessage());
    }
  }


  /**
   * @see com.vh.locker.service.EmailService#sendEmail(String, String, String, String, String, String)
   */
  public void sendEmail(String fromName, String fromAddr, String toName, String toAddr, String subject, String body) throws ServiceException {
    try {
      Properties props = new Properties();    
      props.put( "mail.smtp.host", Constants.SMTPSERVER );
      Session mailSession = Session.getDefaultInstance( props, null );
      mailSession.setDebug( false );

      MimeMessage message = new MimeMessage( mailSession );
      message.setFrom( new InternetAddress(fromAddr, fromName) );
      message.addRecipient( MimeMessage.RecipientType.TO, new InternetAddress(toAddr, toName) );
      message.setSubject( subject );
      message.setText( body );
      Transport.send( message );
    } catch(Exception e) {
      log.error("Could not send email: "+e.toString());
      throw new ServiceException("Could not send email:"+e.getMessage());
    }
  }


  /**
   * @see com.vh.locker.service.EmailService#sendSMS(String[], String[], String, String, Long)
   */
  public void sendSMS(String[] contactIds, String[] contactNames, String subject, String msg, Long userId) throws ServiceException {
    ContactService csv = null;
    try {
      csv = (ContactService) ServiceManager.acquire(Constants.SERVICEKEY_CONTACT);
      User user = findUserById(userId);
      String fromName = user.getFirstName();
      String fromEmail = user.getEmail();
      for(int i=0;i<contactIds.length;i++) {
        if(IS_DEBUG) log.debug("contactIds["+i+"]="+contactIds[i].trim());
        String toAddr = convertPhoneNumToEmailAddr(csv.findContactById(new Long(contactIds[i].trim())).getPhone());
        if(IS_DEBUG) log.debug("toAddr["+i+"]="+toAddr);        
        sendEmail(fromName, fromEmail, contactNames[i].trim(), toAddr, subject, msg);
      }
    } catch(Exception e) {
      log.error("Send SMS error: "+e.toString());
      throw new ServiceException("Send SMS error:"+e.getMessage());
    } finally {
      ServiceManager.release(Constants.SERVICEKEY_CONTACT, csv);      
    }
  }
 
 
  /**
   * Converts the phone number to an email address where an SMS can be sent.
   * Breaks up the phonenumber into tokens and then adds the providers email
   * suffix at the end.
   * 
   * @param phoneNum the phone number where the sms will be sent
   * @return String the converted email address
   * @throws Exception
   */ 
  private String convertPhoneNumToEmailAddr(String phoneNum) throws Exception {
    StringTokenizer t = new StringTokenizer(phoneNum, "-_. ");
    StringBuffer b = new StringBuffer();
    while(t.hasMoreElements()) {
      b.append(t.nextToken());
    }
    b.append("@messaging.sprintpcs.com");
    return b.toString();
  }
}