<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.artists"/></title>
  </head>
  
  <body onload="altRows();">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr>
	    <td align="left" valign="top">
		    <table width="100%" cellspacing="0" cellpadding="0">
  	  	  	  <thead id="theHeader">	
	          <tr class="trnormal">
		        <th class="listtitle" width="3%"><input type="checkbox" name="toggleAll" onclick="ToggleAll();" /></th>
		        <th class="listtitle" width="97%"><a href="javascript:TableSort(1,0)">Name</a>&nbsp;&nbsp;</th>
	          </tr>
	          </thead>
	          <tbody id="theRows">
				<c:forEach items="${artistColl}" var="artist">     	      
	              <tr class="trnormal">
		            <td class="list" width="3%"><input type="checkbox" name="id" value="<c:out value='${artist.id}'/>" onclick="Toggle(this);" /></td>
		            <td class="list" width="97%"><h:link target="bgFrame" action="/music/StartMusic.bg?c=content&c2=footer&t=3" paramId="id" paramName="artist" paramProperty="id"><c:out value="${artist.desc}"/></h:link></td>
                  </tr>
				</c:forEach>
              </tbody>
	        </table>
		</td>
	  </tr>
	</table>

  </body>

</html>