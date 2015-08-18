<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Create Mix</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

	<table cellspacing="0" cellpadding="0" width="100%">
		<form name="mixForm" id="mixForm" target="bgFrame" action="<c:url value='/music/CreateMix.bg?c=grid'/>" method="post" onSubmit="selectAllOptions('mfColl');">
		<input type="hidden" name="mfId" id="mfId" />
			<thead id="mixHeader">	
			<tr><td class="itemtext" height="20" colspan="2">&nbsp;Please edit the properties of your mix and add songs to it.</td></tr>
			<l:messagesPresent><tr><td colspan="2"><h:errors/></td></tr></l:messagesPresent>
			<tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
			<tr><td class="itemin" width="30%"><b:message key="com.vh.label.Mix_Name" bundle="resources"/><span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<input class="fieldarea" type="text" name="mfName" style="width:250px;" validate="required" />&nbsp;</td></tr>
			<tr><td class="itemin" width="30%"><b:message key="com.vh.label.Genre" bundle="resources"/>&nbsp;&nbsp;&nbsp;</td>
				<td class="field" width="70%">&nbsp;
				<select name="mfGenreId" id="mfGenreId" class="fieldarea" style="width:250px;">
					<option value="-1"></option>
					<c:forEach items="${allGenreColl}" var="genre">
					  <option value="<c:out value='${genre.id}'/>"><c:out value="${genre.desc}"/></option>
					</c:forEach>
				</select>		
				</td>
			</tr>
			<tr><td height="30" class="itemin" width="30%">&nbsp;&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<a href="#"><img border="0" onMouseOver="style.cursor='hand';" alt="Add Song" src="<c:url value='/common/img/add.gif'/>" /></a>&nbsp;<img border="0" onclick="deleteSelectedOption();" onMouseOver="style.cursor='hand';" alt="Remove Song" src="<c:url value='/common/img/remove.gif'/>" />&nbsp;<img border="0" onclick="moveUp();" onMouseOver="style.cursor='hand';" alt="Move Song Up" src="<c:url value='/common/img/up.gif'/>" />&nbsp;<img border="0" onclick="moveDown();" onMouseOver="style.cursor='hand';" alt="Move Song Down" src="<c:url value='/common/img/down.gif'/>" />&nbsp;</td></tr>
			</thead>
			<tbody id="mixRows">		
			<tr><td class="itemin" width="30%"><b:message key="com.vh.label.Songs" bundle="resources"/><span class="asterisk">*</span>&nbsp;&nbsp;</td>
				<td class="field" width="70%">&nbsp;
					<select name="mfColl" id="mfColl" size="3" style="width:250px; height:150px;" class="fieldarea" validate="required"></select>
				</td>
			</tr>
			</tbody>
		</form> 
	</table>

</body>
</html>