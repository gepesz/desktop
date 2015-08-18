<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title><b:message bundle="resources" key="com.vh.title.jsp.login"/></title>
</head>
<body onload="focusOnUserName()">

  <% /* true or false, depending on whether signup link should be shown */ %>
  <c:set var="signup_enabled"><%=com.vh.locker.util.Constants.SIGNUP_ENABLED%></c:set>
  <% /* contains the error msg that comes back from Login action */ %>
  <c:set var="errorMsg" value="${requestScope['errorMsg']}" />

  <table cellspacing="0" cellpadding="0" width="100%">	
  <form name="loginForm" action="/outside/Login.do" method="post">
    <tr>
		<td class="fieldlog" width="70%" height="350px" valign="top">
		  <b:message bundle="resources" key="com.vh.label.Intro"/>
		</td>
		<td height="351px" width="30%">
			<table class="itemlog" height="100%" width="100%" >
			    <tr><td class="itemlogbig" valign="bottom" colspan="2"><br /><b:message bundle="resources" key="com.vh.label.Sign_in"/><br /><br /></td></tr>
                <% /* USERNAME */ %>
				<tr><td valign="bottom" colspan="2"><b:message bundle="resources" key="com.vh.label.Username"/></td></tr>
				<tr><td valign="top" colspan="2"><input class="fieldarea" type="text" name="username" validate="required" size="25" /></td></tr>
                <% /* PASSWORD */ %>
				<tr><td valign="bottom" colspan="2"><b:message bundle="resources" key="com.vh.label.Password"/></td></tr>
				<tr>
					<td valign="top" width="60%">
					  <input class="fieldarea" type="password" name="password" size="25" validate="required" />
                      <c:if test="${errorMsg != null}" >
                        <span class="formFieldError"><c:out value="${errorMsg}" /></span>
                      </c:if>
					</td>
					<td align="left">
						<img src="/common/img/forward.gif" 
						     alt="<b:message bundle='resources' key='com.vh.title.jsp.login'/>" onclick="validateForm(document.loginForm);" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" />
					</td>
				</tr>
                <% /* REMEMBER ME */ %>
				<c:if test="${signup_enabled}">	      
				  <tr>
				    <td valign="bottom" colspan="2">
					<input type="checkbox" name="remember" />
					<b:message bundle="resources" key="com.vh.label.Remember_my_password"/>
					</td>
				  </tr>
				</c:if>
				<tr><td valign="bottom" colspan="2"><br /><hr width="100%"><br /></td></tr>
                <% /* SIGN_UP, FORGOT_PWD LINKS */ %>
				<c:if test="${signup_enabled}">
				  <tr><td align="right" valign="bottom" colspan="2"><a class="underline" href="#" onclick="loadURLIntoContainer('/outside/ViewSignup.none','content')"><b:message bundle="resources" key="com.vh.label.Sign_up"/></a></td></tr>
				  <tr><td height="40" align="right" valign="top" colspan="2"><a href="#" class="underline" onclick="loadURLIntoContainer('/outside/jsp/forgotpwd.jsp','content')"><b:message bundle="resources" key="com.vh.label.Forgotpassword?"/></a></td></tr>
				</c:if>
			</table>
		</td>
	  </tr>
  </form>
  </table>

<script>
  var un = "<cookie:getCookieValue name='<%=com.vh.locker.util.Constants.COOKIE_USERNAME%>'/>";
  if((un!=null) && (un!='')) {
    document.getElementById('username').value = un;
    document.getElementById('password').value = "<cookie:getCookieValue name='<%=com.vh.locker.util.Constants.COOKIE_PASSWORD%>'/>";
    document.getElementById('remember').checked = 'true';
  }
</script>

</body>
</html>
