<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sing In</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>
<form action="/login" method="post">
    <input placeholder="E-mail" class="input" type="text" name="username" id="username">
    <input placeholder="Password" class="input last" type="password" name="password" id ="password">
    <p>Select your post:
    <p><input type="radio" value="1" name="UserType">Student</p>
    <p><input type="radio" value="2" name="UserType">Teacher</p>
    <p><input type="submit"></p>
</form>
</body>
</html>
