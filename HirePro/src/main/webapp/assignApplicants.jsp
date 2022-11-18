<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title><c:out value="${title}"/></title>
</head>
<body >
<jsp:include page="index.jsp"/>
	<div class="container">
	<br>
	${recruiter}
	<form action="assignApplicants" method="post">
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
				<c:forEach items="${applicants}" var="applicant">

				<tr>
					<td><input type="checkbox" name="applicant_Id" value="${applicant.applicantId}">&nbsp${applicant.applicantId}</td>
					<td>${applicant.name }</td>
					<td>${applicant.email}</td>
					<td>${applicant.contactNumber}</td>
					<td>${applicant.degree}</td>
					<td>${applicant.gender}</td>
					<td>${applicant.experience}</td>
					<td>${applicant.dateOfBirth}</td>
				</tr>
				</c:forEach>
			</table>
		<input type="text" name="recruiter_Id" placeholder="recruiter ID"> 
		<input type="hidden" name="source" value="AssignApplicants">			
		<input type="submit" name="submit" value="Assign Selected">
		</form>
	</div>

</body>
</html>