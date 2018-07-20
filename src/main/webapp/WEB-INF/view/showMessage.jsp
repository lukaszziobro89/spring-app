<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <link rel="icon" type="image/png" href="resources/spring_icon.png" sizes="32x32">
    <title>Hello User</title>
</head>
<body>
<h2>
    Another method:
</h2>
<br><br>

    <p>
        ${message}
    </p>

    <br><br><br>

<br><br><br>
<form action="showForm"><input type="submit" class="btn success" value="Back"/></form>
<form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
