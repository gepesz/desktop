<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.tracks"/></title>
  </head>
  
  <body onload="altRows();">

    <%@ include file="/modules/music/jsp/musicdivs.jsp"%>

	<form name="gridForm" target="bgFrame" action="<c:url value='/music/MusicDispatcher.bg?c=grid'/>" method="post">
	<h:hidden property="nextAction" value="error"/>
	
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar" width="33px">&nbsp;<img alt="Music" width="16" height="16" src="<c:url value='/modules/music/img/kmix.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle"><b:message bundle="resources" key="com.vh.title.jsp.mymusic"/></td>
		<td class="titlebar" align="right" width="55px">
			<img src="<c:url value='/common/img/minimize.gif'/>" 
				 alt="Minimize" 
				 onclick="loadApp();" 
				 onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" />
			<img src="<c:url value='/common/img/close.gif'/>" 
				 alt="Close" 
				 onclick="closeApp();" 
				 onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" />
		</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="20">
	    <td class="toolbarline1" width="18">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('musicFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('musicViewMenu', this);">&nbsp;&nbsp;&nbsp;View&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('musicHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>	
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="24">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="setNextAction('play');" width="30" valign="bottom">&nbsp;&nbsp;<input alt="Play" type="image" src="<c:url value='/modules/music/img/play.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="setNextAction('shuffle');" width="30" valign="bottom">&nbsp;&nbsp;<input alt="Shuffle" type="image" src="<c:url value='/modules/music/img/shuffle.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="confirmDelete('delete');" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Delete" src="<c:url value='/common/img/delete.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="Dialog('/modules/music/jsp/uploadSong.jsp');" width="30" valign="bottom">&nbsp;&nbsp;<img border="0" alt="Upload" src="<c:url value='/common/img/upload.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="download();" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Download" src="<c:url value='/common/img/download.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="Dialog('/modules/music/jsp/createMix.jsp'); populateOptions();" width="30" valign="bottom">&nbsp;&nbsp;<img border="0" alt="Create Mix" src="<c:url value='/modules/music/img/musicmix.gif'/>" /></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>

	<div id="grid" name="grid">
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
	</div>
	</form>

  </body>

</html>