<%@page import="com.ideas2it.headHunt.model.ApplicantDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <c:set var="applicant" value="${requestScope.applicant}" scope="page"></c:set>
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

		<div class="form center-align">
		<form action="createApplicant"  method="post">
			<div>
				<input type="text" name="name" placeholder="Enter Name" required>
			</div>
			<div>
				<input type="email" name="email" placeholder="Enter Email"> 
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
			Degree: <select name="degree">
				<option value="BTECH">BTECH</option>
				<option value="MTECH">MTECH</option>
				<option value="MCA">MCA</option>
				<option value="BCA">BCA</option>
				<option value="MSC">MSC</option>
				<option value="MSC">BSC</option>
				</select>
			</div>
			<div>
			<input type="submit" value="Submit" name="submit">
			</div>
			
		</form>
	</div>	
	</div>

	<c:if test="${(null != applicant)}">
		
	<table class="table bg-info">
		<tr>
			<td>Applicant ID</td>
			<td> <c:out value="${applicant.getApplicantId()}"></c:out> </td>
		</tr>
		<tr>
			<td>Name of Applicant</td>
			<td> <c:out value="${applicant.getName()}"></c:out> </td>
		</tr>
		<tr>
			<td>Email of Applicant</td>
			<td> <c:out value="${applicant.getEmail()}"></c:out> </td>
		</tr>
				<tr>
			<td>Contact Number of Applicant</td>
			<td> <c:out value="${applicant.getContactNumber()}"></c:out> </td>
		</tr>
		<tr>
			<td>Degree of Applicant</td>
			<td> <c:out value="${applicant.getDegree()}"></c:out> </td>
		</tr>
		<tr>
			<td>Gender of Applicant</td>
			<td> <c:out value="${applicant.getGender()}"></c:out> </td>
		</tr>
		<tr>
			<td>Experience of Applicant</td>
			<td> <c:out value="${applicant.getExperience()}"></c:out></td>
		</tr>
		<tr>
			<td>Date of Birth of Applicant</td>
			<td><c:out value="${applicant.getDateOfBirth()}"></c:out></td>
		</tr>
		
	</table>
	</c:if>
	</body>
</body>
</html>