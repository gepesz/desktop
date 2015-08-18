/**
 * @file StartMusic
 * @author peter.szocs
 * @version 1.0
 * 
 * Start action for 'music.'
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
import org.apache.struts.util.MessageResources;

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
public class StartMusic extends BaseInsideAction {

  private static Logger log = Logger.getLogger(StartMusic.class);

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
    
    //put genre coll into session
    if((t==null) || (t.length()==0)) {
      request.getSession().setAttribute("allGenreColl", mcs.findGenreByUser(userId));
    }
    
    //get music coll from db
    Collection musicColl = null;
    if(t!=null) {
      String id = request.getParameter("id");
      Long idLong = null;
      boolean ok = true;
      int cases=0;
      //convert cases    
      try {
        cases = Integer.parseInt(t);
      } catch(Exception ex) {
        log.warn("/music/StartMusic.do?t="+t+" is undefined case.  The error is: "+ex.getMessage());
        ok=false;
      }

      if(ok && (cases>1) && (id!=null) && (id.length()>0)) {
        try {
          idLong = new Long(id);
        } catch(Exception ex) {
          log.warn("/music/StartMusic.do?t="+t+"&id="+id+" is undefined case.  The error is: "+ex.getMessage());
          ok=false;
        }
      } else if(cases>1) {
        ok=false;
      }
      
      if(ok) {
        switch (cases) {
          case 0:  if(IS_DEBUG) log.debug("case 0: tracks");  musicColl = mcs.findMusicFileByUser(userId);     break;
          case 1:  if(IS_DEBUG) log.debug("case 1: recent");  musicColl = mcs.findMostRecentMusicFile(userId); break;
          case 2:  if(IS_DEBUG) log.debug("case 2: album");   musicColl = mcs.findMusicFileByAlbum(idLong);    break;
          case 3:  if(IS_DEBUG) log.debug("case 3: artist");  musicColl = mcs.findMusicFileByArtist(idLong);   break;
          case 4:  if(IS_DEBUG) log.debug("case 4: genre");   musicColl = mcs.findMusicFileByGenre(idLong);    break;
          case 5:  if(IS_DEBUG) log.debug("case 5: mix");     musicColl = mcs.findMusicFileByMix(idLong);      break;
          default: if(IS_DEBUG) log.debug("default: tracks"); musicColl = mcs.findMusicFileByUser(userId);     break;
        }            
      }
    }

    //default case    
    if(musicColl==null) musicColl = mcs.findMusicFileByUser(userId);

    releaseService(Constants.SERVICEKEY_MUSIC, mcs);
    request.setAttribute("musicColl", musicColl);
    
    return mapping.findForward("success");
  }
}
