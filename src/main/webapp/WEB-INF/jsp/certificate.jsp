<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Certificate</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>
<div class="recv">
    <p>National aviation university</p>
    <p>Komarova, 1, Kyiv, 03680</p>
</div>
<div class="card">
    <h1 style="text-align:center;">Reference</h1>
    <div class="cert">
        This reference was given to <span class="v">${student.getSurname()}  ${student.getName()}</span>,
    </div>
    <div class="cert">
        to confirm that he is a student group <span class="v">${student.getGroup().getNumber()}</span>
    </div>
    <div class="cert">
        Education on specialization 6.050103 "Software engineering".
    </div>
    <p class="date" style="font-size: 20px;"> Date: 26.10.2016 </p>
    <img class="print" src="http://superpechat.ru/images/article/esk/1.png" alt="">
</div>


</body>
</html>
