/**
 * Outside JS methods.  This file uses JSON.
 *
 * @author peter.szocs
 * @since Sep 2005
 */

/**
 * Initializes the server global var.
 * This method is called once: base_outside.jsp onload.
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
 * Checks whether the specified userName is still available.
 * Basically either shows a not available or an available message 
 * under the field to the user within a <span class='formFieldError'>theMsg</span>.
 * Used from outside/signup.jsp.
 *
 * @param field the field that contains the userName.
 */
function checkUserNameAvailability(field) {
  var userName = field.value.trim();
  if(!userName) { // userName is empty, show required error
	showFieldError(field, 'Must be specified.');
  } else {        // userName not empty, check availability
    server.outsideService.checkUserName(cb, userName);
  }

  //callback function: called when checkUserName java call returns
  function cb(result, exception) {
	if(exception) { // exception occurred
      alert(exception);
	} else {        // normal flow
      if(result) {  // userName available
        showFieldError(field, '<div class="itemlogbig">'+userName+' is available.</div>');
      } else {      // userName not available
        showFieldError(field, '<i>'+userName+'</i> is not available.');
      }
	}
  }
}
/**
 * Validates the captcha.  Don't use it because (1) the captcha becomes invalid
 * after the first validate attempt and (2) if used the captcha remains the same
 * after each call so robots could take advantage of the same captcha!
 * Currently not used.
 *
function validateCaptcha(field) {
  var captchaResponse = field.value.trim();
  if(!captchaResponse) { // captchaResponse is empty, show required error
	showFieldError(field, 'Must be specified.');
  } else {              // captchaResponse not empty, validate it
    server.outsideService.validateCaptcha(cb, captchaResponse);
  }

  //callback function: called when validateCaptcha java call returns
  function cb(result, exception) {
	if(exception) { // exception occurred
      alert(exception);
	} else {        // normal flow
      if(result) {  // valid captchaResponse
        showFieldError(field, '<div class="itemlogbig">Valid captchaResponse!</div>');
      } else {      // invalid captchaResponse
        showFieldError(field, 'Invalid captchaResponse.');
      }
	}
  }
}
*/
/**
 * Focuses the blinking cursor on the username input field of the login page.
 */
function focusOnUserName() {
  try {
    document.getElementsByName('username')[0].focus();
  } catch(e) {}
}
/**
 * Changes the user's locale.
 */
function selectLocale(localeString) {
  top.frames[0].location.href = 
    '/outside/SelectLocale.do?lang=' + localeString;
}
/**
 * Displays/hides the background iframe.
 */
document.onkeyup = function(e) {
  e = e || event;
  if(e) {
    if(e.keyCode==F12_KEY) { //show bgFrame on F12
	  if(document.getElementById('bgFrame').style.display=="none") {
        document.getElementById('bgFrame').style.display="block";
      } else {
        document.getElementById('bgFrame').style.display="none";
      }      
    }
  }
}
