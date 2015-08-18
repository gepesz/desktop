/**
 * If an element is invisible, make it visible, else make it invisible
 * @param id:   the object whose opacity we will be shifting
 * @param wait: the wait time.  The higher the wait time, the slower fading is.
 */
function shiftOpacity(id, wait) {
  var obj = document.getElementById(id);
  if(obj.style.opacity < 90) {
    obj.style.display = 'block';
    opacity(id, 90, wait);
  } else opacity(id, 0, wait);
}
/**
 * Fades in/out an element/div/image on the DOM.
 * @param id:         the id of the object that we will fade in or out
 * @param opacEnd:    the desired opacity.  Range: [0-100], means % opacity.
 * @param wait:       the speed at which to fade.  The higher the wait, the slower the fading is!!
 */
function opacity(id, opacEnd, wait) {
  document.fadeObjectStyle = document.getElementById(id).style;
  var opacStart = document.fadeObjectStyle.opacity;
  if(!opacStart) opacStart = 0; //if opacity not defined on the object, default it to 0
  var speed = Math.round(wait / 100);
  var timer = 0;
  //alert(opacStart);
  //alert(opacEnd);
  //determine the direction for the blending, if start and end are the same nothing happens
  if(opacStart > opacEnd) { //hiding
    for(i = opacStart-1; i >= opacEnd; i--) {
      setTimeout('changeOpac(' + i + ')', (timer * speed));
      timer++;
    }
  } else if(opacStart < opacEnd) { //fading in
    for(i = opacStart+1; i <= opacEnd; i++) {
      setTimeout('changeOpac(' + i + ')', (timer * speed));
      timer++;
    }
  }
}
/**
 * Changes the opacity of the HTML element stored in document.fadeObjectStyle.
 */
function changeOpac(opacity) {
  document.fadeObjectStyle.opacity = opacity;
  document.fadeObjectStyle.MozOpacity = (opacity / 100);
  document.fadeObjectStyle.KhtmlOpacity = (opacity / 100);
  document.fadeObjectStyle.filter = 'alpha(opacity=' + opacity + ')';
  if(opacity == 0) document.fadeObjectStyle.display = 'none'; //change display to none if opacity=0
}