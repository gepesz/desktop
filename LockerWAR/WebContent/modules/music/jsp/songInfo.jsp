<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Song Info</title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>
</head>
<body>

  <form name="songForm" target="bgFrame" action="<c:url value='/music/UpdateSong.bg?c=grid'/>" method="post">
	<table cellpadding="0" cellspacing="0" width="100%">  
		<input type="hidden" name="sfId" id="sfId" />
		<l:messagesPresent><tr><td colspan="2"><h:errors/></td></tr></l:messagesPresent>
		<tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
		<tr><td class="itemin" width="30%"><b:message key="com.vh.label.Artist" bundle="resources"/><span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="sfArtist" id="sfArtist" class="fieldarea" style="width:200px;" validate="required" /></td></tr>
		<tr><td class="itemin" width="30%"><b:message key="com.vh.label.Song_Title" bundle="resources"/><span class="asterisk">*</span>&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="sfSongTitle" id="sfSongTitle" class="fieldarea" style="width:200px;" validate="required" /></td></tr>
		<tr><td class="itemin" width="30%"><b:message key="com.vh.label.Album" bundle="resources"/>&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="sfAlbum" id="sfAlbum" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
		<tr><td class="itemin" width="30%"><b:message key="com.vh.label.Genre" bundle="resources"/>&nbsp;&nbsp;&nbsp;</td><td class="field" width="70%" align="left" >&nbsp;&nbsp;<input type="text" name="sfGenre" id="sfGenre" class="fieldarea" style="width:200px;" validate="required" />&nbsp;</td></tr>
	</table>
  </form>

</body>
</html>