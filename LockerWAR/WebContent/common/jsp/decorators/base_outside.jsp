<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <meta http-equiv="imagetoolbar" content="no" />
    <title><decorator:title/></title>
    <decorator:head />
	<%@ include file="/common/jsp/include/include_outside_css.jsp"%>
	<%@ include file="/common/jsp/include/include_outside_js.jsp"%>
  </head>
  <body onload="top.document.title=document.title;
                <decorator:getProperty property='body.onload'/>;
				initJSON();">

	<iframe name="bgFrame" id="bgFrame" style="display:none;position:absolute;width:600px;height:300px;margin:150px;top:0;left:0px;z-index:100;" src="/common/jsp/blank.jsp"></iframe>

	<div>
      <%@ include file="/outside/jsp/header.jsp"%>
    </div>

    <div id="content">
	  <decorator:body />
	</div>

	<div>
      <%@ include file="/outside/jsp/footer.jsp"%>
    </div>
	
  </body>
</html>
