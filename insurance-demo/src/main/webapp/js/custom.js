
function checkPassword() {
	var field1Value = document.getElementById("pswd").value;
	if(field1Value == "") {
		document.getElementById("errmsg2").innerHTML = "Password cannot be left blank.";
		return false;
	}
	
	return true;
}

function checkUserName() {
	var field2Value = document.getElementById("userName").value;
	if(field2Value == "") {
		document.getElementById("errmsg1").innerHTML = "User Name cannot be left blank.";
		return false;
	}
	
	return true;
}



