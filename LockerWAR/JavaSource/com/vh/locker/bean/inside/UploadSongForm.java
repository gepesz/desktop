/**
 * @file UploadSongForm
 * @author peter.szocs
 * @version 1.0
 * 
 * Used when uploading a music file.
 */


package com.vh.locker.bean.inside;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public class UploadSongForm extends ActionForm {

  private FormFile upFile;
  private String   upArtist;
  private String   upSongTitle;
  private String   upAlbum;
  private String   upGenre;
	

  /**
   * @return
   */
  public String getUpAlbum() {
	return upAlbum;
  }

  /**
   * @return
   */
  public String getUpArtist() {
	return upArtist;
  }

  /**
   * @return
   */
  public FormFile getUpFile() {
	return upFile;
  }

  /**
   * @return
   */
  public String getUpGenre() {
	return upGenre;
  }

  /**
   * @return
   */
  public String getUpSongTitle() {
	return upSongTitle;
  }

  /**
   * @param string
   */
  public void setUpAlbum(String string) {
	upAlbum = string;
  }

  /**
   * @param string
   */
  public void setUpArtist(String string) {
	upArtist = string;
  }

  /**
   * @param file
   */
  public void setUpFile(FormFile file) {
	upFile = file;
  }

  /**
   * @param string
   */
  public void setUpGenre(String string) {
	upGenre = string;
  }

  /**
   * @param string
   */
  public void setUpSongTitle(String string) {
	upSongTitle = string;
  }

}