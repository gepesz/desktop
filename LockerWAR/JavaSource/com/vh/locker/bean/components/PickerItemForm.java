/**
 * @file PickerItemForm
 * @author peter.szocs
 * @version 1.0
 * 
 * This form represents one item in the picker.
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
public class PickerItemForm {
  private int type;
  private Long id;
  private String displayName;

  public PickerItemForm(int type, Long id, String displayName) {
    this.type = type;
    this.id = id;
    this.displayName = displayName;
  }

  public String getDisplayName() {
	return displayName;
  }

  public Long getId() {
	return id;
  }

  public int getType() {
	return type;
  }

  public void setDisplayName(String string) {
	displayName = string;
  }

  public void setId(Long l) {
	id = l;
  }

  public void setType(int i) {
	type = i;
  }

}