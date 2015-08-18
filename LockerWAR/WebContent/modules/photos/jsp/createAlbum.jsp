<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Create Album</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

	<table cellpadding="0" cellspacing="0" width="100%">  
		<%--<h:form action="/CreateAlbum">--%>
			<tr><td class="itemtext" height="20" colspan="2">&nbsp;Please edit the details of this photo album.</td></tr>
			<% /*<l:messagesPresent><tr><td colspan="2"><h:errors/></td></tr></l:messagesPresent>*/ %>
			<tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
			<tr><td class="itemin" width="30%">Name<span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="albumName" id="albumName" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
			<tr><td class="itemin" width="30%">Description&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="albumDesc" id="albumDesc" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
			<tr><td class="itemin" width="30%">Date<span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="albumDate" id="albumDate" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
			<tr><td class="itemin" width="30%"># of Photos&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="albumNo" id="albumNo" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
			<tr><td height="30" class="itemin" width="30%">&nbsp;&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<a href="#"><img border="0" onMouseOver="style.cursor='hand';" alt="Add Photo" src="<c:url value='/common/img/add.gif'/>" /></a>&nbsp;<img border="0" onclick="deleteSelectedOption();" onMouseOver="style.cursor='hand';" alt="Remove Photo" src="<c:url value='/common/img/remove.gif'/>" />&nbsp;<img border="0" onclick="moveUp();" onMouseOver="style.cursor='hand';" alt="Move Photo Up" src="<c:url value='/common/img/up.gif'/>" />&nbsp;<img border="0" onclick="moveDown();" onMouseOver="style.cursor='hand';" alt="Move Photo Down" src="<c:url value='/common/img/down.gif'/>" />&nbsp;</td></tr>
			</thead>
			<tbody id="mixRows">		
			<tr><td class="itemin" width="30%">Photos<span class="asterisk">*</span>&nbsp;&nbsp;</td>
				<td class="field" width="70%">&nbsp;
					<select name="phColl" id="phColl" size="3" style="width:250px; height:150px;" class="fieldarea"></select>
				</td>
			</tr>
			</tbody>
		<%--</h:form>--%>
	</table>

</body>
</html>