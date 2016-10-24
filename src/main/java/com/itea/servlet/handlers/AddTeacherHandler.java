package com.itea.servlet.handlers;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
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

@WebServlet("/handlerAddTeacher")
public class AddTeacherHandler extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = new Teacher();
        String name = req.getParameter("TeacherName");
        String surname = req.getParameter("TeacherSurname");
        String phone = req.getParameter("TeacherPhone");
        String email = req.getParameter("TeacherEmail");
        String password = req.getParameter("TeacherPassword");
        teacher.setEmail(email);
        teacher.setPhone(phone);
        teacher.setName(name);
        teacher.setSurname(surname);
        teacher.setPassword(password);
        dao.insertTeacher(teacher);
        req.getRequestDispatcher("/home").forward(req,resp);
    }
}
