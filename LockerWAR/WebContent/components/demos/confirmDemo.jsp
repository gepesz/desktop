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
  <h4>Confirm</h4>
  
       
  <input type="button" value="Show Confirm" onclick="Confirm('Did we win this weekend?', 'win(\'hell!\')', 'lose(\'2nd division...\')');" />
  <script type="text/javascript">
    function win(loc) {
      Alert('All right, Barca can go to ' + loc);
    }

    function lose(loc) {
      Alert('Losing sucks.  Now we are going to go to ' + loc);
    }
  </script>
   

</body>
</html>