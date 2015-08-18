<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title></title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>
  <h4>Alert</h4>
  
       
  <input type="button" value="Show Alert"    onclick="Alert('Hello world!');" />
  <input type="button" value="Another Alert" onclick="Alert('All right then...');" />
  
<div class="desktopbg" oncontextmenu="CONTEXTMENU.show('cmDisplay', event);">
  <img id="desktopbg" border="0" src="<c:url value='/common/img/thailand3.jpg'/>" />
</div>

<textarea class="shortcutTextArea" style="left:150px; top:200px;" cols="20" rows="1" onfocus="document.onselectstart = new Function ('return true');" onblur="renameShortCutOnBlur(this);" onclick="renameShortCut(this);">ABC DEF</textarea>

</body>
</html>