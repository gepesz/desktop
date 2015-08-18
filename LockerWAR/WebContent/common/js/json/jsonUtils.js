/**
 * JSON utility methods.
 *
 * @author peter.szocs
 * @since Aug 2005
 */

/**
 * Initializes the jsonrpc global variable.
 * This method is called once: base_inside.jsp onload.
 */
function initJSON() {
  try {
    //JSONRpcClient.max_req_active = 5;
	if(!server) server = new JSONRpcClient(JSON_URL);
  } catch(e) {
    LOG.error(e.msg);
  }
}
/**
 * Saves shortcut locations (x;y) to the database at logout time.
 */
function saveShortCuts() {
  var arr = new Array();                                  //shortcut array
  var divs = getElementsByClass(document.body, 'dragme'); //shortcut divs
  //debugger;         //to analyze what's in divs[0]

  for(var i=0; i<divs.length; i++) {
	var s = { desc:  divs[i].childNodes[1].innerHTML,
	          icon:  divs[i].childNodes[0].src.substring(26),
              appId: divs[i].childNodes[3].value,
	          x:     divs[i].style.left.replace(/px/, ''),
	          y:     divs[i].style.top.replace(/px/, '') };
    arr.push(s);
  }

  server.userService.saveShortCuts(arr);
}
/**
 * Auto save functionality for desktop shortcuts.
 * It checks the global variable isAutoSaveShortcuts to see if indeed shortcuts should be saved into dbase.
 * Note: this function is called every 0:30 (min:sec)!
 */
function autoSaveShortcuts() {    
  if(isAutoSaveShortcuts) {
    saveShortCuts();
	isAutoSaveShortcuts = false;
    LOG.debug(' ***** SHORTCUTS AUTO-SAVED INTO DATABASE! ***** ');
    setWindowStatus('Shortcuts auto saved at '+new Date());
    setTimeout("setWindowStatus('Done')", 3000);
  }
  setTimeout("autoSaveShortcuts()", 10000);
}
autoSaveShortcuts();
