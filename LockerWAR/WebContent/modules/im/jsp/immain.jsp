<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.immain"/></title>
  </head>

  <body>

    <%@ include file="/modules/im/jsp/imdivs.jsp"%>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar">&nbsp;<img alt="IM" width="16" height="16" src="<c:url value='/modules/im/img/kuser.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle" width="100">&nbsp;<b:message bundle="resources" key="com.vh.title.jsp.immain"/></td>
		<td class="titlebar" width="800">&nbsp;</td>
		<td class="titlebar" align="right">&nbsp;
			<a href="<c:url value='/common/ShowDesktop.bg?c=content&c2=footer'/>" target="bgFrame" title="Minimize" class="titlebar"><img alt="Minimize" width="16" height="16" border="0" src="<c:url value='/common/img/minimize.gif'/>" />&nbsp;</a>
			<a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame" title="Close" class="titlebar"><img alt="Close" width="16" height="16" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;</a>
		</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="20">
	    <td class="toolbarline1" width="10">&nbsp;&nbsp;|</td>
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('imFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('imActionMenu', this);">&nbsp;&nbsp;&nbsp;Action&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('imHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="10">&nbsp;&nbsp;|&nbsp;&nbsp;</td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Add New" width="16" height="16" border="0" src="<c:url value='/modules/im/img/addcontact.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Remove" width="16" height="16" border="0" src="<c:url value='/modules/im/img/removecontact.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Send Message" width="16" height="16" border="0" src="<c:url value='/modules/im/img/sendmessage.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Send File" width="16" height="16" border="0" src="<c:url value='/modules/im/img/sendfile.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Send Email" width="16" height="16" border="0" src="<c:url value='/modules/im/img/sendemail.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>
	<table width="10%" cellspacing="0" cellpadding="0">
	  <tr class="trnormal">
		<th class="listtitle" width="10%">&nbsp;Friends&nbsp;</th>
	  </tr>
	  <tr class="trnormal">
		<td class="list" width="10%">&nbsp;&nbsp;&nbsp;<a href="#">Zeynep</a>&nbsp;</td>
	  </tr>
	  <tr class="trnormal">
		<td class="list" width="10%">&nbsp;&nbsp;&nbsp;<a href="#">Elif</a>&nbsp;</td>
	  </tr>
	  <tr class="trnormal">
		<th class="listtitle" width="10%">&nbsp;Work&nbsp;</th>
	  </tr>
	  <tr class="trnormal">
		<td class="list" width="10%">&nbsp;&nbsp;&nbsp;<a href="#">Beta</a>&nbsp;</td>
	  </tr>
	  <tr class="trnormal">
		<td class="list" width="10%">&nbsp;&nbsp;&nbsp;<a href="#">Mark</a>&nbsp;</td>
	  </tr>
	  <tr class="trnormal">
		<th class="listtitle" width="10%">&nbsp;Family&nbsp;</th>
	  </tr>
	  <tr class="trnormal">
		<td class="list" width="10%">&nbsp;&nbsp;&nbsp;<a href="#">Ipek</a>&nbsp;</td>
	  </tr>
	  <tr class="trnormal">
		<td class="list" width="10%">&nbsp;&nbsp;&nbsp;<a href="#">Yasemin</a>&nbsp;</td>
	  </tr>
	  <tr class="trnormal">
		<td class="list" width="10%">&nbsp;&nbsp;&nbsp;<a href="#">Vildan</a>&nbsp;</td>
	  </tr>
	</table>

	<%@ include file="/modules/im/jsp/imdivs.jsp" %>

  </body>

</html>
