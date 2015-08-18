-- MySQL dump 10.10
--
-- Host: localhost    Database: locker
-- ------------------------------------------------------
-- Server version	5.0.20-Debian_1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ALBUM`
--

DROP TABLE IF EXISTS `ALBUM`;
CREATE TABLE `ALBUM` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ALBUM`
--


/*!40000 ALTER TABLE `ALBUM` DISABLE KEYS */;
LOCK TABLES `ALBUM` WRITE;
INSERT INTO `ALBUM` VALUES (1,'',NULL),(2,'Vanilla Time',1),(3,'Greatest Hits',1),(4,'Until the end of time',1),(5,'Vanilla Time',2),(6,'Greatest Hits',2),(7,'Until the end of time',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ALBUM` ENABLE KEYS */;

--
-- Table structure for table `APPLICATION`
--

DROP TABLE IF EXISTS `APPLICATION`;
CREATE TABLE `APPLICATION` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `DEFAULTICON` varchar(250) character set latin1 collate latin1_bin default NULL,
  `TARGETURL` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `APPLICATION`
--


/*!40000 ALTER TABLE `APPLICATION` DISABLE KEYS */;
LOCK TABLES `APPLICATION` WRITE;
INSERT INTO `APPLICATION` VALUES (1,'Files','/modules/files/img/folder.gif','/files/StartFiles.none'),(2,'Trash','/modules/trash/img/trashcan_empty.gif','/trash/StartTrash.none'),(3,'Email','/modules/email/img/email.gif','/email/StartEmail.none'),(4,'Music','/modules/music/img/kmix.gif','/music/StartMusic.none'),(5,'IM','/modules/im/img/kuser.gif','/im/StartIM.none'),(6,'HTML','/modules/html/img/favorites.gif','/html/StartHTML.none'),(7,'Photos','/modules/photos/img/camera.gif','/photos/StartPhotos.none'),(8,'Phone','/modules/phone/img/sms_protocol.gif','/phone/StartPhone.none'),(9,'Bills','/modules/bills/img/kwallet.gif','/bills/StartBills.none'),(10,'Notes','/modules/notes/img/korganizer.gif','/notes/StartNotes.none');
UNLOCK TABLES;
/*!40000 ALTER TABLE `APPLICATION` ENABLE KEYS */;

--
-- Table structure for table `ARTIST`
--

DROP TABLE IF EXISTS `ARTIST`;
CREATE TABLE `ARTIST` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ARTIST`
--


/*!40000 ALTER TABLE `ARTIST` DISABLE KEYS */;
LOCK TABLES `ARTIST` WRITE;
INSERT INTO `ARTIST` VALUES (1,'Vanilla Ice',1),(2,'Kevin Lyttle f. Alison Hinds',1),(3,'2 Pac',1),(4,'Vanilla Ice',2),(5,'Kevin Lyttle f. Alison Hinds',2),(6,'2 Pac',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ARTIST` ENABLE KEYS */;

--
-- Table structure for table `CONTACT`
--

DROP TABLE IF EXISTS `CONTACT`;
CREATE TABLE `CONTACT` (
  `ID` bigint(20) NOT NULL auto_increment,
  `NAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  `NICKNAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  `PHONE` varchar(250) character set latin1 collate latin1_bin default NULL,
  `EMAIL` varchar(250) character set latin1 collate latin1_bin default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CONTACT`
--


/*!40000 ALTER TABLE `CONTACT` DISABLE KEYS */;
LOCK TABLES `CONTACT` WRITE;
INSERT INTO `CONTACT` VALUES (1,'Petek Pekgoz','Petek','703-599-7232','petek@zlocker.com',1),(2,'Adrian Szabadi','Adri','202-285-3299','ekszer@freemail.hu',1),(3,'Pannon','Pannon','202-285-3299',NULL,1),(4,'Ayda Elgun','Ayda','555-555-5555','ayda@museum.ny',2),(5,'Elif Arsalbek','Elif','666-666-6666','elif@turkey.com',2),(6,'Ipek Pekgoz','Mom','703-812-3840','fipek@hotmail.com',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `CONTACT` ENABLE KEYS */;

--
-- Table structure for table `COUNTRY`
--

DROP TABLE IF EXISTS `COUNTRY`;
CREATE TABLE `COUNTRY` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `COUNTRY`
--


/*!40000 ALTER TABLE `COUNTRY` DISABLE KEYS */;
LOCK TABLES `COUNTRY` WRITE;
INSERT INTO `COUNTRY` VALUES (1,'United States'),(2,'Hungary'),(3,'Poland'),(4,'Turkey'),(5,'Mexico');
UNLOCK TABLES;
/*!40000 ALTER TABLE `COUNTRY` ENABLE KEYS */;

--
-- Table structure for table `FILETYPE`
--

DROP TABLE IF EXISTS `FILETYPE`;
CREATE TABLE `FILETYPE` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FILETYPE`
--


/*!40000 ALTER TABLE `FILETYPE` DISABLE KEYS */;
LOCK TABLES `FILETYPE` WRITE;
INSERT INTO `FILETYPE` VALUES (1,'mp3'),(2,'wav'),(3,'txt'),(4,'doc'),(5,'xls');
UNLOCK TABLES;
/*!40000 ALTER TABLE `FILETYPE` ENABLE KEYS */;

--
-- Table structure for table `GENRE`
--

DROP TABLE IF EXISTS `GENRE`;
CREATE TABLE `GENRE` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `GENRE`
--


/*!40000 ALTER TABLE `GENRE` DISABLE KEYS */;
LOCK TABLES `GENRE` WRITE;
INSERT INTO `GENRE` VALUES (1,'',NULL),(2,'Rock',1),(3,'Rap',1),(4,'Dance',1),(5,'England',1),(6,'German',1),(7,'Hungarian',1),(8,'Hip-hop',1),(9,'Etc',1),(10,'Rock',2),(11,'Other',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `GENRE` ENABLE KEYS */;

--
-- Table structure for table `LANGUAGE`
--

DROP TABLE IF EXISTS `LANGUAGE`;
CREATE TABLE `LANGUAGE` (
  `ID` bigint(20) NOT NULL auto_increment,
  `LOC` varchar(250) character set latin1 collate latin1_bin default NULL,
  `FLAG` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `LANGUAGE`
--


/*!40000 ALTER TABLE `LANGUAGE` DISABLE KEYS */;
LOCK TABLES `LANGUAGE` WRITE;
INSERT INTO `LANGUAGE` VALUES (1,'en_US','USA_flag.gif'),(2,'hu_HU','HUN_flag.gif'),(3,'tr_TR','TUR_flag.gif');
UNLOCK TABLES;
/*!40000 ALTER TABLE `LANGUAGE` ENABLE KEYS */;

--
-- Table structure for table `MIXES`
--

DROP TABLE IF EXISTS `MIXES`;
CREATE TABLE `MIXES` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TITLE` varchar(250) character set latin1 collate latin1_bin default NULL,
  `LENGTH` bigint(20) NOT NULL default '0',
  `DATECREATED` datetime default NULL,
  `NOFPLAYED` bigint(20) NOT NULL default '0',
  `GENRE_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MIXES`
--


/*!40000 ALTER TABLE `MIXES` DISABLE KEYS */;
LOCK TABLES `MIXES` WRITE;
INSERT INTO `MIXES` VALUES (1,'Peter Mix 1',273,'2006-04-09 04:00:10',1,2),(2,'Peter Mix 2',577,'2006-04-09 04:00:10',2,3),(3,'Peter Mix 3',818,'2006-04-09 04:00:10',3,9),(4,'Petek Mix 1',273,'2006-04-09 04:00:10',0,10),(5,'Petek Mix 2',577,'2006-04-09 04:00:10',3,11);
UNLOCK TABLES;
/*!40000 ALTER TABLE `MIXES` ENABLE KEYS */;

--
-- Table structure for table `MUSICFILE`
--

DROP TABLE IF EXISTS `MUSICFILE`;
CREATE TABLE `MUSICFILE` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ARTIST_ID` bigint(20) default NULL,
  `SONGTITLE` varchar(250) character set latin1 collate latin1_bin default NULL,
  `ALBUM_ID` bigint(20) default NULL,
  `LENGTH` bigint(20) NOT NULL default '0',
  `DATECREATED` datetime default NULL,
  `LINK` varchar(250) character set latin1 collate latin1_bin default NULL,
  `NOFPLAYED` bigint(20) NOT NULL default '0',
  `GENRE_ID` bigint(20) default NULL,
  `FILETYPE_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MUSICFILE`
--


/*!40000 ALTER TABLE `MUSICFILE` DISABLE KEYS */;
LOCK TABLES `MUSICFILE` WRITE;
INSERT INTO `MUSICFILE` VALUES (1,1,'Ice Ice Baby',2,273,'2006-04-09 04:00:10','Vanilla_Ice_-_Ice_Ice_Baby.mp3',0,3,1,1),(2,2,'Turn Me On (Extended Remix)',3,304,'2006-04-09 04:00:10','Kevin_Lyttle_-_Turn_me_on.mp3',0,9,1,1),(3,3,'California Love',4,241,'2006-04-09 04:00:10','California_Love.mp3',0,3,1,1),(4,4,'Ice Ice Baby',5,273,'2006-04-09 04:00:10','Vanilla_Ice_-_Ice_Ice_Baby.mp3',0,11,1,2),(5,5,'Turn Me On (Extended Remix)',6,304,'2006-04-09 04:00:10','Kevin_Lyttle_-_Turn_me_on.mp3',0,11,1,2),(6,6,'California Love',7,241,'2006-04-09 04:00:10','California_Love.mp3',0,11,1,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `MUSICFILE` ENABLE KEYS */;

--
-- Table structure for table `PHOTO`
--

DROP TABLE IF EXISTS `PHOTO`;
CREATE TABLE `PHOTO` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `LINK` varchar(250) character set latin1 collate latin1_bin default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PHOTO`
--


/*!40000 ALTER TABLE `PHOTO` DISABLE KEYS */;
LOCK TABLES `PHOTO` WRITE;
INSERT INTO `PHOTO` VALUES (1,'Thailand','thailand3.jpg',NULL),(2,'Cruise 1','kruz2005_0003.jpg',1),(3,'Cruise 2','kruz2005_0004.jpg',1),(4,'Cruise 3','kruz2005_0005.jpg',1),(5,'Cruise 4','kruz2005_0003.jpg',2),(6,'Cruise 5','kruz2005_0004.jpg',2),(7,'Cruise 6','kruz2005_0005.jpg',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `PHOTO` ENABLE KEYS */;

--
-- Table structure for table `PHOTOALBUM`
--

DROP TABLE IF EXISTS `PHOTOALBUM`;
CREATE TABLE `PHOTOALBUM` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TITLE` varchar(250) character set latin1 collate latin1_bin default NULL,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `DATECREATED` datetime default NULL,
  `NOFVISITS` bigint(20) NOT NULL default '0',
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PHOTOALBUM`
--


/*!40000 ALTER TABLE `PHOTOALBUM` DISABLE KEYS */;
LOCK TABLES `PHOTOALBUM` WRITE;
INSERT INTO `PHOTOALBUM` VALUES (1,'Cruise 2003','Another great vacation, paid for by!','2006-04-09 04:00:10',3,1),(2,'Cruise 2005','Sun and fun down under','2006-04-09 04:00:10',12,1),(3,'Cruise 2003','Another great vacation, paid for by!','2006-04-09 04:00:10',2,2),(4,'Cruise 2005','Sun and fun down under','2006-04-09 04:00:10',7,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `PHOTOALBUM` ENABLE KEYS */;

--
-- Table structure for table `RELMUSICMIXES`
--

DROP TABLE IF EXISTS `RELMUSICMIXES`;
CREATE TABLE `RELMUSICMIXES` (
  `MUSICFILEID` bigint(20) NOT NULL default '0',
  `MIXESID` bigint(20) NOT NULL default '0',
  `ORDERINMIX` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`MUSICFILEID`,`MIXESID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `RELMUSICMIXES`
--


/*!40000 ALTER TABLE `RELMUSICMIXES` DISABLE KEYS */;
LOCK TABLES `RELMUSICMIXES` WRITE;
INSERT INTO `RELMUSICMIXES` VALUES (1,1,1),(1,2,1),(2,2,2),(1,3,1),(2,3,2),(3,3,3),(4,4,1),(4,5,1),(5,5,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `RELMUSICMIXES` ENABLE KEYS */;

--
-- Table structure for table `RELPHOTOALBUM`
--

DROP TABLE IF EXISTS `RELPHOTOALBUM`;
CREATE TABLE `RELPHOTOALBUM` (
  `PHOTOID` bigint(20) NOT NULL default '0',
  `ALBUMID` bigint(20) NOT NULL default '0',
  `ORDERINALBUM` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`PHOTOID`,`ALBUMID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `RELPHOTOALBUM`
--


/*!40000 ALTER TABLE `RELPHOTOALBUM` DISABLE KEYS */;
LOCK TABLES `RELPHOTOALBUM` WRITE;
INSERT INTO `RELPHOTOALBUM` VALUES (1,1,1),(2,1,2),(3,1,3),(2,2,1),(3,2,2),(4,3,1),(5,3,2),(6,3,3),(5,4,1),(6,4,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `RELPHOTOALBUM` ENABLE KEYS */;

--
-- Table structure for table `SECRETQUESTION`
--

DROP TABLE IF EXISTS `SECRETQUESTION`;
CREATE TABLE `SECRETQUESTION` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SECRETQUESTION`
--


/*!40000 ALTER TABLE `SECRETQUESTION` DISABLE KEYS */;
LOCK TABLES `SECRETQUESTION` WRITE;
INSERT INTO `SECRETQUESTION` VALUES (1,'What\'s your mother\'s maiden name?'),(2,'What was your nickname in high school?'),(3,'What\'s your favorite movie?');
UNLOCK TABLES;
/*!40000 ALTER TABLE `SECRETQUESTION` ENABLE KEYS */;

--
-- Table structure for table `SHORTCUT`
--

DROP TABLE IF EXISTS `SHORTCUT`;
CREATE TABLE `SHORTCUT` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `ICON` varchar(250) character set latin1 collate latin1_bin default NULL,
  `XCOORD` bigint(20) default NULL,
  `YCOORD` bigint(20) default NULL,
  `APPLICATION_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SHORTCUT`
--


/*!40000 ALTER TABLE `SHORTCUT` DISABLE KEYS */;
LOCK TABLES `SHORTCUT` WRITE;
INSERT INTO `SHORTCUT` VALUES (78,'Notes','/modules/notes/img/korganizer.gif',95,237,10,2),(106,'Files','/modules/files/img/folder.gif',0,5,1,1),(107,'Phone','/modules/phone/img/sms_protocol.gif',95,179,8,1),(108,'Notes','/modules/notes/img/korganizer.gif',95,237,10,1),(105,'Email','/modules/email/img/email.gif',0,63,3,1),(104,'HTML','/modules/html/img/favorites.gif',95,121,6,1),(103,'Trash','/modules/trash/img/trashcan_empty.gif',340,230,2,1),(77,'Bills','/modules/bills/img/kwallet.gif',0,237,9,2),(76,'Phone','/modules/phone/img/sms_protocol.gif',95,179,8,2),(75,'Photos','/modules/photos/img/camera.gif',0,179,7,2),(74,'HTML','/modules/html/img/favorites.gif',95,121,6,2),(73,'IM','/modules/im/img/kuser.gif',0,121,5,2),(72,'Email','/modules/email/img/email.gif',0,63,3,2),(71,'Trash','/modules/trash/img/trashcan_empty.gif',95,5,2,2),(70,'Files','/modules/files/img/folder.gif',0,5,1,2),(102,'Music','/modules/music/img/kmix.gif',271,88,4,1),(100,'Photos','/modules/photos/img/camera.gif',0,179,7,1),(101,'IM','/modules/im/img/kuser.gif',0,121,5,1),(99,'Bills','/modules/bills/img/kwallet.gif',0,237,9,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `SHORTCUT` ENABLE KEYS */;

--
-- Table structure for table `SKIN`
--

DROP TABLE IF EXISTS `SKIN`;
CREATE TABLE `SKIN` (
  `ID` bigint(20) NOT NULL auto_increment,
  `NAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  `FILENAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SKIN`
--


/*!40000 ALTER TABLE `SKIN` DISABLE KEYS */;
LOCK TABLES `SKIN` WRITE;
INSERT INTO `SKIN` VALUES (1,'Blue','blue.css'),(2,'Green','green.css'),(3,'Grey','grey.css'),(4,'Purple','purple.css'),(5,'Red','red.css'),(6,'Yellow','yellow.css');
UNLOCK TABLES;
/*!40000 ALTER TABLE `SKIN` ENABLE KEYS */;

--
-- Table structure for table `USER1`
--

DROP TABLE IF EXISTS `USER1`;
CREATE TABLE `USER1` (
  `ID` bigint(20) NOT NULL auto_increment,
  `FIRSTNAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  `MIDDLENAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  `LASTNAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  `GENDER` tinyint(4) NOT NULL default '0',
  `BIRTHDAY` datetime default NULL,
  `ADDRESS1` varchar(250) character set latin1 collate latin1_bin default NULL,
  `ADDRESS2` varchar(250) character set latin1 collate latin1_bin default NULL,
  `CITY` varchar(250) character set latin1 collate latin1_bin default NULL,
  `STATE` varchar(250) character set latin1 collate latin1_bin default NULL,
  `ZIP` varchar(250) character set latin1 collate latin1_bin default NULL,
  `USERNAME` varchar(250) character set latin1 collate latin1_bin default NULL,
  `PASSWORD` varchar(250) character set latin1 collate latin1_bin default NULL,
  `EMAIL` varchar(250) character set latin1 collate latin1_bin default NULL,
  `PHONE` varchar(250) character set latin1 collate latin1_bin default NULL,
  `SECRETANSWER` varchar(250) character set latin1 collate latin1_bin default NULL,
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
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USER1`
--


/*!40000 ALTER TABLE `USER1` DISABLE KEYS */;
LOCK TABLES `USER1` WRITE;
INSERT INTO `USER1` VALUES (1,'Peter','','Szocs',0,'1979-05-25 12:00:00','7409 Allan Ave','','Falls Church','VA','22046','peter','peter','peter@zlocker.com','202-285-3299','secret1',5,'2006-04-09 04:00:10','2007-02-21 23:31:16',1,1,1,2,2,3,4),(2,'Petek','','Pekgoz',1,'1978-12-17 12:00:00','200 North Randolph Str.','','Arlington','VA','22203','petek','petek','petek@zlocker.com','703-599-7232','secret2',2,'2006-04-09 04:00:10','2006-12-12 15:15:01',1,1,1,1,2,0,6),(3,'Ferenc','','Vehmann',0,'1982-07-21 12:00:00','Oreghegy u. 30.','','Paks','Tolna','7030','fatso','fatso','fatso@zlocker.com','+36-75-313-973','secret3',1,'2006-04-09 04:00:10','2006-05-13 13:05:53',1,1,1,1,2,0,6),(4,'Hungary','Test','User',0,'1979-05-25 12:00:00','7409 Allan Ave','','Falls Church','VA','22046','hungary','hungary','peter@zlocker.com','202-285-3299','secret8',0,'2006-04-09 04:00:10',NULL,2,1,1,2,2,0,6),(5,'Turkey','','Turkey',0,'1980-02-20 12:00:00','7409 Allan Ave','','Falls Church','VA','22046','turkey','turkey','petek@zlocker.com','703-599-7232','secret9',0,'2006-04-09 04:00:10',NULL,3,1,1,2,2,0,6);
UNLOCK TABLES;
/*!40000 ALTER TABLE `USER1` ENABLE KEYS */;

--
-- Table structure for table `USERSTATUS`
--

DROP TABLE IF EXISTS `USERSTATUS`;
CREATE TABLE `USERSTATUS` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USERSTATUS`
--


/*!40000 ALTER TABLE `USERSTATUS` DISABLE KEYS */;
LOCK TABLES `USERSTATUS` WRITE;
INSERT INTO `USERSTATUS` VALUES (1,'Trial'),(2,'Active'),(3,'Closed'),(4,'Expired'),(5,'Suspended');
UNLOCK TABLES;
/*!40000 ALTER TABLE `USERSTATUS` ENABLE KEYS */;

--
-- Table structure for table `USERTYPE`
--

DROP TABLE IF EXISTS `USERTYPE`;
CREATE TABLE `USERTYPE` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESC1` varchar(250) character set latin1 collate latin1_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USERTYPE`
--


/*!40000 ALTER TABLE `USERTYPE` DISABLE KEYS */;
LOCK TABLES `USERTYPE` WRITE;
INSERT INTO `USERTYPE` VALUES (1,'Basic'),(2,'Admin');
UNLOCK TABLES;
/*!40000 ALTER TABLE `USERTYPE` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

