/**
 * @file PlayAlbum
 * @author peter.szocs
 * @version 1.0
 * 
 * Plays mp3 albums that user selects.
 */


package com.vh.locker.action.inside;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
import com.vh.locker.bean.inside.GridForm;
import com.vh.locker.ejb.MusicFile;
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
public class PlayAlbum extends BaseInsideAction {

  private static Logger log = Logger.getLogger(PlayAlbum.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    //setup m3u to play
    GridForm gridForm = (GridForm) request.getAttribute("gridForm");
    String[] albumIds = gridForm.getId(); // the selected albums ids
    ArrayList arr = new ArrayList(); // all mp3 ids in all of the selected albums
    MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);
    for(int i=0;i<albumIds.length;i++) {
      Collection mp3Coll = mcs.findMusicFileByAlbum(new Long(albumIds[i]));
      if(mp3Coll!=null) {
        Iterator it = mp3Coll.iterator();
        while(it.hasNext()) {
          MusicFile mp3 = (MusicFile)it.next();
          arr.add(mp3.getId());
          log.debug("Added mp3="+mp3.getId());
        }
      }
    }
    Long[] mp3Ids = (Long[]) arr.toArray(new Long[]{});
    MusicUtils.createPlaylist(mp3Ids, request);
    if(request.getParameter("s").equalsIgnoreCase("1")) MusicUtils.createInitFile(true, request);
    else MusicUtils.createInitFile(false, request);
    request.setAttribute("playlist", MusicUtils.getPlaylist(request));
    request.setAttribute("init",     MusicUtils.getInitFile(request));
        
    return mapping.findForward("success");
  }
}
