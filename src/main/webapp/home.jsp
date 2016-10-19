<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<c:forEach var="i" begin="0" end="${groups.size()-1}">
<h2><c:out value="Group: ${groups.get(i).getNumber()}"/></h2><p>
<c:out value="Student list"/><p>
    <c:forEach items="${students.get(i)}" var="student">
    <a href="student?id=${student.getId()}">
        <c:out value="${student.getSurname()} "/>
        <c:out value="${student.getName()}"/></a><p>
    </c:forEach>
    </c:forEach>
</body>
</html>