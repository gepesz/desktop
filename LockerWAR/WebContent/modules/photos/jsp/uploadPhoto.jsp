<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Upload Photo</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

	<table cellpadding="0" cellspacing="0" width="100%">  
		<%--<h:form action="/music/UploadMusic" method="POST" enctype="multipart/form-data">--%>
		  <tr><td class="itemtext" height="20" colspan="2">&nbsp;Please upload your photo.</td></tr>
		  <l:messagesPresent><tr><td colspan="2"><h:errors/></td></tr></l:messagesPresent>
		  <tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%"><b:message key="com.vh.label.File" bundle="resources"/><span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<input type="file" name="upFile" id="upFile" value="" class="fieldarea" style="width:200px;" onchange="parseFileName(this.value);">&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%">Name<span class="asterisk">*</span>&nbsp;</td><td class="field"  width="70%">&nbsp;&nbsp;<input type="text" name="upArtist" id="upArtist" value="" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		<%--</h:form>--%>
	</table>

</body>
</html>