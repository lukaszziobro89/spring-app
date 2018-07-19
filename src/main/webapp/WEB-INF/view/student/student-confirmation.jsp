<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Student Confirmation</title>
</head>
<body>

<h2>
    Student added to database!
</h2>
<br>
ID: ${student.id}
<br>
First name: ${firstName}
<br>
Last name: ${lastName}
<br>
Email: ${email}


</body>
</html>
