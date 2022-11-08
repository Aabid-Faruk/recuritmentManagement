<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.ideas2it.headHunt.model.ApplicantDTO"%>
<%@page import="com.ideas2it.headHunt.model.RecruiterDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.ideas2it.headHunt.model.Recruiter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% List<ApplicantDTO> applicants = (List<ApplicantDTO>) session.getAttribute("applicantList"); %>
    <% RecruiterDTO recruiter = (RecruiterDTO)session.getAttribute("recruiter"); %>    
    <%boolean status = false; %>
    <%if(session.getAttribute("status") != null) { %>
    <%  status = (boolean)session.getAttribute("status"); %>
    <%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unassign Applicants</title>
</head>
<body >

<br><br><hr><hr>
<jsp:include page="index.jsp"/>
	<div class="container">
	<br>
	<form action="unassignApplicants" method="post">
	
	<% if (null !=applicants) {%>
			<table class="table bg-info">
				<tr>
					<td>Applicant ID</td>
					<td>Name of Applicant</td>
					<td>Applicant Email</td>
					<td>Applicant Contact</td>
					<td>Applicant Degree</td>
					<td>Applicant Gender</td>
					<td>Applicant Experience</td>
					<td>Applicant DOB</td>
				</tr>
				<% for(ApplicantDTO applicant : applicants) {%>

				<tr>
					<td><input type="checkbox" checked="checked" name="applicant_Id" value="<%=applicant.getApplicantId()%>">&nbsp<%=applicant.getApplicantId()%></td>
					<td><%=applicant.getName()%></td>
					<td><%=applicant.getEmail()%></td>
					<td><%=applicant.getContactNumber()%></td>
					<td><%=applicant.getDegree()%></td>
					<td><%=applicant.getGender()%></td>
					<td><%=applicant.getExperience()%></td>
					<td><%=applicant.getDateOfBirth()%></td>
				</tr>
				<%}%>
			</table>
			<%}%>
		<input type="text" name="recruiter_Id" placeholder="recruiter ID"> 
		<input type="hidden" name="source" value="unassignApplicants">				
		<input type="submit" name="submit" value="Unassign Selected">
		</form>
	</div>
		
	
	<%if(status)  {%>
	<%= "Unassigned Successfully"%>
	<%} else {%>
	<%= "Data not found" %>
	<%} %>

</body>
</html>