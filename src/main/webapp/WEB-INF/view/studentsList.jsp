<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">

    <title>Students list</title>
    <link rel="icon" type="image/png" href="resources/spring_icon.png" sizes="32x32">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">

    <%--<style>--%>
        <%--#results {--%>
            <%--font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;--%>
            <%--border-collapse: collapse;--%>
            <%--width: 100%;--%>
        <%--}--%>

        <%--#results td, #results th {--%>
            <%--border: 1px solid #ddd;--%>
            <%--padding: 8px;--%>
        <%--}--%>

        <%--#results tr:nth-child(even){background-color: #f2f2f2;}--%>

        <%--#results tr:hover {background-color: #ddd;}--%>

        <%--#results th {--%>
            <%--padding-top: 12px;--%>
            <%--padding-bottom: 12px;--%>
            <%--text-align: left;--%>
            <%--background-color: #4CAF50;--%>
            <%--color: white;--%>
        <%--}--%>

    <%--</style>--%>
</head>
<body>

    <h2>Students list</h2>

    <table id="results" border="1" cellpadding="5" cellspacing="1" >
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
        <c:forEach items="${studentsLists}" var="student" >
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
    </table>

<br><br>
    <form action="addStudent"><input type="submit" class="btn success" value="Back"/></form>
    <form action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
