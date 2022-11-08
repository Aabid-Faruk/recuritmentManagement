<%@page import="com.ideas2it.headHunt.model.RecruiterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% RecruiterDTO recruiter = (RecruiterDTO)session.getAttribute("recruiter"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search (Recruiter)</title>
</head>
<body >

<br><br><hr><hr>
<div class="container">
<jsp:include page="index.jsp"/>
	<br>
	<form action="readRecruiter" method="post">
		<input type="text" name="id" placeholder="recruiter ID"> 
		<input type="hidden" name="source" value="readRecruiter">
		<input type="submit" name="submit" value="Display">
	</form>
	</div>
	
	<%if(null != recruiter)  {%>
	<table class="table bg-info">
		<tr>
			<td>Applicant ID</td>
			<td> <%= recruiter.getRecruiterId() %></td>
		</tr>
		<tr>
			<td>Name of Applicant</td>
			<td> <%= recruiter.getName() %></td>
		</tr>
		<tr>
			<td>Applicant Email</td>
			<td> <%= recruiter.getEmail() %></td>
		</tr>
				<tr>
			<td>Applicant Contact</td>
			<td> <%= recruiter.getContactNumber() %></td>
		</tr>
		<tr>
			<td>Applicant Gender</td>
			<td> <%= recruiter.getGender() %></td>
		</tr>
		<tr>
			<td>Applicant Experience</td>
			<td> <%= recruiter.getExperience() %></td>
		</tr>
		<tr>
			<td>Applicant DOB</td>
			<td><%=recruiter.getDateOfBirth() %></td>
		</tr>
		
	</table>
		<%session.invalidate(); %>
	<%} else {%>
	<%= "Data not found" %>
	<%} %>

</body>
</html>