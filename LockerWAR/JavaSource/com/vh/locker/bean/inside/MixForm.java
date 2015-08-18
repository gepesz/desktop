/**
 * @file MixForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Used when creating a music mix.
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
public class MixForm extends ActionForm {

  private Long     mfId;
  private String   mfName;
  private Long     mfGenreId;
  private String[] mfColl;
	
  /**
   * @return
   */
  public String[] getMfColl() {
	return mfColl;
  }

  /**
   * @return
   */
  public Long getMfGenreId() {
	return mfGenreId;
  }

  /**
   * @return
   */
  public Long getMfId() {
	return mfId;
  }

  /**
   * @return
   */
  public String getMfName() {
	return mfName;
  }

  /**
   * @param strings
   */
  public void setMfColl(String[] strings) {
	mfColl = strings;
  }

  /**
   * @param long1
   */
  public void setMfGenreId(Long long1) {
	mfGenreId = long1;
  }

  /**
   * @param long1
   */
  public void setMfId(Long long1) {
	mfId = long1;
  }

  /**
   * @param string
   */
  public void setMfName(String string) {
	mfName = string;
  }

}