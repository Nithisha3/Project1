<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.cg.model.Userrole"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ClaimView</title>
</head>
<%
	Userrole ur = (Userrole) session.getAttribute("Profile");
%>
<body>
	<form action="ClaimViewController" method="post" align="center">
		<h3>Enter your Claim-Id</h3>
		<label>Claim-Id:</label> <input type="text" Id="Claim-Id:"
			name="claimId" /> <br> <br> <input type="submit"
			value="ViewClaim" name="name"></input>&nbsp; 
			<%if(!ur.getRoleCode().equals("Claim Handler")){ %>
			<input id="report" type="submit" value="GenerateReport" name="name"></input> <br>
			<%} %>
	</form>
</body>
</html>