<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <title>Student Confirmation</title>
</head>
<body>

<h2>
    Student correctly added to database!
</h2>

<br>
First name: ${firstName}
<br>
Last name: ${lastName}
<br>
Email: ${email}

</body>
</html>
