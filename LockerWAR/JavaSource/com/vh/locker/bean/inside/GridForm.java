/**
 * @file GridForm
 * @author peter.szocs
 * @version 1.0
 * 
 * This form holds information when a grid checkbox is checked and an action
 * is wanted on that item (like delete, or update those items etc).
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
public class GridForm extends ActionForm {

  private String[] id;
  private String   nextAction;
  
  
  /**
   * @return
   */
  public String[] getId() {
	return id;
  }

  /**
   * @return
   */
  public String getNextAction() {
	return nextAction;
  }

  /**
   * @param strings
   */
  public void setId(String[] strings) {
	id = strings;
  }

  /**
   * @param string
   */
  public void setNextAction(String string) {
	nextAction = string;
  }

}