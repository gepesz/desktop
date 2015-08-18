/**
 * @file BaseOutsideAction
 * @author peter.szocs
 * @version 1.0
 * 
 * BaseOutsideAction that extends Struts Action that every Action
 * outside the application should extend.
 */


package com.vh.locker.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vh.locker.service.Service;
import com.vh.locker.service.ServiceManager;
import com.vh.locker.service.exception.ServiceException;
import com.vh.locker.util.ActionUtils;

/**
 * The VH Corporation
 *
 * Copyright (c) 2003 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written  approval is prohibited.
 * 
 */
public abstract class BaseOutsideAction extends Action {

	private static Logger log = Logger.getLogger(BaseOutsideAction.class);
    protected final boolean IS_DEBUG = log.isDebugEnabled();        
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionErrors errors = new ActionErrors();
		ActionForward forward = null;

		try {
            forward = executeAction(mapping, form, request, response);
            String c = request.getParameter("c");
            if(c!=null) request.setAttribute("c", c);
		} catch (BaseException be) {
			log.error("BaseException: "+be.toString());
			be.printStackTrace();
			forward = ActionUtils.handleThrowable(request, be, mapping);

		} catch (ServiceException se) {
			log.error("ServiceException: "+se.toString());
			se.printStackTrace();
			forward = ActionUtils.handleThrowable(request, se, mapping);

		} catch (Exception e) {
			log.error("Exception: "+e.toString());
			e.printStackTrace();
			forward = ActionUtils.handleThrowable(request, e, mapping);
			
		}

		if(!errors.isEmpty()) saveErrors(request, errors);

		return forward;
	}


	
	protected Service getService(String serviceName) throws ServiceException {
		return ServiceManager.acquire(serviceName);
	}



	protected boolean releaseService(String serviceName, Service ss)  throws ServiceException  {
		return ServiceManager.release(serviceName, ss);
	}



	abstract public ActionForward executeAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception;

}
