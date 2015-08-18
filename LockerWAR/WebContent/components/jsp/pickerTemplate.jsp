<%@ include file="/common/jsp/include/include_tld.jsp" %>

<c:set var="avalCollSize"><z:size collection="avalColl" scope="request"/></c:set>
<c:set var="selCollSize"><z:size collection="selColl" scope="request"/></c:set>

<% /* main picker area */ %>
<div style="">
<%--  <h2 style="background-color:#333399; width:100%; color:#ffffff; font-size:14px;">Select Albums</h2> --%>
  
  <% /* search box */ %>
  <div style="position:absolute; top:35px; left:10px;">
    <form name="pickerForm" action="<c:url value='/components/picker/PickerSearch.none'/>" method="post">
	  <input type="hidden" name="pickerType" value="<c:out value='${pickerForm.pickerType}'/>" />
	  <input type="text" name="searchString" size="25" />&nbsp;&nbsp;&nbsp;&nbsp;
	  <input type="image" src="<c:url value='/components/img/forward.gif'/>" alt="Search" />
	</form>
  </div>

  <% /* left box */ %>
  <div style="position:absolute; top:80px; left:10px; height:200px;">
	Available items:&nbsp;<span id="pickerAvailableSize"><c:out value="${avalCollSize}"/></span>
	<select id="pickerAvailableBox" multiple="multiple" style="width:210px; height:200px;">
	  <c:forEach items="${avalColl}" var="item">
		<option value="<c:out value='${item.id}'/>"><c:out value="${item.displayName}"/></option>
	  </c:forEach>
	</select>
  </div>

  <% /* arrows */ %>
  <div style="position:absolute; top:150px; left:231px;">
    <img src="<c:url value='/components/img/forward.gif'/>" alt="Add" onclick="PICKER.pickItems()" onmouseover="this.style.cursor='hand'" />
    <img src="<c:url value='/components/img/back.gif'/>" alt="Remove" onclick="PICKER.removeItems()" onmouseover="this.style.cursor='hand'" />
  </div>

  <% /* right box */ %>
  <div style="position:absolute; top:80px; left:263px; height:200px;">
    Selected items:&nbsp;<span id="pickerSelectedSize"><c:out value="${selCollSize}"/></span>
	<select id="pickerSelectedBox" multiple="multiple" style="width:210px; height:200px;">
	  <c:forEach items="${selColl}" var="item">
		<option value="<c:out value='${item.id}'/>"><c:out value="${item.displayName}"/></option>
	  </c:forEach>
	</select>
  </div>
</div>

<% /* buttons */ %>
<div style="position:absolute; top:300px; left:80px;">
  <input type="button" class="zuiDialogButton" hidefocus="true" value="<b:message key='com.vh.label.OK' bundle='resources'/>"  onclick="PICKER.submit()" />
  <input type="button" class="zuiDialogButton" hidefocus="true" value="<b:message key='com.vh.label.Cancel' bundle='resources'/>"  onclick="removeObject(PICKER.id, window.filter)" />
</div>
