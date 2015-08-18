/**
 * This file should contain all js methods needed by bg.jsp.
 *
 * @author peter.szocs
 * @since Sep 2005
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
 * Swaps content of the bgFrame into the container specified by targetId.
 *
 * @param sourceId the id of the source container on the bgFrame
 * @param targetId the id of the target container on the main window
 */
function swapContent(sourceId, targetId) {
  var target = window.parent.document.getElementById(targetId);
  var source = target.cloneNode(true);
  source.innerHTML = sourceId ? document.getElementById(sourceId).innerHTML : document.body.innerHTML;
  top.document.title = document.title;
  target.parentNode.replaceChild(source, target);
}

// figure out whether ToggleAll checkbox should be checked too
function checkToggleAll() {
  var frm = document.gridForm;
  var TV=TW=0;

  // TV=how many checkboxes on the form
  // TW=how many CHECKED checkboxes on the form
  for(var i=0;i<frm.elements.length;i++) {
	var v = frm.elements[i];
	if((v.name != 'toggleAll') && (v.type=='checkbox')) {
	  TV++;
	  if(v.checked) TW++;
	}
  }
  if(frm.toggleAll) {
	if((TW==TV) && (document.getElementById('theRows').rows.length>0)) frm.toggleAll.checked=true;
	else frm.toggleAll.checked=false;
  }
}

// colors one table row (change tr class to "trhighlight")
function colorRow(V) {
  while(V.tagName!="TR") V=V.parentNode;
  V.className = "trhighlight";
}

// uncolors one table row (change tr class from "trhighlight" to "trodd" or "treven")
function clearRow(V, odd) {
  while(V.tagName!="TR") V=V.parentNode;
  if(odd) V.className = "trodd";
  else V.className = "treven";
}

// color rows that were checked.  This function is called after column sort to recolor rows.
function altRows() {
  var frm = document.gridForm;
  //var frm = document.getElementById('grid');	
  if(frm) {
	for(var i=0;i<frm.elements.length;i++) {
		var v = frm.elements[i];
		if((v.name!='toggleAll') && (v.type=='checkbox')) {
			if(v.checked) colorRow(v);
			else clearRow(v, i%2);
		}
	}
	checkToggleAll();
  } else {
	//alert('altRows: cannot find document.gridForm');
  }
}