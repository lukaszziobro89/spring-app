<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
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
<form action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Back"/></form>

</body>
</html>
