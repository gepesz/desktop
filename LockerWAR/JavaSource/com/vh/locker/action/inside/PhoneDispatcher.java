/**
 * @file PhoneDispatcher
 * @author peter.szocs
 * @version 1.0
 * 
 * Dispatches to next action based on what user clicked on.
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
import com.vh.locker.bean.inside.GridForm;


/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class PhoneDispatcher extends BaseInsideAction {

  private static Logger log = Logger.getLogger(PhoneDispatcher.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    ActionErrors errors = new ActionErrors();

    GridForm gridForm = (GridForm) form;
    String nextAction = gridForm.getNextAction();
    String[] id = gridForm.getId();

    if(nextAction==null) return new ActionForward("error");
    else if((id==null) || (id.length==0)) {
      if(IS_DEBUG) log.debug("No item selected on gridForm, forwarding to 'failure'");
      errors.add("error", new ActionError("errors.gridForm.music"));
      saveErrors(request, errors);
      return mapping.findForward("failure");
    } else {
      request.setAttribute("gridForm", gridForm);
      if(nextAction.equalsIgnoreCase("delete")) return new ActionForward("/phone/DeleteContact.do");
      else return new ActionForward("error");
    }
  }
}
