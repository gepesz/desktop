<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title>Slide Show</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>
  </head>

  <body onload="altRows();">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <thead id="theHeader">	
	  <tr class="trnormal">
		<th colspan="100%" class="list" height="20px">&nbsp;Caribbean Cruise 2005&nbsp;</th>
	  </tr>
	  </thead>
	    <tbody>
		  <tr class="trnormal">
		    <td class="list" width="5px"></td>
			<td class="list" width="90%"><img width="450px" height="350px" border="1px solid #666666" src="<c:url value='/home/${user.userName}/zdocs/photo/${photo.link}'/>" /></td>
			<td class="list" width="5px" align="left"><a href="#"><img alt="Next" border="0" src="<c:url value='/common/img/forward.gif'/>" /></a></td>
		  </tr>
		</tbody>
	</table>

  </body>
</html>