<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title><b:message bundle="resources" key="com.vh.title.jsp.logout"/></title>
</head>
<body onload="focusOnUserName()">

  <% /* prepopulated ActionForm (loginForm) that the jsp uses to prepopulate input fields */ %>
  <c:set var="theForm" value="${requestScope['loginform']}" />
  <% /* contains the error msg that comes back from Login2 action */ %>
  <c:set var="errorMsg" value="${requestScope['errorMsg']}" />

  <table cellspacing="0" cellpadding="0" border="0" width="100%">
    <form name="loginForm" action="/outside/Login2.do" method="post">
	  <tr>
	    <td height="300px" width="30%">
			<table class="itemlog" height="100%" width="100%"> 	
			    <tr><td class="itemlogbig" valign="bottom" colspan="2"><br /><b:message bundle="resources" key="com.vh.label.Sign_back"/></td></tr>
		    	<tr><td valign="bottom" colspan="2"><br /><b:message bundle="resources" key="com.vh.label.Username"/></td></tr>
		    	<tr><td valign="top" colspan="2"><input class="fieldarea" type="text" name="username" value="<c:out value='${theForm.username}' />" validate="required" /></td></tr>
		    	<tr><td valign="bottom" colspan="2"><b:message bundle="resources" key="com.vh.label.Password"/></td></tr>
		    	<tr><td valign="top" width="60%"><input class="fieldarea" type="password" name="password" value="<c:out value='${theForm.password}' />" validate="required" />
				      <c:if test="${errorMsg != null}" >
                        <span class="formFieldError"><c:out value="${errorMsg}" /></span>
                      </c:if></td></tr>
				<tr><td valign="bottom" colspan="2">
				        <c:if test="${theForm.remember == 'on'}">
                          <input type="checkbox" name="remember" checked="checked" />
						</c:if>
				        <c:if test="${theForm.remember != 'on'}">
                          <input type="checkbox" name="remember" />
						</c:if>
						<b:message bundle="resources" key="com.vh.label.Remember_my_password"/>
					</td></tr>
				<tr><td align="left"><br />
				  	  <img src="/common/img/back.gif" 
						   alt="<b:message bundle='resources' key='com.vh.title.jsp.login'/>" onclick="validateForm(document.loginForm);" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" /><br /><br /><br /><br /></td></tr>
			</table>
	    </td>
		<td height="300px" valign="top">
			<table border="0" height="100%" width="100%" class="fieldlog">
			  <tr>
				<td>
				  <ul>
			        <li><a class="underline" href="#" onclick="loadURLIntoContainer('/outside/ViewSignup.none','content')"><b:message bundle="resources" key="com.vh.label.Sign_up"/></a></li><br /><br />
			        <li><a class="underline" href="#" onclick="loadURLIntoContainer('/outside/jsp/forgotpwd.jsp','content')"><b:message bundle="resources" key="com.vh.label.Forgotpassword?"/></a></li><br /><br />
				  </ul>
				</td>
			  </tr>
			</table>
		</td>
	  </tr>
	</form>
  </table>
  
</body>
</html>
