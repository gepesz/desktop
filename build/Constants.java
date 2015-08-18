/**
 * @file Constants
 * @author peter.szocs
 * 
 * Constants to be used throughout the VH project.
 */


package com.vh.locker.util;

import java.util.ResourceBundle;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  peter.szocs
 * @version 1.0
 */
public interface Constants {

  //Resource bundles
  public static final ResourceBundle IMAGES    = ResourceBundle.getBundle("com.vh.locker.resources.images");
  public static final ResourceBundle SERVICES  = ResourceBundle.getBundle("com.vh.locker.resources.services");
  public static final String LABELS = "resources";

  
  //File upload/download constants
  public static final String FILEUPLOAD_PREFIX="/home/peter/build/vh/trunk/LockerWAR/WebContent/home/";
  public static final String      JLGUI_PREFIX="../home/";
  public static final int    FILEUPLOAD_BUFFER=8192;
  public static final int  FILEDOWNLOAD_BUFFER=8192;
  public static final int          MAXFILESIZE=20; //in MB


  //Music constants
  public static final String MUSIC_PLAYLISTFILE="/zdocs/music/default.m3u";
  public static final String MUSIC_INITFILE="/zdocs/music/jlgui.ini";


  //Cookie constants
  public static final String  COOKIE_LANGUAGE="zlan";
  public static final String  COOKIE_REMEMBER="zrem";
  public static final String  COOKIE_USERNAME="zusr";
  public static final String  COOKIE_PASSWORD="zpwd";
  public static final boolean COOKIE_STOREPASSWORD=false;


  //Application constants
  public static final boolean SIGNUP_ENABLED=false;


  //SMTP server for email
  public static final String SMTPSERVER="zlocker.com";

  
  //Service name constants
  public static final String SERVICEKEY_CONTACT = "contactService";
  public static final String SERVICEKEY_EMAIL   = "emailService";
  public static final String SERVICEKEY_MUSIC   = "musicService";
  public static final String SERVICEKEY_PHOTO   = "photoService";
  public static final String SERVICEKEY_USER    = "userService";


  //Gender constants
  public static final byte GENDER_MALE   = 0;
  public static final byte GENDER_FEMALE = 1;


  //Picker types
  public static final int TYPE_ALBUM       = 0;
  public static final int TYPE_ARTIST      = 1;
  public static final int TYPE_CONTACT     = 2;
  public static final int TYPE_GENRE       = 3;
  public static final int TYPE_MIX         = 4;
  public static final int TYPE_PHOTO       = 5;
  public static final int TYPE_PHOTOALBUM  = 6;
  public static final int TYPE_SONG        = 7;


  //UserStatus constants
  public static final Long USERSTATUS_TRIAL     = new Long(1);
  public static final Long USERSTATUS_ACTIVE    = new Long(2);
  public static final Long USERSTATUS_CLOSED    = new Long(3);
  public static final Long USERSTATUS_EXPIRED   = new Long(4);
  public static final Long USERSTATUS_SUSPENDED = new Long(5);


  //UserType constants
  public static final Long USERTYPE_BASIC = new Long(1);
  public static final Long USERTYPE_ADMIN = new Long(2);


  //DataSource JNDI name
  //NOTE:(1) WebSphere:  DATASOURCE = "jdbc/LockerDS";
  //	   (2) JBOSS:      DATASOURCE = "java:/jdbc/LockerDS";
  //public static final String DATASOURCE = "jdbc/LockerDS";
  public static final String DATASOURCE =  "java:/jdbc/LockerDS";

  
  //EJB JNDI names
  public static final String Album_HOME=             "java:comp/env/com/vh/locker/ejb/AlbumHome";
  public static final String Application_HOME=       "java:comp/env/com/vh/locker/ejb/ApplicationHome";  
  public static final String Artist_HOME=            "java:comp/env/com/vh/locker/ejb/ArtistHome";
  public static final String Contact_HOME=           "java:comp/env/com/vh/locker/ejb/ContactHome";
  public static final String Country_HOME=     	     "java:comp/env/com/vh/locker/ejb/CountryHome";
  public static final String FileType_HOME=          "java:comp/env/com/vh/locker/ejb/FileTypeHome";
  public static final String Genre_HOME=             "java:comp/env/com/vh/locker/ejb/GenreHome";
  public static final String Language_HOME=          "java:comp/env/com/vh/locker/ejb/LanguageHome";
  public static final String Mixes_HOME=             "java:comp/env/com/vh/locker/ejb/MixesHome";
  public static final String MusicFile_HOME=         "java:comp/env/com/vh/locker/ejb/MusicFileHome";
  public static final String Photo_HOME=             "java:comp/env/com/vh/locker/ejb/PhotoHome";
  public static final String PhotoAlbum_HOME=        "java:comp/env/com/vh/locker/ejb/PhotoAlbumHome";
  public static final String RelMusicMixes_HOME=     "java:comp/env/com/vh/locker/ejb/RelMusicMixesHome";
  public static final String RelPhotoAlbum_HOME=     "java:comp/env/com/vh/locker/ejb/RelPhotoAlbumHome";
  public static final String SecretQuestion_HOME=    "java:comp/env/com/vh/locker/ejb/SecretQuestionHome";
  public static final String ShortCut_HOME=          "java:comp/env/com/vh/locker/ejb/ShortCutHome";
  public static final String Skin_HOME=              "java:comp/env/com/vh/locker/ejb/SkinHome";
  public static final String User_HOME=              "java:comp/env/com/vh/locker/ejb/UserHome";
  public static final String UserStatus_HOME=        "java:comp/env/com/vh/locker/ejb/UserStatusHome";
  public static final String UserType_HOME=          "java:comp/env/com/vh/locker/ejb/UserTypeHome";
  

}
