<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.tracks"/></title>
  </head>
  
  <body onload="altRows();">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <thead id="theHeader">	
	  <tr class="trnormal">
		<th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
		<th class="listtitle" width="27%"><a href="javascript:TableSort(1,0)">Name</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="20%"><a href="javascript:TableSort(2,0)">Artist</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="20%"><a href="javascript:TableSort(3,0)">Album</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="10%"><a href="javascript:TableSort(4,0)">Genre</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="10%"><a href="javascript:TableSort(5,5)">Length</a>&nbsp;&nbsp;</th>
		<th class="listtitle" width="10%"><a href="javascript:TableSort(6,0)">Type</a>&nbsp;&nbsp;</th>
	  </tr>
	  </thead>
	  <tbody id="theRows">              
		<c:forEach items="${musicColl}" var="mp3">
		  <tr class="trnormal">
			<td class="list" width="3%"><input type="checkbox" name="id" onclick="Toggle(this);" value="<c:out value='${mp3.id}'/>" /></td>
			<td class="list" width="27%"><a href="#" onClick="Dialog('/modules/music/jsp/songInfo.jsp', [<c:out value='${mp3.id}'/>,'<c:out value='${mp3.artist.desc}'/>','<c:out value='${mp3.songTitle}'/>','<c:out value='${mp3.album.desc}'/>','<c:out value='${mp3.genre.desc}'/>']);"><c:out value="${mp3.songTitle}"/></a></td>
			<td class="list" width="20%"><c:out value="${mp3.artist.desc}"/>&nbsp;</td>
			<td class="list" width="20%"><c:out value="${mp3.album.desc}"/>&nbsp;</td>
			<td class="list" width="10%"><c:out value="${mp3.genre.desc}"/>&nbsp;</td>
			<td class="list" width="10%"><z:songLength value="${mp3.length}"/>&nbsp;</td>
			<td class="list" width="10%"><c:out value="${mp3.fileType.desc}"/>&nbsp;</td>
		  </tr>
		</c:forEach>
	  </tbody>
	</table>

  </body>

</html>