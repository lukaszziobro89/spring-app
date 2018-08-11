<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<form class="center_align" action="showForm"><input type="submit" class="btn success" value="Various"/></form>
<form class="center_align" action="addStudent" method="post"><input type="submit" class="btn success" value="Add student"/></form>
<form class="center_align" action="showStudents" method="get"><input type="submit" class="btn success" value="Show students list"/></form>
<br>
Select file: <br />
<form:form method="POST" action="loadFile" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label path="file">Select a file to upload</label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
<br>
<p style="text-align:center;">
    <input type="submit" onclick="doSomeWork()" value="Simple alert"/>
</p>
<p style="text-align:center;">
    <input type="submit" onclick="printTime()" value="Get time"/>
</p>

</body>
</html>
