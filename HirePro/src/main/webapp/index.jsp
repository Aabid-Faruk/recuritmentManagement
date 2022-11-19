<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
    <title><c:out value="${title}">Home Page</c:out> </title>
</head>
	
	
	<body>
		<!-- Navbar -->
		<jsp:include page="normal_navbar.jsp"/>
		
		<!-- Banner -->
		<div class="container-fluid p-0 m-0">
		
			<div class="jumbotron">
				<div class="container">
					<h6 class="display-6">Welcome to Ideas2It Recruitment</h6>
					<p>
					“If you are an Amazing Software Engineer who wants to make great money working at an amazing company then keep reading!”
					</p>
					<p>
					They created a job ad called “Assemble your future” in the same style as its typical flatpack assembly instructions and inserted into their furniture boxes. Isn’t that brilliant? 😮
					</p>
					
					<a href="#"><button class="btn btn-outline-dark btn-lg">Admin Login</button></a>
				</div>
			</div>
		</div>
	</body>
</html>