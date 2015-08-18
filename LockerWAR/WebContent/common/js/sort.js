/**
 * Grid sorting functionality.
 * This file includes all sorting relevant methods, including selecting and
 * unselecting checkboxes on grids.
 * 
 * @author peter.szocs
 * @since Sep 2005
 */

// stores the current and previous column to be sorted by
var currentCol = -1;
var prevCol    = -1;
var sortDown   = -1;

function CompareAlpha(a, b) {
  // this one works with ASCII values
  if (a[currentCol] < b[currentCol]) { return -1; }
  if (a[currentCol] > b[currentCol]) { return 1;  }
  return 0;
}

function CompareNumeric(a, b) {
  // this one compares numbers
  numA = a[currentCol];
  numB = b[currentCol];
  if (isNaN(numA)) { return 0;}
  else {
	if (isNaN(numB)) { return 0; }
	else { return numA - numB; }
  }
}

function CompareAlphaIgnore(a, b) {
  // this one ignores the difference between lowercase and uppercase chars
  strA = a[currentCol].toLowerCase();
  strB = b[currentCol].toLowerCase();
  if (strA < strB) { return -1; }
  else {
	if (strA > strB) { return 1; }
	else { return 0; }
  }
}

function CompareDate(a, b) {
  // this one works with date formats conforming to Javascript specifications, e.g. mm/dd/yyyy
  datA = new Date(a[currentCol]);
  datB = new Date(b[currentCol]);
  if (datA < datB) { return -1; }
  else {
	if (datA > datB) { return 1; }
	else { return 0; }
  }
}

function CompareDateEuro(a, b) {
  // this one works with european date formats, e.g. yyyy-mm-dd
  strA = a[currentCol].split("-");
  strB = b[currentCol].split("-")
  datA = new Date(strA[0], strA[1], strA[2]);
  datB = new Date(strB[0], strB[1], strB[2]);
  if (datA < datB) { return -1; }
  else {
	if (datA > datB) { return 1; }
	else { return 0; }
  }
}

function CompareSongLength(a, b) {
  // this one works with song lengths, e.g. mm:ss OR hh:mm:ss
  strA = a[currentCol].split(":");
  strB = b[currentCol].split(":");
  if(strA.length==3) numA = (strA[0]*3600-0) + (strA[1]*60-0) + (strA[2]-0);
  else numA = (strA[0]*60-0) + (strA[1]-0);
  if(strB.length==3) numB = (strB[0]*3600-0) + (strB[1]*60-0) + (strB[2]-0);
  else numB = (strB[0]*60-0) + (strB[1]-0);

  if (isNaN(numA)) { return 0;}
  else {
	if (isNaN(numB)) { return 0; }
	else { return numA - numB; }
  }
}

function TableSort(myCol, mySort) {

	// Remove and then put up/down arrow into theHeader
	var myHeader = document.getElementById('theHeader').rows[0];
	if ((prevCol!=-1) && (prevCol<myHeader.cells.length)) {
		var str = myHeader.cells[prevCol].innerHTML;	
		var i = str.indexOf("<IMG");
		if(i<0) i = str.indexOf("<img");
		if(i>0) myHeader.cells[prevCol].innerHTML=str.substring(0, i);	
	}
	if (prevCol!=myCol) {
		prevCol=myCol;
		sortDown=0;
	} else {
		sortDown=sortDown?0:1;	
	}
	if (!sortDown) myHeader.cells[myCol].innerHTML+='<img src="'+CONTEXT_PREFIX+'common/img/uparrow.gif">';
	else myHeader.cells[myCol].innerHTML+='<img src="'+CONTEXT_PREFIX+'common/img/downarrow.gif">';

	var mySource = document.getElementById('theRows');
	var myRows = mySource.rows.length;
	if(myRows>0) {
		// (1) Create a two-dimensional array and fill it with the table's content
		// NOTE: the name of the table to be sorted=theRows; header=theHeader.
		var myCols = mySource.rows[0].cells.length;
		var str    = mySource.rows[0].cells[0].innerHTML.toLowerCase();
		var fCType = 0; // first  col type: 0=text, 1=checkbox
		var sCType = 0; // second col type: 0=text, 1=href	
		if((str.indexOf("input")>0) && (str.indexOf("type=checkbox"))) fCType=1;
		str = mySource.rows[0].cells[1].innerHTML.toLowerCase();
		if(str.indexOf("href")>0) sCType=1;
		currentCol = myCol;
		myArray = new Array(myRows);
		if((fCType>0) || (sCType>0)) {
			//window.alert(document.getElementById('theRows').innerHTML);
			for (i=0; i < myRows; i++) {
				myArray[i] = new Array(myCols+2);

				// column #1
				myArray[i][myCols]=document.getElementById('theRows').rows[i].cells[0].innerHTML;
				// column #2
				myArray[i][myCols+1]=document.getElementById('theRows').rows[i].cells[1].innerHTML;
				//window.alert(document.getElementById('theRows').rows[i].cells[0].innerHTML);

				//innerText replaced with innerHTML.replace(/<[^>]+>/g,"") for Moz compatibility
				for (j=1; j < myCols; j++) {
					myArray[i][j] = document.getElementById('theRows').rows[i].cells[j].innerHTML.replace(/<[^>]+>/g,"");
				}
			}		
		} else {
			window.alert("Default sorting");
			for (i=0; i < myRows; i++) {
				myArray[i] = new Array(myCols);
				for (j=0; j < myCols; j++) {
					myArray[i][j] = document.getElementById('theRows').rows[i].cells[j].innerHTML.replace(/<[^>]+>/g,"");
				}
			}			
		}

		// (2) Sort the two-dimensional array
		switch (mySort) {
			case 0:
				myArray.sort(CompareAlpha);
				break;
			case 1:
				myArray.sort(CompareNumeric);
				break;
			case 2:
				myArray.sort(CompareAlphaIgnore);
				break;
			case 3:
				myArray.sort(CompareDate);
				break;
			case 4:
				myArray.sort(CompareDateEuro);
				break;
			case 5:
				myArray.sort(CompareSongLength);
				break;
			default:
				//window.alert("default case");
				myArray.sort(CompareAlpha);
				break;
		}
		if (sortDown) {
			myArray.reverse(); // this is for reverse sortings
		}	

		// (3) Re-write the table contents: array --> back to the table
		if((fCType>0) || (sCType>0)) {
			//alert("fCType="+fCType+", sCType="+sCType);
			for (i=0; i < myRows; i++) {
	
				// column #1
				mySource.rows[i].cells[0].innerHTML	= myArray[i][myCols];
				// column #2
				mySource.rows[i].cells[1].innerHTML	= myArray[i][myCols+1];

				for (j=2; j < myCols; j++) {
					mySource.rows[i].cells[j].innerHTML = myArray[i][j];
				}
			}	
		} else {
			//alert("Rewrite back, default");
			for (i=0; i < myRows; i++) {
				for (j=0; j < myCols; j++) {
					mySource.rows[i].cells[j].innerHTML = myArray[i][j];
				}
			}	
		}		
		altRows();
	} // eof: if(myRows>0)
}

// check OR uncheck all checkboxes
function ToggleAll() {
  var frm = document.gridForm;
  for(var i=0;i<frm.elements.length;i++) {
	var v = frm.elements[i];
	if((v.name!='toggleAll') && (v.type=='checkbox')) {
	  v.checked = frm.toggleAll.checked;
	  if(frm.toggleAll.checked) colorRow(v);
	  else clearRow(v, i%2);
	}
  }
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

// checks one checkbox, and colors OR clears the table row
function Toggle(CB) {
  if(CB.checked) colorRow(CB);
  else altRows();
  checkToggleAll();
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
