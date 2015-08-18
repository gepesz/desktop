/**
 * @file ShortcutForm
 * @author peter.szocs
 * @version 1.0
 * 
 * This form is used when creating a shortcut on the desktop.
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
public class ShortcutForm extends ActionForm {

  private String shortcutApp;
  private String shortcutName;
  
  /**
   * @return
   */
  public String getShortcutApp() {
    return shortcutApp;
  }

  /**
   * @return
   */
  public String getShortcutName() {
    return shortcutName;
  }

  /**
   * @param string
   */
  public void setShortcutApp(String string) {
    shortcutApp = string;
  }

  /**
   * @param string
   */
  public void setShortcutName(String string) {
    shortcutName = string;
  }

}