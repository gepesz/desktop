<!doctype html public "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="content-type" content="text/html" />
  <title>Adjust Time</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>  
</head>
<body>

	<table cellpadding="0" cellspacing="0" width="100%">  
		
		<tr>
			<td  class="itemin" width="50%">
			Date (Month/DD/YYYY):&nbsp;</td>
			<td class="field" width="50%" align="left" >&nbsp;
				<select name="month" class="fieldarea">
					<option class="fieldarea" value="0">January</option>
					<option class="fieldarea" value="1">February</option>
					<option class="fieldarea" value="2">March</option>
					<option class="fieldarea" value="3">April</option>
					<option class="fieldarea" value="4">May</option>
					<option class="fieldarea" value="5">June</option>
					<option class="fieldarea" value="6">July</option>
					<option class="fieldarea" value="7">August</option>
					<option class="fieldarea" value="8">September</option>
					<option class="fieldarea" value="9">October</option>
					<option class="fieldarea" value="10">November</option>
					<option class="fieldarea" value="11">December</option>
				</select>
				&nbsp;<input type="text" class="fieldarea" name="day" maxlength="2" style="width: 20px"/>
				&nbsp;<input type="text" class="fieldarea" name="year" maxlength="4" style="width: 40px"/>
			</td>
		</tr>
		<tr>	
				<td  class="itemin" width="50%">Time (Hour:Minute):</td>
			    <td class="field" width="50%" align="left" >
				&nbsp;&nbsp;<input type="text" class="fieldarea" name="hour" maxlength="2" style="width: 20px"/>&nbsp;:&nbsp;<input type="text" class="fieldarea" name="min" maxlength="2" style="width: 20px"/>
			</td>
		</tr>

	</table>

</body>
</html>