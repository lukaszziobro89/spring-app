<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
    <link rel="icon" type="image/png" href="resources/spring_icon.png" sizes="32x32">
</head>
<body>
<h2>
    Spring/Hibernate Web Application
</h2>
<p style="text-align:center;">
    <img src="${pageContext.request.contextPath}/resources/images/spring_logo.png"/>
    <img src="${pageContext.request.contextPath}/resources/images/hibernate_logo.png" height="150" width="450"/>
</p>

<form class="center_align" action="showForm"><input type="submit" crlass="btn success" value="Various"/></form>
<form class="center_align" action="addStudent"><input type="submit" class="btn success" value="Add student"/></form>
<%--<form class="center_align" action="showStudents"><input type="submit" class="btn success" value="Show students list"/></form>--%>
<form class="center_align" action="showStudents"><input type="submit" class="btn success" value="Show students list"/></form>

<p style="text-align:center;">
    <input type="submit" onclick="doSomeWork()" value="Simple alert"/>
</p>
<p style="text-align:center;">
    <input type="submit" onclick="printTime()" value="Get time"/>
</p>

</body>
</html>
