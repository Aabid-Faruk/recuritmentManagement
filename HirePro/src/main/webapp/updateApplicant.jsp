<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/12/2022
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title><c:out value="${title}">Update</c:out> </title>

</head>
<body>
	<jsp:include page="normal_navbar.jsp"></jsp:include>

<div class="container mt-3">

  <div class="col-md-6 offset-md-3">

    <h1 class="text-center mb-3">Update Applicant details</h1>

    <form action="${pageContext.request.contextPath}/handleApplicant"  method="post">
      <div class="form-group">
        <input type="number"
               class="form-control"
               name="applicantId"
               placeholder="Enter the Applicant Id here"
               value="${applicant.applicantId}">
               
      </div>
      <div class="form-group">
        <input type="text"
               class="form-control"
               name="name"
               placeholder="Enter the Recruiter name here"
               value="${applicant.name}">
      </div>
      <div class="form-group">
        <input type="email"
               class="form-control"
               name="email"
               value="${applicant.email}"
               placeholder="Enter the Recruiter email here">
      </div>
      <div class="form-group">
        <input type="text"
               class="form-control"
               name="contactNumber"
               value="${applicant.contactNumber}"
               placeholder="Enter the Recruiter contactNumber here">
      </div>
      <div class="form-group">
        <input type="date"
               class="form-control"
               name="tempDob"
               value="${applicant.dateOfBirth}"
               placeholder="Enter the Recruiter contactNumber here">
      </div>

      <div class="form-group">
        <c:if test="${applicant.gender eq 'MALE'}">
        	Gender: <input name="tempGender"
                       	   type="radio"
                       	   value="MALE"
                       	   checked="checked">Male
                	<input name="tempGender"
                		   type="radio"
                		   value="FEMALE">Female
        </c:if>
        <c:if test="${applicant.gender eq 'FEMALE'}">
          	Gender: <input name="tempGender"
          				   type="radio"
          				   value="MALE">Male
          		  	<input name="tempGender"
          		  		   type="radio"
          		  		   value="FEMALE"
          		  		   checked="checked">Female
        </c:if>
      </div>

      <div class="form-group">
	<%-- 	<c:set var="Degree" value="${applicant.Degree}"></c:set> --%>
      	Degree: <select name="tempDegree">
        			<option value="BTECH">B-Tech</option>
            		<option value="MTECH">M-Tech</option>
                    <option value="BCA">BCA</option>
                    <option value="MCA">MCA</option>
                    <option value="BSC">BSc</option>
                    <option value="MSC">MSc</option>
                </select>
      </div>
      
      <div class="form-group">
        <input name="experience"
               type="number"
               value="${applicant.experience}"
               placeholder="Total Experience in Years"
               class="form-control">
      </div>
      <div class="container text-center">
        <a href="${pageContext.request.contextPath}/applicant"
           class="btn btn-outline-danger">Back</a>
        <button type="submit" class="btn btn-warning">update</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>