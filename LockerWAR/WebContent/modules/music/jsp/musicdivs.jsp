
  <div class="zuiDropDown" id="musicFileMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); setNextAction('play');"><img alt="Play" width="16" height="16" border="0" src="<c:url value='/modules/music/img/play.gif'/>" />&nbsp;Play</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); setNextAction('shuffle');"><img alt="Shuffle" width="16" height="16" border="0" src="<c:url value='/modules/music/img/shuffle.gif'/>" />&nbsp;Shuffle</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); setNextAction('delete');"><img alt="Delete" width="16" height="16" border="0" src="<c:url value='/common/img/delete.gif'/>" />&nbsp;Delete</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Dialog('/modules/music/jsp/uploadSong.jsp');"><img alt="Upload" width="16" height="16" border="0" src="<c:url value='/common/img/upload.gif'/>" />&nbsp;Upload</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); download();"><img alt="Download" width="16" height="16" border="0" src="<c:url value='/common/img/download.gif'/>" />&nbsp;Download</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame"><img alt="Close" width="16" height="16" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;Close</a></li>
	</ul>
  </div>

  <div class="zuiDropDown" id="musicViewMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a target="bgFrame" href="<c:url value='/music/ViewArtists.bg?c=grid'/>"><img alt="Artists" width="16" height="16" border="0" src="<c:url value='/modules/music/img/heart.gif'/>" />&nbsp;Artists</a></li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a target="bgFrame" href="<c:url value='/music/ViewAlbums.bg?c=grid'/>"><img alt="Albums" width="16" height="16" border="0" src="<c:url value='/modules/music/img/heart.gif'/>" />&nbsp;Albums</a></li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a target="bgFrame" href="<c:url value='/music/ViewTracks.bg?c=grid&t=0'/>"><img alt="Tracks" width="16" height="16" border="0" src="<c:url value='/modules/music/img/heart.gif'/>" />&nbsp;Tracks</a></li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a target="bgFrame" href="<c:url value='/music/ViewGenres.bg?c=grid'/>"><img alt="Genres" width="16" height="16" border="0" src="<c:url value='/modules/music/img/heart.gif'/>" />&nbsp;Genres</a></li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a target="bgFrame" href="<c:url value='/music/ViewMixes.bg?c=grid'/>"><img alt="Mixes" width="16" height="16" border="0" src="<c:url value='/modules/music/img/heart.gif'/>" />&nbsp;Mixes</a></li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide();"><a target="bgFrame" href="<c:url value='/music/ViewTracks.bg?c=grid&t=1'/>"><img alt="Recent" width="16" height="16" border="0" src="<c:url value='/modules/music/img/heart.gif'/>" />&nbsp;Recent</a></li>
	</ul>
  </div>

  <div class="zuiDropDown" id="musicHelpMenu">
    <ul>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('UNDER CONSTRUCTION');"><img alt="Help" width="16" height="16" border="0" src="<c:url  value='/common/img/question.gif'/>" />&nbsp;Help</li>
        <li onmouseover="this.className='hover';" onmouseout="this.className='';" onclick="MENU.hide(); Alert('&nbsp;Version 1.0.&nbsp;Copyright 2004 ZLocker Inc.&nbsp;All rights reserved.&nbsp;');"><img alt="About Z" width="16" height="16" border="0" src="<c:url value='/common/img/info.gif'/>" />&nbsp;About Z</li>
	</ul>
  </div>