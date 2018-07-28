<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <%--<c:forEach var="tempStudent" items="${student}" >--%>

            <%--<c:url var="updateButton" value="/student/showUpdateForm"/>--%>
                <%--<c:param name="id" value="${tempStudent.id}"/>--%>
            <%--<c:url/>--%>
            <%----%>

            <%----%>
            <%--<tr>--%>
                <%--<td>${tempStudent.id}</td>--%>
                <%--<td>${tempStudent.firstName}</td>--%>
                <%--<td>${tempStudent.lastName}</td>--%>
                <%--<td>${tempStudent.email}</td>--%>
                <%--<td>--%>
                    <%--&lt;%&ndash;<form class="right_align" action="${updateButton}" method="get"><input type="submit" class="btn success" value="Update student"/></form>&ndash;%&gt;--%>
                        <%--<a href="${updateButton}">Update</a>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>

        <c:forEach var="tempStudent" items="${student}">

            <!-- construct an "update" link with customer id -->
            <c:url var="updateButton" value="/student/showUpdateForm">
                <c:param name="id" value="${tempStudent.id}" />
            </c:url>

            <tr>
                <td>${tempStudent.id}</td>
                <td>${tempStudent.firstName}</td>
                <td>${tempStudent.lastName}</td>
                <td>${tempStudent.email}</td>
                <td>
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


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- put new button: Add Customer -->

        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />

        <!--  add our html table here -->

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempCustomer" items="${customers}">

                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}" />
                </c:url>

                <tr>
                    <td> ${tempCustomer.firstName} </td>
                    <td> ${tempCustomer.lastName} </td>
                    <td> ${tempCustomer.email} </td>

                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Update</a>
                    </td>

                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>









