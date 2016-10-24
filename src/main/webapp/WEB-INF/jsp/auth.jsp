<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing In</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
<form action="authHandler" method="post">
    <input placeholder="E-mail" class="input" type="text" name="Email">
    <input placeholder="Password" class="input last" type="password" name="Password">
    <p>Select your post:
    <p><input type="radio" value="1" name="Post">Student</p>
    <p><input type="radio" value="2" name="Post">Teacher</p>
    <p><input type="submit"></p>
</form>
</body>
</html>
