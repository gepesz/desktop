/**
 * @file LocaleBean
 * @author peter.szocs
 * @version 1.0
 * 
 * Used in select locale form.  Holds the flag for the language as well as a java.util.Locale
 * object for each of the available languages.  The Language object is repopulated into this object
 * after pulling all languages from the database to display them on the form.
 */


package com.vh.locker.bean.outside;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class LocaleBean {

  private Locale locale; //the actual Locale object
  private String loc; //String representation of the locale: en_US, hu_HU, etc
  private String displayName;     //eg: Magyar (Magyarorszag)  
  private String displayLanguage; //eg: Magyar  
  private String displayCountry;  //eg: Magyarorszag  
  private String flag;
	
  
	/**
	 * The constructor. 
	 */
	public LocaleBean(String loc, String flag) {
    this.loc = loc;
    this.flag = flag;
    this.locale = new Locale(loc.substring(0, loc.indexOf("_")), loc.substring(loc.indexOf("_")+1));
    this.displayName     = StringUtils.capitalize(this.locale.getDisplayName(this.locale));
	  this.displayLanguage = StringUtils.capitalize(this.locale.getDisplayLanguage(this.locale));
    this.displayCountry  = StringUtils.capitalize(this.locale.getDisplayCountry(this.locale));
  }

  /**
   * @return
   */
  public String getFlag() {
    return flag;
  }

  /**
   * @return
   */
  public Locale getLocale() {
    return locale;
  }

  /**
   * @param string
   */
  public void setFlag(String string) {
    flag = string;
  }

  /**
   * @param locale
   */
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  /**
   * @return
   */
  public String getLoc() {
	  return loc;
  }

  /**
   * @param string
   */
  public void setLoc(String string) {
	  loc = string;
  }

  /**
   * @return
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @param string
   */
  public void setDisplayName(String string) {
    displayName = string;
  }

  /**
   * @return
   */
  public String getDisplayCountry() {
	  return displayCountry;
  }

  /**
   * @return
   */
  public String getDisplayLanguage() {
	  return displayLanguage;
  }

  /**
   * @param string
   */
  public void setDisplayCountry(String string) {
	  displayCountry = string;
  }

  /**
   * @param string
   */
  public void setDisplayLanguage(String string) {
	  displayLanguage = string;
  }

}