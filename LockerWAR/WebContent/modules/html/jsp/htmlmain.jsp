<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.htmlmain"/></title>
  </head>

  <body>

    <%@ include file="/modules/html/jsp/htmldivs.jsp"%>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar">&nbsp;<img alt="HTML" width="16" height="16" src="<c:url value='/modules/html/img/favorites.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle" width="100">&nbsp;<b:message bundle="resources" key="com.vh.title.jsp.htmlmain"/></td>
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
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('htmlFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('htmlHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="10">&nbsp;&nbsp;|&nbsp;&nbsp;</td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Add" width="16" height="16" border="0" src="<c:url value='/modules/html/img/addhtml.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Delete" width="16" height="16" border="0" src="<c:url value='/common/img/delete.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Edit" width="16" height="16" border="0" src="<c:url value='/common/img/edit.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr>
		<td>
		  <table width="100%" cellspacing="0" cellpadding="0">
			<tr>
			  <td align="left"><textarea class="textbox" rows="31" name="folders" style="width:200px">This area is for hierarchical folder/file browsing.</textarea></td>
			</tr>
		  </table>
		</td>
		<td valign="top" style="width:804px" align="left">
			<table width="100%" cellspacing="0" cellpadding="0">
			  <tr class="trnormal">
				<th class="listtitle" width="5%">&nbsp;<input type="checkbox" />&nbsp;</th>
				<th class="listtitle" width="45%">&nbsp;Name&nbsp;</th>
				<th class="listtitle" width="50%">&nbsp;Address&nbsp;</th>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="5%">&nbsp;<input type="checkbox" />&nbsp;</td>
				<td class="list" width="45%">&nbsp;<a href="#">Armani Exchange</a>&nbsp;</td>
				<td class="list" width="50%">&nbsp;<a href="http://www.armaniexchange.com" target="_new">www.armaniexchange.com</a>&nbsp;</td>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="5%">&nbsp;<input type="checkbox" />&nbsp;</td>
				<td class="list" width="45%">&nbsp;<a href="#">2004 Summer Olympics</a>&nbsp;</td>
				<td class="list" width="50%">&nbsp;<a href="http://www.athens2004.com" target="_new">www.athens2004.com</a>&nbsp;</td>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="5%">&nbsp;<input type="checkbox" />&nbsp;</td>
				<td class="list" width="45%">&nbsp;<a href="#">Weather</a>&nbsp;</td>
				<td class="list" width="50%">&nbsp;<a href="http://www.weather.com" target="_new">www.weather.com</a>&nbsp;</td>
			  </tr>
			</table>
		</td>
	  </tr>
	</table>
	
	<%@ include file="/modules/html/jsp/htmldivs.jsp" %>

  </body>

</html>
