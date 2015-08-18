<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title>Inbox</title>
  </head>
  
  <body onload="altRows();">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <thead id="theHeader">	
	  <tr class="trnormal">
		<th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
		<th class="listtitle" width="5%"><a href="javascript:TableSort(1,0)"></a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="5%"><a href="javascript:TableSort(2,0)"></a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="25%"><a href="javascript:TableSort(3,0)">From</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="40%"><a href="javascript:TableSort(4,0)">Subject</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="25%"><a href="javascript:TableSort(5,0)">Received</a>&nbsp;&nbsp;</th>
	  </tr>
	  </thead>
	  <tbody id="theRows">              
		<!--<c:forEach items="${inboxColl}" var="mail">-->
		  <tr class="trnormal">
			<td class="list" width="3%"><input type="checkbox" name="id" onclick="Toggle(this);" value="<c:out value='${mail.id}'/>" /></td>
			<td class="list" width="5%"></td>
			<td class="list" width="5%"></td>
			<td class="list" width="25%"><c:out value="${mail.sender}"/>&nbsp;</td>
			<td class="list" width="40%"><c:out value="${mail.subject}"/>&nbsp;</td>
			<td class="list" width="25%"><c:out value="${mail.received}"/>&nbsp;</td>
		  </tr>
		<!--</c:forEach>-->
	  </tbody>
	</table>

  </body>

</html>