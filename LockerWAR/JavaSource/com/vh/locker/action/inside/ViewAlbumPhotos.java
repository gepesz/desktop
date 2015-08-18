/**
 * @file ViewAlbumPhotos
 * @author peter.szocs
 * @version 1.0
 * 
 * View action for photos->album photos.
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
import com.vh.locker.service.PhotoService;
import com.vh.locker.util.Constants;
import com.vh.locker.util.MessageUtils;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class ViewAlbumPhotos extends BaseInsideAction {

  private static Logger log = Logger.getLogger(ViewAlbumPhotos.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    ActionErrors errors = new ActionErrors();
    
    String strPhotoAlbumId = request.getParameter("id");
    if((strPhotoAlbumId==null) || ("".equals(strPhotoAlbumId))) {
      errors.add("errors.required", new ActionError("errors.required", "com.vh.label.ID"));
    } else {
      PhotoService photoSvc = (PhotoService) getService(Constants.SERVICEKEY_PHOTO);
      try {
        long photoAlbumId = Long.parseLong(strPhotoAlbumId);
        Collection photoColl = photoSvc.findPhotoByAlbum(new Long(photoAlbumId));
        request.setAttribute("photoColl", photoColl);      
      } catch(Exception e) {
        e.printStackTrace();
        errors.add("errors.none", new ActionError("errors.none", "Couldn't get photos for album!"));        
      } finally {
        releaseService(Constants.SERVICEKEY_PHOTO, photoSvc);        
      }
    }
    
    //check for errors
    if(errors.isEmpty()) {
      return mapping.findForward("success");
    } else {
      saveErrors(request, errors);
      return mapping.findForward("failure");
    }    
  }
}