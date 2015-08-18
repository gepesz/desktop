<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Add Contact</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

	<table cellspacing="0" cellpadding="0" width="100%">
	  <form name="contactForm" target="bgFrame" action="<c:url value='/phone/UpdateContact.bg?c=grid'/>" method="post">
	    <input type="hidden" name="contactId" id="contactId" />
		<input type="hidden" name="token" id="token" value="5" />
		<tr><td class="itemtext" height="20" colspan="2">&nbsp;Please edit the details of this contact entry.</td></tr>
		<tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
		<tr><td class="itemin" width="30%">Name<span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="contactName" id="contactName" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		<tr><td class="itemin" width="30%">Nickname&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="contactNickName" id="contactNickName" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		<tr><td class="itemin" width="30%">Phone<span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="contactPhone" id="contactPhone" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		<tr><td class="itemin" width="30%">Email&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="contactEmail" id="contactEmail" class="fieldarea" style="width:200px;" />&nbsp;</td></tr>
	  </form>
	</table>

</body>
</html>