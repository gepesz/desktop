/**
 * ClickFilter Component
 *
 * ClickFilters are used to cover the whole page and call a javascript function onclick.
 *
 * @param hideId    (optional) The id of the element you want to hide when the
 *                  clickFilter is clicked.  You can leave it blank or null if nothing to hide.
 *
 * @return a ClickFilter object
 */
function ClickFilter(hideId) {
  this.component = Component;
  this.component(null);

  this.DOM = init(document.body);

  function init(filterTarget) {
    var targetHeight = filterTarget.offsetHeight;
    var targetWidth = filterTarget.offsetWidth;
	var zIndex = filterTarget.style.zIndex - (-20);
	var iframe = document.createElement('IFRAME');
      iframe.className = 'zuiFilterIframe';
      iframe.style.height = targetHeight + 'px';
      iframe.style.width = targetWidth + 'px';
      iframe.style.zIndex = zIndex;
	var div = document.createElement('DIV');
      div.className = 'zuiClickFilterDiv';
      div.style.height = targetHeight + 'px';
      div.style.width = targetWidth + 'px';
      div.style.zIndex = zIndex;
    var container = document.createElement('DIV');
	  container.id = 'zuiClickFilter';
      container.appendChild(iframe);
      container.appendChild(div);
	  container.onclick = function() {
        if(hideId) {
		  var div = document.getElementById(hideId);
		  if(div) div.style.display = 'none';
		}
		if(window.clickFilter) CLICKFILTER.remove();
		else {
		  var zuiClickFilter = document.getElementById('zuiClickFilter');
          if(zuiClickFilter) zuiClickFilter.parentNode.removeChild(zuiClickFilter);
		}
	  }
	
	container = filterTarget.insertBefore(container, filterTarget.firstChild);
	return container;
  }
}
CLICKFILTER = {
  /**
   * Creates a ClickFilter object and puts it onto window.clickFilter.
   */
  show : function(hideId) {
	if(!window.clickFilter) window.clickFilter = new ClickFilter(hideId);
  },
  /**
   * Removes window.clickFilter from the DOM.
   */
  remove : function() {
	if(window.clickFilter) {
	  window.clickFilter.remove();
      window.clickFilter = null;
    }
  }
}