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
  <h4>Form Validation</h4>

  <h5>Form w/ validation</h5>
  <form name="validateDemoForm" action="<c:url value='/components/demos/validateDemo.jsp'/>" >
  <table>
    <tr>
      <td>First Name:</td>
	  <td><input type="text" name="fName" validate="required" /></td>
	</tr>
    <tr>
      <td>Last Name:</td>
	  <td><input type="text" name="lName" /></td>
	</tr>
    <tr>
      <td>Age:</td>
	  <td><input type="text" name="age" validate="required, integer, intRange" /></td>
	</tr>
    <tr>
      <td>Email:</td>
	  <td><input type="text" name="email" validate="required,email" /></td>
	</tr>
    <tr>
      <td>State:</td>
	  <td>
		<select name="state" validate="required">
		  <option value="-1"></option>
		  <option value="1">CA</option>
		  <option value="2">FL</option>
		  <option value="3">NY</option>
		</select>
	  </td>
	</tr>
	<tr>    
	  <td><br /><input type="button" value="Submit" onclick="validateForm(this.form);" /></td>
	  <td><br /><img src="<c:url value='/common/img/forward.gif'/>" onclick="validateForm(document.validateDemoForm);" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" /></td>
	</tr>
  </table>
  </form>

  <hr width="50%" />

  <h5>Form w/o validation</h5>
  <form name="validateDemoForm2" action="<c:url value='/components/demos/validateDemo.jsp'/>" >
  <table>
    <tr>
      <td>First Name:</td>
	  <td><input type="text" name="fName" /></td>
	</tr>
    <tr>
      <td>Last Name:</td>
	  <td><input type="text" name="lName" /></td>
	</tr>
	<tr>    
	  <td><br /><input type="button" value="Submit" onclick="validateForm(this.form);" /></td>
	  <td><br /><img src="<c:url value='/common/img/forward.gif'/>" onclick="validateForm(document.validateDemoForm2);" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" /></td>
	</tr>
  </table>
  </form>

</body>
</html>