
<div class="zuiDropDown" id="phoneFileMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Dialog('/modules/phone/jsp/sendSMS.jsp');"><img alt="Send SMS" width="16" height="16" border="0" src="<c:url value='/modules/phone/img/queue.gif'/>" />&nbsp;Send SMS</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Dialog('/modules/phone/jsp/addContact.jsp');"><img alt="Add New" width="16" height="16" border="0" src="<c:url value='/modules/phone/img/comment.gif'/>" />&nbsp;Add New</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); confirmDelete('delete');"><img alt="Remove" width="16" height="16" border="0" src="<c:url value='/modules/phone/img/removecomment.gif'/>" />&nbsp;Remove</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame"><img alt="Close" width="16" height="16" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;Close</a></li>
	</ul>
  </div>

  <div class="zuiDropDown" id="phoneHelpMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('UNDER CONSTRUCTION');"><img alt="Help" width="16" height="16" border="0" src="<c:url  value='/common/img/question.gif'/>" />&nbsp;Help</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('&nbsp;Version 1.0.&nbsp;Copyright 2004 ZLocker Inc.&nbsp;All rights reserved.&nbsp;');"><img alt="About Z" width="16" height="16" border="0" src="<c:url value='/common/img/info.gif'/>" />&nbsp;About Z</li>
	</ul>
  </div>