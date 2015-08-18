/**
 * @file UploadMusic
 * @author peter.szocs
 * @version 1.0
 * 
 * Upload music files to user's locker.
 */


package com.vh.locker.action.inside;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.vh.locker.base.BaseInsideAction;
import com.vh.locker.bean.inside.UploadSongForm;
import com.vh.locker.ejb.MusicFile;
import com.vh.locker.service.MusicService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.FileUploader;
import com.vh.locker.util.FileUtils;
import com.vh.locker.util.MusicUtils;
import com.vh.locker.util.UploadTask;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class UploadMusic extends BaseInsideAction {

  private static Logger log = Logger.getLogger(UploadMusic.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    //get values from form
    UploadSongForm uploadSongForm = (UploadSongForm) form;
    FormFile theFile = uploadSongForm.getUpFile();
    Long userId = ActionUtils.getUserId(request);
    String fileName  = theFile.getFileName().trim().replace(' ','_');
    String ext       = FileUtils.getFileExtension(theFile);
    String artist    = uploadSongForm.getUpArtist();
    String songTitle = uploadSongForm.getUpSongTitle();
    String album     = uploadSongForm.getUpAlbum();
    String genre     = uploadSongForm.getUpGenre();
    
    //validate file, upload file
    String fileErrors=FileUtils.validateFileTypeLength(theFile, request);
    if(fileErrors.equals("")) {
      if(FileUtils.doesFileExist(theFile, "music", request)) {
        MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);    
        Collection musicColl = mcs.findMusicFileByUser(userId);
        request.setAttribute("musicColl", musicColl);
        releaseService(Constants.SERVICEKEY_MUSIC, mcs);
        ActionErrors errors = new ActionErrors();
        errors.add("error", new ActionError("errors.duplicatefile", fileName));
        saveErrors(request, errors);
        return mapping.findForward("failure");                        
      } else {
        MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);    
        mcs.createMusicFile(artist, songTitle, album, MusicUtils.getLengthInSeconds(theFile), ActionUtils.getCurrentDate(), fileName, 0, genre, ext, userId);
        Collection musicColl = mcs.findMusicFileByUser(userId);
        request.setAttribute("musicColl", musicColl);
        request.getSession().setAttribute("allGenreColl", mcs.findGenreByUser(userId));        
        releaseService(Constants.SERVICEKEY_MUSIC, mcs);
        
        /*
        UploadTask task = new UploadTask(theFile, Constants.FILEUPLOAD_PREFIX+ActionUtils.getUserFromSession(request).getUserName()+"/zdocs/music");
        request.getSession().setAttribute("task", task);        
        new Thread(task).start();
        */
        
        FileUploader.upload(theFile, "music", request.getSession());
      }
    } else {
      MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);    
      Collection musicColl = mcs.findMusicFileByUser(ActionUtils.getUserId(request));
      request.setAttribute("musicColl", musicColl);
      releaseService(Constants.SERVICEKEY_MUSIC, mcs);
      ActionErrors errors = new ActionErrors();
      errors.add("error", new ActionError("errors.none", fileErrors));
      saveErrors(request, errors);
      return mapping.findForward("failure");                
    }

    return mapping.findForward("success");
  }
}