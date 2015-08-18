<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.notesmain"/></title>
  </head>

  <body>

    <%@ include file="/modules/notes/jsp/notesdivs.jsp"%>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar">&nbsp;<img alt="Notes" width="16" height="16" src="<c:url value='/modules/notes/img/korganizer.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle" width="100">&nbsp;<b:message bundle="resources" key="com.vh.title.jsp.notesmain"/></td>
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
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('notesFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('notesSearchMenu', this);">&nbsp;&nbsp;&nbsp;Search&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('notesHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="10">&nbsp;&nbsp;|&nbsp;&nbsp;</td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="New" width="16" height="16" border="0" src="<c:url value='/modules/notes/img/filenew.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Open..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/fileopen.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Save" width="16" height="16" border="0" src="<c:url value='/modules/notes/img/filesave.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Save As..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/filesaveas.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Find..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/find.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Replace..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/replace.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Go to line..." width="16" height="16" border="0" src="<c:url value='/modules/notes/img/goto.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>

	<%@ include file="/modules/notes/jsp/notesdivs.jsp" %>

  </body>

</html>
