<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.emailmain"/></title>
  </head>

    <%@ include file="/modules/email/jsp/emaildivs.jsp"%>
	
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar" width="33px">&nbsp;<img alt="Email" width="16" height="16" src="<c:url value='/modules/email/img/email.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle"><b:message bundle="resources" key="com.vh.title.jsp.emailmain"/></td>
		<td class="titlebar" align="right" width="55px">
			<img src="<c:url value='/common/img/minimize.gif'/>" 
				 alt="Minimize" 
				 onclick="loadApp();" 
				 onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" />
			<img src="<c:url value='/common/img/close.gif'/>" 
				 alt="Close" 
				 onclick="closeApp();" 
				 onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" />
		</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="20">
	    <td class="toolbarline1" width="18">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('emailFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('emailHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>	
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="24">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="" width="30" valign="bottom">&nbsp;&nbsp;<a href="" onClick="Dialog('/modules/email/jsp/compose.jsp'); return false;"><img alt="New" src="<c:url value='/modules/email/img/mail_new.gif'/>" border="0"></a></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Reply" src="<c:url value='/modules/email/img/mail_reply.gif'/>" ></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Reply All" src="<c:url value='/modules/email/img/mail_replyall.gif'/>" ></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Forward" src="<c:url value='/modules/email/img/mail_forward.gif'/>" ></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="confirmDelete('delete');" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Delete" src="<c:url value='/modules/email/img/mail_delete.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Send" src="<c:url value='/modules/email/img/mail_send.gif'/>" ></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Get" src="<c:url value='/modules/email/img/mail_get.gif'/>" ></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>

	<div id="grid" name="grid">
	<table width="100%" cellspacing="0" cellpadding="0">
	  <thead id="theHeader">	
	  <tr class="trnormal">
		<th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
		<th class="listtitle" width="3%"><a href="javascript:TableSort(1,0)"></a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="20%"><a href="javascript:TableSort(2,0)">From</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="40%"><a href="javascript:TableSort(3,0)">Subject</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="20%"><a href="javascript:TableSort(4,0)">Received</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="14%"><a href="javascript:TableSort(5,0)">Size</a>&nbsp;&nbsp;</th>
	  </tr>
	  </thead>
	  <tbody id="theRows">              
		  <tr class="trnormal">
			<td class="list" width="3%"><input type="checkbox" name="id" onclick="Toggle(this);" value="<c:out value='${mail.id}'/>" /></td>
			<td class="list" width="3%"></td>
			<td class="list" width="20%">Petek Pekgoz<c:out value="${mail.sender}"/>&nbsp;</td>
			<td class="list" width="40%"><a href="#" onClick="Dialog('/modules/email/jsp/message.jsp');">BIDIK is here saying hi!<c:out value="${mail.subject}"/>&nbsp;</a></td>
			<td class="list" width="20%">Sun 12/02/2005 3:33 PM<c:out value="${mail.received}"/>&nbsp;</td>
			<td class="list" width="14%">12KB<c:out value="${mail.size}"/>&nbsp;</td>
		  </tr>
	  </tbody>
	</table>

  </body>

</html>