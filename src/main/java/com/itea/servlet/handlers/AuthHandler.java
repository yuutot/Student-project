package com.itea.servlet.handlers;

import com.itea.dao.EntityDao;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/authHandler")
public class AuthHandler extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("Email");
        String password = req.getParameter("Password");
        Integer post = Integer.parseInt(req.getParameter("Post"));
        HttpSession session = req.getSession();
        if(post == 1){
            Student student = dao.getStudentByPassword(email,password);
            if(student == null){
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }else {
                session.setAttribute("user", student);
                req.getRequestDispatcher("/student").forward(req, resp);
            }
        }
        else if(post == 2){
            Teacher teacher = dao.getTeacherByPassword(email,password);
            if(teacher== null){
                req.getRequestDispatcher("/error.jsp").forward(req, resp);
            }else {
                session.setAttribute("user", teacher);
                req.getRequestDispatcher("/home").forward(req, resp);
            }
        }
    }

}
