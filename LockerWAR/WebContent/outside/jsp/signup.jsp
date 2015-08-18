<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.signup"/></title>
  </head>
  <body>

  <% /* prepopulated ActionForm (signupForm) that the jsp uses to prepopulate input fields */ %>
  <c:set var="theForm" value="${requestScope['signupForm']}" />
  <% /* contains the error msg that comes back from Signup action */ %>
  <c:set var="errorMsg" value="${requestScope['errorMsg']}" />

  
    <dl class="itemlog">

	<form name="signupForm" action="/outside/Signup.do" method="post">
    <input type="hidden" name="<%=com.vh.locker.util.Constants_Scope.REQUEST_TOKEN_KEY%>" 
                           id="<%=com.vh.locker.util.Constants_Scope.REQUEST_TOKEN_KEY%>"
                        value="<%=com.vh.locker.base.TokenProcessor.saveToken(request)%>" />

	<h2><span class="itemlogbig">New Account:</span></h2>
	<p style="padding-left:6px;">Please fill out the following form so that we can create your account.</p><br />

      <dt><b:message bundle="resources" key="com.vh.label.First_Name"/><span class="asterisk">*</span></dt>
      <dd><input class="fieldarea" type="text" name="firstName" value="<c:out value='${theForm.firstName}' />" validate="required" /></dd>

      <dt><b:message bundle="resources" key="com.vh.label.Last_Name"/><span class="asterisk">*</span></dt>
      <dd><input class="fieldarea" type="text" name="lastName" value="<c:out value='${theForm.lastName}' />" validate="required" /></dd>

      <dt><b:message bundle="resources" key="com.vh.label.Username"/><span class="asterisk">*</span></dt>
      <dd>
	    <input class="fieldarea" type="text" name="userName" value="<c:out value='${theForm.userName}' />" validate="required" />
		<input type="button" class="button" value="Check!" onclick="checkUserNameAvailability(this.form.userName)" />
		<p class="fieldnotes">examples: john, john.smith</p>
	  </dd>

      <dt><b:message bundle="resources" key="com.vh.label.Password"/><span class="asterisk">*</span></dt>
      <dd>
	    <input class="fieldarea" type="password" name="password" value="" validate="required,minLength5,pwMatch" />
		<p class="fieldnotes">minimum 5 characters in length</p>
	  </dd>

      <dt><b:message bundle="resources" key="com.vh.label.Retype_Password"/><span class="asterisk">*</span></dt>
      <dd><input class="fieldarea" type="password" name="passwordAgain" value="" validate="required,minLength5" /></dd>

      <dt><b:message bundle="resources" key="com.vh.label.Security_Question"/><span class="asterisk">*</span></dt>
      <dd>
        <select name="question" class="fieldarea" validate="required" >
		  <option value="-1"></option>
		  <c:forEach items="${allSecretQuestionColl}" var="q">
		    <c:if test="${theForm.question == q.id}">
			  <option value="<c:out value='${q.id}'/>" selected="selected"><c:out value="${q.desc}"/></option>
			</c:if>
		    <c:if test="${theForm.question != q.id}">
			  <option value="<c:out value='${q.id}'/>"><c:out value="${q.desc}"/></option>
			</c:if>
		  </c:forEach>
		</select>
        <p class="fieldnotes">if you forget your password we will ask for the answer to your security question</p>
      </dd>

      <dt><b:message bundle="resources" key="com.vh.label.Answer"/><span class="asterisk">*</span></dt>
      <dd><input class="fieldarea" type="text" name="answer" value="<c:out value='${theForm.answer}' />" validate="required" /></dd>

      <dt><b:message bundle="resources" key="com.vh.label.Email"/><span class="asterisk">*</span></dt>
      <dd>
	    <input class="fieldarea" type="text" name="email" value="<c:out value='${theForm.email}' />" validate="required,email" />
	    <p class="fieldnotes">this address is used to help you should you ever forget your password</p>
	  </dd>

	  <dt>Word Verification<span class="asterisk">*</span></dt>
      <dd>Type the characters that you see in the picture below:</dd>
	  <dd><img src="/outside/jcaptcha.do" width="200" height="100" alt="If you can see this, you do not have images enabled. Please enable images in order to proceed." /></dd>
      <dd><input class="fieldarea" type="text" name="captcha" value="" validate="required" /><br />
	      characters are case-sensitive
          <c:if test="${errorMsg != null}" >
            <span class="formFieldError"><c:out value="${errorMsg}" /></span>
          </c:if>
	  </dd>

      <dt><b:message bundle="resources" key="com.vh.label.Terms_of_Service"/><span class="asterisk">*</span></dt>
      <dd>
		<c:if test="${theForm.firstName != null}">
		  <input type="checkbox" name="tos" validate="required" checked="checked" />
		</c:if>
		<c:if test="${theForm.firstName == null}">
		  <input type="checkbox" name="tos" validate="required" />
		</c:if>
        <span style="padding-left:6px;">I agree to the <a href="#" onclick="window.open('/outside/jsp/legal.jsp',null,'width=400,height=400,top=220,left=220,scrollbars=1,resizable=1');" >Terms of Service</a> and have read and understand the <a href="#" onclick="window.open('/outside/jsp/privacy.jsp',null,'width=400,height=400,top=220,left=220,scrollbars=1,resizable=1');" >ZLocker Privacy Policy</a>.</span>
	  </dd>
	  
	  <dt><input type="button" class="button" value="OK"     onclick="checkUserNameAvailability(this.form.userName); validateForm(this.form);" /></dt>
      <dd><input type="button" class="button" value="Cancel" onclick="loadURLIntoContainer('/outside/jsp/login.jsp','content')" /></dd>

	</form>
	
	</dl>

  </body>
</html>
