<%@page import="com.ideas2it.headHunt.model.ApplicantDTO"%>
<%@page import="com.ideas2it.headHunt.model.RecruiterDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ideas2it.headHunt.model.Recruiter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% List<RecruiterDTO> recruiters = (List<RecruiterDTO>)session.getAttribute("recruiterList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Assigned Recruiters</title>
</head>
<body >

<br><br><hr><hr>
<div class="container">
<jsp:include page="index.jsp"/>
	<br>
	<form action="viewAssignedRecruiters" method="post">
		<input type="text" name="id" placeholder="applicant ID"> 
		<input type="hidden" name="source" value="viewAssignedRecruiters">
		<input type="submit" name="submit" value="Display">
	</form>
	</div>
	
	<%if(null != recruiters)  {%>
	<% for (RecruiterDTO rec : recruiters) {%>
	<table class="table bg-info">
		<tr>
			<td>Recruiter ID</td>
			<td> <%= rec.getRecruiterId() %></td>
		</tr>
		<tr>
			<td>Name of Recruiter</td>
			<td> <%= rec.getName() %></td>
		</tr>
		<tr>
			<td>Recruiter Email</td>
			<td> <%= rec.getEmail() %></td>
		</tr>
				<tr>
			<td>Recruiter Contact</td>
			<td> <%= rec.getContactNumber() %></td>
		</tr>
		<tr>
			<td>Recruiter Gender</td>
			<td> <%= rec.getGender() %></td>
		</tr>
		<tr>
			<td>Recruiter Experience</td>
			<td> <%= rec.getExperience() %></td>
		</tr>
		<tr>
			<td>Recruiter DOB</td>
			<td><%=rec.getDateOfBirth() %></td>
		</tr>		
	</table>
	<%} %>
		<%session.invalidate(); %>
	<%} else {%>
	<%= "Data not found" %>
	<%} %>

</body>
</html>