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
  <h4>Picker</h4>
  
       
  <p>Select Albums: <input type="text" name="albumNames" readonly="readonly" onclick="Picker(TYPE_ALBUM, 'albumNames', 'albumIds');" size="50" /></p>

  <p>Ids: <input type="text" name="albumIds" size="50" onchange="Alert('value changed!!')" /></p>
   

</body>
</html>