<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.phonemain"/></title>
  </head>
  
  <body onload="altRows();">

    <%@ include file="/modules/phone/jsp/phonedivs.jsp"%>

    <form name="gridForm" target="bgFrame" action="<c:url value='/phone/PhoneDispatcher.bg?c=grid'/>" method="post">
    <h:hidden property="nextAction" value="error"/>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar" width="33px">&nbsp;<img alt="Phone/SMS" width="16" height="16" src="<c:url value='/modules/phone/img/sms_protocol.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle"><b:message bundle="resources" key="com.vh.title.jsp.phonemain"/></td>
		<td class="titlebar" align="right" width="55px">
			<a href="<c:url value='/common/ShowDesktop.bg?c=content&c2=footer'/>" target="bgFrame" title="Minimize" class="titlebar"><img alt="Minimize" border="0" src="<c:url value='/common/img/minimize.gif'/>" />&nbsp;</a>
			<a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame" title="Close" class="titlebar"><img alt="Close" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;</a>
		</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="20">
	    <td class="toolbarline1" width="18">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('phoneFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('phoneHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="24">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
        <td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="Dialog('/modules/phone/jsp/sendSMS.jsp');" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Send SMS" src="<c:url value='/modules/phone/img/queue.gif'/>" /></td>
        <td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="Dialog('/modules/phone/jsp/addContact.jsp');" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Add New" src="<c:url value='/modules/phone/img/comment.gif'/>" /></td>
        <td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="confirmDelete('delete');" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Delete" src="<c:url value='/modules/phone/img/removecomment.gif'/>" /></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>

	<div id="grid" name="grid">
	<table width="100%" cellspacing="0" cellpadding="0">
  	  <thead id="theHeader">
	  <tr class="trnormal">
		<th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
		<th class="listtitle" width="25%"><a href="javascript:TableSort(1,0)">Name</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="17%"><a href="javascript:TableSort(2,0)">Nickname</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="25%"><a href="javascript:TableSort(3,0)">Phone</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="30%"><a href="javascript:TableSort(4,0)">Email</a>&nbsp;&nbsp;</th>
	  </tr>
  	  </thead>	
	  
	  <tbody id="theRows">
        <c:forEach items="${phoneColl}" var="num">
          <tr class="trnormal">
	        <td class="list" width="3%"><input type="checkbox" name="id" onclick="Toggle(this);" value="<c:out value='${num.id}'/>" /></td>
	        <td class="list" width="25%"><a href="#" onClick="Dialog('/modules/phone/jsp/addContact.jsp', [<c:out value='${num.nickName}'/>,'<c:out value='${num.phone}'/>','<c:out value='${num.email}'/>']);"><c:out value="${num.name}"/></a></td>
	        <td class="list" width="17%"><c:out value="${num.nickName}"/>&nbsp;</td>
	        <td class="list" width="25%"><c:out value="${num.phone}"/>&nbsp;</td>
	        <td class="list" width="30%"><c:out value="${num.email}"/>&nbsp;</td>
          </tr>
		</c:forEach>
	  </tbody>
	</table>
    </div>
	</form>

  </body>

</html>