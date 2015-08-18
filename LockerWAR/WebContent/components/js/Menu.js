/**
 * Menu Component
 *
 * A Menu is a little menu that pops up on click of a toolbar item such as File, View, etc.
 *
 * @param id          The id of the div whose contents will be displayed onclick.
 * @param srcElement  The source element under which the menu will be displayed.
 */
MENU = {
  /**
   * Private method.
   * Simply puts the (top;left) corner of the menu div under the scrElement,
   * and displays the div with 'block' style.
   */
  displayDiv : function(id, srcElement) {
	var DOM = document.getElementById(id);
	DOM.style.left = srcElement.offsetLeft + 'px';
    DOM.style.top  = srcElement.offsetTop + 15 + 'px';
	DOM.style.display = 'block';
	document.hideObject = DOM;
	document.clickCounter = -1; //the current click will be immediately added, hence the -1 value
  },
  /** 
   * The id is the id of the div on the jsp that will be displayed to the user.
   * The srcElement is the element that was clicked to trigger the Menu.
   */
  show : function(id, srcElement) {
    if(document.hideObject) {
      document.hideObject.style.display = 'none';
	  if(document.hideObject.id != id) MENU.displayDiv(id, srcElement);
	  else document.hideObject = null;
	} else MENU.displayDiv(id, srcElement);
  }
}