<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/jsp/include/include_tld.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  
  <head>
    <meta http-equiv="content-type" content="text/html" />
	<title>Music</title>
	<%@ include file="/common/jsp/include/include_css.jsp"%>
	<%@ include file="/common/jsp/include/include_js.jsp"%>
  </head>
  
  <body>
  
  <table border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
		<td align="middle" valign="center">
			
			
			<% /*IE*/ %>
        	<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
        	width="275"
        	height="348"
        	codebase="http://java.sun.com/products/plugin/1.3/jinstall-13-win32.cab#Version=1,3,0,0"
			name="player">
              <param name="code"       value="javazoom.jlgui.player.amp.PlayerApplet" />
              <param name="archive"    value="<c:url value='/modules/music/jlgui/lib/jlguiapplet2.3.jar'/>,<c:url value='/modules/music/jlgui/lib/jlgui2.3-light.jar'/>,<c:url value='/modules/music/jlgui/lib/tritonus_share.jar'/>,<c:url value='/modules/music/jlgui/lib/basicplayer2.3.jar'/>,<c:url value='/modules/music/jlgui/lib/mp3spi1.9.1.jar'/>,<c:url value='/modules/music/jlgui/lib/jl0.4.jar'/>,<c:url value='/modules/music/jlgui/lib/vorbisspi1.0.jar'/>,<c:url value='/modules/music/jlgui/lib/jorbis-0.0.12.jar'/>,<c:url value='/modules/music/jlgui/lib/jogg-0.0.5.jar'/>,<c:url value='/modules/music/jlgui/lib/commons-logging-api.jar'/>" />
              <param name="type"       value="application/x-java-applet;version=1.3" />
              <param name="scriptable" value="true" />
              <param name="skin"       value="../jlgui/skins/wa021.wsz" />
              <param name="start"      value="yes" />
              <param name="song"       value="../../../<%=request.getParameter("playlist")%>" />
              <param name="init"       value="../../../<%=request.getParameter("init")%>" />
              <param name="location"   value="all" />
              <param name="useragent"  value="winampMPEG/2.7" />  
			  
			  
			<% /* Mozilla/Netscape */ %>
              <embed type="application/x-java-applet;version=1.3"
	   			name="player"
       			code="javazoom.jlgui.player.amp.PlayerApplet"	archive="<c:url value='/modules/music/jlgui/lib/jlguiapplet2.3.jar'/>,<c:url value='/modules/music/jlgui/lib/jlgui2.3-light.jar'/>,<c:url value='/modules/music/jlgui/lib/tritonus_share.jar'/>,<c:url value='/modules/music/jlgui/lib/basicplayer2.3.jar'/>,<c:url value='/modules/music/jlgui/lib/mp3spi1.9.1.jar'/>,<c:url value='/modules/music/jlgui/lib/jl0.4.jar'/>,<c:url value='/modules/music/jlgui/lib/vorbisspi1.0.jar'/>,<c:url value='/modules/music/jlgui/lib/jorbis-0.0.12.jar'/>,<c:url value='/modules/music/jlgui/lib/jogg-0.0.5.jar'/>,<c:url value='/modules/music/jlgui/lib/commons-logging-api.jar'/>"
       			width="275"
       			height="348"
       			skin="../jlgui/skins/wa021.wsz"
       			start="yes"
       			song="../../../<%=request.getParameter("playlist")%>"
       			init="../../../<%=request.getParameter("init")%>"
       			location="all"
       			useragent="winampMPEG/2.7"
       			scriptable="true"
       			pluginspage="http://java.sun.com/products/plugin/1.3/plugin-install.html"></embed>
            </object>

        </td>
	</tr>
  </table>

  </body>

</html>