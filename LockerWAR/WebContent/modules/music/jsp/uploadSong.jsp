<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Upload Song</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

<table cellpadding="0" cellspacing="0" width="100%">  
	<form name="uploadSongForm" target="bgFrame" action="<c:url value='/music/UploadMusic.bg?c=grid'/>" enctype="multipart/form-data" method="post">
		  <tr><td class="itemtext" height="20" colspan="2">&nbsp;Please upload your song.</td></tr>
		  <l:messagesPresent><tr><td colspan="2"><h:errors/></td></tr></l:messagesPresent>
		  <tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%"><b:message key="com.vh.label.File" bundle="resources"/><span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<input type="file" name="upFile" id="upFile" value="" class="fieldarea" style="width:200px;" onchange="parseFileName(this.value);" validate="required" />&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%"><b:message key="com.vh.label.Artist" bundle="resources"/><span class="asterisk">*</span>&nbsp;</td><td class="field"  width="70%">&nbsp;&nbsp;<input type="text" name="upArtist" id="upArtist" value="" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%"><b:message key="com.vh.label.Song_Title" bundle="resources"/><span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<input type="text" name="upSongTitle" id="upSongTitle" value="" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%"><b:message key="com.vh.label.Album" bundle="resources"/>&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<input type="text" name="upAlbum" id="upAlbum" value="" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		  <tr><td class="itemin" width="30%"><b:message key="com.vh.label.Genre" bundle="resources"/>&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%">&nbsp;&nbsp;<input type="text" name="upGenre" id="upGenre" value="" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
	</form>
</table>

</body>
</html>