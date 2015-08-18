/**
 * Utility methods for various desktop (canvas) actions.
 * 
 * @author peter.szocs
 * @since Nov 2005
 */
 
//if(navigator.userAgent.toLowerCase().indexOf('gecko') == -1) {...} //IE

/**
 * Adjusts the shortcuts' titles to be right under the shortcut icons.
 * Called from desktop.jsp.
 */
function adjustShortcutTitles() {
  var arr = getElementsByClass(document.body, 'dragme'); //shortcut divs
  if(arr.length > 0) { //are there any shortcuts?
	for(var i=0; i<arr.length; i++) {
      var textarea = arr[i].childNodes[1];
	  textarea.style.margin = '0px '+((SHORTCUT_DIV_WIDTH - textarea.offsetWidth)/2) + 'px';
    }
  }
}
/**
 * Adjusts the wallpaper's width and height to fit the clients resolution.
 * Called from desktop.jsp.
 */
function adjustWallpaperSize() {
  activeDivId = desktopDivId;
  try {
    document.getElementById('desktopbg').width  = document.body.offsetWidth;
    document.getElementById('desktopbg').height = document.body.offsetHeight;
    document.getElementById('desktopbg').style.display = '';
  } catch(e) {}
}
/**
 * Loads the requested application.
 * It hides the old app's div and shows the requested app's div.
 * Usage 1:  loadApp();  -- show desktop
 * Usage 2:  loadApp(1); -- load the app with id 1 [in appsArray]
 */
function loadApp(appId) {
  if(!appId) { //show desktop if no args
	if(activeDivId != desktopDivId) {
	  switchFooter(null); //switch taskbar to no active task
	  document.getElementById(activeDivId).style.display = 'none';   //hide old app
      document.getElementById(desktopDivId).style.display = 'block'; //show desktop div	
	  activeDivId = desktopDivId;
	}
  } else { //load regular app
	var appDivId = 'app_'+appId;
	if(appDivId != activeDivId) { //if user clicked on a non-active task in taskbar
      var target = document.getElementById(appDivId);
      switchFooter(appId); //switch taskbar to the new app
	  if(!target) { //new app, need to load it for the first time
	    target = document.createElement('DIV');
        target.className = 'appDiv';
	    target.id = appDivId;
        target.style.top = HEADER_HEIGHT + 'px';
        target.style.display = 'none';

        document.body.insertBefore(target, document.getElementById(desktopDivId)); //put new div into DOM
	    loadURLIntoContainer(appsArray[appId].targetUrl, appDivId); //load app into new div
	  }
	  document.getElementById(activeDivId).style.display = 'none'; //hide old app
	  target.style.display = ''; //show new app
      activeDivId = appDivId;
	}
  }
}
/**
 * Closes the application with id appId.
 * Removes the app's task from the taskbar.  The method DOES NOT remove the app's div, in case it needs to be opened again!
 * Usage 1:  closeApp();   -- close the activeDivId
 * Usage 2:  closeApp(1);  -- close the app with id 1 [in appsArray]
 */
function closeApp(appId) {
  if(!appId) appId = activeDivId.substr(activeDivId.search(/_/)+1);
  var taskBeanDivId = 'tb_'+appId;
  var taskBeanDiv = document.getElementById(taskBeanDivId);
  taskBeanDiv.parentNode.removeChild(taskBeanDiv);
  loadApp(); //show desktop
}
/**
 * Closes all opened apps.
 */
function closeAllOpenApps() {
  for(var i=0; i<appsArray.length; i++) {
    var taskBeanDivId = 'tb_'+i;
    var taskBeanDiv = document.getElementById(taskBeanDivId);
    if(taskBeanDiv) taskBeanDiv.parentNode.removeChild(taskBeanDiv);
  }
  loadApp(); //show desktop
}
/**
 * Switches the footer's active task from the current task to newAppId.
 */
function switchFooter(newAppId) {
  var oldAppId = activeDivId.substr(activeDivId.search(/_/)+1);
  var oldTaskBeanDiv = document.getElementById('tb_'+oldAppId);
  if(oldTaskBeanDiv) { 
	  oldTaskBeanDiv.className = 'footertaskinactive'; //unselect old app
  }
  if(newAppId) { //select new app
    var taskBeanDivId = 'tb_'+newAppId;
	var taskBeanDiv = document.getElementById(taskBeanDivId);
	if(taskBeanDiv) taskBeanDiv.className = 'footertaskactive'; //new task already in footer, switch className
	else {                                                      //new task not yet in footer, create new div
      var img = document.createElement('IMG');
        img.src = appsArray[newAppId].icon;
        img.border = '0';
		img.style.padding = '2px 8px 0px 8px';
		img.style.width = '14px';
		img.style.height = '14px';
	  var text = document.createTextNode(appsArray[newAppId].desc);
	  var li = document.createElement('LI');
        li.className = 'footertaskactive';
		li.id = taskBeanDivId;
		li.title = appsArray[newAppId].desc;
        li.oncontextmenu = function(e) { CONTEXTMENU.show('cmTaskBar', event); }
		li.onclick = function(e) { loadApp(newAppId); }
	  li.appendChild(img);
	  li.appendChild(text);

      document.getElementById(taskbarDivId).appendChild(li); //put new div into DOM
	}
  }
}
/**
 * Loads the lasso-ed application(s).
 */
function loadLassoedApps() {
  if(window.lassoObjects) {
	document.onclick(event); //hides the contextMenu
    for(var i=0; i<window.lassoObjects.length; i++) loadApp(window.lassoObjects[i].childNodes[3].value);
  }
}
/**
 * This method is called when shortcuts need to be lined up on the desktop (on the canvas).
 */
function lineUpShortCuts() {
  var arr = getElementsByClass2(document.getElementById(desktopDivId), 'dragme'); //shortcut array
  if(arr.length > 0) {
    var gridWidth  = SHORTCUT_DIV_WIDTH  + 1;
	var gridHeight = SHORTCUT_DIV_HEIGHT + 5;
    for(var i=0; i<arr.length; i++) {
      var left = CANVAS_LEFT_MARGIN + gridWidth*(Math.floor( arr[i].style.left.replace(/px/,'') / gridWidth )); //try to put shortcut at this left
	  var top = CANVAS_TOP_MARGIN + gridHeight*(Math.floor( arr[i].style.top.replace(/px/,'') / gridHeight ));  //try to put shortcut at this top
	  var shiftLeft = 0; //used iff need to shift to left because of another shortCut occupying space already
	  for(var j=0; j<i; j++) { //another shortcut already occupying (left;top) ?
        if((arr[j].style.left.replace(/px/,'') == left) && (arr[j].style.top.replace(/px/,'') == top)) { //yes, another shortcut already at (left;top)
          shiftLeft++;
		  left = CANVAS_LEFT_MARGIN + gridWidth*(shiftLeft + (Math.floor(arr[i].style.left.replace(/px/,'')/gridWidth)));
		  j=-1; //start over: maybe another shortcut is already at the shifted position?
		}
	  }
	  if(left > document.body.offsetWidth) {
        //alert('Shortcut outside canvas, putting it to the left...');
	    left = CANVAS_LEFT_MARGIN + gridWidth*(Math.floor( arr[i].style.left.replace(/px/,'') / gridWidth )); //try to put shortcut at this left
		shiftLeft = 0;
	    for(var j=0; j<i; j++) {
          if((arr[j].style.left.replace(/px/,'') == left) && (arr[j].style.top.replace(/px/,'') == top)) { //yes, another shortcut already at (left;top)
            shiftLeft--;
		    left = CANVAS_LEFT_MARGIN + gridWidth*(shiftLeft + (Math.floor(arr[i].style.left.replace(/px/,'')/gridWidth)));
		    j=-1; //start over: maybe another shortcut is already at the shifted position?
		  }
	    }
	  }
	  if(left < 0) {
        alert('Shortcut outside canvas, putting it to original position (WILL OVERLAP OTHER ICON)..');
	    left = CANVAS_LEFT_MARGIN + gridWidth*(Math.floor( arr[i].style.left.replace(/px/,'') / gridWidth ));
	  }
	  arr[i].style.left = left + 'px';
      arr[i].style.top = top + 'px';
    }
    isAutoSaveShortcuts = true;
  }
}
/**
 * Refresh the page.  Basically reloads the whole page as if the user pressed F5.
 */
function refreshPage() {
  top.location.href=WELCOME_FILE;
}
/**
 *
 * Rename shortcut methods.
 * 
 */
function shortcutTextareaOnKeyDown(e, textarea) {
  e = e || event;
  if(e) {
    if(e.keyCode==ENTER_KEY) {
      textarea.blur();
	} else if(e.keyCode==ESC_KEY) {
      textarea.value = document.shortcutOriginalText;
	  textarea.blur();
	} else {
      var len = textarea.value.length;
      if(len > SHORTCUT_TEXTAREA_MAX_LENGTH) textarea.value = textarea.value.substring(0, SHORTCUT_TEXTAREA_MAX_LENGTH);
      else if(len > 0) {
        if((e.keyCode==32) || (e.keyCode>47)) textarea.rows = Math.floor(len/SHORTCUT_TEXTAREA_MAX_COLS)+1;
        else textarea.rows = Math.floor((len-1)/SHORTCUT_TEXTAREA_MAX_COLS)+1;
        if(textarea.offsetHeight < textarea.scrollHeight) textarea.rows+=1;
	  }
      window.status = len + ' / ' + SHORTCUT_TEXTAREA_MAX_LENGTH;
    }
  }
  return false;
}
function shortcutTextareaOnKeyUp(textarea) {
  var len = textarea.value.length;
  if(len > SHORTCUT_TEXTAREA_MAX_LENGTH) textarea.value = textarea.value.substring(0, SHORTCUT_TEXTAREA_MAX_LENGTH);
  else if(len > 0) {
    textarea.rows = Math.floor((len-1)/SHORTCUT_TEXTAREA_MAX_COLS)+1;
	if(textarea.offsetHeight < textarea.scrollHeight) textarea.rows+=1;
  }
  window.status = len + ' / ' + SHORTCUT_TEXTAREA_MAX_LENGTH;
  return false;
}
function shortcutTextareaOnFocus(textarea) {
  if(window.lassoObjects) { //only right click->rename, or lasso icon & F2 is allowed: simple onfocus isn't!
	window.lassoEnabled=true;
    textarea.value = textarea.nextSibling.value;
    while(textarea.offsetHeight < textarea.scrollHeight) textarea.rows++; //increase rows until orig text fits
    document.onselectstart = new Function('return true');
    textarea.style.margin = '0px';
    textarea.className = 'shortcutRenameTextarea';
    textarea.select(); //select text in textarea
    textarea.cols=SHORTCUT_TEXTAREA_MAX_COLS;
	window.status = textarea.value.length + ' / ' + SHORTCUT_TEXTAREA_MAX_LENGTH;
    document.shortcutOriginalText = textarea.value;
    for(var i=0; i<window.lassoObjects.length; i++) window.lassoObjects[i].className = 'dragme';
    window.lassoObjects = null;
  } else { //textarea was clicked directly -> onfocus is disallowed so call blur()
    textarea.blur();
  }
  return false;
}
function shortcutTextareaOnBlur(textarea) {
  if(document.shortcutOriginalText!=textarea.value) isAutoSaveShortcuts = true;
  textarea.nextSibling.value = textarea.value;
  trimShortcutTextarea(textarea);
  textarea.value = textarea.value; //unselect text in textarea
  textarea.cols = (textarea.value.length+1 < SHORTCUT_TEXTAREA_MAX_COLS) ? textarea.value.length+1 : SHORTCUT_TEXTAREA_MAX_COLS;
  textarea.className = 'shortcutTextarea';
  textarea.style.margin = '0px '+((SHORTCUT_DIV_WIDTH - textarea.offsetWidth)/2) + 'px';
  window.status = 'Done';
  document.shortcutOriginalText = null;
  document.onselectstart = new Function('return false');
  return false;
}
/**
 * Trims the shortcuts title: appends '...' to the end if needed.
 */
function trimShortcutTextarea(textarea) {
  if((textarea.rows > 2) || (textarea.offsetHeight < textarea.scrollHeight)) {
	textarea.rows = 2;
    var origVal = textarea.value;
	var trimLen = SHORTCUT_TEXTAREA_MAX_DISPLAY_LENGTH;
	textarea.value = origVal.substring(0, trimLen) + '...';
	while(textarea.offsetHeight < textarea.scrollHeight) {
      trimLen--;
      textarea.value = origVal.substring(0, trimLen) + '...';
	}
  }
}
/**
 * This function is called when right click on shortcut --> rename.
 * It's also called when F2 is pressed on the desktop and there is at least one shortcut lasso-ed.
 * 
 * @param container    The shortCut that will be renamed.  Optional, can be left null,
 *                     in which case it figures out which shortcut to rename from lastEvent stored in JS.
 */
function renameShortcut(container) {
  if(!container) { //right click --> rename
	window.lassoEnabled=false;
    var container = getMouseXYFromJS()[2];
    var maxDepth = 1;
    //Ensure container contains the entire shortcut div, not the img or other child elements
    while((!container.className.match(/^dragme/i)) && (container.tagName != 'BODY') && (container.tagName != 'HTML') && (maxDepth != 0)) {
	  container = container.parentNode;
	  maxDepth--;
    }
  }
  container.childNodes[1].focus(); //textarea.focus()
}
/**
 *
 * EOF rename shortcut methods.
 * 
 */
/**
 * This method is used while creating a new shortCut.
 * It populates the shortcut name input field dynamically after a program is chosen from the dropdown list.
 */
function newShortCutDialogDropDownOnChange() {
  var box = document.getElementById('shortcutApp');
  var input = document.getElementById('shortcutName');
  if(box.selectedIndex>0) input.value=box.options[box.selectedIndex].text;
  else input.value='';
}
/**
 * This method is called to create a new shortcut on the canvas.
 * It's called from the new shortcut Dialog (onOK, after validation succeeds).
 */
function createShortCut() {
  var f = document.getElementById('shortcutForm'); //form
  var appId = f.elements[0].value;
  var desc = f.elements[1].value; //shortcut title
  
  var img = document.createElement('IMG');
    img.src = appsArray[appId].icon;
    img.className = 'shortcutImage';
  var ta = document.createElement('TEXTAREA');
    ta.value = desc;
    ta.setAttribute('wrap', 'virtual');
    ta.rows = 1;
	ta.cols = (desc.length + 1 < SHORTCUT_TEXTAREA_MAX_COLS) ? (desc.length + 1) : SHORTCUT_TEXTAREA_MAX_COLS;
	ta.className = 'shortcutTextarea';
	ta.onkeydown = function(e) { e=e || event; shortcutTextareaOnKeyDown(e, ta); }
    ta.onkeyup   = function(e) { shortcutTextareaOnKeyUp(ta); }
    ta.onfocus   = function(e) { shortcutTextareaOnFocus(ta); }
    ta.onblur    = function(e) { shortcutTextareaOnBlur(ta);  }
  var in_desc = document.createElement('INPUT');
    in_desc.type  = 'hidden';
	in_desc.value = desc;
  var in_appId = document.createElement('INPUT');
    in_appId.type  = 'hidden';
	in_appId.value = appId;
  var lastEvent = getMouseXYFromJS();
  var div = document.createElement('DIV');
    div.className = 'dragme';
	div.style.left = lastEvent[0] + 'px';
	div.style.top = lastEvent[1] - HEADER_HEIGHT + 'px';
	div.style.width = SHORTCUT_DIV_WIDTH + 'px';
	div.style.border = '1px solid red';
	div.title = desc;
	div.oncontextmenu = function(e) { e=e || event; setMouseXYIntoJS(e); putThisIntoLasso(div); CONTEXTMENU.show('cmShort', e); }
	div.ondblclick    = function(e) { loadApp(appId); }
  
  div.appendChild(img);
  div.appendChild(ta);
  div.appendChild(in_desc);
  div.appendChild(in_appId);

  document.getElementById(desktopDivId).appendChild(div);
  trimShortcutTextarea(ta);
  ta.style.margin = '0px '+((SHORTCUT_DIV_WIDTH - ta.offsetWidth)/2) + 'px'; //align shortcut title to the middle of img
  isAutoSaveShortcuts = true;
  
}
/**
 * Confirm lasso-ed objects deletion.
 */
function confirmLassoObjectsDelete() {
  if(window.lassoObjects) {
	if(window.lassoObjects.length > 1) Confirm('Are you sure you want to send these '+window.lassoObjects.length+' items to the Recycle Bin?', 'deleteLassoObjects()');
	else Confirm('Are you sure you want to send this item to the Recycle Bin?', 'deleteLassoObjects()');
  }
}
/**
 * Delete lasso-ed objects from DOM.
 */
function deleteLassoObjects() {
  if(window.lassoObjects) {
	for(var i=0; i<window.lassoObjects.length; i++) window.lassoObjects[i].parentNode.removeChild(window.lassoObjects[i]);
    window.lassoObjects = null;
    isAutoSaveShortcuts = true;
  }
}
/**
 * Puts the div into window.lassoObjects.
 */
function putThisIntoLasso(div) {
  if(div.className == 'dragme') div.className = 'dragmeOnMove';
  if(!window.lassoObjects) {
    window.lassoObjects = [];
    window.lassoObjects.push(div);
  } else {
	var isAlreadyInLasso = false;
    for(var i=0; i<window.lassoObjects.length; i++) {
      if(div == window.lassoObjects[i]) isAlreadyInLasso = true;
	}
	if(!isAlreadyInLasso) window.lassoObjects.push(div);
  }
}
/**
 * Populates the desktop props dialog with:
 *    - current wallpaper info
 *    - current skin info
 * NOTE: the *skin* MUST BE the last css imported in the head
 */
function populateDesktopPropsDialog() {
  //Highlight current skin in desktopProps Dialog's dropdown
  var currentSkin = document.styleSheets[ document.styleSheets.length-1 ].href; //get skin css
  currentSkin = currentSkin.substr(currentSkin.lastIndexOf('/')+1); //remove context and other prefixes
  var box = document.getElementById('desiredSkin'); //select the current skin in the dropdown of the Dialog
  var opts = box.options;
  var i = 0;
  while(i<opts.length) {
	if(opts[i].value == currentSkin) {
      box.selectedIndex = i;
	  i = opts.length;
	}
	i++;
  }

  //Highlight current wallpaper in desktopProps Dialog's dropdown
  server.userService.getWallpapers(cb); //json call to get all wallpapers a user has into the var allWallpapers
  function cb(allWallpapers, exception) { //json callback
    if(exception) alert(exception.message);
    else if(allWallpapers) {
	  allWallpapers.push('thailand3.jpg'); //add the default wallpaper option at the end
	  var currentWallpaper  = document.getElementById('desktopbg').src; //get hands on current wallpaper
      var wallpaperFilename = currentWallpaper.substr(currentWallpaper.lastIndexOf('/')+1); //remove context and other prefixes
	  box = document.getElementById('desiredWallpaper'); //select the current wallpaper in the dropdown of the Dialog
      opts = box.options;
	  for(var i=0; i<allWallpapers.length; i++) { //create wallpaper options AND highlight the current one
        opts[opts.length] = new Option(allWallpapers[i], allWallpapers[i]);
        if(wallpaperFilename == allWallpapers[i]) {
		  box.selectedIndex = i;
		  document.getElementById('desiredPreview').src = currentWallpaper;
		}
	  }
	}
  }
}
/**
 * This method is called to change the skin (css) and desktop wallpaper.
 * It's called from the desktopProps Dialog (onOK, after validation succeeds).
 */
function changeSkinAndWallpaper() {
  //Change skin
  var currentSkin = document.styleSheets[ document.styleSheets.length-1 ].href; //get current skin's css file location
  var head = document.getElementsByTagName('HEAD')[0]; //the head
  var j=-1; //will contain the index of the currentSkin in head's childNodes array
  for(var i=0; i<head.childNodes.length; i++) { //find current skin among head's childNodes
    if(head.childNodes[i].href==currentSkin) {
	  j=i;
	  i=head.childNodes.length;
	}
  }
  currentSkin = head.childNodes[j];
  var newSkin = currentSkin.cloneNode(true); //the desired skin we will change to
    newSkin.href = CONTEXT_PREFIX + 'common/css/skins/' + document.getElementById('desiredSkin').value;
  head.replaceChild( newSkin, currentSkin );

  //Change wallpaper
  document.getElementById('desktopbg').src = getPhotoFullPath( document.getElementById('desiredWallpaper').value );
  //var newWallpaper = currentWallpaper.cloneNode(true); //the desired wallpaper
  //newWallpaper.src = CONTEXT_PREFIX + 'home/' + USER_USERNAME + '/zdocs/photo/' + document.getElementById('desiredWallpaper').value;
  //alert(newWallpaper.outerHTML);
  //document.getElementById('desktopWallpaper').replaceChild( newWallpaper, currentWallpaper );
}
/**
 * This method is called to change the previw of the desktopProps dialog when a wallpaper is selected.
 */
function showWallpaperPreview() {
  document.getElementById('desiredPreview').src = getPhotoFullPath( document.getElementById('desiredWallpaper').value );
}
/**
 * This method is called when adding a new image to the wallpaper list through the Browse... button.
 */
function addWallpaper(input) {
  var fullPath = input.value;
  server.userService.uploadFile(cb, fullPath, 'photo'); //json call to upload new wallpaper into photos
  function cb(re, ex) { //json callback
    if(ex) alert(ex.message);
    else {
	  var i = fullPath.lastIndexOf('\\');
	  if(i<0) fullPath.lastIndexOf('/');
      var wallpaperFilename = fullPath.substr(i+1); //fetch filename from fullPath
	  var box = document.getElementById('desiredWallpaper'); //available wallpapers select box
      box.options[box.options.length] = new Option(wallpaperFilename, wallpaperFilename); //create new wallpaper option for select box
	  box.selectedIndex = box.options.length-1; //highlight the newly added wallpaper in the select box
	  showWallpaperPreview(); //preview the newly added wallpaper
	}
  }
}