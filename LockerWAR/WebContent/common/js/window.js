/**
 * Window object method overrides.
 * If a window.someMethod needs to be overriden, it should go into this file!
 * 
 * @author peter.szocs
 * @since Dec 2005
 */

/**
 * Global onerror overwrite.  This method is called every time a JS error
 * happens.  It's like a base action for all JS errors: it catches the error,
 * which we then log on the JBoss console using the JS Logger.
 * 
 * Source: http://msdn.microsoft.com/library/default.asp?url=/library/en-us/dnscrpt/html/WebErrors2.asp
 * TODO: window.caller itself can have caller!  (window.caller.caller, etc.)
 */
//window.onerror = sima;
function sima(msg, url, line) {
  //debugger;
  var s = '%0AA JS error occurred at: ' + url;
     s += '%0ALine number: ' + line;
	 s += '%0AError: ' + msg;
	 s += '%0ACaller: ' + window.onerror.caller;
  alert(s);

  LOG.error(s);
  return false;
}
/**
 * Enable/disable lasso creation.  It's a global variable to control lasso creation.
 */
window.lassoEnabled = true;
/**
 * Saves out the mouse xy and the container into a global var for later use.
 */
function setMouseXYIntoJS(e) {
  e = e || event;
  var container = e.srcElement ? e.srcElement : e.target;
  window.lastEvent = [e.clientX, e.clientY, container];
}
/**
 * Gets the event object from window.lastEvent;
 */
function getMouseXYFromJS() {
  return window.lastEvent;
}