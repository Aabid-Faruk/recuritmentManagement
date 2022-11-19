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

            <h1 class="text-center mb-3">Fill the Recruiter details</h1>

            <form action="handleRecruiter"  method="post">

                <div class="form-group">
                    <input type="text"
                           class="form-control"
                           name="name"
                           placeholder="Enter the Recruiter name here">
                </div>
                <div class="form-group">
                    <input type="email"
                           class="form-control"
                           name="email"
                           placeholder="Enter the Recruiter email here">
                </div>
                <div class="form-group">
                    <input type="text"
                           class="form-control"
                           name="contactNumber"
                           placeholder="Enter the Recruiter contactNumber here">
                </div>
                <div class="form-group">
                    <input type="date"
                           class="form-control"
                           name="tempDob"
                           placeholder="Enter the Recruiter contactNumber here">
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
                    <input name="experience"
                           type="number"
                           placeholder="Total Experience in Years"
                           class="form-control">
                </div>
                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/recruiter"
                       class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-primary">Add</button>
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
