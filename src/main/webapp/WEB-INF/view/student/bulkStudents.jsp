<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bulk confirmation</title>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
</head>
<body>
<h2>
    List of uploaded students:
</h2>
<table id="results" border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="correctStudent" items="${correctEntries}" >
        <tr>
            <td>${correctStudent.firstName}</td>
            <td>${correctStudent.lastName}</td>
            <td>${correctStudent.email}</td>
        </tr>
    </c:forEach>
</table>
<br><br>
<h2>
    List of incorrect entries:
</h2>
<table id="results" border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Incorrect entries</th>
    </tr>
    <c:forEach var="incorrectStudent" items="${incorrectEntries}" >
        <tr>
            <td>${incorrectStudent}</td>
        </tr>
    </c:forEach>
</table>

<br><br>
<form class="left_align" action="showStudents" method="get"><input type="submit" class="btn success" value="Show students list"/></form>
<form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>


</body>
</html>
