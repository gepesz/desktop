<%
  
  System.out.println( request.getAttribute(org.apache.struts.Globals.ERROR_KEY) );

  request.getSession().setAttribute( org.apache.struts.Globals.ERROR_KEY, request.getAttribute(org.apache.struts.Globals.ERROR_KEY) );
  
  response.sendRedirect( (String)request.getAttribute("redirectURL") ); 
%>