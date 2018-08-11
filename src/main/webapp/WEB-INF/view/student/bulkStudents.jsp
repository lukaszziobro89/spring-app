<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bulk confirmation</title>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
</head>
<body>

<table id="results" border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="tempStudent" items="${theStudent}" >
        <tr>
            <td>${tempStudent.firstName}</td>
            <td>${tempStudent.lastName}</td>
            <td>${tempStudent.email}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
