<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
    <title><b:message bundle="resources" key="com.vh.title.jsp.settings"/></title>
  </head>
  <body>

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="16">
		<td class="titlebar">&nbsp;<img border="0" width="16" height="16" src="/common/img/settings.gif" alt="<b:message bundle='resources' key='com.vh.label.Settings'/>" /></td>
		<td class="titlebar" align="left" valign="middle" width="100">&nbsp;<b:message bundle="resources" key="com.vh.title.jsp.settings"/></td>
		<td class="titlebar" width="900">&nbsp;</td>
	  </tr>
	</table>

	<div id="profile">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="500px">
	    <td class="navmain" width="20%" valign="top">
		  <table id="settingsnav" width="100%" cellpadding="0" cellspacing="0">
			<tr height="30px"><td>&nbsp;</td></tr>
			<tr height="120px"><td class="navborder">&nbsp;</td></tr>
			<tr height="30px">
				<td class="naveach" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;&nbsp;&nbsp;&nbsp;Profile&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr height="30px">
				<td class="navborder" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;<a onclick="document.getElementById('account').style.display='block'; document.getElementById('profile').style.display='none';" title="Account">&nbsp;&nbsp;&nbsp;Account&nbsp;&nbsp;&nbsp;</a></td>
			</tr>
			<tr height="30px">
				<td class="navborder" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;<a onclick="document.getElementById('style').style.display='block'; document.getElementById('profile').style.display='none';" title="Style">&nbsp;&nbsp;&nbsp;Style&nbsp;&nbsp;&nbsp;</a></td>
			</tr>
			<tr height="178px"><td class="navborder">&nbsp;</td></tr>
		  </table>
		</td>
		<td width="80%">
		  <span class="navarea">
			<form name="signupForm" action="/common/SaveSettings.do" method="post">		
			<div id="Profile" style="top:50px; width:100%; overflow:hidden; position:absolute;">
			<table width="100%" cellspacing="0" cellpadding="0" class="navarea">
			<tr height="10px"><td>&nbsp;</td></tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.First_Name"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="firstname" style="width: 300px" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Middle_Initial"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="middleinit" style="width: 20px" maxlength="1" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Last_Name"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="lastname" style="width: 300px" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Gender"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;
					<input type="radio" name="gender" class="setitemtext" value="Male">&nbsp;
					<input type="radio" name="gender" class="setitemtext" value="Female">
				</td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Birth_Date"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;
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
					<select name="day" class="fieldarea">
					 <% /* <c:forEach var="i" begin="1" end="31" step="1">  					
							<c:if test="${bday==i}">
							  <option value="<c:out value='${i}'/>" selected="selected"><c:out value="${i}"/></option>
							</c:if>
							<c:if test="${bday!=i}">
							  <option value="<c:out value='${i}'/>"><c:out value="${i}"/></option>
							</c:if>
						</c:forEach> */ %>
					</select>				
					<input type="text" class="fieldarea" name="year" maxlength="4" style="width: 40px"/>
				</td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Address_Line_1"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="address1" style="width: 300px" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Address_Line_2"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="address2" style="width: 300px" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.City"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="city" style="width: 300px" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.State"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="state" style="width: 30px" maxlength="2" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Zip"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="zip" style="width: 50px" maxlength="5" /></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Country"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;
					<select name="country" class="fieldarea" style="width: 300px">
						<option value="-1"></option>
					</select>
				</td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Language"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;
					<select name="language" class="fieldarea" style="width: 300px">
						<option value="-1"></option>
					</select>		
				</td>
			</tr>
			<tr height="25px">
				<td class="navbutton" width="500" height="30" colspan="2">&nbsp;</td>
			</tr>
			<tr height="25px">
				<td class="navbutton" width="500" height="30">&nbsp;</td>
				<td class="navbutton" width="300" height="30" align="center" valign="middle">
					<input type="button" class="button" value="Submit" onclick="">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="button" value="Cancel" onclick="">
				</td>
			</tr>
			<tr height="10px"><td>&nbsp;</td></tr>	
			</table>
			</div>
			</form>
		  </span>
		</td>
	  </tr>
	</table>

	</div>

	<div id="account" style="display:none;">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="500px">
	    <td class="navmain" width="20%" valign="top">
		  <table id="settingsnav" width="100%" cellpadding="0" cellspacing="0">
			<tr height="80px"><td>&nbsp;</td></tr>
			<tr height="70px"><td class="navborder">&nbsp;</td></tr>
			<tr height="30px">
				<td class="navborder" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;<a onclick="document.getElementById('profile').style.display='block'; document.getElementById('account').style.display='none';" title="Profile">&nbsp;&nbsp;&nbsp;Profile&nbsp;&nbsp;&nbsp;</a></td>
			</tr>
			<tr height="30px">
				<td class="naveach" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;&nbsp;&nbsp;&nbsp;Account&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr height="30px">
				<td class="navborder" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;<a  onclick="document.getElementById('style').style.display='block'; document.getElementById('account').style.display='none';" title="Style">&nbsp;&nbsp;&nbsp;Style&nbsp;&nbsp;&nbsp;</a></td>
			</tr>
			<tr height="78px"><td class="navborder">&nbsp;</td></tr>
		  </table>
		</td>
		<td width="80%">
		  <span class="navarea">
			<form name="signupForm" action="/common/SaveSettings.do" method="post">
			<div id="Account" style="top:100px; width:100%; overflow:hidden; position:absolute;">
			<table width="100%" cellspacing="0" cellpadding="0" class="navarea">
			<tr height="10px"><td>&nbsp;</td></tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Username"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="username" style="width: 300px"/></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Password"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="password" style="width: 300px"/></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Retype_Password"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="repassword" style="width: 300px"/></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Security_Question"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;
					<select name="question" class="fieldarea" style="width: 300px">
						<option value="-1"></option>
					</select>				
				</td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Email"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="email" style="width: 300px"/></td>
			</tr>
			<tr height="25px">
				<td class="setitem"  width="30%"><b:message bundle="resources" key="com.vh.label.Phone"/>&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;&nbsp;<input type="text" class="fieldarea" name="phone" style="width: 300px"/></td>
			</tr>
			<tr height="25px">
				<td class="navbutton" width="500" height="30" colspan="2">&nbsp;</td>
			</tr>
			<tr height="25px">
				<td class="navbutton" width="500" height="30">&nbsp;</td>
				<td class="navbutton" width="300" height="30" align="center" valign="middle">
					<input type="button" class="button" value="Submit" onclick="">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="button" value="Cancel" onclick="">
				</td>
			</tr>
			<tr height="10px"><td>&nbsp;</td></tr>	
			</table>
			</div>
			</form>
		  </span>
		</td>
	  </tr>
	</table>

	</div>

	<div id="style" style="display:none;">

	<table width="100%" cellspacing="0" cellpadding="0">
	  <tr height="500px">
	    <td class="navmain" width="20%" valign="top">
		  <table id="settingsnav" width="100%" cellpadding="0" cellspacing="0">
			<tr height="151px"><td>&nbsp;</td></tr>
			<tr height="30px">
				<td class="navmain" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;<a onclick="document.getElementById('profile').style.display='block'; document.getElementById('style').style.display='none';" title="Profile">&nbsp;&nbsp;&nbsp;Profile&nbsp;&nbsp;&nbsp;</a></td>
			</tr>
			<tr height="30px">
				<td class="navborder" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;<a onclick="document.getElementById('account').style.display='block'; document.getElementById('style').style.display='none';" title="Account">&nbsp;&nbsp;&nbsp;Account&nbsp;&nbsp;&nbsp;</a></td>
			</tr>
			<tr height="30px">
				<td class="naveach" valign="middle">&nbsp;&nbsp;<img border="0" src="/common/img/dots_3x5_small.gif" />&nbsp;&nbsp;&nbsp;&nbsp;Style&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr height="54px"><td class="navborder">&nbsp;</td></tr>
		  </table>
		</td>
		<td width="80%">
		  <span class="navarea">
			<form name="signupForm" action="/common/SaveSettings.do" method="post">
			<div id="Style" style="top:201px; width:100%; overflow:hidden; position:absolute;">
			<table width="100%" cellspacing="0" cellpadding="0" class="navarea">
			<tr height="10px"><td>&nbsp;</td></tr>
			<tr height="25px">
				<td class="setitem"  width="30%">Color Schema&nbsp;&nbsp;</td>
				<td class="setfield" width="70%">&nbsp;
					<select name="language" class="fieldarea" style="width: 300px">
						<option value="0">blue</option>
						<option value="1">green</option>
						<option value="2">grey</option>
						<option value="3">purple</option>
						<option value="4">red</option>
						<option value="5">yellow</option>
					</select>
				</td>
			</tr>
			<tr height="25px">
				<td class="navbutton" width="500" height="30" colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td class="navbutton" width="500" height="30">&nbsp;</td>
				<td class="navbutton" width="300" height="30" align="center" valign="middle">
					<input type="button" class="button" value="Submit" onclick="">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="button" value="Cancel" onclick="">
				</td>
			</tr>
			<tr height="10px"><td>&nbsp;</td></tr>	
			</table>
			</div>
			</form>
		  </span>
		</td>
	  </tr>
	</table>

	</div>

  </body>
</html>
