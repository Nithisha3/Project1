<%@page import="com.cg.entity.Policy"%>
<%@page import="com.cg.entity.UserRole"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- HEAD STARTS -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Login Success</title>
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
			ArrayList<Policy> policyList = (ArrayList<Policy>)session.getAttribute("POLICY_DATA");
		%>
		<!-- HEADER STARTS -->
		<div class ="container-fluid">
			<div class  = "row header">
				<div class ="col-md-2 text1">CG Insurance Claim System</div>
				<div class ="col-md-4 col-md-offset-2 text1">
					Welcome 
				</div>
			
				<div class = "col-md-2 text-right">
				<div class = "col-md-5 text-right ">
						<input type = "button" value  = "view claim" class ="button" data-toggle="modal"  data-target="#viewClaimModal"/>
				</div>
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
		
		
					<div class="container">
						  <div class="table-responsive">          
						  <table class="table">
						    <thead>
						      <tr>
						        <th>Account Number</th>
						        <th>Policy Number</th>
						        <th>premium</th>
						        <th>Click to Create Claim</th>
						      </tr>
						    </thead>	
			
		<%
			for(Policy policy : policyList) {
		%>  
						    <tbody>
						      <tr>
						        <td><%= policy.getAccountNumber() %></td>
						        <td><%= policy.getPolicyNumber() %></td>
						        <td><%= policy.getPolicyPremium() %></td>
						        <td>
								      <form action ="claimCreationredirect" method = "post">
											 <div class ="col-md-10 ">
												<input type = "hidden" class="form-control input-lg"  name = "policyNo" value=<%=policy.getPolicyNumber() %>>
											</div>
											
								 			<div class = "col-md-6 ">
								 				<input type = "submit" value = "create claim" class = "button">
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
	
	<!-- VIEW CLAIM  Modal -->
		<div class="modal fade" id="viewClaimModal" >
			<div class="modal-dialog" role="document">
				<div id = "myModal" class="modal-content">
			  		<div class="modal-header">
						<h3 class="modal-title" id="personalModalLongTitle">Please Enter Valid Claim ID</h3>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  		<span aria-hidden="true">&times;</span>
						</button>
			  		</div>
			  		<div class="modal-body">
			  			<div class ="container-fluid">
							<div class  = "row">
								<form action ="viewClaim" method = "post">
									<div class ="col-md-10 ">
										<B>Claim Id :</B><input type = "text" class="form-control input-lg"  name = "claimId">
									</div>
									<div class ="col-md-10 ">
												<input type = "hidden" class="form-control input-lg"  name = "userName" value=<%=user.getUserName() %>>
									</div>
									<div class ="col-md-10 ">
												<input type = "hidden" class="form-control input-lg"  name = roleCode value=<%=user.getRoleCode() %>>
									</div>
						 			<div class = "col-md-6 ">
						 				<input type = "submit" value = "Show Polices" class = "button">
						 			</div>
						 		</form>
							</div>
						 </div>			
			   		</div>
		     	</div>
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