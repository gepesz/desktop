<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.billsmain"/></title>
  </head>

  <body>

    <%@ include file="/modules/bills/jsp/billsdivs.jsp"%>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar">&nbsp;<img alt="Bills" width="16" height="16" src="<c:url value='/modules/bills/img/kwallet.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle" width="100">&nbsp;<b:message bundle="resources" key="com.vh.title.jsp.billsmain"/></td>
		<td class="titlebar" width="800">&nbsp;</td>
		<td class="titlebar" align="right">&nbsp;
			<a href="<c:url value='/common/ShowDesktop.bg?c=content&c2=footer'/>" target="bgFrame" title="Minimize" class="titlebar"><img alt="Minimize" width="16" height="16" border="0" src="<c:url  value='/common/img/minimize.gif'/>" />&nbsp;</a>
			<a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame" title="Close" class="titlebar"><img alt="Close" width="16" height="16" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;</a>
		</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="20">
	    <td class="toolbarline1" width="10">&nbsp;&nbsp;|</td>
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('billsFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('billsHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="10">&nbsp;&nbsp;|&nbsp;&nbsp;</td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Pay Bill" width="16" height="16" border="0" src="<c:url value='/modules/bills/img/pay.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="New Bill" width="16" height="16" border="0" src="<c:url value='/modules/bills/img/wizard.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Delete" width="16" height="16" border="0" src="<c:url value='/common/img/delete.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" width="30" valign="bottom">&nbsp;&nbsp;<a href="#"><img alt="Edit" width="16" height="16" border="0" src="<c:url value='/common/img/edit.gif'/>" />&nbsp;</a></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr>
		<td valign="top" align="left">
			<table width="100%" cellspacing="0" cellpadding="0">
			  <tr class="trnormal">
				<th class="listtitle" width="5%">&nbsp;<input type="checkbox" />&nbsp;</th>
				<th class="listtitle" width="25%">&nbsp;Provider&nbsp;</th>
				<th class="listtitle" width="30%">&nbsp;Description&nbsp;</th>
				<th class="listtitle" width="20%">&nbsp;Deadline&nbsp;</th>
				<th class="listtitle" width="20%">&nbsp;Amount&nbsp;</th>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="5%">&nbsp;<input type="checkbox" />&nbsp;</td>
				<td class="list" width="25%">&nbsp;<a href="#">Verizon</a>&nbsp;</td>
				<td class="list" width="30%">&nbsp;Home phone line&nbsp;</td>
				<td class="list" width="20%">&nbsp;16th of each month&nbsp;</td>
				<td class="list" width="20%">&nbsp;$24.55&nbsp;</td>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="5%">&nbsp;<input type="checkbox" />&nbsp;</td>
				<td class="list" width="25%">&nbsp;<a href="#">Verizon</a>&nbsp;</td>
				<td class="list" width="30%">&nbsp;Network connection&nbsp;</td>
				<td class="list" width="20%">&nbsp;29th of each month&nbsp;</td>
				<td class="list" width="20%">&nbsp;$29.96&nbsp;</td>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="5%">&nbsp;<input type="checkbox" />&nbsp;</td>
				<td class="list" width="25%">&nbsp;<a href="#">Sprint PCS</a>&nbsp;</td>
				<td class="list" width="30%">&nbsp;Cell phone&nbsp;</td>
				<td class="list" width="20%">&nbsp;22nd of each month&nbsp;</td>
				<td class="list" width="20%">&nbsp;$35.42&nbsp;</td>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="5%">&nbsp;<input type="checkbox" />&nbsp;</td>
				<td class="list" width="25%">&nbsp;<a href="#">Comcast</a>&nbsp;</td>
				<td class="list" width="30%">&nbsp;Cable TV&nbsp;</td>
				<td class="list" width="20%">&nbsp;15th of each month&nbsp;</td>
				<td class="list" width="20%">&nbsp;$47.66&nbsp;</td>
			  </tr>
			</table>
		</td>
	  </tr>
	</table>

	<%@ include file="/modules/bills/jsp/billsdivs.jsp" %>

  </body>

</html>
