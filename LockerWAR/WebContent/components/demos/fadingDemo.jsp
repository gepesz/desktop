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
<h4>Fading</h4>
	
	<img src="<c:url value='/modules/files/img/folder.gif'/>" id="picture" />
	<a onclick="opacity('picture', 100, 0, 500)">Hide img</a>&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
	<a onclick="opacity('picture', 0, 100, 500)">Show img</a>
	
	<br /><br /><br />
	
	<img src="<c:url value='/common/img/settings.gif'/>" id="picture2" />
	<a onclick="shiftOpacity('picture2', 1000)">Hide/Show img</a>


	<br /><br /><br /><br /><br /><br />

	
<a onclick="shiftOpacity('startList', 500)">Hide/Show StartMenu</a>

	<br /><br />

<a onclick="opacity('startList', 0,   500)">Hide StartList</a>&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;
<a onclick="opacity('startList', 100, 500)">Show StartList</a>

  <div id="startList" style="position:absolute; bottom:25px; left:5px; filter:alpha(opacity=0); -moz-opacity: 0; opacity:0;">
    <ul>
      <li><img alt="Programs" src="<c:url value='/common/img/desktop.gif'/>" border="0" />&nbsp;Programs >></li>
      <li><img alt="Documents" src="<c:url value='/modules/files/img/folder.gif'/>" border="0" />&nbsp;Documents</li>
      <li><img alt="Settings" src="<c:url value='/common/img/settings.gif'/>" border="0" />&nbsp;Settings</li>
      <li><img alt="Help" src="<c:url value='/common/img/help.gif'/>" border="0" />&nbsp;Help</li>
	  <c:if test="${sessionScope['<%=com.vh.locker.util.Constants_Scope.SSOENABLED_KEY%>']}">
	    <li><img alt="Logout" src="<c:url value='/common/img/logout.gif'/>" border="0" />&nbsp;Logout</li>
	  </c:if>
	  <c:if test="${!sessionScope['<%=com.vh.locker.util.Constants_Scope.SSOENABLED_KEY%>']}">
	    <li><img alt="Logout" src="<c:url value='/common/img/logout.gif'/>" border="0" />&nbsp;Logout</li>
	  </c:if>
	</ul>
  </div>

</body>
</html>