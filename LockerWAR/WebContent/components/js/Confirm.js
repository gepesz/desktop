/**
 * Confirm Component
 *
 * Same as window.confirm but using Filter component and divs.
 *
 * @param text      The text to confim.
 * @param onOK      (optional) Javascript function to call when OK button is clicked.
 *                  Make sure that it is a String!
 * @param onCancel  (optional) Javascript function to call when Cancel button is clicked.
 *                  Make sure that it is a String!
 * @return a Confirm object
 */
function Confirm(text, onOK, onCancel) {
  this.id = 'zuiConfirm';  // getElementById id of this DOM
  this.DOM = init();
  window.dialog = this;

  function init() {
	window.filter = new Filter();  // create new filter at window.filter
    var h1 = createHeader('Confirm', id, window.filter);
	var p1 = document.createElement('P');
      p1.className = 'zuiAlertText';
      p1.innerHTML = text;
	var ok = createButton('OK', id, window.filter, onOK);
	var cancel = createButton('Cancel', id, window.filter, onCancel);
	if(text.match(/\?$/)) {
      ok.value = LABEL_YES;
	  cancel.value = LABEL_NO;
	}
	var p2 = document.createElement('P');
      p2.className = 'center';
	  p2.appendChild(ok);
      p2.appendChild(cancel);
    var container = document.createElement('DIV');
      container.className = 'zuiDialog';
      container.id = id;
	  container.onkeydown = function(e) {
        e = e || event;
        if(e.keyCode==ESC_KEY) {
		  removeObject(id, window.filter);
		}
      }
	  container.style.display = 'block';
      container.appendChild(h1);
	  container.appendChild(p1);
      container.appendChild(p2);

	document.body.insertBefore(container, document.body.firstChild);
    centerDiv(container);
    
	return container;
  }
}