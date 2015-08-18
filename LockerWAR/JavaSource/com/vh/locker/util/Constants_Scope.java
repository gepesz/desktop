/**
 * @file Constants_Scope
 * @author peter.szocs
 * 
 * Constants that are used in any of the scopes: 
 *      request, session, application.
 */


package com.vh.locker.util;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public interface Constants_Scope {

  //REQUEST keys: keys for objects in request scope
  public static final String REQUEST_TOKEN_KEY = "com.vh.locker.REQUEST_TOKEN";


  //SESSION keys: keys for objects in session scope
  public static final String LOCALE_KEY         = org.apache.struts.Globals.LOCALE_KEY;
  public static final String LASTPAGE_KEY       = "com.vh.locker.LASTPAGE";
  public static final String SSOENABLED_KEY     = "com.vh.locker.SSOENABLED";
  public static final String GLOBALERRORS_KEY   = "com.vh.locker.GLOBALERRORS";
  public static final String USER_KEY           = "com.vh.locker.USER";
  public static final String TOKENS_KEY         = "com.vh.locker.base.TokenProcessor.TOKENS";
  public static final String JSONBRIDGE_KEY     = "JSONRPCBridge"; //don't change value: session key dictated by JSON!!
  

  //APPLICATION scope keys: keys for objects in application scope
  public static final String ALL_APPLICATIONS_KEY = "com.vh.locker.ALLAPPS";
  public static final String ALL_SKINS_KEY        = "com.vh.locker.ALLSKINS";
  public static final String ALL_LANGUAGES_KEY    = "com.vh.locker.ALLLANGS";

}