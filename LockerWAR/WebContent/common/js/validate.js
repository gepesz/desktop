/**
 * Form validation methods.
 *
 * @author peter.szocs
 * @since Jul 2005
 */

/**
 * Removes leading/ending whitespaces from string.
 * Source: http://msdn.microsoft.com/library/default.asp?url=/library/en-us/script56/html/js56jsconconstructor.asp
 */
String.prototype.trim = function () {
  return this.replace(/(^\s*)|(\s*$)/g, '');
}
/**
 * Tests the string against the requested testType:
 *   'required'   : contains at least one non-whitespace char
 *                  For drop downs, 'required' means the selected option's value is anything but -1.
 *   'minLength5' : minimum FIELD_MIN_LENGTH_5 (ie 5) chars in length
 *   'integer'    : contains only [0-9] chars
 *   'intRange'   : contains only [0-9] chars and the value is between (FIELD_INT_MIN;FIELD_INT_MAX)
 *   'email'      : email address
 *   'zip'        : five or more digits
 * 
 * @param testType    The type of test required.
 * @return            true IF the String fails the requested test
 */
String.prototype.failsTest = function(testType) {
  switch (testType) {
    case 'required': return this.trim().match(/\S/) == null;
    case 'minLength5': return this.trim().length < FIELD_MIN_LENGTH_5;
    case 'integer': return this.trim().match(/^\d+$/) == null;
    case 'intRange': return (this.failsTest('integer') || (this <= FIELD_INT_MIN) && (this >= FIELD_INT_MAX));
    case 'email': return this.trim().match(/^[\w\d._%-]+@[\w\d._%-]+\.[\w\d._%-]{2,4}$/) == null;
    case 'zip': return this.trim().match(/^\d{5}\d*$/) == null;
    default: alert('Unknown String.failsTest testType: '+testType); return false;
  }
}
/**
 * Shows validation error message for ONE form field.
 * Basically puts the <span class="formFieldError">errorMsg</span> into the DOM.
 */
function showFieldError(field, errorMsg) {
  var span = field.parentNode.lastChild;
  if(span.className == 'formFieldError') {
    span.innerHTML = errorMsg;
	span.style.display = 'block';
  } else {
	span = document.createElement('SPAN');
    span.className = 'formFieldError';
    span.innerHTML = errorMsg;
	field.parentNode.appendChild(span);
  }
}
/**
 * Main form validation method.
 * @param form:      The form to validate.
 * @param isSubmit:  Boolean (true/false) value that indicates whether to submit the form
 *                   if validation is successful.
 *                   Optional, can be left null, in which case it defaults to true.
 * @return boolean:  Returns whether validation has succeeded, ie 'true' only iff no validation errors.
 */
function validateForm(form, isSubmit) {

  /**
   * Clears ALL form field error messages.
   * Basically hides the <span class='formFieldError'>errorMsg</span> from the DOM.
   */
  function clearFormErrors(form) {
	for(var i=0; i<form.elements.length; i++) {
	  var span = form.elements[i].parentNode.lastChild;
	  if( span.innerHTML == null ) span = span.previousSibling;
	  if(span.className == 'formFieldError') span.style.display = 'none';
    }
  }

  clearFormErrors(form); //clear previous errors
  var isErrorsPresent = false; //are there any validation errors?
  if(isSubmit==null) isSubmit = true;
  for(var i=0; i<form.elements.length; i++) {
	var field = form.elements[i];
	var validate = field.getAttribute('validate');
	//validate only fields that have the validate attribute
	if(validate) {
      validate = validate.split(',');
	  var value = field.value;
	  for(var j=0; j<validate.length; j++) {
	    var type = validate[j].trim();
		switch (type) {
          case 'required':
            if((field.tagName == 'SELECT') && (value == '-1')) {
			  showFieldError(field, 'Must be specified.');
			  j = validate.length;
              isErrorsPresent = true;
            } else if((field.type == 'checkbox') && (!field.checked)) {
			  showFieldError(field, 'Must be checked.');
			  j = validate.length;
              isErrorsPresent = true;
			} else if(value.failsTest('required')) {
			  showFieldError(field, 'Must be specified.');
			  j = validate.length;
              isErrorsPresent = true;
		    }
            break;
          case 'minLength5':
            if(value.failsTest('minLength5')) {
			  showFieldError(field, 'Must be minimum '+FIELD_MIN_LENGTH_5+' characters in length.');
			  j = validate.length;
              isErrorsPresent = true;
		    }
            break;
          case 'integer':
            if(value.failsTest('integer')) {
			  showFieldError(field, 'Must be a number.');
			  j = validate.length;
              isErrorsPresent = true;
		    }
            break;
          case 'intRange':
            if(value.failsTest('intRange')) {
			  showFieldError(field, 'Must be within the range '+FIELD_INT_MIN+'-'+FIELD_INT_MAX+'.');
			  j = validate.length;
              isErrorsPresent = true;
		    }
            break;
          case 'email':
            if(value.failsTest('email')) {
			  showFieldError(field, 'Must be an email address.');
			  j = validate.length;
              isErrorsPresent = true;
		    }
            break;
          case 'zip':
            if(value.failsTest('zip')) {
			  showFieldError(field, 'Must be a zip code.');
			  j = validate.length;
              isErrorsPresent = true;
		    }
            break;
          case 'pwMatch':
		    if( document.getElementById('passwordAgain').value.trim() != value.trim() ) {
			  showFieldError(field, 'Passwords do not match.');
			  j = validate.length;
              isErrorsPresent = true;
		    }
            break;
          default: 
		    alert('No validator found for validate=\"'+type+'\".  Modify validate.js#validateForm() and add a new switch statement!');
		    break;
        } //eof switch  
	  } //eof for loop (j)
	} //eof if(validate)
  } //eof for loop (i)
  
  if(isErrorsPresent) return false; //THERE ARE validation errors: don't submit the form
  else {                            //NO validation errors: submit the form if isSubmit is true
	if(isSubmit) form.submit();
    return true;
  }
}