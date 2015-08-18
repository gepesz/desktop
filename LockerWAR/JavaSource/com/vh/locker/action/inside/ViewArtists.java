/**
 * @file ViewArtists
 * @author peter.szocs
 * @version 1.0
 * 
 * View action for music->artists.
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


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class ViewArtists extends BaseInsideAction {

	private static Logger log = Logger.getLogger(ViewArtists.class);

	public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    //get artist coll from db
    MusicService mcs = (MusicService) getService(Constants.SERVICEKEY_MUSIC);
    Collection artistColl = mcs.findArtistByUser(ActionUtils.getUserId(request));
    releaseService(Constants.SERVICEKEY_MUSIC, mcs);
    request.setAttribute("artistColl", artistColl);
    
    return (mapping.findForward("success"));
	}
}
