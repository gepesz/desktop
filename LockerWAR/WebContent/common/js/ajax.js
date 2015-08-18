/**
 * AJAX methods reside here.
 * 
 * @author peter.szocs
 * @since Jan 2006
 */
  
/**
 * Prepends the context path at the beginning of the url and returns the prepended string.
 */
function rewriteURL(url) {
  return CONTEXT_PREFIX + url.substr(1,url.length-1);
}
/**
 * Gets the request URL as string.  Returns the responseText of the response (String).
 */
function getURLAsText(url) {
  //url = rewriteURL(url);
  if(window.XMLHttpRequest) var req = new XMLHttpRequest();
  else var req = new ActiveXObject("Microsoft.XMLHTTP");
  req.open("GET", url, false);
  req.send(null);
  return req.responseText;
}
/**
 * Loads the requested urls and puts them into the given containers.
 * Usage 1:  loadURLIntoContainer('/common/action.do','div');
 * Usage 2:  loadURLIntoContainer(['/common/action1.do','/common/action2.do'] ,['div1','div2']);
 */
function loadURLIntoContainer(urls, containers) {
  if(urls.constructor != Array) {
    urls = [urls];
	containers = [containers];
  }
  for(var i=0; i<urls.length; i++) {
    try {
      //document.getElementById(containers[i]).style.display = 'none';
      document.getElementById(containers[i]).innerHTML = getURLAsText(urls[i]);
      //shiftOpacity(containers[i], 250);
      //document.getElementById(containers[i]).style.display = 'block';      
	  LOG.debug('Successfully loaded page "'+urls[i]+'" into container "'+containers[i]+'"');
    } catch(e) {
      LOG.error('An exception occurred while loading page "'+urls[i]+'" into container "'+containers[i]+'": '+e.message);
	  alert('An exception occurred while loading page "'+urls[i]+'" into container "'+containers[i]+'":\n'+e.message);
	  debugger;
	}
  }
}
