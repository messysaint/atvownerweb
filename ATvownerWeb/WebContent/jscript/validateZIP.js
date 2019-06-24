/*******************************************************************/
/* 
/* Validate Add New Vehicle Form
/*
/*******************************************************************/

function validateZIP() {
	
	// Validate ZIP code
	var zipcode=document.forms["searchMechanicOtherZIP"]["zip"].value;
	if ( isNaN(zipcode) || zipcode.length < 4 ) { // not a number
		alert("Please enter ZIP Code");
		//alert( zipcode + zipcode.length );
		return false;
	}
	
	
}




















