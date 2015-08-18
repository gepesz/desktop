<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Desktop Properties</title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>
</head>
<body>

  <c:set var="skins" value="${applicationScope['com.vh.locker.ALLSKINS']}" />

  <form name="desktopForm">
  <div style="width:100%; height:300px;">
    <p style="margin:10px">1) Configure your preferences</p>
	<div style="float:left; margin:10px;">
		 <p>Wallpaper:</p>
		 <select name="desiredWallpaper" class="fieldarea" validate="required" size="3" style="width:200px; height:150px;" onchange="showWallpaperPreview();"></select>
         <input type="file" class="fieldarea" onchange="addWallpaper(this);" />
	</div>

	<div style="float:right; margin:10px;">
		 <p>Skin:</p>
		 <select name="desiredSkin" class="fieldarea" validate="required" >
           <c:forEach var="s" items="${skins}">
             <option value="<c:out value='${s.fileName}'/>"><c:out value="${s.name}"/></option>
           </c:forEach>
		 </select>
	</div>

	<div style="float:left; margin:10px 47px;">
        <p>2) Preview your settings</p>
		<img id="desiredPreview" src="" width="200px" height="100px" border="1px solid gray" />
	</div>

  </div>
  </form>

</body>
</html>