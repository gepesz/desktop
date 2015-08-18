/**
 * Filter Component
 *
 * Filters are used to block out sections of a page, rendering them unclickable.
 *
 * @param id        (optional) The id of the element you want the filter to cover.
 *                  Leave it blank or null to cover the whole screen.
 *
 * @return a Filter object
 */
function Filter(id) {
  var isWholeScreen = id ? false : true;

  if(isWholeScreen) this.filterTarget = document.body;
  else this.filterTarget = document.getElementById(id);

  this.DOM = init(this.filterTarget);
  window.filter = this;

  function init(filterTarget) {
    var targetHeight = (!isWholeScreen && filterTarget.scrollHeight) ? filterTarget.scrollHeight : filterTarget.offsetHeight;
    var targetWidth = (!isWholeScreen && filterTarget.scrollWidth) ? filterTarget.scrollWidth : filterTarget.offsetWidth;
	var zIndex = filterTarget.style.zIndex - (-50);
	var iframe = document.createElement('IFRAME');
      iframe.src = rewriteURL('/common/jsp/blank.jsp');
      iframe.className = 'zuiFilterIframe';
      iframe.style.height = targetHeight + 'px';
      iframe.style.width = targetWidth + 'px';
      iframe.style.zIndex = zIndex;
	var div = document.createElement('DIV');
      div.className = 'zuiFilterDiv';
      div.style.height = targetHeight + 'px';
      div.style.width = targetWidth + 'px';
      div.style.zIndex = zIndex;
    var container = document.createElement('DIV');
	  container.id = 'FilterContainer_' + this.id;
      container.appendChild(iframe);
      container.appendChild(div);
	if(isWholeScreen) {
      container = filterTarget.insertBefore(container, filterTarget.firstChild);
    } else {
      container = filterTarget.parentNode.insertBefore(container, filterTarget);
    }
    return container;
  }
}