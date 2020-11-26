<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="css/Admin.css">
</head>
<body>
<form action="AdminController" method="post" align="center">
<h1>AdminPage</h1>
<ol  type="1">

		<input type=submit name="name" value="Profile-create"></input>
		<br>
		<br><input type=submit name="name" value="Create-claim"></input>
		<br>
		<br><input type=submit name="name" value="View-claim"></input>
		<br>
		<br><input type=submit name="name" value="Report"></input></br>
		
			
		</ol>
		</form>
		<script src="js/jquery-1.12.4.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/display.js"></script>
</body>
</html>