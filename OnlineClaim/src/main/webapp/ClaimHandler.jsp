<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ClaimHandler</title>
</head>
<body>
<h2>Claim Handler</h2>
<% ArrayList<String> customers = (ArrayList<String>)request.getAttribute("customers");  %>
<form action="Claimhandlercontroller" method="post" align="center">
Customer id:
<select>
	<%for(String cust:customers){ %>
	<option><%=cust %></option>
	<%} %>
</select><a href="Claimcreate.jsp">Create Claim</a>
<br><br>
<a href="Claimview.jsp">View Claim</a>
</form>
</body>
</html>