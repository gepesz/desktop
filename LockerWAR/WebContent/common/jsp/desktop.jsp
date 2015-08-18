<%@ include file="/common/jsp/include/include_tld.jsp" %>

<c:set var="applications" value="${applicationScope['com.vh.locker.ALLAPPS']}" />


<% /* Desktop wallpaper */ %>
<div id="desktopWallpaper" class="desktopbg" oncontextmenu="setMouseXYIntoJS(event); CONTEXTMENU.show('cmDisplay', event);">
  <img id="desktopbg" border="0" src="/common/img/thailand3.jpg" style="display:none" />
</div>


<% /* Shortcuts */ %>
<% /* NOTE: Don't re-align the contents of the div!!  It will make JS functions not work. */ %>
<c:forEach var="s" items="${shortCuts}">
  <div class="dragme" style="left:<c:out value='${s.XCoord}'/>px; top:<c:out value='${s.YCoord}'/>px; border:1px solid red; width:<%=com.vh.locker.util.Constants_UI.SHORTCUT_DIV_WIDTH%>px;" oncontextmenu="setMouseXYIntoJS(event); putThisIntoLasso(this); CONTEXTMENU.show('cmShort', event);" ondblclick="loadApp(<c:out value='${s.application.id}'/>);" title="<c:out value='${s.desc}'/>"><img src="<c:out value='${s.icon}'/>" class="shortcutImage" /><textarea rows="1" cols="<c:out value='${fn:length(s.desc)+1}'/>" wrap="virtual" class="shortcutTextarea"
			  onkeydown="shortcutTextareaOnKeyDown(event, this)"
			  onkeyup="shortcutTextareaOnKeyUp(this)"
			  onfocus="shortcutTextareaOnFocus(this)" 
			  onblur="shortcutTextareaOnBlur(this)"><c:out value='${s.desc}'/></textarea><input type="hidden" value="<c:out value='${s.desc}'/>" /><input type="hidden" value="<c:out value='${s.application.id}'/>" />
  </div>
</c:forEach>


<% /* Adjusting width and height of wallpaper image.  
      Also, setting activeDesktopId to desktopDivId. 
	  Populating the global JS var appsArray. */ %>
<script>
  adjustShortcutTitles();
  adjustWallpaperSize();
  
  <c:forEach var="app" items="${applications}">
    appsArray.push( { id:'<c:out value="${app.id}" />',
	                  desc:'<c:out value="${app.desc}" />',
				      icon:'<c:out value="${app.defaultIcon}"/>',
				      targetUrl:'<c:out value="${app.targetUrl}"/>' } );
  </c:forEach>
</script>


<% /* ShortCuts' contextMenu. */ %>
<div class="zuiDropDown" id="cmShort">
    <ul>
      <li onclick="loadLassoedApps()" onmouseover="this.className='hover'" onmouseout="this.className=''">Open</li>
      <li onclick="confirmLassoObjectsDelete()" onmouseover="this.className='hover'" onmouseout="this.className=''">Delete</li>
      <li onclick="renameShortcut();" onmouseover="this.className='hover'" onmouseout="this.className=''">Rename</li>
	  <li><div class="divider"></div></li>
      <li onclick="Dialog('/common/jsp/shortcutProps.jsp');" onmouseover="this.className='hover'" onmouseout="this.className=''">Properties</li>
	</ul>
</div>


<% /* Desktop's contextMenu.  This is when you click on the background for example to change wallpaper. */ %>
<div class="zuiDropDown" id="cmDisplay">
    <ul>
      <li onclick="Dialog('/common/jsp/newShortcut.jsp', null, 'createShortCut()');" onmouseover="this.className='hover'" onmouseout="this.className=''">New Shortcut</li>
	  <li><div class="divider"></div></li>
      <li onclick="lineUpShortCuts();" onmouseover="this.className='hover'" onmouseout="this.className=''">Lineup Icons</li>
      <li onclick="refreshPage();" onmouseover="this.className='hover'" onmouseout="this.className=''">Refresh</li>
	  <li><div class="divider"></div></li>
      <li onclick="Dialog('/common/jsp/desktopProps.jsp', 'populateDesktopPropsDialog()', 'changeSkinAndWallpaper()');" onmouseover="this.className='hover'" onmouseout="this.className=''">Properties</li>
	</ul>
</div>
