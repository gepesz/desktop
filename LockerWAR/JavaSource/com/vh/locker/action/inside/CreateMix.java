/**
 * @file CreateMix
 * @author peter.szocs
 * @version 1.0
 * 
 * Save action for creating music mix.
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
import com.vh.locker.bean.inside.MixForm;
import com.vh.locker.ejb.Mixes;
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
public class CreateMix extends BaseInsideAction {

  private static Logger log = Logger.getLogger(CreateMix.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    //create mix
    MixForm mixForm = (MixForm) form;
    String mixName = mixForm.getMfName();
    Long genreId =   mixForm.getMfGenreId();
    if((genreId!=null) && (genreId.longValue()<0)) genreId=new Long(1);
    String[] songs  = mixForm.getMfColl();
    if(IS_DEBUG) {
      log.debug("mixName="+mixName);
      log.debug("genreId="+genreId);
      if(songs!=null) {
        log.debug("songs.length="+songs.length);
        for(int i=0;i<songs.length;i++) {
          log.debug("song["+i+"]="+songs[i]);
        }
      } else {
        log.debug("songs is NULL");
      }
    }
    MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);
    if((songs!=null) && (songs.length>0)) {
      Long mixId = mcs.createMixes(mixName, 0, ActionUtils.getCurrentDate(), 0, genreId);
      long length = 0;
      for(int i=0;i<songs.length;i++) {
        Long songId = new Long(songs[i]);
        length+=mcs.findMusicFileById(songId).getLength();
        mcs.createRelMusicMixes(songId, mixId, i);
      }
      mcs.updateMixes(mixId, mixName, length, genreId); // updating mix length
    }

    //set request objects
    Collection musicColl = mcs.findMusicFileByUser(ActionUtils.getUserId(request));
    releaseService(Constants.SERVICEKEY_MUSIC, mcs);
    request.setAttribute("musicColl", musicColl);

    return mapping.findForward("success");
  }
}
