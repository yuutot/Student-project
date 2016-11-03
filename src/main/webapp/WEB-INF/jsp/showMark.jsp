<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Show Mark</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>
<p>Show mark for <span class="title-t"> ${student.getName()} ${student.getSurname()} </span>Avg: ${avgMark}<p>
    <c:forEach var="i" begin="0" end="${lessons.size()-1}">
        <details>
        <summary>
            <div class="title-d">Lesson: </div>
            <div class="title-d">${lessons.get(i).getTitle()} </div>
            <div class="title-d">Avg: ${avg.get(i)}</div>
            <div style="clear: both"></div>
        </summary>
            <c:forEach items="${marks.get(i)}" var="mark">
        <p>Date: ${mark.getDate()} Mark: ${mark.getMark()}</p>
    </c:forEach>
<br>
    </details>
    </c:forEach>
</body>
</html>