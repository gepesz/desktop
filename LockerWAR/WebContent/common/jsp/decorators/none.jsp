<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><decorator:title /></title>
    <decorator:head />
  </head>

  <body bgcolor="<decorator:getProperty property='body.bgcolor'/>" onload="<decorator:getProperty property='body.onload'/>; window.status='Done';" onmousemove="<decorator:getProperty property='body.onmousemove'/>">
	<decorator:body />
  </body>

</html>