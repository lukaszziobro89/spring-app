<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <link rel="icon" type="image/png" href="resources/spring_icon.png" sizes="32x32">
    <title>Hello User</title>

</head>
<body>
    Hello World!
<br><br>
<p>
Student name: ${param.userName}
</p>
    <br><br><br>

    <form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>


</body>
</html>
