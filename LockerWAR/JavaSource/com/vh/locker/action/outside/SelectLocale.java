/**
 * @file SelectLocale
 * @author peter.szocs
 * @version 1.0
 * 
 * This action picks up the user's preferred locale, and initializes
 * the Locale settings accordingly.
 */


package com.vh.locker.action.outside;

import java.util.Locale;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.base.BaseOutsideAction;
import com.vh.locker.util.ActionUtils;
import com.vh.locker.util.Constants;
import com.vh.locker.util.Constants_Scope;
import com.vh.locker.util.MessageUtils;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class SelectLocale extends BaseOutsideAction {

  private static Logger log = Logger.getLogger(SelectLocale.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    //change locale
    String lang = request.getParameter("lang");
    if((lang!=null) && (!"".equals(lang))) {
      setLocale(request, ActionUtils.changeLocale(request, lang));
      //create cookie
      Cookie cookie = new Cookie(Constants.COOKIE_LANGUAGE, lang);
      cookie.setMaxAge(365 * 24 * 60 * 60);
      response.addCookie(cookie);
    }
    
    //figure out where to go next
    String lastPage = (String) request.getSession().getAttribute(Constants_Scope.LASTPAGE_KEY);
    if((lastPage==null) || ("".equals(lastPage))) {
      if(IS_DEBUG) log.debug("Forwarding to \"default\" mapping");
      return mapping.findForward("default");
    } else {
      //log.debug("222: " + ActionUtils.getCookie(request, Constants.COOKIE_LANGUAGE));
      if (ActionUtils.getCookie(request, Constants.COOKIE_LANGUAGE) == null) {
        if(IS_DEBUG) log.debug("Forwarding to \"default\" mapping");
        return mapping.findForward("default");
      } else {
        if(IS_DEBUG) log.debug("Forwarding to: " + lastPage);
        return new ActionForward(lastPage);
      }
    }
  }
}
