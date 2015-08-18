<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Message</title>
  <%@ include file="/common/jsp/include/include_css.jsp"%>
  <%@ include file="/common/jsp/include/include_js.jsp"%>
</head>
<body>

  <form name="mailForm" target="bgFrame" action="" method="post">
	<table cellpadding="0" cellspacing="0" width="100%">  
		<input type="hidden" name="mailId" id="mailId" />
		<l:messagesPresent><tr><td colspan="2"><h:errors/></td></tr></l:messagesPresent>
		<tr><td class="field" width="100%" height="5" colspan="2">&nbsp;</td></tr>
		<tr><td class="itemin" width="18%">From&nbsp;&nbsp;&nbsp;</td><td class="field" width="82%" align="left" >&nbsp;&nbsp;Petek Pekgoz</td></tr>
		<tr><td class="itemin" width="18%">CC&nbsp;&nbsp;&nbsp;</td><td class="field" width="82%" align="left" >&nbsp;&nbsp;Peter Szocs</td></tr>
		<tr><td class="itemin" width="18%">BCC&nbsp;&nbsp;&nbsp;</td><td class="field" width="82%" align="left" >&nbsp;&nbsp;</td></tr>
		<tr><td class="itemin" width="18%">Subject&nbsp;&nbsp;&nbsp;</td><td class="field" width="82%" align="left" >&nbsp;&nbsp;BIDIK is here saying hi!</td></tr>
		<tr><td class="itemin" width="18%">Message&nbsp;&nbsp;&nbsp;</td><td class="field" width="82%" align="left" >&nbsp;&nbsp;<textarea class="fieldarea" style="width:300px;" readonly="readonly" validate="required" rows="10"/>xxxxxxxxxxx</textarea></td></tr>
	</table>
  </form>

</body>
</html>