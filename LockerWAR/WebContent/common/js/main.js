/**
 * This is like an 'etc' file for JS methods: any method that
 * doesn't really fit anywhere else should go into here.
 *
 * Every simple JS method on its own should go into this file!
 * 
 * @author peter.szocs
 * @since Dec 2003
 */

/**
 * Sets the next action to be called by dispatch action.
 */
function setNextAction(target) {
  document.gridForm.nextAction.value=target;
}
/**
 * Calls delete confirmation or gives alert, based on how whether anything is selected on the grid.
 */
function confirmDelete(type) {
  if(getSelectedRowCount()==0) { 
	Alert('Please select at least one item to delete.');
  } else {
	var d=document.getElementById('nextActionTD').innerHTML;
	d=d.replace(/setNextAction\(\'[a-z]{0,12}\'\)/gi,"setNextAction('"+type+"')");
	document.getElementById('nextActionTD').innerHTML=d;
	Confirm('Are you sure you would like to delete selected items?', 'Alert(\'Delete Me!!!\')');
	return false; 
  }
}
/**
 * Start menu show/hide.
 */
function showStartMenu() {
  var startMenu = document.getElementById('startMenu');
  startMenu.style.display='block';
  document.getElementById('progList').style.display='none';
  shiftOpacity('startList', 250);
  document.getElementById('startList').style.display='block';
  document.hideObject = startMenu;
  document.clickCounter = -1; //hide start menu on next click
}
/**
 * Hides the default footer.
 * It also increases the canvas because it sets the FOOTER_HEIGHT to 0.
 */
function hideFooter() {
  document.getElementById('hiddenFooter').style.display='block';
  document.getElementById('defaultFooter').style.display='none';
  document.getElementById(footerDivId).className = 'hiddenFooter';
  FOOTER_HEIGHT = 0; //increase canvas area
}
/**
 * Shows the default footer with the taskbar.
 */
function showFooter() {
  FOOTER_HEIGHT = DEFAULT_FOOTER_HEIGHT;
  document.getElementById(footerDivId).className = 'defaultFooter';
  document.getElementById('hiddenFooter').style.display='none';
  document.getElementById('defaultFooter').style.display='block';
}
/**
 * Clock.
 */
function calcTime(clockDiv) {
  var currenttime = new Date();
  var hours = currenttime.getHours();
  var minutes = currenttime.getMinutes();
  var seconds = currenttime.getSeconds();
  var timesuffix = "AM";
	
  if(hours > 11) {
    timesuffix = "PM";
    hours = hours - 12;
  }
  if(hours == 0) hours = 12;
  else if(hours < 10) hours = "0" + hours;
  if(minutes < 10) minutes = "0" + minutes;
  if(seconds < 10) seconds = "0" + seconds;

  document.getElementById(clockDiv).innerHTML = hours + ":" + minutes + " " + timesuffix;
  setTimeout("calcTime('"+clockDiv+"')", 2000);
}
/**
 * Sets the window.status to the incoming message.
 * It's added here as a fx so that it can be called from a setTimeout() function.
 */
function setWindowStatus(msg) {
  window.status = msg;
}
