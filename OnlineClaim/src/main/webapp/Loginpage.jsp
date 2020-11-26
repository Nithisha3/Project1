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
<title>Login</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<form action="LoginController" method="post" align="center">
		<h1>Login Page</h1>
		User-Name:<input type="text" name="Username" required /> <br> <br>
		Password<input type="password" name="Password" required />
		<input type="submit" name="name" value="submit"></input>
	</form>
</body>
</html>