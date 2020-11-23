<%@page import="com.cg.entity.UserRole"%>
<%@page import="com.cg.entity.Accounts"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- HEAD STARTS -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insured Success</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		
	</head>
	<!-- HEAD ENDS -->
	
	<!-- BODY STARTS -->
	<body>
		<%
			UserRole user = (UserRole)session.getAttribute("USER_DATA");
		ArrayList<Accounts> accountsList = (ArrayList)session.getAttribute("CUSTOMERS_OF_HANDLER");
		%>
		<!-- HEADER STARTS -->
		<div class ="container-fluid">
			<div class  = "row header">
				<div class ="col-md-2 text1">CG Insurance Claim System</div>
				<div class ="col-md-4 col-md-offset-2 text1">
					Welcome 
				</div>
			
				<div class = "col-md-2 text-right">
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "logout" class ="button" onclick="location.href ='link?type=logout';"/>
					 </div>
				 </div>
			</div>
		</div>
		<!-- HEADER ENDS -->
		
		
		
		<!-- PORTAL CONTENT STARTS -->
		<div class="matter">
			<h1>CG Insurance Claim System</h1>
			<p>Welcome to CG Insurance Claim System </p> 
		</div>
		
		</div>
		
					<div class="container">
						<h2>Table</h2>
						  <div class="table-responsive">          
						  <table class="table">
						    <thead>
						      <tr>
						        <th>Account Number</th>
						        <th>Click to View Customer</th>
						      </tr>
						    </thead>	
			
		<%
			for(Accounts accounts: accountsList) {
		%>  
						    <tbody>
						      <tr>
						        <td><%= accounts.getAccountNumber() %></td>
						        <td>
								      <form action ="viewUserredirect" method = "post">
											 <div class ="col-md-10 ">
												<input type = "hidden" class="form-control input-lg"  name = "accNo" value=<%=accounts.getAccountNumber() %>>
											</div>
											
								 			<div class = "col-md-6 ">
								 				<input type = "submit" value = "view customer" class = "button">
								 			</div>
								 		</form>
						        </td>
						      </tr>
						    </tbody>
						
						 
		<% 			
			}
		%>
		  </table>
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
	<!-- BODY ENDS -->
</html>