<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.photosmain"/></title>
  </head>
  
  <body onload="altRows();">

    <%@ include file="/modules/photos/jsp/photosdivs.jsp"%>

    <form name="gridForm" target="bgFrame" action="<c:url value='/phone/PhotosDispatcher.bg?c=grid'/>" method="post">
    <h:hidden property="nextAction" value="error"/>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar" width="33px">&nbsp;<img alt="Photos" width="16" height="16" src="<c:url value='/modules/photos/img/camera.gif'/>" /></td>
		<td class="titlebar" align="left" valign="middle"><b:message bundle="resources" key="com.vh.title.jsp.photosmain"/></td>
		<td class="titlebar" align="right" width="55px">
			<a href="<c:url value='/common/ShowDesktop.bg?c=content&c2=footer'/>" target="bgFrame" title="Minimize" class="titlebar"><img alt="Minimize" border="0" src="<c:url value='/common/img/minimize.gif'/>" />&nbsp;</a>
			<a href="<c:url value='/common/CloseApp.bg?c=content&c2=footer'/>" target="bgFrame" title="Close" class="titlebar"><img alt="Close" border="0" src="<c:url value='/common/img/close.gif'/>" />&nbsp;</a>
		</td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="20">
	    <td class="toolbarline1" width="18">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
		<td class="menu"><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('photosFileMenu', this);">&nbsp;&nbsp;&nbsp;File&nbsp;&nbsp;&nbsp;</a><a href="#" style="z-index:25; position:relative;" onClick="MENU.show('photosHelpMenu', this);">&nbsp;&nbsp;&nbsp;Help&nbsp;&nbsp;&nbsp;</a></td>
	  </tr>
	</table>
	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="25">
	    <td class="toolbarline2" width="24">&nbsp;&nbsp;<img border="0" src="<c:url value='/common/img/dots_3x5_small.gif'/>" /></td>
        <td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="Dialog('/modules/photos/jsp/createAlbum.jsp');" width="30" valign="bottom">&nbsp;&nbsp;<img border="0" alt="New Album" src="<c:url value='/modules/photos/img/wizard.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="confirmDelete('delete');" width="30" valign="bottom">&nbsp;&nbsp;<input alt="Delete" type="image" src="<c:url value='/common/img/delete.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="Dialog('/modules/photos/jsp/albumInfo.jsp');" width="30" valign="bottom">&nbsp;&nbsp;<img border="0" alt="Edit" src="<c:url value='/common/img/edit.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="Dialog('/modules/photos/jsp/uploadPhoto.jsp');" width="30" valign="bottom">&nbsp;&nbsp;<img border="0" alt="Upload" src="<c:url value='/common/img/upload.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="download();" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Download" src="<c:url value='/common/img/download.gif'/>" /></td>
		<td class="toolbar" onMouseOver="this.className='toolbarover';" onMouseOut="this.className='toolbarout';" onClick="window.open('<c:url value='/modules/photos/jsp/slideshow.jsp'/>','slideshow','height=400,width=600,top=200,left=200,status=yes,toolbar=no,menubar=no,location=no');" width="30" valign="bottom">&nbsp;&nbsp;<img alt="Slide Show" src="<c:url value='/modules/photos/img/slide.gif'/>" /></td>
		<td class="toolbar" width="800">&nbsp;</td>
	  </tr>
	</table>

	<div id="grid" name="grid">
	<table width="100%" cellspacing="0" cellpadding="0">
  	  <thead id="theHeader">
      <tr class="trnormal">
	    <th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
	    <th class="listtitle" width="27%"><a href="javascript:TableSort(1,0)">Name</a>&nbsp;&nbsp;</th>
	    <th class="listtitle" width="30%"><a href="javascript:TableSort(2,0)">Description</a>&nbsp;&nbsp;</th>
	    <th class="listtitle" width="20%"><a href="javascript:TableSort(3,3)">Date</a>&nbsp;&nbsp;</th>
	    <th class="listtitle" width="20%"><a href="javascript:TableSort(4,1)">Visits</a>&nbsp;&nbsp;</th>
      </tr>
      </thead>
      <tbody id="theRows">              
		<c:forEach items="${photoAlbumColl}" var="photoAlbum">
          <tr class="trnormal">
	        <td class="list" width="3%"><input type="checkbox" name="id" onclick="Toggle(this);" value="<c:out value='${photoAlbum.id}'/>" /></td>
	        <td class="list" width="27%"><a target="bgFrame" href="<c:url value='/photos/ViewAlbumPhotos.bg?c=grid&id=${photoAlbum.id}'/>"><c:out value="${photoAlbum.title}"/></a></td>
	        <td class="list" width="20%"><c:out value="${photoAlbum.desc}"/>&nbsp;</td>
	        <td class="list" width="30%"><fmt:formatDate value="${photoAlbum.dateCreated}" pattern="MM/dd/yyyy"/>&nbsp;</td>
	        <td class="list" width="20%"><c:out value="${photoAlbum.nofVisits}"/>&nbsp;</td>
          </tr>
		</c:forEach>
      </tbody>
	</table>
	</div>
	</form>

  </body>
</html>