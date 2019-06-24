/*******************************************************************/
/* 
/* Validate Add New Vehicle Form
/*
/*******************************************************************/

function validateMessageForm() {
	
	// Validate subject
	var subject=document.forms["messageForm"]["subject"].value;
	if (subject==null || subject=="") { // null or empty
		alert("Please enter subject");
		return false;
	}
		
	// Validate message-text
	var messagetext=document.forms["messageForm"]["message-text"].value;
	if (messagetext==null || messagetext=="") { // null or empty
		alert("Please enter message text");
		return false;
	}
		
	
	
	return confirm('Do you want to save this record?');
	
}




















