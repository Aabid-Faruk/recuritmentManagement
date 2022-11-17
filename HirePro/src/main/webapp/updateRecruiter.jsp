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
<%@ page isELIgnored="false" %>
<html>
<head>
  <%@include file="base.jsp"%>
  <title><c:out value="${title}">Update</c:out> </title>

</head>
<body>

<div class="container mt-3">

  <div class="col-md-6 offset-md-3">

    <h1 class="text-center mb-3">Change Recruiter details</h1>

    <form action="${pageContext.request.contextPath}/handle-Recruiter"  method="post">

      <div class="form-group">
        <input type="number"
               class="form-control"
               name="recruiterId"
               placeholder="Enter the Recruiter Id here"
               value="${recruiter.recruiterId}">
      </div>
      <div class="form-group">
        <input type="text"
               class="form-control"
               name="name"
               placeholder="Enter the Recruiter name here"
               value="${recruiter.name}">
      </div>
      <div class="form-group">
        <input type="email"
               class="form-control"
               name="email"
               value="${recruiter.email}"
               placeholder="Enter the Recruiter email here">
      </div>
      <div class="form-group">
        <input type="text"
               class="form-control"
               name="contactNumber"
               value="${recruiter.contactNumber}"
               placeholder="Enter the Recruiter contactNumber here">
      </div>
      <div class="form-group">
        <input type="date"
               class="form-control"
               name="tempDob"
               value="${recruiter.dateOfBirth}"
               placeholder="Enter the Recruiter contactNumber here">
      </div>

      <div class="form-group">
        <c:if test="${recruiter.gender eq 'MALE'}">
        Gender: <input name="tempGender"
                       type="radio"
                       value="MALE"
                        checked="checked">Male
                </input>
                <input name="tempGender"
                       type="radio"
                       value="FEMALE">Female
                </input>
        </c:if>
        <c:if test="${recruiter.gender eq 'FEMALE'}">
          Gender: <input name="tempGender"
                         type="radio"
                         value="MALE">Male
          </input>
          <input name="tempGender"
                 type="radio"
                 value="FEMALE"
                 checked="checked">Female
          </input>
        </c:if>
      </div>
      <div class="form-group">
        <input name="experience"
               type="number"
               value="${recruiter.experience}"
               placeholder="Total Experience in Years"
               class="form-control">
      </div>
      <div class="container text-center">
        <a href="${pageContext.request.contextPath}/"
           class="btn btn-outline-danger">Back</a>
        <button type="submit" class="btn btn-warning">update</button>
      </div>
    </form>
  </div>
</div>
</body>
</html>
<%--            <div style="display:block">all field are required</div>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--<script type="text/javascript">--%>

<%--    function createRecruiter(event) {--%>
<%--        event.preventDefault();--%>
<%--        var validFlag = true;--%>
<%--        var name = document.getElementById('name');--%>
<%--        if(name.length == '' ) {--%>
<%--            validFlag = flag;--%>
<%--        }--%>
<%--        alert('fddd');--%>

<%--        if(validFlag == true) {--%>
<%--            ajaxFunction();--%>
<%--        } else {--%>
<%--            document.getElementById('error').style = 'block';--%>
<%--        }--%>
<%--    }--%>

<%--    function ajaxFunction(){--%>
<%--        //ajax coding--%>
<%--    }--%>


<%--</script>--%>
