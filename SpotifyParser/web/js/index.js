(function(doc) {
  // note: browser support on forEach and querySelectorAll is not super
  [].forEach.call(doc.querySelectorAll('input.json__value--string'), function(input) {
    // create the wrapper
    var wrapper = doc.createElement('span');
    wrapper.className = 'json__value--string';
    
    // wrap input in wrapper
    input.parentNode.insertBefore(wrapper, input);
    wrapper.appendChild(input);
    
    // fit width initially, and on input (note: ie8 has no input event)
    fit.call(input);
    input.addEventListener('input', fit);
  });
  
  // hardcoded 0.625em character width, omg!
  function fit() {
    this.style.width = (this.value.length * 0.625) + 'em';
  }
})(document);