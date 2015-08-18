<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>New Shortcut</title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>
</head>
<body>

  <c:set var="applications" value="${applicationScope['com.vh.locker.ALLAPPS']}" />

  <form name="shortcutForm">
  <table cellpadding="0" cellspacing="0" width="100%">
    <tr><td class="field" height="20" colspan="2">Please complete the fields below to add a new shortcut.</td></tr>
    <tr><td class="itemin" width="30%">Select program:</td>
	    <td class="field" width="70%" align="left">
		 <select name="shortcutApp" id="shortcutApp" class="fieldarea" validate="required" onchange="newShortCutDialogDropDownOnChange();" style="width:100px;">
		    <option value="-1" selected="true">--Select--</option>
            <c:forEach var="app" items="${applications}">
		      <option value="<c:out value='${app.id}'/>"><c:out value="${app.desc}"/></option>
            </c:forEach>
		  </select>
		</td>
	</tr>
	<tr><td class="itemin" width="30%">Name shortcut:</td>
	    <td class="field" width="70%" align="left">
		<input type="text" name="shortcutName" id="shortcutName" class="fieldarea" style="width:150px;" validate="required" value="" /></td>
	</tr>
  </table>
  </form>

</body>
</html>