/**
 * Tooltip Component
 * 
 *
 */
TOOLTIP = {
  /**
   * Pointer to the tooltip containing div.
   */
  container : null,
  /**
   * Initializes the container var.
   */
  init : function() {
	var img = document.createElement('IMG');
	  img.id = 'zuiToolTipImg';
	  img.src = '../img/arrow2.gif';
    var div = document.createElement('DIV');
	  div.id = 'zuiToolTip';
	  div.appendChild(img);

	TOOLTIP.container = div;
	document.body.appendChild(div);
  },
  /**
   * Position and show the tooltip.
   */
  show : function(text) {
    if(!TOOLTIP.container) TOOLTIP.init();
	TOOLTIP.container.innerHTML += text;
    TOOLTIP.container.style.left = 200 + 'px';
    TOOLTIP.container.style.top = 200 + 'px';
	TOOLTIP.container.style.display = 'block';
	
	//alert(TOOLTIP.container.outerHTML);
  },
  /**
   * Hide the tooltip.
   */
  hide : function() {
    if(TOOLTIP.container) {
      TOOLTIP.container.style.display = 'none';
	}
  }
}