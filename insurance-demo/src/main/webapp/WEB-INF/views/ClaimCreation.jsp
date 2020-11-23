<%@page import="com.cg.entity.Policy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- HEAD STARTS-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Claim Creation</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<!-- HEAD ENDS-->
	
	<!-- BODY STARTS -->
	<body>
		<%	
			 Integer policyNoForClaimCreation = (Integer)session.getAttribute("POLICYNO_FOR_CLAIMCREATION");
			
		%>
			<!-- HEADER STARTS -->
			<div class ="container-fluid">
				<div class  = "row header">
					<div class ="col-md-1 text1">CG Insurance Claim System</div>
					<div class ="col-md-4 col-md-offset-2 text1">
							Welcome 
					</div>
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "logout" class ="button" onclick="location.href ='link?type=logout';"/>
					 </div>
				</div>
			</div>
			<!-- HEADER ENDS -->
		
			<div class = "container">
			<div class="row form-header">
							<div class="col-md-10">
									<h3>Create a New Claim</h3>
							</div>
					</div>	
				<form class ="form-group" action = "claimCreation" method = "post" >
								<div class="row form1">
									<div class="col-md-11">
										<p>Claim Reason:
											<input type="text"  name="claimReason"  class="form-control input-lg" placeholder="Enter Claim Reason"  />
										</p>                     
									</div>
									<div class=" col-md-11">
										<p>Accident Location Street:
											<input type="text" name="accidentLocStreet" class="form-control input-lg" placeholder="Enter Accident Location Street"  /> 
										</p>
									</div>
									<div class=" col-md-11">
										<p>Accident City:
											<input type="text" name="accidentCity" class="form-control input-lg" placeholder="Enter Accident City"  /> 
										</p>
									</div>
									<div class=" col-md-11">
										<p>Accident State:
											<input type="text" name="accidentState" class="form-control input-lg" placeholder="Enter Accident State"  /> 
										</p>
									</div>
									<div class=" col-md-11">
										<p>Accident Zip:
											<input type="text" name="accidentZip" class="form-control input-lg" placeholder="Enter Accident Zip"  /> 
										</p>
									</div>
									<div class=" col-md-11">
										<p>Claim type:</p>
										<select name = "claimType" id = "claimType"  class="form-control input-lg" required>
												<option value = "claimType">Claim type</option>
												<option value = "Accident">Accident</option>
												<option value = "Damage">Damage</option>
											</select>
									</div>
									 <div class ="col-md-10 ">
												<input type = "hidden" class="form-control input-lg"  name = "policyNo" value= <%= policyNoForClaimCreation%>>
											</div>
									<div class=" col-md-11">
										<p><input type="submit" id="myBtn" name="submit" value="Submit" class = "button1"/></p>
									</div>
									
							</form >
			</div>
			<!-- FOOTER STARTS-->
			<div class="container-fluid navbar-fixed-bottom">
				<div class = "row footer">
					<div class ="col-md-9">CG Insurance Claim System</div>
					<div class = "col-md-3 text-right">&copy;2017 CG Insurance Claim System. All Rights Reserved</div>
				</div>
			</div>
			<!-- FOOTER ENDS-->
	
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery-1.12.4.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/display.js"></script>
	</body>
	<!-- BODY ENDS-->
</html>