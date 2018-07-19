<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>User Page</title>
    <style>
        .error {color:red}
    </style>
</head>
<body>

<form:form action="processStudent" modelAttribute="student" method="get">
    Id: <form:input path="id"/>
    <form:errors path="id" cssClass="error"/>
    <br><br>
    First name: <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Email: <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
