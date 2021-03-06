/**
 * @file DownloadMusic
 * @author peter.szocs
 * @version 1.0
 * 
 * Download music files from locker to user hard drive.
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
import com.vh.locker.bean.inside.GridForm;
import com.vh.locker.service.MusicService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.FileUploader;
import com.vh.locker.util.MusicUtils;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class DownloadMusic extends BaseInsideAction {

  private static Logger log = Logger.getLogger(DownloadMusic.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    GridForm gridForm = (GridForm) request.getAttribute("gridForm");
    String[] id = gridForm.getId();

    MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);
    Collection musicColl = mcs.findMusicFileByUser(ActionUtils.getUserId(request));
    releaseService(Constants.SERVICEKEY_MUSIC, mcs);
    request.setAttribute("musicColl", musicColl);

    if(id.length>1) {
      ActionErrors errors = new ActionErrors();
      errors.add("error", new ActionError("errors.download.onefile"));
      saveErrors(request, errors);
      return mapping.findForward("failure");      
    } else {
      String filePath = MusicUtils.getFilePath(id[0]);
      if(IS_DEBUG) log.debug("Downloading: "+filePath);
      FileUploader.download(filePath, request, response);
      return mapping.findForward("success");
    }
  }
}
