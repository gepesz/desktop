
<div class="zuiDropDown" id="notesFileMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="New" width="16" height="16" border="0" src="<c:url value='/modules/notes/img/filenew.gif'/>" />&nbsp;New</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Open..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/fileopen.gif'/>" />&nbsp;Open...</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Save" width="16" height="16" border="0" src="<c:url value='/modules/notes/img/filesave.gif'/>" />&nbsp;Save</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Save As..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/filesaveas.gif'/>" />&nbsp;Save As...</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame"><img alt="Close" width="16" height="16" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;Close</a></li>
	</ul>
  </div>

  <div class="zuiDropDown" id="notesSearchMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Find..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/find.gif'/>" />&nbsp;Find...</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Replace..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/replace.gif'/>" />&nbsp;Replace...</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Go to line..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/goto.gif'/>" />&nbsp;Go to line...</li>
	</ul>
  </div>

  <div class="zuiDropDown" id="notesHelpMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('UNDER CONSTRUCTION');"><img alt="Help" width="16" height="16" border="0" src="<c:url  value='/common/img/question.gif'/>" />&nbsp;Help</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('&nbsp;Version 1.0.&nbsp;Copyright 2004 ZLocker Inc.&nbsp;All rights reserved.&nbsp;');"><img alt="About Z" width="16" height="16" border="0" src="<c:url value='/common/img/info.gif'/>" />&nbsp;About Z</li>
	</ul>
  </div>
