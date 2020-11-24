<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.cg.model.QuestionAndAnswers"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ClaimNumber</title>
</head>
<%
	HttpSession ssn = request.getSession();
ArrayList<QuestionAndAnswers> list = (ArrayList<QuestionAndAnswers>) ssn.getAttribute("QuestionAndAnswers");
request.setAttribute("questions", list);
%>
<body>
	<form action=SubmitController method="post" align="center">
	<select name="question">
	<c:forEach question="${questionName}" var="id">
	<option value="${id}">${id}</option>
	</c:forEach>
	</select>
	

	</form>
</body>
</html>