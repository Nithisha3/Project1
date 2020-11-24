<%@page import="com.cg.entity.Answers"%>
<%@page import="com.cg.entity.Questions"%>
<%@page import="com.cg.entity.Policy"%>
<%@page import="com.cg.entity.UserRole"%>
<%@page import="com.cg.entity.Claim"%>
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
			Claim claim = (Claim)session.getAttribute("VIEW_CLAIM_DATA");
			HashMap<Questions, Answers> claimQuestionsAnswersMap = 
					(HashMap<Questions, Answers>)session.getAttribute("CLAIM_QUESTION_ANSWER_MAP");
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
		
					<div class="container">
						  <div class="table-responsive">          
						  <table class="table">
						    <thead>
						      <tr>
						        <th>Field Name</th>
						        <th>Value</th>   
						      </tr>
						    </thead>	
	
						    <tbody>
						      <tr>
							      <td>Claim Reason</td>
							      <td><%= claim.getClaimReason() %></td>
						      </tr>
						      <tr>
							      <td>Accident Location Street</td>
							       <td><%= claim.getaccidentLocationStreet() %></td>
						      </tr>
						      <tr>
							      <td>Accident City</td>
							     <td><%= claim.getAccidentCity() %></td>
						      </tr>
						       <tr>
							      <td>Accident State</td>
							    <td><%= claim.getAccidentState() %></td>
						      </tr>
						       <tr>
							      <td>Accident Zip</td>
							     	<td><%= claim.getAccidentZip() %></td>
						      </tr>
						       <tr>
							      <td>Claim type</td>
							    <td><%= claim.getClaimType() %></td>
							    </tr>
						     
<%
	for (Map.Entry<Questions, Answers> entry : claimQuestionsAnswersMap.entrySet())  {
		Questions questions = entry.getKey();
		Answers answers = entry.getValue();
%>
			 </tr>
				<td><%= questions.getQuestion() %></td>
				<td><%= answers.getAnswer() %></td>
			  </tr>
<%
}
%>   
						    
						    </tbody>
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