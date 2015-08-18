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
  <h4>Logger</h4>
  <table>
    <tr><td>Available log levels:</td></tr>
    <tr><td>DEBUG - 0</td></tr>
    <tr><td>INFO  - 1</td></tr>
    <tr><td>WARN  - 2</td></tr>
    <tr><td>ERROR - 3</td></tr>
    <tr><td>FATAL - 4</td></tr>
    <tr><td>NONE  - 5</td></tr>
  </table>
  <p>Current log level: <script>document.write(LOG_LEVEL);</script></p>

       
  Hello world! <input type="button" value="Debug" onclick="LOG.debug('Hello world!');" />
  <br /><br />

  What time is it? <input type="button" value="Info" onclick="LOG.info('What time is it?');" />
  <br /><br />

  Let me tell you how to do this.<input type="button" value="Warn" onclick="LOG.warn('Let me tell you how to do this.');" />
  <br /><br />

  I want to eat tofu.<input type="button" value="Error" onclick="LOG.error('I want to eat tofu.');" />
  <br /><br />
   

</body>
</html>