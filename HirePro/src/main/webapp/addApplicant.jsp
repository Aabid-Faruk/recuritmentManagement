<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<%@include file="base.jsp"%>

</head>
<body>

    <div class="container mt-3">

        <div class="col-md-6 offset-md-3">

            <h1 class="text-center mb-3">Fill the Applicant details</h1>

            <form action="handleApplicant"  method="post">

                <div class="form-group">
                	<label for="Name">Applicant Name</label>
                    <input type="text"
                           class="form-control"
                           name="name"
                           id="name"
                           placeholder="Enter the Applicant name here">
                </div>
                <div class="form-group">
                    <input type="email"
                           class="form-control"
                           name="email"
                           placeholder="Enter the Applicant email here">
                </div>
                <div class="form-group">
                    <input type="text"
                           class="form-control"
                           name="contactNumber"
                           placeholder="Enter the Applicant contactNumber here">
                </div>
                <div class="form-group">
                    <input type="date"
                           class="form-control"
                           name="tempDob"
                           placeholder="Enter the Applicant contactNumber here">
                </div>

                <div class="form-group">

                        Gender: <input name="tempGender"
                                       type="radio"
                                       value="MALE">Male
                                <input name="tempGender"
                                       type="radio"
                                       value="FEMALE">Female
                </div>

                <div class="form-group">

                        Degree: <select name="tempDegree" >
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
                           placeholder="Total Experience in Years"
                           class="form-control">
                </div>
                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/applicant"
                       class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
