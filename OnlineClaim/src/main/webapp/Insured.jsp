<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insured</title>
</head>
<body>
<form action="ClaimhandlerController" method="post align="center">
<h2>Insured</h2>
<% ArrayList<Integer> policies =(ArrayList<Integer>)request.getAttribute("policies");  %>
Policy No:
<select>
	<%for(int pol: policies){ %>
	<option><%=pol%></option>
	<%} %>
</select><a href="Claimcreate.jsp">Create Claim</a>
<br><br>
<a href="Claimview.jsp">View Claim</a>
</form>
</body>
</html>