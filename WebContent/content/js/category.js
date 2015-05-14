 
var xhr;

if (XMLHttpRequest)
	xhr = new XMLHttpRequest();
else
	xhr = new ActiveXObject("Microsoft.XMLHTTP");

xhr.onload = function () {

    if (xhr.status === 200) {
        document.getElementById( 'CategoryItems' ).innerHTML = xhr.responseText; 
    }
};

xhr.open('GET', 'test/category' , true );
xhr.send(null); 


 

 

