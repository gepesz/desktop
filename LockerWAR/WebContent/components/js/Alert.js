/**
 * Alert Component
 *
 * Same as window.alert but using Filter component and divs.
 *
 * @param text      The text to be displayed in the alert.
 * @param onOK      (optional) Javascript function to call when OK button is clicked.
 *                  Make sure that it is a String!
 * @return an Alert object
 */
function Alert(text, onOK) {

  var theAlert = document.getElementById('zuiAlert');
  if(theAlert) {
    alert(theAlert.outerHTML);
    document.getElementById('zuiAlertText').innerHTML = text;
    var ok = createButton('OK', 'zuiAlert', window.filter, onOK);
	
	theAlert.style.display = '';
  } else {

  this.id = 'zuiAlert';  // getElementById id of this DOM
  this.DOM = init();
  window.dialog = this;

  function init() {
	window.filter = new Filter();  // create new filter at window.filter
    var h1 = createHeader('Alert', id, window.filter);
	var p1 = document.createElement('P');
      p1.className = 'zuiAlertText';
      p1.id = 'zuiAlertText';
      p1.innerHTML = text;    
	var ok = createButton('OK', id, window.filter, onOK);
	var p2 = document.createElement('P');
      p2.className = 'center';
	  p2.appendChild(ok);
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
}