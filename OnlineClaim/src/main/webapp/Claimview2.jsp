
<%@page import="com.cg.model.ClaimAdjuster"%>
<%@page import="com.cg.model.Userrole"%>
<%@ page import="java.util.*"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<!-- HEAD ENDS -->

<!-- BODY STARTS -->
<body>
	<%
		// Userrole user = (Userrole)session.getAttribute("USER_DATA");
	ClaimAdjuster claim = (ClaimAdjuster) request.getAttribute("claimDetails");
	%>
	<!-- HEADER STARTS -->
	<div class="container-fluid">
		<div class="row header">
			<div class="col-md-2 text1">CG Insurance Claim System</div>
			<div class="col-md-4 col-md-offset-2 text1">Welcome</div>
		</div>
		<!-- HEADER ENDS -->



		<!-- PORTAL CONTENT STARTS -->
		<div class="matter">
			<h1>CG Insurance Claim System</h1>
			<p>Welcome to CG Insurance Claim System</p>
		</div>

		<div class="container">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Claim Id</th>
							<th>Reason</th>
							<th>Accident Location</th>
							<th>Accident State</th>
							<th>Accident City</th>
							<th>Accident Zip</th>
							<th>Claim Type</th>
							<%-- <%
				if(user.getRoleCode().equals("ADJUSTER")) {
				%>		   
								<th>Generate Report</th>  
				<%
				}
				%>  --%>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td><%=claim.getClaimId()%></td>
							<td><%=claim.getClaimReason()%></td>
							<td><%=claim.getClaimLocation()%></td>
							<td><%=claim.getClaimState()%></td>
							<td><%=claim.getClaimCity()%></td>
							<td><%=claim.getClaimZip()%></td>
							<td><%=claim.getClaimType()%></td>
							<%--
					if(user.getRoleCode().equals("ADJUSTER")) {
				--%>
							<%--	<td>
								 <form action ="genrateReport" method = "post">
											 <div class ="col-md-10 ">
												<input type = "hidden" class="form-control input-lg"  name = "claimId" value=<%=claim.getClaimNumber() %>>
											</div>
											
								 			<div class = "col-md-6 ">
								 				<input type = "submit" value = "Generate Report " class = "button">
								 			</div>
								 		</form>  
								 </td> --%>
							<%--
				}
				--%>

						</tr>
					</tbody>
				</table>
			</div>
		</div>




		<!-- FOOTER STARTS-->
		<div class="container-fluid navbar-fixed-bottom">
			<div class="row footer">
				<div class="col-md-9">CG Insurance Claim System</div>
				<div class="col-md-3 text-right">&copy;2017 CG Insurance Claim
					System. All Rights Reserved</div>
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
