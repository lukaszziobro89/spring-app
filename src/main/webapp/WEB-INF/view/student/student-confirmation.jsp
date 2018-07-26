<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <title>Confirmation</title>
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

<br><br><br>
<form class="left_align" action="addStudent" method="post"><input type="submit" class="btn success" value="Add another student"/></form>
<form class="left_align" action="showStudents" method="get"><input type="submit" class="btn success" value="Show students list"/></form>
<form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
