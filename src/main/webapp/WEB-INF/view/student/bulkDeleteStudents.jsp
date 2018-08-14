<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete students</title>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
</head>
<body>
<br>
File to upload needs to be in txt format with list of integer IDs - each one in separate line:<br>
<br>
<b>Example:</b><br>
1<br>
12<br>
22<br>
<br>
<br>
<h2>Example IDs file to upload:</h2><br>
<p>
    <a href="${pageContext.request.contextPath}/resources/ids_list.txt" download >
        <img class="center_align" border="0" src="${pageContext.request.contextPath}/resources/file_icon.png" width="100" height="100">
    </a>
</p>
<br>
<h2>
    Upload file:
</h2>
<form:form method="POST" action="bulkStudentsDelete" enctype="multipart/form-data" cssClass="center_align">
    <input type="file" name="file" class="btn success"/><br><br>
    <input type="submit" value="Submit" class="btn success"/>
</form:form>

<br><br>
<form class="left_align" action="showStudents" method="get"><input type="submit" class="btn success" value="Show students list"/></form>
<form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
