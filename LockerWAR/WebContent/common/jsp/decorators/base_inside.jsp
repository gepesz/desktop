<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <meta http-equiv="imagetoolbar" content="no" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.prefix"/><decorator:title default="Welcome" /></title>
    <decorator:head />
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>
  </head>
  
  <body onload="top.document.title=document.title; calcTime('digitalclock'); initJSON();">

	<iframe name="bgFrame" id="bgFrame" style="display:none;position:absolute;width:700px;height:400px;margin:130px;top:0;left:0px;z-index:2" src="<c:url value='/common/jsp/blank.jsp'/>"></iframe>
	
	<div id="header" class="appDiv">
		<%@ include file="/common/jsp/header.jsp"%>
	</div>

	<div id="desktop" class="appDiv" style="top:<%=com.vh.locker.util.Constants_UI.HEADER_HEIGHT%>px;">
		<decorator:body />
	</div>
		
	<div id="footer" class="defaultFooter">
		<%@ include file="/common/jsp/footer.jsp"%>
	</div>

   <% /************************************************************************/ %>
   <% /*                          CONTEXT MENUS                               */ %>
   <% /*   THEY NEED TO BE HERE OTHERWISE VERTICAL POSITIONING IS MESSED UP   */ %>
   <% /************************************************************************/ %>

	<% /* CLOCK CONTEXTMENU */ %>
	<div class="zuiDropDown" id="cmClock">
	<ul>
	  <li onclick="Dialog('/common/jsp/adjustTime.jsp');" onmouseover="this.className='hover'" onmouseout="this.className=''">Adjust Date/Time</li>
	  <li onclick="Dialog('/common/jsp/clockProps.jsp');" onmouseover="this.className='hover'" onmouseout="this.className=''">Properties</li>
	</ul>
	</div>

	<% /* TASK CONTEXTMENU */ %>
	<div class="zuiDropDown" id="cmTaskBar">
	  <ul>
		<li onclick="closeAllOpenApps();" onmouseover="this.className='hover'" onmouseout="this.className=''">Close All</li>
		<li onclick="closeApp();" onmouseover="this.className='hover'" onmouseout="this.className=''">Close</li>
	  </ul>
	</div>

  </body>
</html>