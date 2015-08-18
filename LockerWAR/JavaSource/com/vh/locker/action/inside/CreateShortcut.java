/**
 * @file CreateShortcut
 * @author peter.szocs
 * @version 1.0
 * 
 * Create shortcut action.  This action is called from the desktop when a new shortcut is created.
 */


package com.vh.locker.action.inside;

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
import com.vh.locker.bean.inside.ShortcutForm;
import com.vh.locker.ejb.Application;
import com.vh.locker.service.UserService;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class CreateShortcut extends BaseInsideAction {

  private static Logger log = Logger.getLogger(CreateShortcut.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    ShortcutForm shortcutForm = (ShortcutForm) form;
    log.debug("shortcutApp="+shortcutForm.getShortcutApp());
    log.debug("shortcutName="+shortcutForm.getShortcutName());
    
    Long appId = new Long(shortcutForm.getShortcutApp());    
    UserService uss = (UserService) getService(Constants.SERVICEKEY_USER);
    Application theApp = uss.findApplicationById(appId);
    uss.createShortCut(shortcutForm.getShortcutName(), theApp.getDefaultIcon(), 200, 200, appId, ActionUtils.getUserId(request));
    releaseService(Constants.SERVICEKEY_USER, uss);
            
    return mapping.findForward("success");
  }
}