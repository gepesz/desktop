/**
 * Document object method overrides.
 * If a document.someMethod needs to be overriden, it should go into this file!
 * 
 * @author peter.szocs
 * @since Sep 2005
 */

/**
 * Displays/hides iframe, default IE contextMenu.
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
    if(e.keyCode==F9_KEY) {  //show default IE context menu on F9
	  if(document.oncontextmenu=="function(e) {return false;}") document.oncontextmenu = function(e) {return true;};
	  else document.oncontextmenu = function(e) {return false;};
	}
  }
}
/**
 * Ctrl key events.
 */
document.onkeydown = function(e) {
  e = e || event;
  if(e) {
    // ctrl-a
	if(e.ctrlKey && e.keyCode == 65) {
	  if(activeDivId == desktopDivId) {
	    window.lassoObjects = getElementsByClass2(document.getElementById(desktopDivId), 'dragme'); //selected lassoable objects
	    for(var i=0; i<window.lassoObjects.length; i++) window.lassoObjects[i].className = 'dragmeOnMove';
	  }
	  return false;
	}
    // ctrl-c
    if(e.ctrlKey && e.keyCode == 67) {
	  alert('ctrl-c');
	}
    // ctrl-v
    if(e.ctrlKey && e.keyCode == 86) {
	  alert('ctrl-v');
	}
    // ctrl-x
    if(e.ctrlKey && e.keyCode == 88) {
	  alert('ctrl-x');
	}
    // delete
	if(e.keyCode == DELETE_KEY) {
      confirmLassoObjectsDelete();
	}
    // F2
	if(e.keyCode == F2_KEY) {
	  if((activeDivId == desktopDivId) && (window.lassoObjects)) {
        renameShortcut( window.lassoObjects[0] );
	  }
	}

  }
}
/**
 * The document.clickCounter object is used to hide objects on the next onclick anywhere on the page.
 * This is how the clickFilter is implemented.
 */
document.onclick = function(e) {
  e = e || event;
  if(e) {
	document.clickCounter++;
	//LOG.debug('isAutoSaveShortcuts='+isAutoSaveShortcuts);
    if(document.hideObject && document.clickCounter) {
	  //alert( document.hideObject.outerHTML );
	  document.hideObject.style.display = 'none';
	  if(document.hideObject == document.getElementById('startMenu')) { //fade out start menu
        //shiftOpacity('startList', 250);
		document.fadeObjectStyle = document.getElementById('startList').style;
        changeOpac(0);
	  }
	  document.hideObject = null;
	}
  }
}
/**
 * Drag and drop functionality for any element with className="dragme".
 * Lasso functionality for desktop.
 */
document.onmousedown = function(e) {
  
  //return false;

  e = e || event;
  var container = e.srcElement ? e.srcElement : e.target;
  if(container.onclick) container.onclick(e); //force container.onclick() --> it's not called when click was made on an object on canvas (desktop), so we call manually
  document.onclick(e); //force document.onclick() --> it's not called when click made on canvas (desktop), so we call manually
  var maxDepth = 1;
  //alert(container.outerHTML);
  while((!container.className.match(/^dragme/i)) && (container.tagName != 'BODY') && (container.tagName != 'HTML') && (maxDepth != 0)) {
	container = container.parentNode;
	maxDepth--;
  }
  //alert(container.outerHTML);
  //Normal dragging: dragging icons without any lasso stuff
  if(container.className == 'dragme') {
	//Clear previously lasso-ed (selected) objects if any
    if(window.lassoObjects && (!window.dialog)) {
	  for(var i=0; i<window.lassoObjects.length; i++) window.lassoObjects[i].className = 'dragme';
      window.lassoObjects = null;
	}
    //Start normal dragging
	container.className = 'dragmeOnMove';
	window.dragObject = container;
	window.firstX = e.clientX;
	window.firstY = e.clientY;
	window.diffX = e.clientX - window.dragObject.style.left.replace(/px/, '');
	window.diffY = e.clientY - window.dragObject.style.top.replace(/px/, '');
	window.maxX = document.body.offsetWidth - container.offsetWidth;
    window.maxY = document.body.offsetHeight - container.offsetHeight - HEADER_HEIGHT - FOOTER_HEIGHT;
  //Dragging lassoed icons: need to drag EVERY lasso-ed item
  } else if(container.className == 'dragmeOnMove') {
	window.dragObject = container;
	window.firstX = e.clientX;
	window.firstY = e.clientY;
	window.diffX = e.clientX - window.dragObject.style.left.replace(/px/, '');
	window.diffY = e.clientY - window.dragObject.style.top.replace(/px/, '');
	window.maxX = document.body.offsetWidth - container.offsetWidth;
    window.maxY = document.body.offsetHeight - 2*container.offsetHeight - FOOTER_HEIGHT;
  //Create lasso
  } else if((activeDivId == desktopDivId) && (window.lassoEnabled) && (!window.dialog) && (e.clientY > HEADER_HEIGHT) && (e.clientY < document.body.offsetHeight - FOOTER_HEIGHT)) {
	//Clear previously lasso-ed (selected) objects if any
    if(window.lassoObjects) {
	  for(var i=0; i<window.lassoObjects.length; i++) window.lassoObjects[i].className = 'dragme';
      window.lassoObjects = null;
	}
    //Create new lasso DIV
	window.diffX = e.clientX; //first click X
	window.diffY = e.clientY; //first click Y
	window.maxY = document.body.offsetHeight - FOOTER_HEIGHT - 1; //max Y coord for lasso bottom=footer's top - 1
    window.lasso = document.createElement('DIV');
	  window.lasso.className = 'lassoOnCreate';
	  window.lasso.style.left = window.diffX + 'px';
	  window.lasso.style.top = window.diffY + 'px';
	document.body.insertBefore(window.lasso, document.body.firstChild);
    window.lassoObjects = getElementsByClass2(document.getElementById(desktopDivId), 'dragme'); //lassoable objects
    for(var i=0; i<window.lassoObjects.length; i++) {
      window.lassoObjects[i] = 
	[window.lassoObjects[i].style.left.replace(/px/,'') - (-window.lassoObjects[i].offsetWidth / 2),  
     window.lassoObjects[i].style.top.replace(/px/,'') - (-window.lassoObjects[i].offsetHeight / 2) + HEADER_HEIGHT,
	 window.lassoObjects[i]];
    }
  }
  return false;
}
document.onmousemove = function(e) {
  e = e || event;
  if(window.dragObject) {
	var dialogX = (e.clientX - window.diffX > 0) ? e.clientX - window.diffX : 0;
	var dialogY = (e.clientY - window.diffY > 0) ? e.clientY - window.diffY : 0;
	dialogX = (dialogX < window.maxX) ? dialogX : window.maxX;
	dialogY = (dialogY < window.maxY) ? dialogY : window.maxY;
	window.dragObject.style.left = dialogX + 'px';
	window.dragObject.style.top = dialogY + 'px';
    //window.status = dialogY + '|' + window.dragObject.offsetHeight + '|' + window.maxY + '|' + document.body.offsetHeight;
  } else if(window.lasso) {
	var dialogX = e.clientX - window.diffX; //width of the lasso
	if(e.clientY < HEADER_HEIGHT) var dialogY = HEADER_HEIGHT - window.diffY; //top of lasso over header
	else if(e.clientY > window.maxY) var dialogY = window.maxY - window.diffY; //bottom of lasso over footer
	else var dialogY = e.clientY - window.diffY; //not touching header or footer
	if(dialogX<0) { //going left: X coords
	  window.lasso.style.left = dialogX + window.diffX + 'px';
      dialogX = -dialogX;
	} else { //going right: X coords
      window.lasso.style.left = window.diffX + 'px';
	}
	if(dialogY<0) { //going up: Y coords
	  window.lasso.style.top = dialogY + window.diffY + 'px';
      dialogY = -dialogY;
	} else { //going down: Y coords 
	  window.lasso.style.top = window.diffY + 'px';
	}
	window.lasso.style.width = dialogX + 'px';
    window.lasso.style.height = dialogY + 'px';
	window.lassoLeft = window.lasso.style.left.replace(/px/, '') - 0;
    window.lassoTop = window.lasso.style.top.replace(/px/, '') - 0;

    /*
	for(var i=0; i<window.lassoObjects.length; i++) { //lassoable objects
      if((window.lassoLeft <= window.lassoObjects[i][0]) && (window.lassoLeft+dialogX >= window.lassoObjects[i][0]))
	    if((window.lassoTop <= window.lassoObjects[i][1]) && (window.lassoTop+dialogY >= window.lassoObjects[i][1])) window.lassoObjects[i][2].className = 'dragmeOnMove';
	    else window.lassoObjects[i][2].className = 'dragme';
      else window.lassoObjects[i][2].className = 'dragme';
	}
	*/
	window.status = dialogX+' x '+dialogY;
    //window.status = 'Top:'+window.lassoLeft+','+window.lassoTop+' | Bottom: '+(window.lassoLeft+dialogX)+','+(window.lassoTop+dialogY)+' | Width: '+dialogX+' | Height: '+dialogY;
  }
  return false;
}
document.onmouseup = function(e) {
  e = e || event;
  if(window.dragObject) { //dragging finished, need to update classNames
	if((e.clientX != window.firstX) || (e.clientY != window.firstY)) { //was there any dragging at all?	  
	  if(window.lassoObjects) { //Dragging all lassoed objects
	    for(var i=0; i<window.lassoObjects.length; i++) {
          if((e.clientX - window.diffX) != window.lassoObjects[i].style.left.replace(/px/, '')) { //don't reposition the lasso handler item, but reposition the others
		    window.lassoObjects[i].style.left = window.lassoObjects[i].style.left.replace(/px/, '') - (window.firstX - e.clientX) + 'px'; //item dragged within canvas: X coord
		    if(window.lassoObjects[i].style.left.replace(/px/, '') < 0) window.lassoObjects[i].style.left = 0 + 'px'; //item dragged too much out to the left
		    else if(window.lassoObjects[i].style.left.replace(/px/, '') > window.maxX) window.lassoObjects[i].style.left = window.maxX + 'px'; //item dragged out too much to the right

		    window.lassoObjects[i].style.top = window.lassoObjects[i].style.top.replace(/px/, '') - (window.firstY - e.clientY) + 'px'; //item dragged within canvas: Y coord
		    if(window.lassoObjects[i].style.top.replace(/px/, '') < 0) window.lassoObjects[i].style.top = 0 + 'px'; //item dragged too much out to the top
		    else if(window.lassoObjects[i].style.top.replace(/px/, '') > window.maxY) window.lassoObjects[i].style.top = window.maxY + 'px'; //item dragged out too much to the bottom
		  }
	    }
	  } else { //normal one item dragging finished
	    window.dragObject.className = 'dragme';
	  }
      isAutoSaveShortcuts = true; //since there was dragging, need to save out shortcuts into database
	}
    window.dragObject = null;
  } else if((window.lasso) && (window.lassoObjects)) { //remove lasso, keep selected items with different className

	//put lasso-ed objects into window.lassoObjects: NEW WAY
	window.lassoLeft = true; //contains whether need to clear selected objects
	window.lassoTop = []; //will contain lasso-ed objects
	for(var i=0; i<window.lassoObjects.length; i++) { //lassoable objects
      if((window.lasso.offsetLeft <= window.lassoObjects[i][0]) && 
		 (window.lasso.offsetLeft+window.lasso.offsetWidth >= window.lassoObjects[i][0]) &&
	     (window.lasso.offsetTop <= window.lassoObjects[i][1]) && 
		 (window.lasso.offsetTop+window.lasso.offsetHeight >= window.lassoObjects[i][1])) {
	    window.lassoObjects[i][2].className = 'dragmeOnMove';
		window.lassoTop.push(window.lassoObjects[i][2]);
	    window.lassoLeft = false;
	  }
	}
	if(window.lassoTop.length > 0) window.lassoObjects = window.lassoTop;
	else window.lassoObjects = null;
	
	//remove ALL lasso-s: there can be more than one div on the page b/c of problem around edges
    window.lasso = getElementsByClass2(document.body, 'lassoOnCreate'); //the lassos
    for(var i=0; i<window.lasso.length; i++) window.lasso[i].parentNode.removeChild(window.lasso[i]);
	window.lasso = null;

    /*
	//put lasso-ed objects into window.lassoObjects: OLD WAY
	window.lassoLeft = true; //contains whether need to clear selected objects
	window.lassoTop = []; //will contain lasso-ed objects
	for(var i=0; i<window.lassoObjects.length; i++) { //lassoable objects
	  if(window.lassoObjects[i][2].className == 'dragmeOnMove') {                                            
		window.lassoTop.push(window.lassoObjects[i][2]);
	    window.lassoLeft = false;
	  }
	}
	if(window.lassoTop.length > 0) window.lassoObjects = window.lassoTop;
	else window.lassoObjects = null;
	*/

	//clear previously lasso-ed (selected) objects on next click
	if(window.lassoLeft) {
      window.lassoTop = getElementsByClass2(document.body, 'dragmeOnMove'); //selected lassoable objs
	  for(var i=0; i<window.lassoTop.length; i++) window.lassoTop[i].className = 'dragme';
	}
	window.lassoLeft = null;
	window.lassoTop = null;
	window.status = 'Done';
  }
}
/**
 * Disable right click on entire site.
 */
document.oncontextmenu = function(e) {return false;}
/**
 * Disable mouse highlighting (selecting text with mouse) on entire site.
 */
document.onselectstart = function(e) { return false; }
