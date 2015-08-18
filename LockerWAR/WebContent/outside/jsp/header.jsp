
<%@ include file="/common/jsp/include/include_tld.jsp" %>

<% /*  localeObject is the java.util.Locale object stored in the Session */ %>
<c:set var="localeObject" value="${sessionScope['org.apache.struts.action.LOCALE']}" />

<% /*  localeString is the String representation of the current locale, eg: 'en_US' or 'fr_FR' */ %>
<c:set var="localeString" value="${localeObject.language}_${localeObject.country}" />

<% /*  langs is a Collection of all the supported languages */ %>
<c:set var="langs" value="${applicationScope['com.vh.locker.ALLLANGS']}" />


<% /* OUTSIDE LOGO: AMSTERDAM PHOTO */ %>
<img id="outsideLogo" src="/outside/img/amsterdam.jpg" width="100%" height="139" style="display:block" />

<% /* CHANGE LANGUAGE DROPDOWN */ %>
<div style="float:right; padding-top:3px; padding-right:10px;">
  <b:message key="com.vh.label.Language" bundle="resources" />:
  <select onchange="selectLocale(this.options[this.selectedIndex].value);">
	<c:forEach items="${langs}" var="lang">
      <c:if test="${localeString == lang.loc}">
        <option value="<c:out value='${lang.loc}'/>" selected="true"><c:out value="${lang.displayLanguage}"/></option>
      </c:if>
      <c:if test="${localeString != lang.loc}">
        <option value="<c:out value='${lang.loc}'/>"><c:out value="${lang.displayLanguage}"/></option>
      </c:if>
	</c:forEach>
  </select>
  <img src="<c:out value='/common/img/flags/${localeString}_flag.gif'/>" border="0" alt="<c:out value='${localeObject.displayName}'/>"/>
</div>

<% /* HEADER MENU ITEMS: HOME, SCREENSHOTS, ABOUT US */ %>
<div class="header">
  <a href="#" onclick="loadURLIntoContainer('/outside/jsp/login.jsp','content')"><b:message bundle="resources" key="com.vh.label.Home"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#" onclick="loadURLIntoContainer('/outside/jsp/screenshots.jsp','content')"><b:message bundle="resources" key="com.vh.label.Screenshots"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#" onclick="loadURLIntoContainer('/outside/jsp/users.jsp','content')"><b:message bundle="resources" key="com.vh.label.Users"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#" onclick="loadURLIntoContainer('/outside/jsp/about.jsp','content')"><b:message bundle="resources" key="com.vh.label.About_Us"/></a>
</div>
