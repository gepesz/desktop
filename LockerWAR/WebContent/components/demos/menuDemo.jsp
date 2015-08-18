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
  <h4>Menu</h4>

  <div class="zuiDropDown" id="fileMenu">
    <ul>
      <li onclick="Alert('Open.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Open...</li>
      <li onclick="Alert('Close.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Close</li>
      <li onclick="Alert('Save.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Save</li>
      <li onclick="Alert('Save As.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Save As...</li>
	</ul>
  </div>
  <div class="zuiDropDown" id="viewMenu">
    <ul>
      <li onclick="Alert('Cut.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Cut</li>
      <li onclick="Alert('Copy.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Copy</li>
      <li onclick="Alert('Paste.')" onmouseover="this.className='hover'" onmouseout="this.className=''">Paste</li>
	</ul>
  </div>
   
  <p>Below is your toolbar...</p>
  <a style="z-index:25; position:relative;" onclick="MENU.show('fileMenu', this);">File</a>&nbsp;&nbsp;
  <a style="z-index:25; position:relative;" onclick="MENU.show('viewMenu', this);">View</a>&nbsp;&nbsp;
  <a style="z-index:25; position:relative;" onclick="MENU.show('fileMenu', this);">File</a>&nbsp;&nbsp;
   
</body>
</html>