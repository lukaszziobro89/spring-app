<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Load students</title>
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
<form:form method="POST" action="bulkAddStudents" enctype="multipart/form-data" cssClass="btn success">
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
