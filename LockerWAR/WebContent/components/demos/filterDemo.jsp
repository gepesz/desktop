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
  <h4>Filter</h4>
  
       
  <p id="littleBrother">What happened?  Why isn't anyone paying attention to me?</p>
  <select id="bigDog" name="bigDog">
    <option value="0" width="30" style="border: 1px solid red;">0</option>
    <option value="1" width="30" style="border: 1px solid red;">1</option>
    <option value="2" width="30" style="border: 1px solid red;">2</option>
  </select>

  <p><input type="checkbox" onclick="if(this.checked) lilBroFilter.show(); else lilBroFilter.hide();" checked="true" />Filter On</p>

  <script type="text/javascript">
    var lilBroFilter = new Filter('bigDog');
  </script>  
   

</body>
</html>