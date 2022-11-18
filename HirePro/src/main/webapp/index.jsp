<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
    <title><c:out value="${title}">Home Page</c:out> </title>

<!--css-->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
		<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		
	
		
		<!-- javascripts -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript"></script>	
		<script>
		</script>
	
	</body>
</html>