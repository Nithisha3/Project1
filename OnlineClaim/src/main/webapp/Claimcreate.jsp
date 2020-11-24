<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim-Creation</title>
</head>
<form action="ClaimController" method="post" align="center">
<h1>Claim Creation</h1>
<label for="ClaimId">ClaimId:</label>
<input type="text"  id="ClaimId" name="claimId" required><br>
<br>
<label for="ClaimReason">ClaimReason:</label>
<input type="ClaimReason" id="ClaimReason" name="claimReason" required><br>
<br>
<label for="Location">Location:</label>
<input type="Location" id="Location" name="Location" required><br>
<br>
<label for="City">City:</label>
<input type="City" id="City" name="City" required><br>
<br>
<label for="State">State:</label>
<input type="State" id="State" name="State" required><br>
<br>
<label for="Zip">Zip:</label>
<input type="Zip" id="Zip" name="Zip" required><br>
<br>
<label for="ClaimType">ClaimType:</label>

    <input type="radio" name="claimType" value="Claims of fact">Claims of fact
    <input type="radio" name="claimType" value="Claims of value">Claims of value
    <input type="radio" name="claimType" value="Claims of policy">Claims of policy
<br>
<input type="submit" name="name" value="Next"></input>
</html>