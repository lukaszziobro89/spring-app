<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <c:forEach var="correctStudent" items="${student}" >
            <c:url var="updateButton" value="showUpdateForm">
                <c:param name="studentId" value="${correctStudent.id}"/>
            </c:url>

            <c:url var="deleteButton" value="delete">
                <c:param name="studentId" value="${correctStudent.id}"/>
            </c:url>

            <tr>
                <td>${correctStudent.id}</td>
                <td>${correctStudent.firstName}</td>
                <td>${correctStudent.lastName}</td>
                <td>${correctStudent.email}</td>
                <td style="width:20%">
                    <form class="buttons">
                        <a href="${updateButton}"><button type="button" class="btn info">Update student</button></a>
                        <a href="${deleteButton}"
                           onclick="if (!confirm('Are you sure you want to delete student?')){return false}">
                            <button type="button" class="btn danger">Delete student</button>
                        </a>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

<br><br>
    <form class="left_align" action="addStudent" method="post"><input type="submit" class="btn success" value="Add Student"/></form>
    <form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
