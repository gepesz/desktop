/**
 * Utility methods for accessing various elements on the grids and on the DOM.
 * 
 * @author peter.szocs
 * @since Sep 2005
 */
  
/**
 * Returns the number of rows checked on the grid.
 */
function getSelectedRowCount() {
  return getSelectedRows().length;
}
/**
 * Returns an Array of the selected ids.
 *
 * @return: an array of ids
 */
function getSelectedRows() {
  var selIds=new Array();
  var frm=document.gridForm;
  for(var i=0; i<frm.elements.length; i++) {
    var v = frm.elements[i];
    if((v.name!='toggleAll') && (v.type=='checkbox') && (v.checked)) {
	  selIds[selIds.length]=v.value; 
    }
  }
  return selIds;
}
/**
 * Returns a string from the grid.
 *
 * @param rowId:     the id of the checkbox (row) from which to retrieve the data from
 * @param colIndex:  the column index to extract the data from (0th col=checkboxes)
 * @return:          String the requested data
 */
function getGridData(rowId, colIndex) {
  var result='';
  var found=false;
  var frm=document.gridForm;
  for(var i=0;i<frm.elements.length;i++) {
    var v = frm.elements[i];
    if((v.name!='toggleAll') && (v.type=='checkbox') && (v.value==rowId)) {
      found=true;
	  break;
    }
  }
  if(found) {
	while(v.tagName!="TR") v=v.parentNode;	
	if(colIndex<v.childNodes.length) {
	  result=v.childNodes[colIndex].innerHTML;
//	  alert(result.trim());
	} else {
//	  alert('This grid has '+v.childNodes.length+' columns.  Attempt for column '+colIndex+' failed because this column index is out of bounds.');
	}
  } else {
//    alert('Row with id '+rowId+' cannot be found on the grid.');
  }
  return result;
}
/**
 * Retrieves the object's closest parent container with the given className.
 *
 * @param object:      the object whose parents we want to traverse.  Required.
 * @param className:   the className that we are looking for in one of the parents.  Required.
 * @param maxDepth:    the maximum depth at which to look for the parent with given className.  Optional.
 * @return:            an element matching the given className or null if none found.
 */
function getParentByClass(object, className, maxDepth) {
  maxDepth = maxDepth || -1;
  while((object.className != className) && (object.tagName != 'BODY') && (maxDepth != 0)) {
    object = object.parentNode;
	maxDepth--;
  }
  return object.className == className ? object : null;
}
/**
 * Find ALL children of a node with a given className.  Recursive.
 *
 * @param theNode:     the object whose children we want to traverse.  Required.
 * @param theClass:    the className that we are looking for in the children.  Required.
 * @return:            an Array of objects matching the className.
 */
function getElementsByClass(theNode, theClass) {
  var cArray = [];
  function doTree(theNode) {
    if(theNode.className && theNode.className==theClass) {
      cArray.push(theNode);
    }
    for(var i=0, len=theNode.childNodes.length; i<len; i++) {
      doTree(theNode.childNodes[i]);
    }
  }
  doTree(theNode);
  return cArray;
}
/**
 * Find all IMMEDIATE children of a node with a given className.
 *
 * @param theNode:     the object whose children we want to traverse.  Required.
 * @param theClass:    the className that we are looking for in the children.  Required.
 * @return:            an Array of objects matching the className.
 */
function getElementsByClass2(theNode, theClass) {
  var cArray = [];
  for(var i=0, len=theNode.childNodes.length; i<len; i++) {
    if(theNode.childNodes[i].className==theClass) cArray.push(theNode.childNodes[i]);
  }
  return cArray;
}
/**
 * Prepends the context path and other directories before the
 * given filename, and returns the full path of the photo.
 * Used to transfer a filename into a full path filename.
 */
function getPhotoFullPath(filename) {
  return CONTEXT_PREFIX + 'home/' + USER_USERNAME + '/zdocs/photo/' + filename;
}