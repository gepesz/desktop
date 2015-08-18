/**
 * @file PickerSearch
 * @author peter.szocs
 * @version 1.0
 * 
 * Search action for the picker.
 */


package com.vh.locker.action.components;

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
import com.vh.locker.bean.components.PickerForm;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class PickerSearch extends BaseInsideAction {

  private static Logger log = Logger.getLogger(PickerSearch.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");
    
    PickerForm f = (PickerForm) form;
    int pickerType = f.getPickerType();
    String searchString = f.getSearchString();
    log.debug("pickerType="+pickerType);
    log.debug("searchString="+searchString);
    
    return mapping.findForward("success");
  }
}