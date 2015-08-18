/**
 * @file SmsForm
 * @author peter.szocs
 * @version 1.0
 * 
 * This form is used when sending an SMS.
 */


package com.vh.locker.bean.inside;

import org.apache.struts.action.ActionForm;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class SmsForm extends ActionForm {

  private String contactIds;
  private String contactNames;
  private String smsSubject;
  private String smsMsg;
  
  /**
   * @return
   */
  public String getContactIds() {
	return contactIds;
  }

  /**
   * @return
   */
  public String getContactNames() {
	return contactNames;
  }

  /**
   * @return
   */
  public String getSmsMsg() {
	return smsMsg;
  }

  /**
   * @return
   */
  public String getSmsSubject() {
	return smsSubject;
  }

  /**
   * @param string
   */
  public void setContactIds(String string) {
	contactIds = string;
  }

  /**
   * @param string
   */
  public void setContactNames(String string) {
	contactNames = string;
  }

  /**
   * @param string
   */
  public void setSmsMsg(String string) {
	smsMsg = string;
  }

  /**
   * @param string
   */
  public void setSmsSubject(String string) {
	smsSubject = string;
  }

}