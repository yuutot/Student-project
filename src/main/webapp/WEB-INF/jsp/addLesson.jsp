<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Lesson</title>
</head>
<body>
<form action="handlerAddLesson" method="post">
    <p>Title: <input type="text" name="LessonTitle">
    <p>Room: <input type="text" name="LessonRoom">
    <p>Select teacher: <select name="teacher">
        <c:forEach items="${teachers}" var="teacher">
            <option value="${teacher.getId()}">${teacher.getName()} ${teacher.getSurname()}</option>
        </c:forEach>
    </select>
    <p>Select group: <select name="group">
        <c:forEach items="${groups}" var="group">
            <option>${group.getNumber()}</option>
        </c:forEach>
    </select>
    <p><input type="submit"></p>
</form>
</body>
</html>