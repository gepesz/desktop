/**
 * @file ForgotPwdForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Used when password help is needed (forgotten pwd).
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
public class ForgotPwdForm extends ActionForm {

  private String username;
  private String captcha;
	

  /**
   * @return
   */
  public String getUsername() {
	return username;
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
  public String getCaptcha() {
	return captcha;
  }

  /**
   * @param string
   */
  public void setCaptcha(String string) {
	captcha = string;
  }

}