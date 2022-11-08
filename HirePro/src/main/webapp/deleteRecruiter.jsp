<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
	<br>
	
	<form action="deleteRecruiter" method="post">
		<input type="text" name="id" placeholder="applicant ID"> 
		<input type="submit" name="submit" value="Delete">
	</form>
	
</body>
</html>