<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<br><br>
<h2>17/07/2018</h2>
<br><br>

<h2>
    Welcome to Web Spring App!
</h2>
<p style="text-align:center;">
    <img src="${pageContext.request.contextPath}/resources/images/spring_logo.png"/>
</p>

<form action="showForm"><input type="submit" class="btn success" value="Various"/></form>

<p style="text-align:center;">
    <input type="submit" onclick="doSomeWork()" value="Simple alert"/>
</p>
<p style="text-align:center;">
    <input type="submit" onclick="printTime()" value="Get time"/>
</p>

</body>
</html>
