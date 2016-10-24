<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<form action="handlerAddStudent" method="post">
    <p>Name: <input type="text" name="StudentName">
    <p>Surname: <input type="text" name="StudentSurname">
    <p>Phone: <input type="text" name="StudentPhone">
    <p>Email: <input type="text" name="StudentEmail">
    <p>Password: <input type="password" name="StudentPassword">
    <p>Tickets: <input type="text" name="StudentTickets">
    <p>Select group: <select name="group">
        <c:forEach items="${groups}" var="group">
            <option>${group.getNumber()}</option>
        </c:forEach>
    </select>
    <p><input type="submit"></p>
</form>
</body>
</html>