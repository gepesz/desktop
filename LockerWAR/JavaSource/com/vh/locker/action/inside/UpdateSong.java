/**
 * @file UpdateSong
 * @author peter.szocs
 * @version 1.0
 * 
 * Save action for update song info.
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

import com.vh.locker.base.BaseInsideAction;
import com.vh.locker.bean.inside.SongForm;
import com.vh.locker.service.MusicService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.MusicUtils;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class UpdateSong extends BaseInsideAction {

  private static Logger log = Logger.getLogger(UpdateSong.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    //update song
    SongForm songForm = (SongForm) form;
    Long   id        = songForm.getSfId();
    String artist    = songForm.getSfArtist();
    String songtitle = songForm.getSfSongTitle();
    String album     = songForm.getSfAlbum();
    String genre     = songForm.getSfGenre();
    Long   userId    = ActionUtils.getUserId(request);
    if(IS_DEBUG) {
      log.debug("id="+id);    
      log.debug("artist="+artist);    
      log.debug("songtitle="+songtitle);    
      log.debug("album="+album);    
      log.debug("genre="+genre);    
    }

    //set request objects
    MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);
    mcs.updateMusicFile(id, artist, songtitle, album, genre, userId);
    Collection musicColl = mcs.findMusicFileByUser(userId);
    releaseService(Constants.SERVICEKEY_MUSIC, mcs);
    request.setAttribute("musicColl", musicColl);

    return (mapping.findForward("success"));
  }
}
