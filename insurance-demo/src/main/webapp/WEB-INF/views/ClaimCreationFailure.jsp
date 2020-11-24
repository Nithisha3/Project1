<%@page import="com.cg.entity.UserRole"%>
<%@ page language="java" contentType="text/html; charset=UTF-8 "
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- HEAD STARTS-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Claim Creation Failure</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<!-- HEAD ENDS-->
	
	<!-- BODY STARTS -->
	<body>
		<%
			UserRole user = (UserRole)session.getAttribute("USER_DATA");
		%>
		<!-- HEADER STARTS -->
		<div class ="container-fluid">
			<div class  = "row header">
				<div class ="col-md-5 text1">CG Insurance Claim System</div>
				<div class ="col-md-6 text1">
					Welcome <%=user.getUserName() %>, your logged in as <%=user.getRoleCode() %> role. 
					The claim can't be created as of now, please try again.....
				</div>
			</div>
		</div>
		<!-- HEADER ENDS-->
		
		<!-- PORTAL CONTENT STARTS -->
		<div class="matter">
			<h1>CG Insurance Claim System</h1>
			<p>Welcome to CG Insurance Claim System</p> 
		</div>
		<!-- PORTAL CONTENT ENDS -->
		
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
	<!-- BODY ENDS -->
</html>