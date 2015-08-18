<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page isErrorPage="true" %>
<%@ page import = "java.io.PrintWriter"%>
<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <link rel="stylesheet" type="text/css" href="/common/css/error.css"/>
    <title>Error Page</title>
  </head>
  
  <body>

	<% java.lang.Throwable ex = com.vh.locker.util.ActionUtils.getThrowable(request);%>

	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">    
	  <tr><td align="center" height="50"></td></tr>
      <tr><td align="center"><h2>500 Error</h2></td></tr>
	  <tr><td align="center" height="30"></td></tr>
	  <tr><td align="center"><h4>A system error has occured.</h4></td></tr>
	  <tr><td align="center" height="10"></td></tr>
	  <tr><td align="center"><p>This is the error:&nbsp;&nbsp;<%=ex%></p></td></tr>
	  <tr><td align="center" height="50"></td></tr>
	  <tr><td align="center"><a href="javascript:history.go(-1)">Try Again</a></td></tr>
    </table>
    
	<hr width="75%" />

	<h3>StackTrace:</h3>
	<table border="0" width="100%" cellpadding="0" cellspacing="0">    
 	  <tr><td><% if(ex!=null) ex.printStackTrace( new java.io.PrintWriter(out,false) );%></td></tr>
 	</table>
  
  </body>

</html>
