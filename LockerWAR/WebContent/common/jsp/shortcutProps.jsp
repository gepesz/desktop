<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Shortcut Properties</title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>
</head>
<body>

  <c:set var="applications" value="${applicationScope['com.vh.locker.ALLAPPS']}" />
  
  <form name="shortcutForm" action="/common/CreateShortcut.bg" method="post">

  <table cellpadding="0" cellspacing="0" width="100%">
    <tr><td class="field" height="20" colspan="2">Please edit the properties of the shortcut.</td></tr>
    <tr>
	    <td class="itemin" width="30%">Name Shortcut:</td>
		<td class="field" width="70%"><input type="text" class="fieldarea" name="username" style="width:175px"/></td>
	</tr>
	<tr>
		<td class="itemin" width="30%">Choose Target:</td>
		<td class="field" width="70%" align="left">
		 <select name="shortcutApp" id="shortcutApp" class="fieldarea" validate="required" onchange="newShortCutDialogDropDownOnChange();" style="width:100px;">
		    <option value="-1" selected="true">--Select--</option>
            <c:forEach var="app" items="${applications}">
		      <option value="<c:out value='${app.id}'/>"><c:out value="${app.desc}"/></option>
            </c:forEach>
		  </select>
		</td>
	</tr>
	<tr>
	    <td class="itemin" width="30%">Select Icon:</td>
		<td class="field" width="70%"><input type="file" name="upIcon" id="upIcon" value="" class="fieldarea" style="width:250px;" onchange="parseFileName(this.value);" validate="required" /></td>
	</tr>
  </table>
  </form>

</body>
</html>
