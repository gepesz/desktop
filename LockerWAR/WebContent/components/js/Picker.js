/**
 * Picker Component
 *
 * The Picker is how objects get picked.  It's a popup with a grid 
 * on the left pane and the selected objects on the right pane.
 * 
 * @param type        The type of the picker ('songs', 'users', etc.).  Use the 
 *                    strings defined in js_constants.jsp, under 'Picker types'.
 * @param targetName  The id of the input field that will contain the picked name(s).
 * @param hiddenId    The id of the hidden input field that will contain the picked id(s).
 *
 * @return a Picker object
 */
function Picker(type, targetName, hiddenId) {
  this.id = PICKER.id;  // getElementById id of this DOM
  this.type = type;
  this.targetName = targetName;
  this.hiddenId = hiddenId;
  this.DOM = init();
  window.picker = this;

  function init() {
	window.filter = new Filter();  // create new filter at window.filter

	/* HEADER */
	var h1 = createHeader(LABEL_SELECT+TYPE_LOOKUP[type], id, window.filter);

	/* CONTENT */
	var div = document.createElement('DIV');
	  //div.innerHTML = getURLAsText('/components/jsp/pickerTemplate.jsp');
	  if(document.getElementById(hiddenId)) div.innerHTML = getURLAsText('/components/picker/PreparePicker.none?pt='+type+'&hi='+document.getElementById(hiddenId).value);
	  else div.innerHTML = getURLAsText('/components/picker/PreparePicker.none?pt='+type);
	  //alert( div.innerHTML );

	/* WRAPPER DIV */
	var container = document.createElement('DIV');
      container.className = 'zuiDialog';
      container.style.width  = 500 + 'px';
      container.style.height = 360 + 'px';
	  container.id = id;
	  container.onkeydown = function(e) {
        e = e || event;
        if(e.keyCode==ESC_KEY) {
		  removeObject(id, window.filter);
		}
      }
      container.appendChild(h1);
      container.appendChild(div);

	document.body.insertBefore(container, document.body.firstChild);
    centerDiv(container);
    
	return container;
  }
}
PICKER = {
  /**
   * The id under which getElementById finds the topmost picker.
   */
  id : 'zuiPicker',
  /**
   * Puts the highlighted items on the left box into the right select box.
   */
  pickItems : function() {
	var leftOpts  = document.getElementById('pickerAvailableBox').options;
	var rightOpts = document.getElementById('pickerSelectedBox').options;
    var pickedArray = new Array();
	for(i=0; i<leftOpts.length; i++) {
      if(leftOpts[i].selected) {
	    rightOpts[rightOpts.length] = new Option(leftOpts[i].text, leftOpts[i].value);  // move to the right
		pickedArray.push(i);
	  }
	}
	if(pickedArray.length>0) {	  
	  for(i=0; i<pickedArray.length; i++) {
        leftOpts[pickedArray[i]-i] = null;        // remove from left
	  }
	  var avalSize = document.getElementById('pickerAvailableSize').innerHTML;
      var selSize = document.getElementById('pickerSelectedSize').innerHTML;
	  document.getElementById('pickerAvailableSize').innerHTML = avalSize - pickedArray.length;
	  document.getElementById('pickerSelectedSize').innerHTML = selSize - (-pickedArray.length);
	}
  },
  /**
   * Removes the highlighted items from the right select box.
   */
  removeItems : function() {
	var leftOpts  = document.getElementById('pickerAvailableBox').options;
	var rightOpts = document.getElementById('pickerSelectedBox').options;
    var pickedArray = new Array();
	for(i=0; i<rightOpts.length; i++) {
      if(rightOpts[i].selected) {
	    leftOpts[leftOpts.length] = new Option(rightOpts[i].text, rightOpts[i].value);  // move to the left
		pickedArray.push(i);
	  }
	}
	if(pickedArray.length>0) {	  
	  for(i=0; i<pickedArray.length; i++) {
        rightOpts[pickedArray[i]-i] = null;        // remove from right
	  }
	  var avalSize = document.getElementById('pickerAvailableSize').innerHTML;
      var selSize = document.getElementById('pickerSelectedSize').innerHTML;
	  document.getElementById('pickerAvailableSize').innerHTML = avalSize - (-pickedArray.length);
	  document.getElementById('pickerSelectedSize').innerHTML = selSize - pickedArray.length;
	}
  },
  /**
   * This method is called only once when the picker is submitted.
   */
  submit : function() {
	var targetName = '';
	var hiddenId = '';
	var selOpts = document.getElementById('pickerSelectedBox').options;
	for(i=0; i<selOpts.length; i++) {
	  targetName += selOpts[i].text + ', ';
	  hiddenId += selOpts[i].value + ',';
    }
	targetName = targetName.substring(0, targetName.length-2); // cut last ', '
	hiddenId = hiddenId.substring(0, hiddenId.length-1);       // cut last ','
	var pickerTargetName = document.getElementById(window.picker.targetName);
	var pickerHiddenId = document.getElementById(window.picker.hiddenId);
    removeObject(PICKER.id, window.filter);  // remove the picker from the UI
	if(pickerTargetName) { // call onchange method (if any)
	  pickerTargetName.value = targetName;
	  try { pickerTargetName.onchange(); } catch(e) { }
	}
    if(pickerHiddenId) {   // call onchange method (if any)
	  pickerHiddenId.value = hiddenId;
	  try { pickerHiddenId.onchange(); } catch(e) { }
	}
  }
}