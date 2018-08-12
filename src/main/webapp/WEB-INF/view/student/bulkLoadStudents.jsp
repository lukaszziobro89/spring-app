<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Load students</title>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
</head>
<body>
<br>
File to upload needs to be in txt format with list of details separated by comma ',':<br>
Name,Surname,Email<br><br>
Example:<br>
Amalle,Prattin,aprattin0@comsenz.com<br>
Umberto,Tunnoch,utunnoch1@aboutads.info<br>
Britni,Bunworth,bbunworth2@cdc.gov<br>
<br>

<h2>
Select file to upload: <br />
</h2>
<form:form method="POST" action="bulkAddStudents" enctype="multipart/form-data" cssClass="center_align">
<table>
<tr>
<td>
    <label path="file">Select a file to upload</label>
</td>
<td>
    <form class="center_align">
        <input type="file" name="file" class="btn success"/>
    </form>
</td>
</tr>
<tr>
<td>
    <form class="center_align">
        <input type="submit" value="Submit" class="btn success"/>
    </form>
</td>
</tr>
</table>
</form:form>

</body>
</html>
