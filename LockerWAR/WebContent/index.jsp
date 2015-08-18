<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>
<%@ page import="com.vh.locker.util.Constants_Scope"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <meta http-equiv="content-type" content="text/html" />
	<title><b:message bundle="resources" key="com.vh.title.jsp.prefix"/></title>
  </head>
  <frameset rows="*">
    <%
    String lastPage = (String)session.getAttribute(Constants_Scope.LASTPAGE_KEY);
	System.out.println("aaa index.jsp: "+lastPage);
    if((lastPage==null) || ("".equals(lastPage))) {
    %>
      <frame src="outside/CheckCookie.none" name="contentFrame" id="contentFrame" />
    <% } else { %>
	System.out.println("bbb index.jsp: "+lastPage);
	  <frame src="<%=lastPage%>" name="contentFrame" id="contentFrame" />
	<% } %>    

	<noframes>	
	  <body>This site requires frames. Please turn on frame support in your web browser.</body>	
	</noframes>
  
  </frameset>
</html>
