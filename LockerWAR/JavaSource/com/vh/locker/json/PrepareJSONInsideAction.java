/**
 * @file PrepareJSONInsideAction
 * @author peter.szocs
 * @version 1.0
 * 
 * Puts the JSONBridge object into session and registers the Java objects
 * that will be accessible from JavaScript through JSON.
 */

package com.vh.locker.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.metaparadigm.jsonrpc.JSONRPCBridge;
import com.vh.locker.base.BaseInsideAction;
import com.vh.locker.util.Constants_Scope;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 */
public class PrepareJSONInsideAction extends BaseInsideAction {

  private static Logger log = Logger.getLogger(PrepareJSONInsideAction.class);

  public ActionForward executeAction(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(IS_DEBUG) log.debug("inside");

    HttpSession session = request.getSession();
    JSONRPCBridge json_bridge = null;
    json_bridge = (JSONRPCBridge) session.getAttribute(Constants_Scope.JSONBRIDGE_KEY);
    if(json_bridge == null) {
      json_bridge = new JSONRPCBridge();
      //JSONSerializerUtil.registerSerializers(json_bridge);
      json_bridge.getSerializer().setMarshallClassHints(false);
      json_bridge.getSerializer().setMarshallNullAttributes(false);
      json_bridge.setDebug(true);
      json_bridge.registerObject("userService",    new JSONUserServiceImpl(session));
      session.setAttribute(Constants_Scope.JSONBRIDGE_KEY, json_bridge);
      if(IS_DEBUG) log.debug("Registered JSON services into new json_bridge object, and saved json_bridge into session under key '"+Constants_Scope.JSONBRIDGE_KEY+"'");
    } else {
      json_bridge.registerObject("userService",    new JSONUserServiceImpl(session));
	  if(IS_DEBUG) log.debug("Put userService into existing json_bridge in the session");
    }

    return mapping.findForward("success");
  }
}