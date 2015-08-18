<div id="startMenu">

  <div id="startList" class="startList" style="filter:alpha(opacity=0); -moz-opacity: 0; opacity:0;">
    <ul>
      <li onmouseover="this.className='hover'; document.getElementById('progList').style.display='block';" onmouseout="this.className=''"><img alt="Programs" src="/common/img/desktop.gif" border="0" />&nbsp;Programs >></li>
      <li onclick="bgFrame.location.href='/common/ViewSettings.bg?c=content&c2=footer';" onmouseover="this.className='hover'; document.getElementById('progList').style.display='none';" onmouseout="this.className='';"><img alt="Settings" src="/common/img/settings.gif" border="0" />&nbsp;Settings</li>
      <li onmouseover="this.className='hover'; document.getElementById('progList').style.display='none';" onmouseout="this.className='';"><img alt="Help" src="/common/img/help.gif" border="0" />&nbsp;Help</li>
	  <c:if test="${sessionScope['<%=com.vh.locker.util.Constants_Scope.SSOENABLED_KEY%>']}">
	    <li onclick="top.location.href='/josso_logout/';" onmouseover="this.className='hover'; document.getElementById('progList').style.display='none';" onmouseout="this.className='';"><img alt="Logout" src="/common/img/logout.gif" border="0" />&nbsp;Logout</li>
	  </c:if>
	  <c:if test="${!sessionScope['<%=com.vh.locker.util.Constants_Scope.SSOENABLED_KEY%>']}">
	    <li onclick="top.location.href='/outside/Logout.do';" onmouseover="this.className='hover'; document.getElementById('progList').style.display='none';" onmouseout="this.className='';"><img alt="Logout" src="/common/img/logout.gif" border="0" />&nbsp;Logout</li>
	  </c:if>
	</ul>
  </div>

  <div id="progList" class="progList">
	<ul>
	  <c:forEach var="app" items="${applications}">
		<li onclick="loadApp(<c:out value='${app.id}'/>);" onmouseover="this.className='hover';" onmouseout="this.className=''"><img alt="<c:out value='${app.desc}' />" src="<c:out value='${app.defaultIcon}'/>" border="0" style="padding:0px 5px 0px 0px;"/><c:out value='${app.desc}' /></li>
      </c:forEach>
	</ul>
  </div>

</div>

<% /* ADJUSTING THE BOTTOM OF THE STARTLIST AND PROGLIST DIVS SO THAT THEY ALIGN TO FOOTER_HEIGHT */ %>
<script>
  document.getElementById('startList').style.bottom = FOOTER_HEIGHT + 'px';
  document.getElementById('progList').style.bottom = FOOTER_HEIGHT + 'px';
</script>
