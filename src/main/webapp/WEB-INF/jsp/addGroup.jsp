<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Group</title>
</head>
<body>
<form action="handlerAddGroup" method="post">
    <p>Input number of group: <input type="text" name="GroupNumber">
    <p>Select curator: <select name="curator">
        <c:forEach items="${teachers}" var="teacher">
            <option value="${teacher.getId()}">${teacher.getName()} ${teacher.getSurname()}</option>
        </c:forEach>
    </select>
    <p><input type="submit"></p>
</form>
</body>
</html>