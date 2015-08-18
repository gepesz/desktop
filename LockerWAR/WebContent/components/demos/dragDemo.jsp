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
  <h4>Drag</h4>

  <% /*  THE DOCUMENT.ONMOUSEXXX FUCNTIONS ARE DEFINED IN UTILS.JS !! */ %>  
  <% /*  The element to move must have className="dragme"  */ %>
  
  <iframe name="bgFrame" id="bgFrame" style="display:none;position:absolute;width:500px;height:300px;margin:130px;top:0;left:0px;z-index:2" src="<c:url value='/common/jsp/blank.jsp'/>"></iframe>

  &nbsp;&nbsp;
  <div class="dragme">
   asdlfjsdlfj
   <img src="<c:url value='/modules/files/img/folder.gif'/>" />
  </div>

<div class="dragme" style="width:40px; left:0px; top:100px;" oncontextmenu="CONTEXTMENU.show('cmShort', event);" ondblclick="bgFrame.location.href='<c:url value='/files/StartFiles.bg?c=content&c2=footer'/>';" title="<b:message bundle='resources' key='com.vh.label.Files'/>">
	<img src="<c:url value='/modules/files/img/folder.gif'/>" /><br />
	<span class="icontext"><b:message bundle="resources" key="com.vh.label.Files"/></span>
</div>
<br />
<div class="dragme" style="width:40px; left:60px; top:100px;" oncontextmenu="CONTEXTMENU.show('cmShort', event);" ondblclick="bgFrame.location.href='<c:url value='/trash/StartTrash.bg?c=content&c2=footer'/>';" title="<b:message bundle='resources' key='com.vh.label.Trash_Can'/>">
	<img src="<c:url value='/modules/trash/img/trashcan_empty.gif'/>" /><br />
	<span class="icontext"><b:message bundle="resources" key="com.vh.label.Trash_Can"/></span>
</div>

  <% /* SHORTCUTS' CONTEXTMENU */ %>
  <div class="zuiDropDown" id="cmShort">
    <ul>
      <li onclick="Alert('Open.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Open</li>
      <li onclick="Alert('Delete.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Delete</li>
      <li onclick="Alert('Rename.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Rename</li>
	</ul>
  </div>
  <% /* EOF SHORTCUTS' CONTEXTMENU */ %>

</body>
</html>