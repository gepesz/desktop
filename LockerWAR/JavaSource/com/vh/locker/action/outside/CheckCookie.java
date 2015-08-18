package com.vh.locker.action.outside;

import java.util.Locale;

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


public class CheckCookie extends BaseOutsideAction {

  private static Logger log=Logger.getLogger(CheckCookie.class);
	
  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
		
    //put message resources into application scope
    request.getSession().getServletContext().setAttribute(Constants.LABELS, this.getResources(request, Constants.LABELS));        

    //initialize cookieValue
    String cookieValue = ActionUtils.getCookie(request, Constants.COOKIE_LANGUAGE);
    if(IS_DEBUG) log.debug(Constants.COOKIE_LANGUAGE+"="+cookieValue);

    //forward based on whether cookie was found or not
    if(cookieValue==null) {
      return mapping.findForward("noCookie");
    } else {
      ActionUtils.setDecorator(request, "outside");
      setLocale(request, ActionUtils.changeLocale(request, cookieValue));
      return mapping.findForward("cookieFound");
    } 
  }
}