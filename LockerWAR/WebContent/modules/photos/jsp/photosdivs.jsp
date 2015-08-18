
<div class="zuiDropDown" id="photosFileMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Dialog('/modules/photos/jsp/createAlbum.jsp');"><img alt="New Album" width="16" height="16" border="0" src="<c:url value='/modules/photos/img/wizard.gif'/>" />&nbsp;New Album</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); confirmDelete('delete');"><img alt="Delete" width="16" height="16" border="0" src="<c:url value='/common/img/delete.gif'/>" />&nbsp;Delete</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Dialog('/modules/photos/jsp/albumInfo.jsp');"><img alt="Edit" width="16" height="16" border="0" src="<c:url value='/common/img/edit.gif'/>" />&nbsp;Edit</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Dialog('/modules/photos/jsp/uploadPhoto.jsp');"><img alt="Upload" width="16" height="16" border="0" src="<c:url value='/common/img/upload.gif'/>" />&nbsp;Upload</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); download();"><img alt="Download" width="16" height="16" border="0" src="<c:url value='/common/img/download.gif'/>" />&nbsp;Download</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame"><img alt="Close" width="16" height="16" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;Close</a></li>
	</ul>
  </div>

  <div class="zuiDropDown" id="photosHelpMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('UNDER CONSTRUCTION');"><img alt="Help" width="16" height="16" border="0" src="<c:url  value='/common/img/question.gif'/>" />&nbsp;Help</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('&nbsp;Version 1.0.&nbsp;Copyright 2004 ZLocker Inc.&nbsp;All rights reserved.&nbsp;');"><img alt="About Z" width="16" height="16" border="0" src="<c:url value='/common/img/info.gif'/>" />&nbsp;About Z</li>
	</ul>
  </div>