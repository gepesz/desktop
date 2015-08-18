/**
 * @file EmailService
 * @author peter.szocs
 * 
 * Service methods related to email.
 */

package com.vh.locker.service;

import javax.servlet.http.HttpServletRequest;

import com.vh.locker.ejb.User;
import com.vh.locker.service.exception.ServiceException;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public interface EmailService extends Service {


  /**
   * Sends forgot password email to the user. 
   * 
   * @param user      the user to send the email to
   * @param request   the HttpServletRequest
   * @throws ServiceException
   */
  public void sendForgotPasswordEmail(User user, HttpServletRequest request) throws ServiceException;


	/**
   * Sends an email.
   * 
	 * @param fromName
	 * @param fromAddr
	 * @param toName
	 * @param toAddr
	 * @param subject
	 * @param body
	 * @throws ServiceException
	 */
	public void sendEmail(String fromName, String fromAddr, String toName, String toAddr, String subject, String body) throws ServiceException;


  /**
   * Sends the same sms to all recipients as described by contactIds[].
   * 
   * @param contactIds
   * @param contactNames
   * @param subject
   * @param msg
   * @param userId the user sending the sms-es
   * @throws ServiceException
   */
  public void sendSMS(String[] contactIds, String[] contactNames, String subject, String msg, Long userId) throws ServiceException;

}