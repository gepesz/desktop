/**
 * @file TaskBean
 * @author peter.szocs
 * @version 1.0
 * 
 * Contains all necessary data of a single task.
 */


package com.vh.locker.bean;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class TaskBean {

  private int id;
  private String image;
  private String name;
	private String link;
	private String alt;
	private boolean accessible;
	

	/**
	 * Constructor for Task.
	 */
	public TaskBean(int id, String image, String name, String link, String alt, boolean accessible) {
    this.id         = id;
    this.image      = image;
    this.name       = name;
    this.link       = link;
    this.alt        = alt;
    this.accessible = accessible;
	}

  /**
   * @return
   */
  public String getImage() {
    return image;
  }

	/**
	 * Returns the accessible.
	 * @return boolean
	 */
	public boolean isAccessible() {
		return accessible;
	}

	/**
	 * Returns the alt.
	 * @return String
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * Returns the link.
	 * @return String
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the accessible.
	 * @param accessible The accessible to set
	 */
	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	/**
	 * Sets the alt.
	 * @param alt The alt to set
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}

	/**
	 * Sets the link.
	 * @param link The link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

  /**
   * @param string
   */
  public void setImage(String string) {
    image = string;
  }


  /**
   * @return
   */
  public int getId() {
	  return id;
  }

  /**
   * @param i
   */
  public void setId(int i) {
	  id = i;
  }

}
