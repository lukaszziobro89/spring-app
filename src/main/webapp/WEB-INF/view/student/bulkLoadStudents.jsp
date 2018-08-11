<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Load students</title>
</head>
<body>


Select file: <br />
<form:form method="POST" action="bulkStudents" enctype="multipart/form-data">
<table>
<tr>
<td><label path="file">Select a file to upload</label></td>
<td><input type="file" name="file" /></td>
</tr>
<tr>
<td><input type="submit" value="Submit" class="btn success"/></td>
</tr>
</table>
</form:form>

</body>
</html>
