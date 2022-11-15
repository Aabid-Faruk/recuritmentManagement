<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container bg-info">
<div class="dropdown">
<ul class="nav nav-pills"><li>
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Register
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="createApplicant.jsp">Add Applicant</a></li>
      <li><a href="createRecruiter.jsp">Add Recruiter</a></li>
    </ul>
    </li>
    <li>
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Search
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="readApplicant.jsp">Display Applicant</a></li>
      <li><a href="readRecruiter.jsp">Display Recruiter</a></li>   
    </ul>
    </li>
        <li>
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Update
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="updateApplicant.jsp">Update Applicant</a></li>
      <li><a href="updateRecruiter.jsp"> Update Recruiter</a></li>
    </ul>
    </li>
        <li>
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Delete
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="deleteApplicant.jsp">Delete Applicant</a></li>     
      <li><a href="deleteRecruiter.jsp">Delete Recruiter</a></li>
    </ul>
    </li>
    <li>
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Assign/Unassign
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
       
      <li>
      <form action="viewAllApplicants" method="post">
		<button type="submit" class= "btn" name="submit" >Assign Applicants</button>
      </form>
      </li>
      <li>
		<a href="viewAssignedApplicants.jsp">Unassign Applicants</a>
      </li>
    </ul>
    </li>
    <li>
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">view Assignments
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="viewAssignedRecruiters.jsp">view Assigned Recruiters</a></li>
      <li><a href="viewAssignedApplicants.jsp">view Assigned Applicants</a></li>    
    </ul>
    </li>
    </ul>
  </div>
</div>
</body>
</html>