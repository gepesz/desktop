<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.photosmain"/></title>
  </head>

  <body onload="altRows();">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <thead id="theHeader">	
	  <tr class="trnormal">
		<th colspan="100%" class="list" height="20px">&nbsp;Caribbean Cruise 2005&nbsp;</th>
	  </tr>
	  </thead>
	  <tbody id="theRows">

		  <tr class="trnormal">
		    <td class="list" width="5px"></td>
			<c:forEach items="${photoColl}" var="photo">
			  <td class="list" width="110px" align="left"><img width="100px" height="100px" border="1px solid #666666" src="<c:url value='/home/${user.userName}/zdocs/photo/${photo.link}'/>" />&nbsp;<input type="checkbox" name="id" onclick="Toggle(this);" value="<c:out value='${photo.id}'/>" />&nbsp;<c:out value="${photo.desc}"/></td>
			</c:forEach>
			<td class="list" width="50%"></td>
		  </tr>
	
		</tbody>
	</table>

  </body>
</html>