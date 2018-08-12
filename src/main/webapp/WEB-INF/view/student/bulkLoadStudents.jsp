<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Load students</title>
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
</head>
<br>
File to upload needs to be in txt format with list of details separated by comma ',':<br>
Name,Surname,Email<br><br>
Example:<br>
Amalle,Prattin,aprattin0@comsenz.com<br>
Umberto,Tunnoch,utunnoch1@aboutads.info<br>
Britni,Bunworth,bbunworth2@cdc.gov<br>
<br>
<h2>
    Upload file:
    <form:form method="POST" action="bulkAddStudents" enctype="multipart/form-data" cssClass="center_align">
    <table>
        <tr align="center">
            <td align="center"><label path="file">Select a file to upload:</label></td>
            <td align="center"><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="Submit" class="btn success"/></td>
        </tr>
    </table>
    </form:form>
</h2>
<br><br>
<form class="left_align" action="showStudents" method="get"><input type="submit" class="btn success" value="Show students list"/></form>
<form class="left_align" action="<%=request.getContextPath() %>/"><input type="submit" class="btn success" value="Home page"/></form>

</body>
</html>
