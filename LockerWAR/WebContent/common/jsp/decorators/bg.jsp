<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.prefix"/><decorator:title default="Welcome" /></title>
    <decorator:head />
	<script language="javascript" src="<c:url value='/common/js/bg.js'/>"></script>
    <script type="text/javascript">
      var c = '<c:out value="${c}"/>';
      var c2 = '<c:out value="${c2}"/>';
	  var c_present = c!='';
	  var c2_present = c2!='';
    </script>
  </head>
  
  <body onload="<decorator:getProperty property='body.onload'/>; 
                if(c_present) swapContent('content',c);
				else swapContent('content','content');
				if(c2_present) swapContent('c2',c2); 
				window.status='Done';" 
		onunload="window.status='Loading...';">
    <center>--- bg.jsp ---</center>

    <% /* CONTENT DIV */ %>
	<c:choose>
      <c:when test="${c == 'grid'}">	  
	    
		<form name="gridForm">
          <input type="hidden" />
		  <div name="content" id="content">
            <decorator:body />
          </div>
        </form>      
	  
	  </c:when>
      <c:otherwise>
      
		<div name="content" id="content">
          <decorator:body />
        </div>
     
	  </c:otherwise>
    </c:choose>
    <% /* END OF CONTENT DIV */ %>

    <% /* C2 CONTENT DIV */ %>
    <c:if test="${c2 == 'footer'}">
      <div id="c2" name="c2">
	    <c:import url="/common/jsp/footer.jsp"/>
	  </div>
	</c:if>
    <% /* END OF C2 CONTENT DIV */ %>

    <% /* GUI POPUP: POPS UP ANOTHER WINDOW WITH THE MUSIC GUI IF 'playlist' IS IN REQUEST SCOPE */ %>
	<c:if test="${playlist!=null}">
	  <p>Playlist:&nbsp;<c:out value="${playlist}"/></p>
	  <p>Init:&nbsp;<c:out value="${init}"/></p>
	  <script language="javascript">
        window.open('<c:url value="/modules/music/jsp/gui.jsp?playlist=${playlist}&init=${init}"/>','gui','width=295,height=370,top=220,left=650,scrollbars=0,resizable=0');
      </script>
	</c:if>
    <% /* END OF GUI POPUP */ %>


	<% /* dumping objects stored at request, session scope */ %>
	<hr width="50%" />
	
	<table align="left" border="0" width="100%" cellpadding="0" cellspacing="0">    
	  <tr><td><h3>Dumping objects at...</h3></td></tr>
	  <tr><td>Request scope:</td></tr>
	  <tr><td><log:dump scope="request"/></td></tr>
	  <tr><td>Session scope:</td></tr>
	  <tr><td><log:dump scope="session"/></td></tr>
	</table>

  </body>
</html>