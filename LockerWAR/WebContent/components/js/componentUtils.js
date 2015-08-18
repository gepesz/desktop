/**
 * Puts the div into the middle of the screen.
 */
function centerDiv(container) {
  container.style.top  = (document.body.offsetHeight - container.offsetHeight) / 2 + 'px';
  container.style.left = (document.body.offsetWidth  - container.offsetWidth)  / 2 + 'px';
}
/**
 * Removes the given object and its filter (if present).
 * @param objectId:      name of the div to hide (eg: 'zuiAlert').  Optional, can be left null.
 * @param filter:        the window.someFilter object to call remove() on.  Optional, can be left null.
 */
function removeObject(objectId, filter) {
  if(objectId) {
	var object = document.getElementById(objectId);
    //if(object) object.parentNode.removeChild(object);
	if(object) object.style.display = 'none';
	window.dialog = null;
	if(objectId == PICKER.id) window.picker = null;
  }
  if(filter) {
    filter.DOM.parentNode.removeChild(filter.DOM);
	filter = null;
    window.filter = null;
  }
}
/**
 * Creates an 'OK' or a 'Cancel' button.
 * 
 * @return an input element of type button
 * @param buttonType:    'OK' or 'Cancel'
 * @param divToHide:     name of the div to hide.  Optional, can be left null.
 * @param filterToHide:  the window.someFilter object to call remove() on.  Optional, can be left null.
 * @param onClick:       the JS function to call onClick.  Optional, can be left null.
 */
function createButton(buttonType, divToHide, filterToHide, onClick) {
  var input = document.createElement('INPUT');
    input.type = 'button';
    input.className = 'zuiDialogButton';
    input.hideFocus = 'true';
    if(buttonType == 'OK') {
      input.value = LABEL_OK;
	  input.onclick = function(e) {
        if(onClick=='VASDialog') { //Validate And Submit Dialog.  Remove dialog IFF validation ok
		  var isValid = validateForm( document.forms[0], true );
		  //if(isValid) removeObject(divToHide, filterToHide);
	    } else { //AJAX Dialog.  Call onClick IFF validation ok
		  var isValid = validateForm( document.forms[0], false );
		  if(isValid) {
	        removeObject(divToHide, filterToHide);
            if(onClick) eval(onClick);
		  }
	    }
	  }
	} else {
      input.value = LABEL_CANCEL;
	  input.onclick = function(e) {
	    removeObject(divToHide, filterToHide);
        if(onClick) eval(onClick);
	  }
	}

  return input;
}
/**
 * Creates a dialog header (h1 element).
 * It returns the h1 element that is the header of Alert, Confirm and Dialog objects.
 *
 * @param title:         the title to be displayed in the header.  Optional, can be left null.
 * @param divToHide:     name of the div to hide.  Optional, can be left null.
 * @param filterToHide:  the window.someFilter object to call remove() on.  Optional, can be left null.
 */
function createHeader(title, divToHide, filterToHide) {
  var img = document.createElement('IMG');
    img.src = CLOSE_IMG;
    img.alt = LABEL_CLOSE;
  var a = document.createElement('A');
    a.onclick = function() { removeObject(divToHide, filterToHide); }
    a.appendChild(img);
  var span = document.createElement('SPAN');
    span.className = 'h1Controls';
    span.appendChild(a);
  var h1 = document.createElement('H1');
    if(title) h1.appendChild(document.createTextNode(title));
    h1.appendChild(span);
    h1.onmousedown = function(e) {
      e = e || event;
	  var container = document.getElementById(divToHide);
	  container.className = 'zuiDialogMove';
	  //alert('Clicked: '+e.clientX+','+e.clientY);
      //alert('Corner: '+container.style.left+','+container.style.top);
      
	  window.dragObject = container;
	  window.diffX = e.clientX - container.style.left.replace(/px/, '');
	  window.diffY = e.clientY - container.style.top.replace(/px/, '');
      window.maxX = document.body.offsetWidth - container.offsetWidth;
      window.maxY = document.body.offsetHeight - container.offsetHeight;
	}
    h1.onmousemove = function(e) {
	  if(!window.dragObject) return false;
      e = e || event;
	  if(e.button==1 || e.which==19) {
		var dialogX = e.clientX - window.diffX;
		var dialogY = e.clientY - window.diffY;
		dialogX = (dialogX < window.maxX) ? dialogX : window.maxX;
		dialogY = (dialogY < window.maxY) ? dialogY : window.maxY;
	    window.dragObject.style.left = dialogX + 'px';
	    window.dragObject.style.top = dialogY + 'px';	  
	    try { document.execCommand("Unselect"); } catch(e) {}
	  }
	}
    h1.onmouseup = function(e) {
      if(window.dragObject) {
		window.dragObject.className = 'zuiDialog';
        window.dragObject = null;
	  }
	}

  return h1;
}
