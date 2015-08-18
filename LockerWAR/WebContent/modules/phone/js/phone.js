// File: phone.js
// Author: Petek Pekgoz


//text counter for SMS message up to 160 characters
function taLimit() {
 var taObj=event.srcElement;
 // no keypresses after maxlength
 if(taObj.value.length==taObj.maxLength*1) return false;
}

// count & display how many chars are left
function taCount(visCnt) {
 var taObj=event.srcElement;
 // if there's more than allowed, chop off the end
 if(taObj.value.length>taObj.maxLength*1) taObj.value=taObj.value.substring(0,taObj.maxLength*1);
 // change the number in the counter span
 if(visCnt) visCnt.innerText=taObj.maxLength-taObj.value.length;
}

// Show sendSMS phone div based on what was checked on the grid.
function showSendSMSDiv() {
  var rows = getSelectedRows();
  //alert(getGridData(17,3));
  if(rows.length>0) {
    document.getElementById('contactIds').value=rows;    
	for(var i=0;i<rows.length;i++) {
      document.getElementById('contactNames').value+=getGridData(rows[i], 2)+',';
    }
    document.getElementById('contactNames').value-=',';
  } else {
    document.getElementById('contactIds').value='';
  }
  Dialog('/modules/phone/jsp/sendSMS.jsp');
}
