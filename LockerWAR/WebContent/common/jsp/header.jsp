
<%@ include file="/common/jsp/include/include_tld.jsp" %>

<% /* the authenticated user object stored in the Session */ %>
<c:set var="user" value="${sessionScope['com.vh.locker.USER']}" />

<% /* tells whether SSO is enabled or not */ %>
<c:set var="isSSOEnabled" value="${sessionScope['com.vh.locker.SSOENABLED']}" />

<% /* Z logo */ %>
<img style="border: 0px solid #666666;" src="/common/img/logo2.gif" alt="Z" onclick="bgFrame.location.href='/common/jsp/desktop.jsp'" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" />

<% /* Links in the header: Settings, Logout */ %>
<div class="header" style="position:absolute; top:0px; right:0px;">  
  <a href="/components/demos/index.html">Components</a>&nbsp;|&nbsp;
  <a href="/common/jsp/images.jsp">Images</a>&nbsp;|&nbsp;
  <a target="bgFrame" href="/common/ViewSettings.bg?c=content&c2=footer" title="<b:message bundle='resources' key='com.vh.label.Settings'/>"><b:message bundle="resources" key="com.vh.label.Settings"/></a>&nbsp;|&nbsp;
  <c:if test="${isSSOEnabled}">
    <a href="#" onclick="saveShortCuts(); top.location.href='/josso_logout/';" title="<b:message bundle='resources' key='com.vh.label.Logout'/>"><b:message bundle="resources" key="com.vh.label.Logout"/></a>
  </c:if>
  <c:if test="${!isSSOEnabled}">
    <a href="#" onclick="saveShortCuts(); top.location.href='/outside/Logout.do';" title="<b:message bundle='resources' key='com.vh.label.Logout'/>" /><b:message bundle="resources" key="com.vh.label.Logout"/></a>
  </c:if>
</div>

<% /* Yellow line */ %>
<div style="font-size:2px; position:absolute; top:38px; left:0px; width:87%; background-color:#E0E25C;">&nbsp;</div>

<% /* Welcome, Peter */ %>
<div class="header" style="position:absolute; top:30px; right:20px;">
  <b:message key="com.vh.label.Welcome"/>, <c:out value="${user.firstName}"/>
</div>
