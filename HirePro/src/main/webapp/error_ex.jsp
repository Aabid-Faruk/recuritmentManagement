<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sorry! Something went wrong</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	
</head>
<body>

	<div class="container p-3 text-center">
		<img src="img/error500.jpg" class="img-fluid" width="350px" height="200px">		
		<h1 class="display-3">Page not Found</h1>
		<p><%= exception %></p>
		<a class="btn btn-outline-primary" href="index.jsp">Home Page</a>
	</div>
</body>
</html>