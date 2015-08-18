/**
 * ContextMenu Component
 *
 * A ContextMenu is a little menu that pops up on right click of an object.
 * It's a context specific menu.
 *
 * @param id      The id of the object that will be displayed onRightClick.
 * @param event   The event that triggered this ContextMenu.
 */
CONTEXTMENU = {
  show : function(id, event) {
	if(document.hideObject) {
      document.hideObject.style.display = 'none';
	  document.hideObject = null;
	}
	var DOM = document.getElementById(id);
	DOM.style.display = 'block'; //need to show before positioning: DOM.offsetWidth is empty otherwise!
	var left = event.clientX;
	var top = event.clientY;
	if(left+DOM.offsetWidth>document.body.offsetWidth) DOM.style.left = left - DOM.offsetWidth  + 'px';
	else DOM.style.left = left + 'px';
	if((top < HEADER_HEIGHT) || (top > document.body.offsetHeight-FOOTER_HEIGHT)) { //click on header or footer
      if(top+DOM.offsetHeight>document.body.offsetHeight) DOM.style.top = top - DOM.offsetHeight + 'px';
      else DOM.style.top = top + 'px';
    } else { //click on canvas area
      if(top+DOM.offsetHeight>document.body.offsetHeight-FOOTER_HEIGHT) DOM.style.top = top - HEADER_HEIGHT - DOM.offsetHeight + 'px';
      else DOM.style.top = top - HEADER_HEIGHT + 'px';
    }	
	document.hideObject = DOM;
	document.clickCounter = 0; //hide context menu on next click
  }
}