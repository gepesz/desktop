<%@ include file="/common/jsp/include/include_tld.jsp" %>
<%@ include file="/common/jsp/startbutton.jsp" %>

<div id="hiddenFooter" style="display:none; float:right;">
  <input id="footerhidebutton1" class="footerhidebutton" type="button" value="<" onclick="showFooter()" />
</div>

<div id="defaultFooter">
  <% /* START BUTTON, SHOW DESKTOP BUTTON, TASKBAR.  NOTE: EVERYTHING HERE IS FLOAT:LEFT !! */ %>
  <a onclick="showStartMenu()" class="defaultFooterText" onmousedown="document.onmousedown = function(e) {return false;}" onmouseup="document.onmousedown = function(e) {defaultOnMouseDown(e);}"><img alt="Start" src="/common/img/starthere_small.gif" border="0" style="margin: 0px 5px; padding:2px 0px 0px 0px" />Start</a>
  <span class="footerdivider">|</span>
  <img src="/common/img/desktop_small.gif" alt="Show Desktop" onclick="loadApp();" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='default'" border="0" style="float:left; padding:2px 0px 0px 0px;" />
  <span class="footerdivider">|</span>
  <ul id="taskbar" style="float:left"></ul>

  <% /* CLOCK, HIDE TASKBAR BUTTON: > */ %>  
  <div style="float:right">
    <span  id="digitalclock"      class="clock" oncontextmenu="CONTEXTMENU.show('cmClock', event);"></span>
    <input id="footerhidebutton2" class="footerhidebutton" type="button" value=">"  onclick="hideFooter()" />
  </div>
</div>

<% /* ADJUSTING THE HEIGHT OF THE FOOTER HIDE BUTTONS: THE > AND < BUTTONS... */ %>
<script>
  document.getElementById('footerhidebutton1').style.height = FOOTER_HEIGHT + 'px';
  document.getElementById('footerhidebutton2').style.height = FOOTER_HEIGHT + 'px';
</script>
