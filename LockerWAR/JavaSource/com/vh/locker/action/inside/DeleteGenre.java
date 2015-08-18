/**
 * @file DeleteGenre
 * @author peter.szocs
 * @version 1.0
 * 
 * Deletes mp3 genres that user selects.
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
import com.vh.locker.util.MusicUtils;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class DeleteGenre extends BaseInsideAction {

  private static Logger log = Logger.getLogger(DeleteGenre.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    GridForm gridForm = (GridForm) request.getAttribute("gridForm");
    String[] id = gridForm.getId();
    Long userId = ActionUtils.getUserId(request);
    MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);
    mcs.deleteGenres(id, userId);
    request.getSession().setAttribute("allGenreColl", mcs.findGenreByUser(userId));
    releaseService(Constants.SERVICEKEY_MUSIC, mcs);
    
    return mapping.findForward("success");
  }
}
