<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Mark</title>
</head>
<body>
<p>Add mark for ${student.getName()} ${student.getSurname()}
<form action="handlerAddMark" method="post">
<p>Select lesson: <select name="lesson">
    <c:forEach items="${lessons}" var="lesson">
        <option value="${lesson.getId()}">${lesson.getTitle()}</option>
    </c:forEach>
</select>
    <p>Mark: <input type="text" name="Mark">
    <p>Date: <input type="text" name="Date">
    <input type="hidden" name="idStudent" value="${student.getId()}">
    <input type="hidden" name="teacher" value="${teacher.getId()}"/>
    <p><input type="submit"></p>
</form>
</body>
</html>