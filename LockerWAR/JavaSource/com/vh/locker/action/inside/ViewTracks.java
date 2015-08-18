/**
 * @file ViewTracks
 * @author peter.szocs
 * @version 1.0
 * 
 * View action for music tracks.
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
public class ViewTracks extends BaseInsideAction {

  private static Logger log = Logger.getLogger(ViewTracks.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    // Cases: (1)t=null --> first time coming to music
    //        (2)t=0    --> clicking on 'tracks'
    //        (3)t=1    --> clicking on 'most recent'
    //        (4)t=2    --> clicking on an album  (need id!)
    //        (5)t=3    --> clicking on an artist (need id!)
    //        (6)t=4    --> clicking on a  genre  (need id!)
    //        (7)t=5    --> clicking on a  mix    (need id!)
    
    String t = request.getParameter("t");
    Long userId = ActionUtils.getUserId(request);
    MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);
    
    //get music coll from db
    Collection musicColl = null;
    try {
      int cases = Integer.parseInt(t);
      switch (cases) {
        case 0:  if(IS_DEBUG) log.debug("case 0: tracks");  musicColl = mcs.findMusicFileByUser(userId);     break;
        case 1:  if(IS_DEBUG) log.debug("case 1: recent");  musicColl = mcs.findMostRecentMusicFile(userId); break;
        default: if(IS_DEBUG) log.debug("default: tracks"); musicColl = mcs.findMusicFileByUser(userId);     break;
      }            

    } catch(Exception ex) {
      log.warn("/music/StartMusic.do?t="+t+" problem.  The error is: "+ex.getMessage());
      musicColl = mcs.findMusicFileByUser(userId);
    }

    releaseService(Constants.SERVICEKEY_MUSIC, mcs);
    request.setAttribute("musicColl", musicColl);
    
    return (mapping.findForward("success"));
  }
}