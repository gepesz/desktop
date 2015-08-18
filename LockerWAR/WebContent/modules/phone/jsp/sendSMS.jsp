<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Send SMS</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

	<table cellspacing="0" cellpadding="0" width="100%">
	  <form name="smsForm" target="bgFrame" action="<c:url value='/phone/SendSMS.bg?c=grid'/>" method="post">
		  <input type="hidden" name="contactIds" id="contactIds" />
		  <tr><td class="itemtext" height="20" colspan="2">&nbsp;Please enter your message.</td></tr>
		  <tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%">To<span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<input type="text" name="contactNames" id="contactNames" value="" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%">Subject<span class="asterisk">*</span>&nbsp;</td><td class="field"  width="70%">&nbsp;&nbsp;<input type="text" name="smsSubject" id="smsSubject" value="" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%">Message<span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<textarea class="fieldarea" style="width:200px;" rows="7" onkeypress="return taLimit()" onkeyup="return taCount(visCnt)" name="smsMsg" id="smsMsg" maxLength="160" style="overflow:hidden;" validate="required"></textarea>&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%">&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<span id="visCnt">160</span>&nbsp;characters left&nbsp;</td></tr>
	  </form>
	</table>

</body>
</html>