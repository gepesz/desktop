
<div class="zuiDropDown" id="imFileMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Add New" width="16" height="16" border="0" src="<c:url value='/modules/im/img/addcontact.gif'/>" />&nbsp;Add New</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Remove" width="16" height="16" border="0" src="<c:url value='/modules/im/img/removecontact.gif'/>" />&nbsp;Remove</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame"><img alt="Close" width="16" height="16" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;Close</a></li>
	</ul>
  </div>

  <div class="zuiDropDown" id="imActionMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Send Message" width="16" height="16" border="0" src="<c:url value='/modules/im/img/sendmessage.gif'/>" />&nbsp;Send Msg</li>
		<li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Send File" width="16" height="16" border="0" src="<c:url value='/modules/im/img/sendfile.gif'/>" />&nbsp;Send File</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><img alt="Send Email" width="16" height="16" border="0" src="<c:url value='/modules/im/img/sendemail.gif'/>" />&nbsp;Send Email</li>
	</ul>
  </div>

  <div class="zuiDropDown" id="imHelpMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('UNDER CONSTRUCTION');"><img alt="Help" width="16" height="16" border="0" src="<c:url  value='/common/img/question.gif'/>" />&nbsp;Help</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('&nbsp;Version 1.0.&nbsp;Copyright 2004 ZLocker Inc.&nbsp;All rights reserved.&nbsp;');"><img alt="About Z" width="16" height="16" border="0" src="<c:url value='/common/img/info.gif'/>" />&nbsp;About Z</li>
	</ul>
  </div>