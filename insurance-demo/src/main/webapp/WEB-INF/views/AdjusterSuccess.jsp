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
			//UserRole user = (UserRole)session.getAttribute("USER_DATA");
			//ArrayList<Accounts> accountsList = (ArrayList)session.getAttribute("CUSTOMERS_OF_HANDLER");
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
		<div class="matter">
			<h1>CG Insurance Claim System</h1>
			<p>Welcome to CG Insurance Claim System </p> 
		</div>
		
			<div class="container">
				<div class = "col-md-11 ">
						<input type = "button" value  = "create claim" class ="button" data-toggle="modal"  data-target="#createClaimModal"/>
					 </div>
					 <div class = "col-md-11 ">
						<input type = "button" value  = "view All claim" class ="button" data-toggle="modal"  data-target="#viewClaimModal"/>
					 </div>
					  <div class = "col-md-11 ">
						<input type = "button" value  = "craete user role" class ="button" data-toggle="modal"  data-target="#createUserRoleModal"/>
					 </div>
					  <div class = "col-md-11 ">
						<input type = "button" value  = "Generate Report" class ="button" onclick="location.href ='link?type=generateReport';"/>
					 </div>
			</div>
	
		
		
		<!-- MODAL LOGICS -->
		<!-- SIGNIN Modal -->
		<div class="modal fade" id="createClaimModal" >
			<div class="modal-dialog" role="document">
				<div id = "myModal" class="modal-content">
			  		<div class="modal-header">
						<h3 class="modal-title" id="personalModalLongTitle">Please Enter Account Number for which claim to be Created </h3>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  		<span aria-hidden="true">&times;</span>
						</button>
			  		</div>
			  		<div class="modal-body">
			  			<div class ="container-fluid">
							<div class  = "row">
								<form action ="createClaimByAdjuster" method = "post">
									<div class ="col-md-10 ">
										<B>Account Number :</B><input type = "text" class="form-control input-lg"  name = "accNo">
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
	    
	    <!-- CREATE USER ROLE  Modal -->
		<div class="modal fade" id="createUserRoleModal" >
			<div class="modal-dialog" role="document">
				<div id = "myModal" class="modal-content">
			  		<div class="modal-header">
						<h3 class="modal-title" id="personalModalLongTitle">Please Enter Your Credentials </h3>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  		<span aria-hidden="true">&times;</span>
						</button>
			  		</div>
			  		<div class="modal-body">
			  			<div class ="container-fluid">
							<div class  = "row">
								<form action ="createUserRole" method = "post">
									<div class="col-md-11">
										<p>User Name:
											<input type="text"  name="userName"  id = "userName" class="form-control input-lg" placeholder="Enter User Name" onblur = "return checkUserName()"  />
											<span id = "errmsg1" style = "color: red;"></span>
										</p>                     
									</div>
									<div class=" col-md-5">
										<p>Password :<input type = "password" id = "paswd" name = "pwd" class="form-control input-lg" onblur = "return checkPassword()" >
											<p><span id = "errmsg2" style = "color: red;"></span></p>						
										</p>
									</div>
									<div class=" col-md-11">
										<p>Claim type:</p>
										<select name = "userRole" id = "userRole"  class="form-control input-lg" required>
												<option value = "INSURED">INSURED</option>
												<option value = "HANDLER">HANDLER</option>
												<option value = "ADJUSTER">ADJUSTER</option>
											</select>
									</div>
						 			<div class = "col-md-6 ">
						 				<input type = "submit" value = "Login" class = "button">
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