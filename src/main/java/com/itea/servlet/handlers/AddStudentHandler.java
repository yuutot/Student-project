package com.itea.servlet.handlers;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Student;
import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/handlerAddStudent")
public class AddStudentHandler extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        String name = req.getParameter("StudentName");
        String surname = req.getParameter("StudentSurname");
        Integer phone = Integer.parseInt(req.getParameter("StudentPhone"));
        String email = req.getParameter("StudentEmail");
        String password = req.getParameter("StudentPassword");
        Integer tickets = Integer.parseInt(req.getParameter("StudentTickets"));
        Group group = dao.findGroup(Integer.parseInt(req.getParameter("group")));
        student.setEmail(email);
        student.setName(name);
        student.setSurname(surname);
        student.setGroup(group);
        student.setNumber(phone);
        student.setTickets(tickets);
        student.setPassword(password);
        dao.insertStudent(student);
        req.getRequestDispatcher("/home").forward(req,resp);
    }
}
