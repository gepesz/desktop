
<%@ include file="/common/jsp/include/include_tld.jsp" %>

<% /* the com.vh.locker.bean.TaskBarBean object stored in the Session */ %>
<c:set var="tbb" value="${sessionScope['com.vh.locker.TBB']}" />

	<c:forEach var="task" items="${tbb.tasks}" varStatus="s">
	<b:define id="task" name="task" type="com.vh.locker.bean.TaskBean"/>

		<% /* active task */ %>					  	  			  
		<c:if test="${s.index==tbb.activePos}">
		  <div class="footertaskactive" oncontextmenu="CONTEXTMENU.show('cmTaskBar', event);"><a target="bgFrame" title="<c:out value='${task.alt}'/>">&nbsp;<img border="0" width="16" height="16" src="<c:url value='${task.image}'/>" />&nbsp;<c:out value="${task.name}"/>&nbsp;</a></div>
		</c:if>
	  
		<% /* inactive tasks */ %>
		<c:if test="${s.index!=tbb.activePos}">	
		  <div class="footertaskinactive" oncontextmenu="CONTEXTMENU.show('cmTaskBar', event);"><a target="bgFrame" href="<c:url value='${task.link}'/>" title="<c:out value='${task.alt}'/>">&nbsp;<img border="0" width="16" height="16" src="<c:url value='${task.image}'/>" />&nbsp;<c:out value="${task.name}"/>&nbsp;</a></div>
		</c:if>
							
	</c:forEach>			  
