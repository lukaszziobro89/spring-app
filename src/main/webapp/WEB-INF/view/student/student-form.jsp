<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <title>Student Page</title>
</head>
<body>

<form:form action="processStudent" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Email: <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
    <br><br>
    <form class="left_align"><input type="submit" class="btn success" value="Submit"></form>
</form:form>

<br><br><br>

<form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
