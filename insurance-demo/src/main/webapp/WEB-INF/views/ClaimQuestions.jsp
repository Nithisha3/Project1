<%@page import="com.cg.entity.Answers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.entity.Questions"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.cg.entity.Claim"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<!-- HEAD STARTS-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Claim Questions and Answers</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<!-- HEAD ENDS-->
	
	<!-- BODY STARTS -->
	<body>
		<%	
			 Claim claim = (Claim)session.getAttribute("CLAIM_DATA");
			 HashMap<Questions, ArrayList<Answers>> claimQuestionsAnswers = (HashMap)session.getAttribute("CLAIM_QUESTION_ANSWERS");
			
		%>
			<!-- HEADER STARTS -->
			<div class ="container-fluid">
				<div class  = "row header">
					<div class ="col-md-1 text1">CG Insurance Claim System</div>
					<div class ="col-md-4 col-md-offset-2 text1">
							Welcome 
					</div>
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "home" class ="button" onclick="location.href ='link?type=home';"/>
					 </div>
					<div class = "col-md-5 text-right">
						<input type = "button" value  = "logout" class ="button" onclick="location.href ='link?type=logout';"/>
					 </div>
					 
				</div>
			</div>
			<!-- HEADER ENDS -->
			
			<div class = "container">
			<div class="row form-header">
							<div class="col-md-10">
									<h3>Select Claim Questions and Answers</h3>
							</div>
					</div>	
		<div class="form-group row">
		<form class ="form-group" action = "claimQuestion" method = "post" >
					<div class="container">
						  <div class="table-responsive">          
						  <table class="table">
						    <thead>
						      <tr>
						        <th>Claim Question</th>
						        <th>Claim Answer Choices</th>
						      </tr>
						    </thead>	
					<div class ="col-md-10 ">
						<input type = "hidden" class="form-control input-lg"  name = "questionLength" value= <%=claimQuestionsAnswers.size() %>>
					</div>
				<%
				 int questionLength = claimQuestionsAnswers.size();
				 for (Map.Entry<Questions,ArrayList<Answers>> entry : claimQuestionsAnswers.entrySet())   {
					 Questions questions = entry.getKey();
					 ArrayList<Answers> ansArrayList = entry.getValue();
					
				 
				
				%>
						<tbody>
						   <tr>						     
								<td>
									<h4><B><p> <%=questions.getQuestion() %></p></B></h4>							
								</td>
									 <div class ="col-md-10 ">
										<input type = "hidden" class="form-control input-lg"  name = "questionId<%=questionLength-- %>" value= <%=questions.getQuestionId() %>>
									</div>
								<td>
									<%
									
									for(Answers answers : ansArrayList) {
									
									%>
				
								    <div class="col-sm-10">
								        <div class="form-check form-check-inline">
								            <input class="form-check-input" type="radio" name=<%=questions.getQuestionId() %> id=<%=answers.getAnswerId() %> value=<%= answers.getAnswerId() %>>
								            <label class="form-check-label" for="inlineRadio1"><%= answers.getAnswer() %></label>
								        </div>
								      </div>
				  
								   <%
								   }
								   %>
							 	</td>
				   			</tr>
						  </tbody>
    			<%
				}
				%>
				 </table>
			 </div>
		 </div>
				
									 <div class ="col-md-10 ">
												<input type = "hidden" class="form-control input-lg"  name = "claimNo" value= <%=claim.getClaimNumber() %>>
									</div>
									<div class=" col-md-11">
										<p><input type="submit" id="myBtn" name="submit" value="Submit" class = "button1"/></p>
									</div>
				</form>
			</div>	
						
	</div>
			
			
			
			<!-- FOOTER STARTS-->
			<div class="container-fluid navbar-fixed-bottom">
				<div class = "row footer">
					<div class ="col-md-9">CG Insurance Claim System</div>
					<div class = "col-md-3 text-right">&copy;2017 CG Insurance Claim System. All Rights Reserved</div>
				</div>
			</div>
			<!-- FOOTER ENDS-->
	
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery-1.12.4.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.js"></script>
		<script src="js/custom.js"></script>
		<script src="js/display.js"></script>
	</body>
	<!-- BODY ENDS-->
</html>