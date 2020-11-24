<%@page import="com.cg.entity.Claim"%>
<%@page import="com.cg.entity.UserRole"%>
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
		<title>Claim Questions and Answers
		</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<!-- HEAD ENDS-->
	
	<!-- BODY STARTS -->
	<body>
		<%	
		UserRole user = (UserRole)session.getAttribute("USER_DATA");
			int claimId = (Integer)session.getAttribute("CLAIM_ID");
			
		%>
			<!-- HEADER STARTS -->
			<div class ="container-fluid">
				<div class  = "row header">
					<div class ="col-md-1 text1">CG Insurance Claim System</div>
					<div class ="col-md-4 col-md-offset-2 text1">
							Welcome 
					</div>
					<%
					if(user.getRoleCode().equals("INSURED")) {
					%>
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "home" class ="button" onclick="location.href ='link?type=insuredHome';"/>
					 </div>
					 <%
					 } else if(user.getRoleCode().equals("HANDLER")) {
					%>
					
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "home" class ="button" onclick="location.href ='link?type=handlerHome';"/>
					 </div>
					  <%
					 } else if(user.getRoleCode().equals("ADJUSTER")) {
					%>
					
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "home" class ="button" onclick="location.href ='link?type=adjusterHome';"/>
					 </div>
					 <%
					 }
					 %>
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "logout" class ="button" onclick="location.href ='link?type=logout';"/>
					 </div>
					 
				</div>
			</div>
			<!-- HEADER ENDS -->
		
			<div class = "container">
				<div class="row form-header">
						<p> The claim with claim id <%=claimId %> is created. Kindly store the Claim id to check the status and claim details </p>		
				</div>
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