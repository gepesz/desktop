<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.mixes"/></title>
  </head>
  
  <body onload="altRows();">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr>
	    <td align="left" valign="top">
		    <table width="100%" cellspacing="0" cellpadding="0">
  	  	  	  <thead id="theHeader">	
	          <tr class="trnormal">
		        <th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
		        <th class="listtitle" width="47%"><a href="javascript:TableSort(1,0)">Name</a>&nbsp;&nbsp;</th>
		        <th class="listtitle" width="10%"><a href="javascript:TableSort(2,0)">Genre</a>&nbsp;&nbsp;</th>
		        <th class="listtitle" width="10%"><a href="javascript:TableSort(3,5)">Length</a>&nbsp;&nbsp;</th>
		        <th class="listtitle" width="20%"><a href="javascript:TableSort(4,3)">Date created</a>&nbsp;&nbsp;</th>
		        <th class="listtitle" width="10%"><a href="javascript:TableSort(5,1)"># played</a>&nbsp;&nbsp;</th>
	          </tr>
	          </thead>
	          <tbody id="theRows">
				<c:forEach items="${mixColl}" var="mix">
	              <tr class="trnormal">
		            <td class="list" width="3%"><input type="checkbox" name="id" onclick="Toggle(this);" value="<c:out value='${mix.id}'/>" /></td>
					<td class="list" width="47%"><a href="#" onClick="Dialog('/modules/music/jsp/createMix.jsp', [<c:out value='${mix.id}'/>,'<c:out value='${mix.title}'/>','<c:out value='${mix.genre.id}'/>']);"><c:out value="${mix.title}"/></a></td>
		            <td class="list" width="10%"><c:out value="${mix.genre.desc}"/>&nbsp;</td>
		            <td class="list" width="10%"><z:songLength value="${mix.length}"/>&nbsp;</td>
		            <td class="list" width="20%"><fmt:formatDate value="${mix.dateCreated}" pattern="MM/dd/yyyy"/>&nbsp;</td>
		            <td class="list" width="10%"><c:out value="${mix.nofPlayed}"/>&nbsp;</td>
                  </tr>
				</c:forEach>
              </tbody>
	        </table>
		</td>
	  </tr>
	</table>

  </body>

</html>