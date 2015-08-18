<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title><b:message bundle="resources" key="com.vh.title.jsp.prefix"/><b:message bundle="resources" key="com.vh.title.jsp.locale"/></title>
</head>
<body bgcolor="#002856" text="#FFFFFF" onload="top.document.title=document.title">

  <% /*  localeObject is the java.util.Locale object stored in the Session */ %>
  <c:set var="localeObject" value="${sessionScope['org.apache.struts.action.LOCALE']}" />

  <% /*  localeString is the String representation of the current locale, eg: 'en_US' or 'fr_FR' */ %>
  <c:set var="localeString" value="${localeObject.language}_${localeObject.country}" />

  <div style="position:absolute; top:50%; left:50%;
              width:400px; height:200px; margin-left:-200px; margin-top:-120px;
			  border: 3px solid #336699;">
    <form name="localeForm" action="/outside/SelectLocale.do" method="post">
		<input type="hidden" name="<%=com.vh.locker.util.Constants_Scope.REQUEST_TOKEN_KEY%>" 
							   id="<%=com.vh.locker.util.Constants_Scope.REQUEST_TOKEN_KEY%>"
							value="<%=com.vh.locker.base.TokenProcessor.saveToken(request)%>" />
		<p style="font-size:11pt; font-weight:bold; color:#9aadc7; font-family:Verdana; margin-left:10%; margin-right:10%; margin-top:20px;">Please select your preferred language:</p>

        <% /* FLAGS */ %>
		<table border="0px solid red" width="100%">
		<c:forEach items="${allLanguageColl}" var="lang">
		  <tr height="20px">
			<% /* check the radio box for the current locale */ %>
			<c:if test="${localeString == lang.loc}">
			  <td width="30%" align="right"><input type="radio" name="lang" value="<c:out value='${lang.loc}'/>" checked="checked" /></td>
			</c:if>
			<% /* uncheck the radio boxes for every other locale */ %>
			<c:if test="${localeString != lang.loc}">
			  <td width="30%" align="right"><input type="radio" name="lang" value="<c:out value='${lang.loc}'/>" /></td>
			</c:if>

			<td width="15%" align="center"><img border="0" src="<c:out value='/common/img/flags/${lang.loc}_flag.gif'/>" alt="<c:out value='${lang.displayName}'/>" /></td>
			<td style="font-size: 10pt; color: #9aadc7; font-family: Verdana" align="left"><c:out value="${lang.displayName}"/></td>
		  </tr>
		</c:forEach>
	    </table>

		<% /* OK button */ %>
		<input type="submit" value="OK"  style="font-family:verdana; font-size:13px; color:#9aadc7; background:#336699; border:1px none #a5a4a3; font-weight:bold; text-align:center; width:100px; margin-left:150px; margin-top:20px;" />
    </form>
  </div>

</body>
</html>
