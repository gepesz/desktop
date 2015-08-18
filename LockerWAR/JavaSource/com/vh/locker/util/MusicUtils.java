/**
 * @file MusicUtils
 * @author peter.szocs
 * @version 1.0
 * 
 * Tab pane and left navigation pane related methods.
 */



package com.vh.locker.util;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;

import javazoom.jlme.decoder.BitStream;
import javazoom.jlme.decoder.Header;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.vh.locker.ejb.Artist;
import com.vh.locker.ejb.MusicFile;
import com.vh.locker.service.MusicService;
import com.vh.locker.service.ServiceManager;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  Peter.Szocs
 * @version 1.0
 */
public class MusicUtils {

  private static Logger log = Logger.getLogger(MusicUtils.class);
  private static boolean IS_DEBUG = log.isDebugEnabled();
  

  /**
   * Creates a default.m3u file on the hard drive for the user in session
   * for the requested songs.  The objective of this method is to rewrite the
   * default.m3u file with the newly requested songs.
   * 
   * @param songIds Long[] the requested songs
   * @param req HttpServletRequest the request
   * @throws Exception
   */
  public static void createPlaylist(Long[] songIds, HttpServletRequest req) throws Exception {
    String userName = ActionUtils.getUserFromSession(req).getUserName();
    String filePath = Constants.FILEUPLOAD_PREFIX+userName+Constants.MUSIC_PLAYLISTFILE;
    if(IS_DEBUG) log.debug("filePath="+filePath);
    BufferedWriter bw = null;
    try {    
      bw = new BufferedWriter(new FileWriter(filePath, false));
      bw.write("#EXTM3U");
      bw.newLine();
      MusicService mus = (MusicService) ServiceManager.acquire(Constants.SERVICEKEY_MUSIC);
      for(int i=0;i<songIds.length;i++) {
        MusicFile mp3 = mus.findMusicFileById(songIds[i]);
        mp3.setNofPlayed(mp3.getNofPlayed()+1);
        bw.write("#EXTINF:"+String.valueOf(mp3.getLength())+",");
        Artist artist = mp3.getArtist();
        if(artist!=null) bw.write(mp3.getArtist().getDesc()+" - "+mp3.getSongTitle());
        else bw.write("N/A - "+mp3.getSongTitle());
        bw.newLine();
        bw.write(Constants.JLGUI_PREFIX+userName+"/zdocs/music/"+mp3.getLink());
        bw.newLine();
      }
      ServiceManager.release(Constants.SERVICEKEY_MUSIC, mus);
      
      bw.flush();
      bw.close();      
    } catch(Exception ex) {
      log.error("Error while creating "+filePath+" playlist file: "+ex.getMessage());
      throw ex;        
    } finally {
      if(bw!=null) bw.close();
    }
  }



  /**
   * Rewrites the jlgui.ini file on the hard drive for the user in session with the
   * requested shuffle parameter.  The objective of this method is to switch the
   * shuffle_enabled key inside jlgui.ini to the requested value. 
   * 
   * @param shuffle boolean shuffle_enabled will be set to this value
   * @param req HttpServletRequest the request
   * @throws Exception
   */
  public static void createInitFile(boolean shuffle, HttpServletRequest req) throws Exception {
    String userName = ActionUtils.getUserFromSession(req).getUserName();
    String filePath = Constants.FILEUPLOAD_PREFIX+userName+Constants.MUSIC_INITFILE;
    if(IS_DEBUG) log.debug("filePath="+filePath);
    try {
      Properties jlProps = new Properties();
      jlProps.load(new FileInputStream(new File(filePath)));
      jlProps.setProperty("shuffle_enabled", String.valueOf(shuffle));
      jlProps.store(new FileOutputStream(filePath), null);        
    } catch(Exception ex) {
      log.error("Error while creating "+filePath+" file: "+ex.getMessage());
      throw ex;        
    } finally {}
  }



  /**
   * Returns the name of the default playlist file for the jsp.
   * The java applet will pick up and play the m3u file that this method returns.
   * 
   * @param req HttpServletRequest the request
   * @return String the location of the m3u file to be played
   */
  public static String getPlaylist(HttpServletRequest req) {
    return "home/"+ActionUtils.getUserFromSession(req).getUserName()+Constants.MUSIC_PLAYLISTFILE;
  }



  /**
   * Returns the init config file for the java music applet.
   * 
   * @param req HttpServletRequest the request
   * @return String the location of the jlgui.ini file on the file system
   */
  public static String getInitFile(HttpServletRequest req) {
    return "home/"+ActionUtils.getUserFromSession(req).getUserName()+Constants.MUSIC_INITFILE;
  }



  /**
   * Returns the full file path for musicfile.
   * 
   * @param String songId The songId
   * @return String the full file path of the file on the system.
   */
  public static String getFilePath(String songId) throws Exception {
    MusicService mcs = (MusicService) ServiceManager.acquire(Constants.SERVICEKEY_MUSIC);
    MusicFile mp3 = mcs.findMusicFileById(new Long(songId));
    ServiceManager.release(Constants.SERVICEKEY_MUSIC, mcs);
    String userName = mp3.getUser().getUserName();
    String path = Constants.FILEUPLOAD_PREFIX+userName+"/zdocs/music/"+mp3.getLink();
    return path;
  }



  /**
   * Returns the init config file for the java music applet.
   * 
   * @param String[] the String[] to be converted
   * @return Long[] the converted array
   */
  public static Long[] stringToLongArray(String[] arr) {
    Long[] newArr = null;
    if(arr!=null) { 
      newArr = new Long[arr.length];
      for(int i=0;i<arr.length;i++) newArr[i]=new Long(arr[i]);
    }
    return newArr;
  }



  /**
   * Returns the length of the song in seconds.
   * 
   * @param File the file
   * @return long the length of the song in seconds.
   */
  public static long getLengthInSeconds(String filePath) throws Exception {
    long duration=300;
    File f = new File(filePath);
    if((f!=null) && (f.exists()) && (!f.isDirectory())) {
      long fileSize = f.length();
      BitStream bitstream = new BitStream(new BufferedInputStream(new FileInputStream(filePath), 2048));
      if(bitstream!=null) {
        Header header = bitstream.readFrame();    
        long bitRate = header.getBitrate();
        if(bitRate!=0) duration=8*fileSize/bitRate;
      }
    }
    return duration;
  }



  /**
   * Returns the length of the song in seconds.
   * 
   * @param FormFile theFile containing the new music file 
   * @return long the length of the song in seconds.
   */
  public static long getLengthInSeconds(FormFile theFile) throws Exception {
    long duration=300;
    if(theFile!=null) {
      long fileSize = theFile.getFileSize();
      BitStream bitstream = new BitStream(new BufferedInputStream(theFile.getInputStream(), 2048));
      if(bitstream!=null) {
        Header header = bitstream.readFrame();
        long bitRate = header.getBitrate();
        if(bitRate!=0) duration=8*fileSize/bitRate;
      }
    }
    return duration;
  }
  
  
}
