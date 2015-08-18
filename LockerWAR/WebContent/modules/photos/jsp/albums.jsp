<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.photosmain"/></title>
  </head>
  
  <body>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr>
		<td valign="top" align="left">
			<table width="100%" cellspacing="0" cellpadding="0">
			  <tr class="trnormal">
				<th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
				<th class="listtitle" width="27%"><a href="javascript:TableSort(1,0)">Name</a>&nbsp;&nbsp;</th>
				<th class="listtitle" width="30%"><a href="javascript:TableSort(2,0)">Description</a>&nbsp;&nbsp;</th>
				<th class="listtitle" width="20%"><a href="javascript:TableSort(3,0)">Date</a>&nbsp;&nbsp;</th>
				<th class="listtitle" width="20%"><a href="javascript:TableSort(4,0)"># of Photos</a>&nbsp;&nbsp;</th>
			  </tr>
			  <tr class="trnormal">
				<td class="list" width="3%"><input type="checkbox" name="id" onclick="Toggle(this);" /></td>
				<td class="list" width="27%"><a href="<c:url value='/photos/ViewAlbumPhotos.bg?c=grid'/>" target="bgFrame">Caribbean Cruise 2005</a>&nbsp;</td>
				<td class="list" width="30%">Pictures of Mark, Beta, Petek and Peter&nbsp;</td>
				<td class="list" width="20%">Jan-Feb 2005&nbsp;</td>
				<td class="list" width="20%">18&nbsp;</td>
			  </tr>
			</table>
		</td>
	  </tr>
	</table>

  </body>
</html>