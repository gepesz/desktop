<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%
  /*
  ManageableCaptchaService manageable = (ManageableCaptchaService)CaptchaServicePlugin.getInstance().getService();

  //setting the captcha's image type
  manageable.setCaptchaEngineClass("com.octo.captcha.engine.image.gimpy.BaffleListGimpyEngine");

  /*
  The available captchaEngineClasses are in WEB-INF/lib/jcaptcha-all-XXX.jar, under the 
  package name com.octo.engine.image.gimpy.

  Available captchaEngineClasses:
  com.octo.engine.image.gimpy.BaffleListGimpyEngine
  com.octo.engine.image.gimpy.BasicGimpyEngine
  com.octo.engine.image.gimpy.BasicListGimpyEngine             -- doesn't work
  com.octo.engine.image.gimpy.DefaultGimpyEngine               -- this is the default if nothing is set
  com.octo.engine.image.gimpy.DeformedBaffleListGimpyEngine
  com.octo.engine.image.gimpy.DoubleRandomListGimpyEngine
  com.octo.engine.image.gimpy.FilteredBaffleListGimpyEngine
  com.octo.engine.image.gimpy.FilteredDoubleRandomListGimpyEngine
  com.octo.engine.image.gimpy.FilteredGimpyEngine
  com.octo.engine.image.gimpy.FilteredListGimpyEngine
  com.octo.engine.image.gimpy.MultipleGimpyEngine              -- doesn't work
  com.octo.engine.image.gimpy.SimpleListImageCaptchaEngine     -- works but gives exception in jboss
  */
%>

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.forgotpwd"/></title>
  </head>
  <body>

  <% /* contains the error msg that comes back from ForgotPassword action */ %>
  <c:set var="errorMsg" value="${requestScope['errorMsg']}" />
  <% /* contains the error type: 0 for captcha error, 1 for username error  */ %>
  <c:set var="errorKey" value="${requestScope['errorKey']}" />
  
  

    <dl class="itemlog">

	<form name="forgotpwdForm" action="/outside/ForgotPassword.bg?c=content" target="bgFrame" method="post">
	
	<h2><span class="itemlogbig">Password Assistance:</span></h2>
	<p style="padding-left:6px;">Please enter your username so that we can assist you with your password.</p>

      <% /* USERNAME */ %>
      <dt><b:message bundle="resources" key="com.vh.label.Username"/><span class="asterisk">*</span></dt>
      <dd>
	      <input class="fieldarea" type="text" name="username" value="<c:out value='${username}' />" validate="required" />
	      <c:if test="${errorKey == 1}" >
		    <span class="formFieldError"><c:out value="${errorMsg}" /></span>
		  </c:if>
	  </dd>

      <% /* CAPTCHA */ %>
	  <dt>Word Verification<span class="asterisk">*</span></dt>
      <dd>Type the characters that you see in the picture below:</dd>
	  <dd><img src="/outside/jcaptcha.do" width="200" height="100" alt="If you can see this, you do not have images enabled. Please enable images in order to proceed." /></dd>
      <dd><input class="fieldarea" type="text" name="captcha" value="" validate="required" />
	      characters are case-sensitive
	      <c:if test="${errorKey == 0}" >
		    <span class="formFieldError"><c:out value="${errorMsg}" /></span>
		  </c:if>	  
	  </dd>
	  
	  <dt><input type="button" class="button" value="OK"     onclick="validateForm(this.form);" /></dt>
      <dd><input type="button" class="button" value="Cancel" onclick="loadURLIntoContainer('/outside/jsp/login.jsp','content')" /></dd>
  
	</form>

	</dl>

  </body>
</html>
