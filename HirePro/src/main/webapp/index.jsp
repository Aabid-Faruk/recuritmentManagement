<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title><c:out value="${title}">Home Page</c:out> </title>
</head>
<body>
    <div class="container mt-3">

        <div class="row">

            <div class="col-md-12">

                <h1 class="text-center mb-3">Welcome to Recruitment App</h1>

                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Contact Number</th>
                        <th scope="col">Date of Birth</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Experience</th>
                        <th scope="col">Action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${recruiters}" var="recruiter">
                    <tr>
                        <th scope="row">${recruiter.recruiterId}</th>
                        <td>${recruiter.name}</td>
                        <td>${recruiter.email}</td>
                        <td>${recruiter.contactNumber}</td>
                        <td>${recruiter.dateOfBirth}</td>
                        <td>${recruiter.gender}</td>
                        <td>${recruiter.experience}</td>
                        <td>@mdo</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="container text-center">
                    <a href="addRecruiter" class="btn btn-outline-success">Add Product</a>

                </div>
            </div>
        </div>
    </div>
</body>
</html>