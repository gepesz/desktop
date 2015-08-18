<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.phonemain"/></title>
  </head>
  
  <body onload="altRows();">

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
	        <td class="list" width="25%"><a href="#" onclick="Dialog('/modules/phone/jsp/addContact.jsp',['<c:out value='${num.id}'/>','<c:out value='${num.name}'/>','<c:out value='${num.nickName}'/>','<c:out value='${num.phone}'/>','<c:out value='${num.email}'/>']);"><c:out value="${num.name}"/></a></td>
	        <td class="list" width="17%"><c:out value="${num.nickName}"/>&nbsp;</td>
	        <td class="list" width="25%"><c:out value="${num.phone}"/>&nbsp;</td>
	        <td class="list" width="30%"><c:out value="${num.email}"/>&nbsp;</td>
          </tr>
		</c:forEach>
	  </tbody>
	</table>

  </body>
</html>