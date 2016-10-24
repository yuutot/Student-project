<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Teacher</title>
</head>
<body>
<form action="handlerAddTeacher" method="post">
    <p>Name: <input type="text" name="TeacherName">
    <p>Surname: <input type="text" name="TeacherSurname">
    <p>Phone: <input type="text" name="TeacherPhone">
    <p>Email: <input type="text" name="TeacherEmail">
    <p>Password: <input type="password" name="TeacherPassword">
    <p><input type="submit"></p>
</form>
</body>
</html>