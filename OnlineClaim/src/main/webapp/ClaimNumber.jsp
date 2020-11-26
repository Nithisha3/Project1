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
ArrayList<QuestionAndAnswers> list = (ArrayList<QuestionAndAnswers>)session.getAttribute("QuestionAndAnswers");
%>
<body>
	<form action=SubmitController method="post" align="center">
	<%for(QuestionAndAnswers qa: list){
		%>
		<h4><%= qa.getQuestion()%>?</h4>
		<input type="radio" name="<%=qa.getQuestionId() %>" id=<%=qa.getAnswer1() %> value="<%=qa.getAnswer1()%>" />
		<label><%= qa.getAnswer1()%></label><br>
		<input type="radio" name="<%=qa.getQuestionId() %>" id=<%=qa.getAnswer2() %> value="<%=qa.getAnswer2()%>" />
		<label><%= qa.getAnswer2()%></label><br>
		<input type="radio" name="<%=qa.getQuestionId() %>" id=<%=qa.getAnswer3() %> value="<%=qa.getAnswer3()%>" />
		<label><%= qa.getAnswer3()%></label><br>
	<% }%>
	
	<input type="submit" name="name">
	</form>
</body>
</html>