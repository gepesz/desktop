<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <link rel="stylesheet" type="text/css" href="/common/css/error.css"/>
    
	<script language="javascript" src="/common/js/js_constants.jsp"></script>
    <script language="javascript" src="/components/js/componentUtils.js"></script>
    <script language="javascript" src="/components/js/Logger.js"></script>
    
	<title><b:message bundle="resources" key="com.vh.title.jsp.prefix"/>File Not Found</title>
  </head>  
  <body>

	<% /* main output to user */ %>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">    
	  <tr><td align="center" height="50"></td></tr>
      <tr><td align="center"><h2>404 Error</h2></td></tr>
	  <tr><td align="center" height="30"></td></tr>
	  <tr><td align="center"><p>The page you have requested does not exist.</p></td></tr>
	  <tr><td align="center" height="10"></td></tr>
    </table>
    
	<hr width="75%" />
	<% System.out.println("User got a 404 for " +  request.getAttribute("javax.servlet.forward.request_uri")); %>

  </body>
</html>
