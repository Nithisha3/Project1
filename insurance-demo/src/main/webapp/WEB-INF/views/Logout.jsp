
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- HEAD STARTS -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Logout</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<!-- HEAD ENDS -->
	
	<!-- BODY STARTS -->
	<body>
		<%
		//	Customer customer = (Customer)session.getAttribute("CUSTOMER_DATA");
		%>
			<!-- HEADER STARTS -->
			<div class ="container-fluid">
				<div class  = "row header">
					<div class ="col-md-1 text1"><a href ="index.jsp">CG Insurance Claim System</a></div>
		<%
			session.invalidate();
		%>
					<div class = "col-md-3 text1"> Sucessfully Logged Out</div>
					<div class = "col-md-2 col-md-offset-2 text-right">
						<input type = "button" value  = "sign In" class ="button" data-toggle="modal" data-target="#siginModal"/>
					 </div>
				</div>
			</div>
			<!-- HEADER ENDS -->
			
			<!-- PORTAL CONTENT STARTS -->
			<div class="matter">
				<h1>CG Insurance Claim System</h1>
				<p>Adios to CG Insurance Claim System </p> 
			</div>
			<!-- PORTAL CONTENT ENDS -->
			
			<!-- FOOTER STARTS -->
			<div class="container-fluid navbar-fixed-bottom">
				<div class = "row footer">
					<div class ="col-md-9">Flipkart</div>
					<div class = "col-md-3 text-right">&copy;2017 FlipKart. All Rights Reserved</div>
				</div>
			</div>
			<!-- FOOTER ENDS -->
		
			<!-- MODAL LOGICS -->
			<!-- SIGNIN Modal -->
			<div class="modal fade" id="siginModal" >
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
									<form action ="login" method = "post">
										<div class ="col-md-10 ">
											<B>Email :</B><input type = "text" class="form-control input-lg"  name = "mail">
										</div>
										<div class = "col-md-10 ">
											<B>Password :</B><input type = "password" class="form-control input-lg" name = "pwd"><br/>
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

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery-1.12.4.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/display.js"></script>
	</body>
	<!-- BODY ENDS -->
</html>