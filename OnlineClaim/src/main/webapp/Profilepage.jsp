<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile page</title>
</head>
<body>
<form action="UserController" method="post" align="center">
<h1>User</h1>
<label for="Username">UserName:</label>
<input type="text"  id="Username" name="UserName" required><br>
<br>
<label for="password">Password:</label>
<input type="password" id="password" name="Password" required><br>
<br>
<label for="Role">User Role:</label>
<select id="Role" name="Role">
  <option value="Insured">Insured</option>
  <option value="Claim Handler">Claim Handler</option>
  <option value="Claim Adjuster">Claim Adjuster</option>
</select>
<br>
<br>
<input type="submit" name="name" value="Sign-up"></input>
<input type="submit" name="name" value="Logout"></input>
</form>
</body>
</html>