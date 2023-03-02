function addField(plusElement){
    let displayButton = document.querySelector(".stop");
  
    // Stopping the function if the input field has no value.
    if(plusElement.previousElementSibling.value.trim() === ""){
       return false;
    }
  
    // creating the div container.
    let div = document.createElement("div");
    div.setAttribute("class", "field");
  
    // Creating the input element.
    let field = document.createElement("input");
    field.setAttribute("type", "text");
    field.setAttribute("name", "classes[]");
  
    // Creating the plus span element.
    let plus = document.createElement("span");
    plus.setAttribute("onclick", "addField(this)");
    let plusText = document.createTextNode("+");
    plus.appendChild(plusText);
  
    // Creating the minus span element.
    let minus = document.createElement("span");
    minus.setAttribute("onclick", "removeField(this)");
    let minusText = document.createTextNode("-");
    minus.appendChild(minusText);
  
    // Adding the elements to the DOM.
    form.insertBefore(div, displayButton);
    div.appendChild(field);
    
    div.appendChild(minus);
  
    // Un hiding the minus sign.
    minus.style.display = "inline-block"; // the minus sign
    // Hiding the plus sign.
    plus.style.display = "inline-block"; // the plus sign
 }
 function removeField(minusElement){
    minusElement.parentElement.remove();
 }
 let form = document.forms[0];
 form.addEventListener("submit", fetchTextNotes);
 function fetchTextNotes(event){
    event.preventDefault();
    let data = new FormData(form);
    let classes = [];
    data.forEach( function(value){
       if(value !== ""){
          classes.push(value);
       }
    });
  
    let inputFields = document.querySelectorAll(".field");
    inputFields.forEach(function(element, index){
       if(index == inputFields.length - 1){
          element.children[0].value = "";
       }else{
          element.remove();
       }
    });
 }