/**
 * Dialog Component
 *
 * A Dialog is like a popup div that simulates the look and feel of regular 
 * popup windows.  Dialogs are used to interact with the system (usually through forms).
 *
 * @param contentURL  The URL of the jsp/action that you want to display in the Dialog.
 *                    Note: Content must be within same WebContent and use full paths
 *                          starting with a '/' character.
 * @param inputArr    If the Dialog needs to be prepopulated, the values will be pulled
 *                    from this input array.  The input elements will be populated in the 
 *                    same exact order as the values are present in this array.  If present, 
 *                    it can be either a JS array OR a string, which corresponds to a JS
 *                    function.  Either the prepopulations happens from the array or the JS
 *                    function is called.  Optional, can be left null.
 * @param onOK        Javascript function to call when OK button is clicked.
 *                    Optional, can be left null.
 *
 * @return a Dialog object
 */
function Dialog(contentURL, inputArr, onOK) {
  this.id = 'zuiDialog';  // getElementById id of this DOM
  this.DOM = init();
  window.dialog = this;

  function init() {
	window.filter = new Filter();  // create new filter at window.filter
    
	/* CONTENT */
	var title = null;
	var div = document.createElement('DIV');
	  div.id = 'zuiDialogContent';
	  if(contentURL) {
		var content = getURLAsText(contentURL);
		title = content.substring( content.indexOf('<title>')+7, content.indexOf('</title>') );
		div.innerHTML = content;
		if(inputArr) {
		  if(inputArr.constructor == Array) {
		    var inputs = div.getElementsByTagName('INPUT');
		    if(inputs) {
			  var len = (inputs.length < inputArr.length) ? inputs.length : inputArr.length;
			  for(var i=0; i<len; i++) {
                inputs[i].value = inputArr[i];
			  }
		    }
		  }
		}
	  }

	/* HEADER */
	var h1 = createHeader(title, id, window.filter);
    
	/* BUTTONS */
	var cancel = createButton('Cancel', id, window.filter);
	if(onOK) var ok = createButton('OK', id, window.filter, onOK);    //AJAX Dialog
	else var ok = createButton('OK', id, window.filter, 'VASDialog'); //Validate And Submit Dialog
	var p = document.createElement('P');
      p.className = 'centerLine';
      p.appendChild(cancel);
	  p.appendChild(ok);

	/* WRAPPER DIV */
	var container = document.createElement('DIV');
      container.className = 'zuiDialog';
      container.id = id;
	  container.onkeydown = function(e) {
        e = e || event;
        if(e.keyCode==ESC_KEY) {
		  removeObject(id, window.filter);
		}
      }
      container.appendChild(h1);
      container.appendChild(div);
      container.appendChild(p);
 
	document.body.insertBefore(container, document.body.firstChild);
    centerDiv(container);
    if(inputArr) {
      if(inputArr.constructor != Array) eval(inputArr);
	}
	
	return container;
  }
}