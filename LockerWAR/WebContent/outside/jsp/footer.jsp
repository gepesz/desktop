
<%@ include file="/common/jsp/include/include_tld.jsp" %>

<% /* COPYRIGHT */ %>
<div style="float:right; padding-top:3px; padding-right:10px;">
  <b:message bundle="resources" key="com.vh.copyright"/>
</div>

<% /* FOOTER LINKS: PRIVACY, LEGAL, CONTACT US */ %>
<div class="footer">
  <a href="#" onclick="loadURLIntoContainer('/outside/jsp/privacy.jsp','content')"><b:message bundle="resources" key="com.vh.label.Privacy"/></a> | 
  <a href="#" onclick="loadURLIntoContainer('/outside/jsp/legal.jsp','content')"><b:message bundle="resources" key="com.vh.label.Legal_Info"/></a> | 
  <a href="#" onclick="loadURLIntoContainer('/outside/jsp/contact.jsp','content')"><b:message bundle="resources" key="com.vh.label.Contact_Us"/></a>
</div>
