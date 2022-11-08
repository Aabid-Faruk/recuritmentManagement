<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.headHunt.model.RecruiterDTO" %>
	<%RecruiterDTO recruiter = (RecruiterDTO) session.getAttribute("recruiter");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Recruiter</title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<form action="readRecruiter" method="post">
		<input type="text" name="id" placeholder="recruiter ID"> 
		<input type="hidden" name="source" value="updateRecruiter">
		<input type="submit" name="submit" value="find">
	</form>
</body>
</html
<%if (null != recruiter) { %>>
<form action=updateRecruiter method="post">
	<input type="number" name = "id" value=<%= recruiter.getRecruiterId() %> readonly>
	<input type="text" name = "name" value=<%= recruiter.getName() %> >
	<input type="text" name = "email" value=<%= recruiter.getEmail() %>>
	<input type="text" name = "number" value=<%= recruiter.getContactNumber() %> >
	<input type="text" name = "dob" value=<%= recruiter.getDateOfBirth() %> >
	<input type="text" name = "gender" value=<%= recruiter.getGender() %> >
	<input type="text" name = "experience" value=<%= recruiter.getExperience() %> >
	<input type="submit" name="submit" value="Update">
</form>
<%session.invalidate();%>
<%}%>