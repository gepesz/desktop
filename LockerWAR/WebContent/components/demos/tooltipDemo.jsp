<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title></title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%> 
  <script language="javascript" src="<c:url value='/components/js/Tooltip.js'/>"></script>
  <script language="javascript" src="<c:url value='/components/js/Tooltip2.js'/>"></script>
	
<style type="text/css">

#dhtmltooltip{
position: absolute;
left: -300px;
width: 150px;
border: 1px solid black;
padding: 2px;
background-color: lightyellow;
visibility: hidden;
z-index: 100;
/*Remove below line to remove shadow. Below line should always appear last within this CSS*/
filter: progid:DXImageTransform.Microsoft.Shadow(color=gray,direction=135);
}

#dhtmlpointer{
position:absolute;
left: -300px;
z-index: 101;
visibility: hidden;
}

</style>

</head>
<body>
  <h3>UNDER CONSTRUCTION -- NOT IN include_js.jsp YET!</h3>
  <h4>Tooltip</h4>

   
  <p>Dymanic drive demo</p>
  Hover over me: <input id="tooltipTarget" onmouseover="ddrivetip('JavaScriptKit.com JavaScript tutorials', 600)" onmouseout="hideddrivetip()" />  
  
  <p>STATIC demo</p>
  Hover over me: <input id="tooltipTarget" onmouseover="TOOLTIP.show('helloooooo')" onmouseout="TOOLTIP.hide()" />    
   

</body>
</html>