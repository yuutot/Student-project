<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>
<a class="links" href="addGroup">Add Group</a>
<a class="links" href="addTeacher">Add Teacher</a>
<a class="links" href="addStudent">Add Student</a>
<a class="links" href="addLesson">Add Lesson</a>
<a class="links" href="logoutHandler">Logout</a>
<div style="clear: both"></div>
<c:forEach var="i" begin="0" end="${groups.size()-1}">
<details>
    <summary>
         Group: ${groups.get(i).getNumber()}
    </summary>
    <c:forEach items="${students.get(i)}" var="student">
    <a href="student?id=${student.getId()}">
            ${student.getSurname()}
            <c:out value="${student.getName()}"/></a>
    <p>
        </c:forEach>
</details>



    </c:forEach>
</body>
</html>