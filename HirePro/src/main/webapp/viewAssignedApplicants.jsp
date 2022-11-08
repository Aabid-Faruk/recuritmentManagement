<%@page import="com.ideas2it.headHunt.model.ApplicantDTO"%>
<%@page import="com.ideas2it.headHunt.model.RecruiterDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ideas2it.headHunt.model.Recruiter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% List<ApplicantDTO> applicants = (List<ApplicantDTO>)session.getAttribute("applicantList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Assigned Applicants</title>
</head>
<body >

<br><br><hr><hr>
<div class="container">
<jsp:include page="index.jsp"/>
	<br>
	<form action="viewAssignedApplicants" method="post">
		<input type="text" name="id" placeholder="recruiter ID"> 
		<input type="hidden" name="source" value="viewAssignedApplicants">
		<input type="submit" name="submit" value="Show Assigned Applicants">
	</form>
	</div>

	<%if(null != applicants)  {%>
	<% for (ApplicantDTO app : applicants) {%>
	<table class="table bg-info">
		<tr>
			<td>Applicant ID</td>
			<td> <%= app.getApplicantId() %></td>
		</tr>
		<tr>
			<td>Name of Applicant</td>
			<td> <%= app.getName() %></td>
		</tr>
		<tr>
			<td>Applicant Email</td>
			<td> <%= app.getEmail() %></td>
		</tr>
				<tr>
			<td>Applicant Contact</td>
			<td> <%= app.getContactNumber() %></td>
		</tr>
		<tr>
			<td>Applicant Gender</td>
			<td> <%= app.getGender() %></td>
		</tr>
		<tr>
			<td>Applicant Degree</td>
			<td> <%= app.getDegree() %></td>
		</tr>
		<tr>
			<td>Applicant Experience</td>
			<td> <%= app.getExperience() %></td>
		</tr>
		<tr>
			<td>Applicant DOB</td>
			<td><%=app.getDateOfBirth() %></td>
		</tr>		
	</table>
	<%} %>
		<%session.invalidate(); %>
	<%} else {%>
	<%= "Data not found" %>
	<%} %>

</body>
</html>