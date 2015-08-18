/**
 * @file SongLengthTag
 * @author peter.szocs
 * @version 2.0
 * 
 * Custom tag for formatting song/mix length.
 */

package com.vh.locker.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import org.apache.strutsel.taglib.utils.EvalHelper;

/**
 * The VH Corporation
 *
 * Copyright (c) 2005 The VH Corporation.  All rights reserved.  
 * Copying or reproduction without prior written approval is prohibited.
 * 
 * @author  Peter.Szocs
 * @version 1.0
 */
public class SongLengthTag extends TagSupport {
  private static Logger log=Logger.getLogger(SongLengthTag.class);	
  private String value=null;

  public void setValue(String string) {
    value = string;
  }

  public int doStartTag() throws JspException {
	JspWriter out = pageContext.getOut();
	try {
      value = EvalHelper.evalString("value", value, this, pageContext);
      if((value!=null) && (!value.equals(""))) {
        long length = Long.parseLong(value);
        if(length>0) {  
          long hours = length/3600;
	  	  long mins  = length/60-hours*60;
	  	  long secs  = length-mins*60-hours*3600;
	  	  String temp = "";
          if(hours>0) {
            temp+=hours+":";
            if(mins<10) temp+="0";
          }
          temp+=mins;
          if(secs<10) temp+=":0"+secs;
	  	  else temp+=":"+secs;
          out.print(temp);
	    } else out.print("0:00");
      } else out.print("0:00");
	} catch(Exception e) {
      log.error(e.getMessage());
      throw new JspException(e.toString());
	}
	return EVAL_PAGE;
  }
  
}
