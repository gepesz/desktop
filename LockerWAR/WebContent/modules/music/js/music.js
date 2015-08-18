// File: music.js
// Author: Peter Szocs

// fills artist and songtitle input texts on upload div with info parsed from fileName
function parseFileName(fileName) {
	//parse for real fileName
	var lastDot = fileName.lastIndexOf('.');
	if(lastDot==-1) lastDot=fileName.length;
	var lastSlash = fileName.lastIndexOf('\\');
	if(lastSlash==-1) lastSlash=fileName.lastIndexOf('/');
	fileName = fileName.substring(lastSlash+1, lastDot);
	//alert("fileName="+fileName);
	
	//parse fileName for artist, songTitle
	lastDot = fileName.indexOf('_-_');
	if(lastDot!=-1) lastSlash=lastDot+3; 
	else {
	  lastDot = fileName.indexOf(' - ');
	  if(lastDot!=-1) lastSlash=lastDot+3;
	  else {
	    lastDot = fileName.indexOf('-');
	    if(lastDot!=-1) lastSlash=lastDot+1;
	    else {
	      lastDot = fileName.indexOf('_');
	      if(lastDot!=-1) lastSlash=lastDot+1;
	      else {
	        lastDot=0;
	        lastSlash=fileName.length;
	      }
	    }
	  }
	}	
	var artist = fileName.substring(0, lastDot);
	var songTitle = fileName.substring(lastSlash, fileName.length);
	//alert("artist="+artist);
	//alert("songTitle="+songTitle);	
	
	document.getElementById('upArtist').value=artist;
	document.getElementById('upSongTitle').value=songTitle;
	//document.getElementById('upAlbum').value='upAlbum';
	//document.getElementById('upGenre').value='upGenre';	
}

// calls DownloadServer or BulkDownloadServlet, based on how many songs are selected
function download() {
	var c=0;
	var id=-1;
	var frm=document.gridForm;
	for(var i=0;i<frm.elements.length;i++) {
		var v = frm.elements[i];
		if((v.name!='toggleAll') && (v.type=='checkbox') && (v.checked)) {
			c++;
			id=v.value;
		}
	}
	//download file, or show alert
	if(c==0) { 
		Alert('Please select at least one item.');
		return false; 
	} else if(c==1) window.location.href='DownloadServlet?id='+id;
	else {
		Alert('Please select only one at a time.');
		return false; 
	}
}

// populates options for create mix
function populateOptions() {
	var selectBox = document.getElementById('mfColl');
	var theRows = document.getElementById('theRows');	
	var frm = document.gridForm;
	var j=0; //selectBox option id
	//put selected rows into selectBox
	for(var i=0;i<frm.elements.length;i++) {
		var v = frm.elements[i];
		if((v.name!='toggleAll') && (v.type=='checkbox') && (v.checked)) {
			var text = theRows.rows(i-2).cells(2).innerText+' - ';
			text+=theRows.rows(i-2).cells(1).innerText; //text=artist - songTitle
			var value = theRows.rows(i-2).cells(0).innerHTML;
			value = value.substring(value.indexOf('value='));
			value = value.substring(6, value.lastIndexOf(' ')); //value=songId
			selectBox.options[j++] = new Option(text, value);
		}
	}
	selectBox.options.length=j;
}

// deletes the selected option
function deleteSelectedOption() {
	var selectBox = document.getElementById('mfColl');
	var selectedIndex = selectBox.selectedIndex;	
	if (selectedIndex>=0) {
		var id = selectBox.options[selectedIndex].value;
		var frm = document.gridForm;
		for(var i=0;i<frm.elements.length;i++) {
			var v = frm.elements[i];
			if((v.name!='toggleAll') && (v.type=='checkbox') && (v.checked) && (v.value==id)) {
				v.checked=false;
				Toggle(v);
			}
		}
		selectBox.options[selectedIndex]=null;
	}
}

// moves the selected option one up
function moveUp() {
	var selectBox = document.getElementById('mfColl');
	var selectedIndex = selectBox.selectedIndex;	
	if(selectedIndex>=0) {
		if(selectedIndex!=0) {
			var tempText  = selectBox.options[selectedIndex-1].text;
			var tempValue = selectBox.options[selectedIndex-1].value;
			selectBox.options[selectedIndex-1] = new Option(selectBox.options[selectedIndex].text, selectBox.options[selectedIndex].value);
			selectBox.options[selectedIndex] = new Option(tempText, tempValue);
			selectedIndex-=1;
		}
		selectBox.selectedIndex=selectedIndex;
	}
}

// moves the selected option one down
function moveDown() {
	var selectBox = document.getElementById('mfColl');
	var selectedIndex = selectBox.selectedIndex;	
	if(selectedIndex>=0) {
		if(selectedIndex!=selectBox.options.length-1) {
			var tempText  = selectBox.options[selectedIndex+1].text;
			var tempValue = selectBox.options[selectedIndex+1].value;
			selectBox.options[selectedIndex+1] = new Option(selectBox.options[selectedIndex].text, selectBox.options[selectedIndex].value);
			selectBox.options[selectedIndex] = new Option(tempText, tempValue);
			selectedIndex+=1;
		}
		selectBox.selectedIndex=selectedIndex;
	}
}
/**
 * Selects all options before submitting form.
 * @param selectId  the id of the <select>..</select> element
 */
function selectAllOptions(selectId) {
  var selectBox = document.getElementById(selectId);
  var orig = selectBox.outerHTML;
  var i = orig.indexOf('>');
  var select = orig.substring(0, i)+' multiple="multiple"';
  selectBox.outerHTML = select+orig.substring(i);	
  for(i=0; i<selectBox.options.length; i++) {
	selectBox.options[i].selected='true';
  }
}
