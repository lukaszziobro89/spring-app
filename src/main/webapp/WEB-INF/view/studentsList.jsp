<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">

    <title>Students list</title>
    <link rel="icon" type="image/png" href="resources/spring_icon.png" sizes="32x32">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">

</head>
<body>

    <h2>Students list</h2>

    <table id="results" border="1" cellpadding="5" cellspacing="1" >
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach var="tempStudent" items="${student}" >

            <c:url var="updateButton" value="/student/showUpdateForm">
                <c:param name="studentId" value="${tempStudent.id}"/>
            </c:url>

            <tr>
                <td>${tempStudent.id}</td>
                <td>${tempStudent.firstName}</td>
                <td>${tempStudent.lastName}</td>
                <td>${tempStudent.email}</td>
                <td>
                    <sf:form class="left_align" action="${updateButton}"><input type="submit" class="btn info" value="Update student"/></sf:form>
                    <%--<form class="right_align" action="${updateButton}" method="get"><input type="submit" class="btn info" value="Delete student"/></form>--%>
                    <a href="${updateButton}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>

<br><br>
    <form class="left_align" action="addStudent" method="post"><input type="submit" class="btn success" value="Add Student"/></form>
    <form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
