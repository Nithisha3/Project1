<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(!(boolean)request.getAttribute("success")) {%>
			<label>UserName or Password Incorrect</label>
			<form action="Loginpage.jsp">
				<input type="submit" value="GO TO LOGIN" />
			</form>
		<%} else { %>
	<form action="MainController" method="post">
		<%--  <%
			if (session.getAttribute("loggedIn") == null) {
			response.sendRedirect("Loginpage.jsp");
		} 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		%>--%>
		
		<a href="logout">Logout</a>
		<button id="btnAdmin" disabled>Admin</button>
		<button id="btnUser" disabled>Insured</button>
		<button id="btnAgent" disabled>Claim Handler</button>
	</form>
	${Profile}
	<%} %>
</body>

<script type="text/javascript">
var roleCode='${Profile.roleCode}';
switch(roleCode){
		case 'Insured':
		document.getElementById('btnUser').disabled=false;
		break;
	case 'Claim Adjuster':
		document.getElementById('btnAdmin').disabled=false;
		break;
	case 'Claim Handler':
		document.getElementById('btnAgent').disabled=false;
		break;
}
</script>

</html>