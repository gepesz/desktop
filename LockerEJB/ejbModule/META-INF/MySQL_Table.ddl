
DROP TABLE locker.ALBUM;
DROP TABLE locker.APPLICATION;
DROP TABLE locker.ARTIST;
DROP TABLE locker.CONTACT;
DROP TABLE locker.COUNTRY;
DROP TABLE locker.FILETYPE;
DROP TABLE locker.GENRE;
DROP TABLE locker.LANGUAGE;
DROP TABLE locker.MIXES;
DROP TABLE locker.MUSICFILE;
DROP TABLE locker.PHOTO;
DROP TABLE locker.PHOTOALBUM;
DROP TABLE locker.RELMUSICMIXES;
DROP TABLE locker.RELPHOTOALBUM;
DROP TABLE locker.SECRETQUESTION;
DROP TABLE locker.SHORTCUT;
DROP TABLE locker.SKIN;
DROP TABLE locker.USER1;
DROP TABLE locker.USERSTATUS;
DROP TABLE locker.USERTYPE;


CREATE TABLE ALBUM (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  `USER_ID` bigint(20) default NULL,  
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE APPLICATION (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  `DEFAULTICON` varchar(250) binary default NULL,
  `TARGETURL` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE ARTIST (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  `USER_ID` bigint(20) default NULL,  
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE CONTACT (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) binary default NULL,
  `NICKNAME` varchar(250) binary default NULL,
  `PHONE` varchar(250) binary default NULL,
  `EMAIL` varchar(250) binary default NULL,
  `USER_ID` bigint(20) default NULL,  
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE COUNTRY (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE FILETYPE (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE GENRE (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  `USER_ID` bigint(20) default NULL,  
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE LANGUAGE (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LOC` varchar(250) binary default NULL,
  `FLAG` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE MIXES (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(250) binary default NULL,
  `LENGTH` bigint(20) NOT NULL default '0',
  `DATECREATED` datetime default NULL,
  `NOFPLAYED` bigint(20) NOT NULL default '0',
  `GENRE_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE MUSICFILE (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ARTIST_ID` bigint(20) default NULL,
  `SONGTITLE` varchar(250) binary default NULL,
  `ALBUM_ID` bigint(20) default NULL,
  `LENGTH` bigint(20) NOT NULL default '0',
  `DATECREATED` datetime default NULL,
  `LINK` varchar(250) binary default NULL,
  `NOFPLAYED` bigint(20) NOT NULL default '0',
  `GENRE_ID` bigint(20) default NULL,
  `FILETYPE_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE PHOTO (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  `LINK` varchar(250) binary default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE PHOTOALBUM (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(250) binary default NULL,
  `DESC1` varchar(250) binary default NULL,
  `DATECREATED` datetime default NULL,
  `NOFVISITS` bigint(20) NOT NULL default '0',
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE RELMUSICMIXES (
  `MUSICFILEID` bigint(20) NOT NULL default '0',
  `MIXESID` bigint(20) NOT NULL default '0',
  `ORDERINMIX` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`MUSICFILEID`,`MIXESID`)
) TYPE=MyISAM; 

CREATE TABLE RELPHOTOALBUM (
  `PHOTOID` bigint(20) NOT NULL default '0',
  `ALBUMID` bigint(20) NOT NULL default '0',
  `ORDERINALBUM` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`PHOTOID`,`ALBUMID`)
) TYPE=MyISAM; 

CREATE TABLE SECRETQUESTION (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE SHORTCUT (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  `ICON` varchar(250) binary default NULL,
  `XCOORD` bigint(20) default NULL,
  `YCOORD` bigint(20) default NULL,
  `APPLICATION_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE SKIN (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(250) binary default NULL,
  `FILENAME` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE USER1 (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(250) binary default NULL,
  `MIDDLENAME` varchar(250) binary default NULL,
  `LASTNAME` varchar(250) binary default NULL,
  `GENDER` tinyint(4) NOT NULL default '0',
  `BIRTHDAY` datetime default NULL,
  `ADDRESS1` varchar(250) binary default NULL,
  `ADDRESS2` varchar(250) binary default NULL,
  `CITY` varchar(250) binary default NULL,
  `STATE` varchar(250) binary default NULL,
  `ZIP` varchar(250) binary default NULL,
  `USERNAME` varchar(250) binary default NULL,
  `PASSWORD` varchar(250) binary default NULL,
  `EMAIL` varchar(250) binary default NULL,
  `PHONE` varchar(250) binary default NULL,
  `SECRETANSWER` varchar(250) binary default NULL,  
  `NOFLOGINS` bigint(20) NOT NULL default '0',
  `DATECREATED` datetime default NULL,
  `LASTLOGIN` datetime default NULL,
  `LANGUAGE_ID` bigint(20) default NULL,
  `COUNTRY_ID` bigint(20) default NULL,
  `SECRETQUESTION_ID` bigint(20) default NULL,
  `USERTYPE_ID` bigint(20) default NULL,
  `USERSTATUS_ID` bigint(20) default NULL,
  `WALLPAPER_ID` bigint(20) default NULL,
  `SKIN_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE (`USERNAME`)
) TYPE=MyISAM; 

CREATE TABLE USERSTATUS (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

CREATE TABLE USERTYPE (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESC1` varchar(250) binary default NULL,
  PRIMARY KEY  (`ID`)
) TYPE=MyISAM; 

