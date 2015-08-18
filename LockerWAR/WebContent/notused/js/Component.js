/**
 * Base Javascript object
 * 
 * This is the superclass of every other JS component.
 */
function Component(id) {

  this.id = id;
  this.DOM = document.getElementById(id);

  /**
   * Removes the DOM object from the document.
   */
  this.remove = function () {
    if(this.DOM) {
	  this.DOM.parentNode.removeChild(this.DOM);
	  this.DOM = null;
	}
  }
  /**
   * Hides (but does not remove) the DOM object from the document.
   */
  this.hide = function () {
    if(this.DOM) this.DOM.style.display = 'none';
  }
  /**
   * Re-dislays a DOM that has previously been hidden.
   */
  this.show = function () {
    if(this.DOM) this.DOM.style.display = '';
  }
}