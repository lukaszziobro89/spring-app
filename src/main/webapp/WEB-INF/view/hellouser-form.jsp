<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Hello User Page</title>
</head>
<body>

<form action="processUserForm" method="GET">
    <input type="text" name="userName" placeholder="What's your name?"/>
    <input type="submit" value="Submit Answer">
</form>
<br><br>

<form action="processUserFormUpperCase" method="GET">
    <input type="text" name="userName" placeholder="What's your name?"/>
    <input type="submit" value="Submit Answer (upper case)">
</form>

<br><br>

<form action="showDayName" method="get">
    <input type="number" name="weekNumber" placeholder="Put weekday number"/>
    <input type="submit" value="Show weekday name"/>
</form>

<br><br><br>
<a href="<%=request.getContextPath() %>/">Back to home page</a>

</body>
</html>
