<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student: ${student.getSurname()} ${student.getName()}</title>
</head>
<body>
Surname: ${student.getSurname()}<p>
    Name: ${student.getName()}<p>
    Tickets: ${student.getTickets()}<p>
    Group: ${student.getGroup().getNumber()}<p>
    Phone: ${student.getNumber()}<p>
    Email: ${student.getEmail()}

</body>
</html>