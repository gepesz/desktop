/**
 * @file ContactForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Used when updating contact information.
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
public class ContactForm extends ActionForm {

  private Long   contactId;
  private String contactName;
  private String contactNickName;
  private String contactPhone;
  private String contactEmail;
  
  /**
   * @return
   */
  public String getContactEmail() {
	return contactEmail;
  }

  /**
   * @return
   */
  public Long getContactId() {
	return contactId;
  }

  /**
   * @return
   */
  public String getContactName() {
	return contactName;
  }

  /**
   * @return
   */
  public String getContactNickName() {
	return contactNickName;
  }

  /**
   * @return
   */
  public String getContactPhone() {
	return contactPhone;
  }

  /**
   * @param string
   */
  public void setContactEmail(String string) {
	contactEmail = string;
  }

  /**
   * @param long1
   */
  public void setContactId(Long long1) {
	contactId = long1;
  }

  /**
   * @param string
   */
  public void setContactName(String string) {
	contactName = string;
  }

  /**
   * @param string
   */
  public void setContactNickName(String string) {
	contactNickName = string;
  }

  /**
   * @param string
   */
  public void setContactPhone(String string) {
	contactPhone = string;
  }

}