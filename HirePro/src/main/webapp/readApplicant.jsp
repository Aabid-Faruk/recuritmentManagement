<%@page import="com.ideas2it.headHunt.model.ApplicantDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ApplicantDTO applicant = (ApplicantDTO)session.getAttribute("applicant"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up (Applicant)</title>
</head>
<body >

<br><br><hr><hr>
<div class="container">
<jsp:include page="index.jsp"/>
	<br>
	<form action="readApplicant" method="post">
		<input type="text" name="id" placeholder="applicant ID"> 
		<input type="hidden" name="source" value="readApplicant">
		<input type="submit" name="submit" value="Display">
	</form>
	</div>
	
	<%if(null != applicant)  {%>
	<table class="table bg-info">
		<tr>
			<td>Applicant ID</td>
			<td> <%= applicant.getApplicantId() %></td>
		</tr>
		<tr>
			<td>Name of Applicant</td>
			<td> <%= applicant.getName() %></td>
		</tr>
		<tr>
			<td>Applicant Email</td>
			<td> <%= applicant.getEmail() %></td>
		</tr>
				<tr>
			<td>Applicant Contact</td>
			<td> <%= applicant.getContactNumber() %></td>
		</tr>
		<tr>
			<td>Applicant Degree</td>
			<td> <%= applicant.getDegree() %></td>
		</tr>
		<tr>
			<td>Applicant Gender</td>
			<td> <%= applicant.getGender() %></td>
		</tr>
		<tr>
			<td>Applicant Experience</td>
			<td> <%= applicant.getExperience() %></td>
		</tr>
		<tr>
			<td>Applicant DOB</td>
			<td><%=applicant.getDateOfBirth() %></td>
		</tr>		
	</table>
		
	<%} else {%>
	<%= "Data not found" %>
	<%} %>

</body>
</html>