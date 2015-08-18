/**
 * @file LoginForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Contains userName/password for the login action.
 */


package com.vh.locker.bean.outside;

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
public class LoginForm extends ActionForm {

  private String username;
  private String password;
  private String remember;
	

  /**
   * @return
   */
  public String getPassword() {
	return password;
  }

  /**
   * @return
   */
  public String getUsername() {
	return username;
  }

  /**
   * @param string
   */
  public void setPassword(String string) {
	password = string;
  }

  /**
   * @param string
   */
  public void setUsername(String string) {
	username = string;
  }

  /**
   * @return
   */
  public String getRemember() {
	return remember;
  }

  /**
   * @param string
   */
  public void setRemember(String string) {
	remember = string;
  }

}