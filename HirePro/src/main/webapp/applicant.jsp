<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${title}">Recruiter</c:out> </title>
</head>
<body>
    <%@include file="myfile.jsp"%>

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
                        <th colspan="2" scope="col">Action</th>

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
                        <td>
                            <a href="updateRecruiter/${recruiter.recruiterId}"><span class="glyphicon glyphicon-edit"></span></a>
                        </td>
                        <td>
                            <a href="deleteRecruiter/${recruiter.recruiterId}"><span class="glyphicon glyphicon-trash"></span></a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="container text-center">
                    <a href="addRecruiter"><button class="btn btn-success">Add Product</button></a>

                </div>
            </div>
        </div>
    </div>
</body>
</html>