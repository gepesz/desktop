/**
 * @file ShortCut
 * @author peter.szocs
 * @version 1.0
 * 
 * Contains all necessary data for a shortcut.
 */


package com.vh.locker.bean.json;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class ShortCut {

    private String desc;
    private String icon;
    private int appId;
    private int x;
    private int y;
	
    /**
     * @return
     */
    public String getDesc() {
    	return desc;
    }
    
    /**
     * @return
     */
    public String getIcon() {
    	return icon;
    }
    
    /**
     * @return
     */
    public int getAppId() {
    	return appId;
    }
    
    
    /**
     * @param string
     */
    public void setDesc(String string) {
    	desc = string;
    }
    
    /**
     * @param string
     */
    public void setIcon(String string) {
    	icon = string;
    }
    
    /**
     * @param string
     */
    public void setAppId(int id) {
    	appId = id;
    }
    
    /**
	   * @return
	   */
    public int getX() {
		  return x;
	  }

    /**
	   * @param string
	   */
	  public void setX(int i) {
		  x = i;
	  }

	  /**
	   * @return
	   */
	  public int getY() {
		  return y;
	  }

	  /**
	   * @param i
	   */
	  public void setY(int i) {
		  y = i;
	  }

}