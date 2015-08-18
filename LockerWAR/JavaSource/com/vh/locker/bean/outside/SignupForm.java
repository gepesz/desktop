/**
 * @file SignupForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Form for the signup action.
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
public class SignupForm extends ActionForm {

  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private String passwordAgain;
  private Long   question;
  private String answer;
  private String email;
  private String captcha;

  /**
   * @return
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * @return
   */
  public String getCaptcha() {
    return captcha;
  }

  /**
   * @return
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return
   */
  public String getPassword() {
    return password;
  }

  /**
   * @return
   */
  public String getPasswordAgain() {
    return passwordAgain;
  }

  /**
   * @return
   */
  public Long getQuestion() {
    return question;
  }

  /**
   * @return
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param string
   */
  public void setAnswer(String string) {
    answer = string;
  }

  /**
   * @param string
   */
  public void setCaptcha(String string) {
    captcha = string;
  }

  /**
   * @param string
   */
  public void setEmail(String string) {
    email = string;
  }

  /**
   * @param string
   */
  public void setFirstName(String string) {
    firstName = string;
  }

  /**
   * @param string
   */
  public void setLastName(String string) {
    lastName = string;
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
  public void setPasswordAgain(String string) {
    passwordAgain = string;
  }

  /**
   * @param string
   */
  public void setQuestion(Long l) {
    question = l;
  }

  /**
   * @param string
   */
  public void setUserName(String string) {
    userName = string;
  }

}