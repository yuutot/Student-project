<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.itea.entity.Teacher" %>
<%@ page import="com.itea.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student: ${student.getSurname()} ${student.getName()}</title>
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
</head>
<body>
<div style="clear: both"></div>
<div class="wrap">
    <br>
    <span class="title">Surname:</span><span class="val">${student.getSurname()}</span> <br>
    <span class="title">Name:</span><span class="val">${student.getName()}</span> <br>
    <span class="title">Tickets: </span><span class="val"> ${student.getTickets()}</span><br>
    <span class="title">Group:</span> <span class="val">${student.getGroup().getNumber()}</span> <br>
    <span class="title">Phone:</span><span class="val"> ${student.getNumber()}</span> <br>
    <span class="title">Email:</span><span class="val">${student.getEmail()}</span>
</div>

    <%
        String id = request.getParameter("id");
        Object user = session.getAttribute("user");
        if(user instanceof Teacher){
            response.getWriter().print("<a class=\"links\" href=\"addMark?student="+ id +"\">Add Mark</a><p>");
        }else{
            id = String.valueOf(((Student)user).getId());
        }
        response.getWriter().print("<a class=\"links\" href=\"showMark?student="+ id +"\">Show Mark</a><p>");
        response.getWriter().print("<a class=\"links last\" href=\"createCertificate?student="+ id +"\">Create Certificate</a><p>");
        response.getWriter().print("<a class=\"links\" href=\"logoutHandler\">Logout</a><p>");
    %>
</body>
</html>