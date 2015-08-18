<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>This is the startButtonDemo title</title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>
  <h4>Start Button</h4>

 
<div class="startButton">
	<a class="startButton" onclick="showStartMenu();">&nbsp;<img alt="Start" src="<c:url value='/common/img/starthere_small.gif'/>" border="0" />&nbsp;Start&nbsp;</a>
</div>

<div id="startMenu">

  <div id="startList" class="startList" style="position:absolute; bottom:25px; left:5px;">
    <ul>
      <li onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''; document.getElementById('proglist').style.display='none';"><img alt="Programs" src="<c:url value='/common/img/desktop.gif'/>" border="0" />&nbsp;Programs >></li>
      <li onclick="bgFrame.location.href='<c:url value='/files/StartFiles.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'" onmouseout="this.className=''; document.getElementById('proglist').style.display='none';"><img alt="Documents" src="<c:url value='/modules/files/img/folder.gif'/>" border="0" />&nbsp;Documents</li>
      <li onclick="bgFrame.location.href='<c:url value='/common/ViewSettings.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'" onmouseout="this.className=''; document.getElementById('proglist').style.display='none';"><img alt="Settings" src="<c:url value='/common/img/settings.gif'/>" border="0" />&nbsp;Settings</li>
      <li onmouseover="this.className='hover'" onmouseout="this.className=''; document.getElementById('proglist').style.display='none';"><img alt="Help" src="<c:url value='/common/img/help.gif'/>" border="0" />&nbsp;Help</li>
	  <c:if test="${sessionScope['<%=com.vh.locker.util.Constants_Scope.SSOENABLED_KEY%>']}">
	    <li onclick="top.location.href='<c:url value='/josso_logout/'/>';" onmouseover="this.className='hover'" onmouseout="this.className=''; document.getElementById('proglist').style.display='none';"><img alt="Logout" src="<c:url value='/common/img/logout.gif'/>" border="0" />&nbsp;Logout</li>
	  </c:if>
	  <c:if test="${!sessionScope['<%=com.vh.locker.util.Constants_Scope.SSOENABLED_KEY%>']}">
	    <li onclick="top.location.href='<c:url value='/outside/Logout.do'/>';" onmouseover="this.className='hover'" onmouseout="this.className=''; document.getElementById('proglist').style.display='none';"><img alt="Logout" src="<c:url value='/common/img/logout.gif'/>" border="0" />&nbsp;Logout</li>
	  </c:if>
	</ul>
  </div>

  <div id="progList" class="progList" style="position:absolute; bottom:25px; left:150px;">
	<ul>
		<li onclick="bgFrame.location.href='<c:url value='/email/StartEmail.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''"><img alt="Email" src="<c:url value='/modules/email/img/email.gif'/>" border="0" />&nbsp;Email</li>
		<li onclick="bgFrame.location.href='<c:url value='/music/StartMusic.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''"><img alt="Music" src="<c:url value='/modules/music/img/kmix.gif'/>" border="0" />&nbsp;Music</li>
		<li onclick="bgFrame.location.href='<c:url value='/im/StartIM.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''"><img alt="IM" src="<c:url value='/modules/im/img/kuser.gif'/>" border="0" />&nbsp;IM</li>
		<li onclick="bgFrame.location.href='<c:url value='/photos/StartPhotos.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''"><img alt="Photos" src="<c:url value='/modules/photos/img/camera.gif'/>" border="0" />&nbsp;Photos</li>
		<li onclick="bgFrame.location.href='<c:url value='/phone/StartPhone.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''"><img alt="Phone/SMS" src="<c:url value='/modules/phone/img/sms_protocol.gif'/>" border="0" />&nbsp;Phone/SMS</li>
		<li onclick="bgFrame.location.href='<c:url value='/bills/StartBills.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''"><img alt="Bills" src="<c:url value='/modules/bills/img/kwallet.gif'/>" border="0" />&nbsp;Bills</li>
		<li onclick="bgFrame.location.href='<c:url value='/notes/StartNotes.bg?c=content&c2=footer'/>';" onmouseover="this.className='hover'; document.getElementById('proglist').style.display='block';" onmouseout="this.className=''"><img alt="Notes" src="<c:url value='/modules/notes/img/korganizer.gif'/>" border="0" />&nbsp;Notes</li>
	</ul>
  </div>

</div>

</body>
</html>