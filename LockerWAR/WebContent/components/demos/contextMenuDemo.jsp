<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title></title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>
  <h4>ContextMenu</h4>

  <div class="zuiDropDown" id="cmTofu">
    <ul>
      <li onclick="Alert('The tofu lies in two halves!')" onmouseover="this.className='hover'" onmouseout="this.className=''">Slice Tofu</li>
	  <li><div class="divider"></div></li>
      <li onclick="Alert('It is delicious.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Eat Tofu</li>
      <li onclick="Alert('Tofu refrigerated.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Refrigerate Tofu</li>
      <li onclick="Alert('Congrats on your new tofu.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Adopt Tofu</li>
	</ul>
  </div>
  <div class="zuiDropDown" id="cmNew">
    <ul>
      <li onclick="Alert('Cut.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Cut</li>
      <li onclick="Alert('Copy.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Copy</li>
      <li onclick="Alert('Paste.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Paste</li>
	</ul>
  </div>
   
  Right click on this image to see the context menu...&nbsp;
  <img style="z-index:22; position:absolute;" src="<c:url value='/components/img/filter.gif'/>" oncontextmenu="CONTEXTMENU.show('cmTofu', event);" />

  <img style="z-index:22; position:absolute;" src="<c:url value='/components/img/filter.gif'/>" oncontextmenu="CONTEXTMENU.show('cmNew', event);" />

  <img style="z-index:22; position:absolute; right:0px;" src="<c:url value='/components/img/filter.gif'/>" oncontextmenu="CONTEXTMENU.show('cmNew', event);" />

  <img style="z-index:22; position:absolute; bottom:0px; right:0px;" src="<c:url value='/components/img/filter.gif'/>" oncontextmenu="CONTEXTMENU.show('cmNew', event);" />

<% /*  
MOZILLA NEEDS THE CODE ON THE JSP TO WORK!!!
IT CANNOT CALL *ANY* FUNCTIONS ONCONTEXTMENU WHICH IS IN A SEPARATE FILE!!!
*/ %>

<% /*  
<script>
CONTEXTMENU = {
  show : function(id, event) {
    if(document.hideObject) {
      document.hideObject.style.display = 'none';
	  document.hideObject = null;
	}
	var DOM = document.getElementById(id);
    DOM.style.left = event.clientX + 'px';
    DOM.style.top  = event.clientY + 'px';
	DOM.style.display = 'block';
	document.hideObject = DOM;
	document.clickCounter = 0; //hide context menu on next click
  }
}
</script>
*/ %>

</body>
</html>