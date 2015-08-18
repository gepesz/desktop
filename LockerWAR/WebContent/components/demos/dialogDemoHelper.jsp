<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>This is the dialogDemoHelper title</title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

  <form name="dialogDemoForm" action="<c:url value='/components/demos/dialogDemo.jsp'/>" >
  <table>
    <tr>
      <td class="zuiDialogItem">First Name:<span class="asterisk">*</span></td>
	  <td><input type="text" name="fName" class="zuiDialogArea" validate="required" /></td>
	</tr>
    <tr>
      <td class="zuiDialogItem">Last Name:</td>
	  <td><input type="text" name="lName" class="zuiDialogArea" /></td>
	</tr>
    <tr>
      <td class="zuiDialogItem">Age:</td>
	  <td><input type="text" name="age" class="zuiDialogArea" /></td>
	</tr>
  </table>
  </form>

</body>
</html>