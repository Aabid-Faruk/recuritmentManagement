<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.headHunt.model.ApplicantDTO" %>
	<%ApplicantDTO applicant = (ApplicantDTO) session.getAttribute("applicant");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Applicant</title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<form action="readApplicant" method="post">
		<input type="text" name="id" placeholder="applicant ID"> 
		<input type="hidden" name="source" value="updateApplicant">
		<input type="submit" name="submit" value="find">
	</form>
</body>
</html
<%if (null != applicant) { %>>
<form action=updateApplicant method="post">
	<input type="number" name = "id" value=<%= applicant.getApplicantId() %> readonly>
	<input type="text" name = "name" value=<%= applicant.getName() %> >
	<input type="text" name = "email" value=<%= applicant.getEmail() %>>
	<input type="text" name = "number" value=<%= applicant.getContactNumber() %> >
	<input type="text" name = "dob" value=<%= applicant.getDateOfBirth() %> >
	<input type="text" name = "gender" value=<%= applicant.getGender() %> >
	<input type="text" name = "degree" value=<%= applicant.getDegree() %> >
	<input type="text" name = "experience" value=<%= applicant.getExperience() %> >
	<input type="submit" name="submit" value="Update">
</form>
<%session.invalidate();%>
<%}%>