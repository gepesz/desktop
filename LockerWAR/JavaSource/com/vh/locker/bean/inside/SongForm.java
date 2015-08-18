/**
 * @file SongForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Used when displaying/updating music file metadata.
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
public class SongForm extends ActionForm {

  private Long   sfId;
  private String sfArtist;
  private String sfSongTitle;
  private String sfAlbum;
  private String sfGenre;
	

  /**
   * @return
   */
  public String getSfAlbum() {
	return sfAlbum;
  }

  /**
   * @return
   */
  public String getSfArtist() {
	return sfArtist;
  }

  /**
   * @return
   */
  public String getSfGenre() {
	return sfGenre;
  }

  /**
   * @return
   */
  public Long getSfId() {
	return sfId;
  }

  /**
   * @return
   */
  public String getSfSongTitle() {
	return sfSongTitle;
  }

  /**
   * @param string
   */
  public void setSfAlbum(String string) {
	sfAlbum = string;
  }

  /**
   * @param string
   */
  public void setSfArtist(String string) {
	sfArtist = string;
  }

  /**
   * @param string
   */
  public void setSfGenre(String string) {
	sfGenre = string;
  }

  /**
   * @param long1
   */
  public void setSfId(Long long1) {
	sfId = long1;
  }

  /**
   * @param string
   */
  public void setSfSongTitle(String string) {
	sfSongTitle = string;
  }

}