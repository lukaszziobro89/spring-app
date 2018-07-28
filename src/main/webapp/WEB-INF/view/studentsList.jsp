<jsp root version = "1.2"
     xmlns="http://www.w3.org/1999/xhtml"
     xmlns: jsp = "http://java.sun.com/JSP/Page"
     xmlns: cms = "urn: jsptld: cms-taglib"
     xmlns: cmsu = "urn: jsptld: cms-util-taglib"
     xmlns: c = "urn: jsptld: http: //java.sun.com/jsp/jstl/core">

<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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

            <c:url var="updateButton" value="/student/showUpdateForm"/>
                <c:param name="id" value="${tempStudent.id}"/>
            <c:url/>

            <tr>
                <td>${tempStudent.id}</td>
                <td>${tempStudent.firstName}</td>
                <td>${tempStudent.lastName}</td>
                <td>${tempStudent.email}</td>
                <td>
                    <%--<form class="right_align" action="${updateButton}" method="get"><input type="submit" class="btn success" value="Update student"/></form>--%>
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