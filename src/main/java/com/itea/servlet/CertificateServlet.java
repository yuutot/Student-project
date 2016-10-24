package com.itea.servlet;

import com.itea.dao.EntityDao;
import com.itea.entity.Student;
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
import java.io.PrintWriter;

@WebServlet("/createCertificate")
public class CertificateServlet extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("student");
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user instanceof Student) {
            id = String.valueOf(((Student) user).getId());
        }
        Student student =new Student();
        try {
            student = dao.findStudent(Integer.parseInt(id));
        }
        catch (NumberFormatException e){
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        if (student == null) {
            PrintWriter out = resp.getWriter();
            out.print("Incorrectly student ID");
        } else {
            req.setAttribute("student", student);
            req.getRequestDispatcher("/WEB-INF/jsp/certificate.jsp").include(req, resp);
        }
    }
}
