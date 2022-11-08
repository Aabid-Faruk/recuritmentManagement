<%@page import="com.ideas2it.headHunt.model.RecruiterDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% RecruiterDTO recruiterDto = (RecruiterDTO)session.getAttribute("recruiter"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up (Recruiter)</title>
</head>
<body >

<br><br><hr><hr>
<div class="container">
<jsp:include page="index.jsp"/>

		<div class="form center-align">
		<form action="createRecruiter"  method="post">
			<div>
				<input type="text" name="name" placeholder="Enter Name">
			</div>
			<div>
				<input type="text" name="email" placeholder="Enter Email"> 
			</div>
			<div>
				<input type="text" name="number" placeholder="Contact Number">
			</div>
			<div>
				<input type="date" name="dob">
			</div>
			<div>		
			Gender:
				<input type="radio" name="gender" value="MALE">Male 
				<input type="radio" name="gender" value="FEMALE">Female
			</div>
			<div>
				<input type="number" name="experience" min="0" max="34" placeholder="Experience">
			</div>
			<div>
			<input type="submit" value="Submit" name="submit">
			</div>
			
		</form>
	</div>	
	</div>
	
		<% if(null != recruiterDto) { %>
		
	<table class="table bg-info">
		<tr>
			<td>ID of Recruiter</td>
			<td> <%= recruiterDto.getRecruiterId() %></td>
		</tr>
		<tr>
			<td>Name of Recruiter</td>
			<td> <%= recruiterDto.getName() %></td>
		</tr>
		<tr>
			<td>Email of Recruiter</td>
			<td> <%= recruiterDto.getEmail() %></td>
		</tr>
				<tr>
			<td>Contact Number of Recruiter</td>
			<td> <%= recruiterDto.getContactNumber() %></td>
		</tr>
		<tr>
			<td>Gender of Recruiter</td>
			<td> <%= recruiterDto.getGender() %></td>
		</tr>
		<tr>
			<td>Experience of Recruiter</td>
			<td> <%= recruiterDto.getExperience() %></td>
		</tr>
		<tr>
			<td>Dob of Recruiter</td>
			<td><%=recruiterDto.getDateOfBirth() %></td>
		</tr>
		
	</table>
	<%}	session.invalidate();%>
</body>
</html>