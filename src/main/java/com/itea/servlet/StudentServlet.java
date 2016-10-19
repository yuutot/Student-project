package com.itea.servlet;

import com.itea.dao.EntityDao;
import com.itea.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        EntityDao dao = context.getBean(EntityDao.class);
        resp.setContentType("text/html");
        Integer id = Integer.parseInt(req.getParameter("id"));
        Student student = dao.getStudent(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("dataStudent.jsp").include(req,resp);
    }
}
