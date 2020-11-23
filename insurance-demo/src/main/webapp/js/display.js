
function checkInput(){
	checkFName();
	checkLName();
	checkDate();
	checkGender();
	checkMail();
	checkPhone();
	checkPassword();
	checkAnswer();

	var field1Value = document.getElementById("fname").value;
	if(field1Value == "") {
		document.getElementById("errmsg1").innerHTML = "First Name cannot be left blank.";
		return false;
	}
		var field2Value = document.getElementById("lname").value;
	if(field2Value == "") {
		document.getElementById("errmsg2").innerHTML = "Last Name cannot be left blank.";
		return false;
	}
	var field3Value = document.getElementById("date").value;
	if(field3Value == "") {
		document.getElementById("errmsg3").innerHTML = "Date of Birth cannot be left blank.";
		return false;
	}
	var field4Value = document.getElementById("male").checked;
	var field5Value = document.getElementById("female").checked;
	
	if(field4Value == false) {
		if(field5Value == false) {
			document.getElementById("errmsg4").innerHTML = "Select a Gender";
		}
		return false;
	}
	var field6Value = document.getElementById("mail").value;
	if(field6Value == "") {
		document.getElementById("errmsg5").innerHTML = "EMail ID cannot be left blank.";
		return false;
	}
	var field7Value = document.getElementById("mobile").value;
	if(field7Value == "") {
		document.getElementById("errmsg6").innerHTML = "Mobile Number cannot be left blank.";
		return false;
	}
	var field8Value = document.getElementById("mobile").value;
	if(field8Value == "") {
		document.getElementById("errmsg10").innerHTML = "password cannot be left blank.";
		return false;
	}
	var field9Value = document.getElementById("mobile").value;
	if(field9Value == "") {
		document.getElementById("errmsg11").innerHTML = "Security Anwer cannot be left blank.";
		return false;
	}
	return true;
	
}

function checkAddresses(){
	checkAddress1();
	checkAddress2();
	checkAddress3();

	var field8Value = document.getElementById("address1").value;
	var field9Value = document.getElementById("address2").value;
	var field10Value = document.getElementById("address3").value;
	if(field8Value == "") {
		document.getElementById("errmsg7").innerHTML = "Address line 1 cannot be left blank.";
		return false;
	}
	if(field9Value == "") {
		document.getElementById("errmsg8").innerHTML = "Address line 2 cannot be left blank.";
		return false;
	}
	if(field10Value == "") {
		document.getElementById("errmsg9").innerHTML = "Address line 3 cannot be left blank.";
		return false;
	}
	return true;
}
function btn1() {
		if(checkInput()) {
			$('#personalModal').modal();
		var fname1 = document.getElementById("fname").value;
		document.getElementById("alrtmsg1").innerHTML = fname1;
		
		var lname = document.getElementById("lname").value;
		document.getElementById("alrtmsg2").innerHTML= lname;
  
		var date = document.getElementById("date").value;
		document.getElementById("alrtmsg3").innerHTML= date;
	
		var male = document.getElementById("male").checked;
		var female = document.getElementById("female").checked;
		if( male){
			document.getElementById("alrtmsg4").innerHTML= "male";
		} else if(female){
			document.getElementById("alrtmsg4").innerHTML= "female";
		} else {
			document.getElementById("alrtmsg4").innerHTML= "";
		}
		
		var mailId = document.getElementById("mail").value;
		document.getElementById("alrtmsg5").innerHTML= mailId;
		
		var mobileNo = document.getElementById("mobile").value;
		document.getElementById("alrtmsg6").innerHTML= mobileNo;
		}
	
}
jQuery("#myBtn").click(function(e){
	btn1();
e.preventDefault();
});
function btn2() {
		if(checkAddresses()){
			$('#addressModal').modal();
		var addressL1 = document.getElementById("address1").value;
		document.getElementById("alrtmsg7").innerHTML= addressL1;
	
		var addressL2 = document.getElementById("address2").value;
		document.getElementById("alrtmsg8").innerHTML= addressL2;
	
		var addressL3 = document.getElementById("address3").value;
		document.getElementById("alrtmsg9").innerHTML= addressL3;
		}
}
jQuery("#myBtn2").click(function(e){
	btn2();
e.preventDefault();
});

function view1(){
  var fname = document.getElementById("fname").value;
  document.getElementById("displaymsg1").innerHTML= fname;
  
    var lname = document.getElementById("lname").value;
	document.getElementById("displaymsg2").innerHTML= lname;
  
    var date = document.getElementById("date").value;
	document.getElementById("displaymsg3").innerHTML= date;
	
	var male = document.getElementById("male").checked;
	var female = document.getElementById("female").checked;
	if( male){
		document.getElementById("displaymsg4").innerHTML= "male";
	} else if(female){
		document.getElementById("displaymsg4").innerHTML= "female";
	} else {
		document.getElementById("displaymsg4").innerHTML= "";
	}
	
	var mailId = document.getElementById("mail").value;
	document.getElementById("displaymsg5").innerHTML= mailId;
	
	var mobileNo = document.getElementById("mobile").value;
	document.getElementById("displaymsg6").innerHTML= mobileNo;
}

function view2(){
	var addressL1 = document.getElementById("address1").value;
	document.getElementById("displaymsg7").innerHTML= addressL1;
	
	var addressL2 = document.getElementById("address2").value;
	document.getElementById("displaymsg8").innerHTML= addressL2;
	
	var addressL3 = document.getElementById("address3").value;
	document.getElementById("displaymsg9").innerHTML= addressL3;
	
}

