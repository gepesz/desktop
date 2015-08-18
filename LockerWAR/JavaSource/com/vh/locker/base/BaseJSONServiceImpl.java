/**
 * @file BaseJSONServiceImpl
 * @author peter.szocs
 * 
 * Base class for JSON service methods.
 * Holds the session var as well as other helper vars (like authenticated user).
 */


package com.vh.locker.base;

import javax.servlet.http.HttpSession;

import com.vh.locker.ejb.User;
import com.vh.locker.util.Constants_Scope;


/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class BaseJSONServiceImpl {

  protected HttpSession session;  //The current session
  protected User user;            //The authenticated user in the current session
  protected Long userId;          //The authenticated user's id
  protected String userName;      //The authenticated user's userName
  
  public BaseJSONServiceImpl(HttpSession session) {
    this.session = session;
    this.user = (User) session.getAttribute(Constants_Scope.USER_KEY);
    if(user!=null) {
      this.userId = this.user.getId();
      this.userName = this.user.getUserName();
    } 
  }
  
}