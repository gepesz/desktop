/**
 * @file PickerForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Variables used by the picker.
 */

package com.vh.locker.bean.components;

import org.apache.struts.action.ActionForm;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class PickerForm extends ActionForm {
  private int pickerType;
  private String searchString;
  
  public int getPickerType() {
	return pickerType;
  }

  public String getSearchString() {
	return searchString;
  }

  public void setPickerType(int i) {
	pickerType = i;
  }

  public void setSearchString(String string) {
	searchString = string;
  }

}