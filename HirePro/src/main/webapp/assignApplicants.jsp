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
<jsp:include page="normal_navbar.jsp"/>
	<div class="container">
	<br>
<%-- 	${recruiter} --%>

			<table class="table table-striped">
				<tr class="bg-info">
					<td>ID</td>
					<td>Name</td>
					<td>Email</td>
					<td>Contact</td>
					<td>Gender</td>
					<td>Experience</td>
					<td>DOB</td>
				</tr>

				<tr>
					<td>${recruiter.recruiterId}</td>
					<td>${recruiter.name }</td>
					<td>${recruiter.email}</td>
					<td>${recruiter.contactNumber}</td>
					<td>${recruiter.gender}</td>
					<td>${recruiter.experience}</td>
					<td>${recruiter.dateOfBirth}</td>
				</tr>
			</table>		
	<hr class="bg-success">
	<br>
	<form action="${pageContext.request.contextPath}/assignApplicants" method="post">
			<table class="table table-striped">
				<tr class="bg-warning">
					<td>ID</td>
					<td>Name</td>
					<td>Email</td>
					<td>Contact</td>
					<td>Degree</td>
					<td>Gender</td>
					<td>Experience</td>
					<td>DOB</td>
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
		<input type="hidden" name="recruiterId" value="${recruiter.recruiterId}">
		<input type="submit" name="submit" value="Assign Selected">
		</form>
	</div>

</body>
</html>