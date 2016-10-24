package com.itea.servlet;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Student;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/home")
public class MainServlet extends HttpServlet {

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
        List<Group> listOfGroup = dao.getAllGroups();
        List<List<Student>> listofStudent = listOfGroup.stream().map(group -> dao.getStudentByGroup(group.getNumber())).collect(Collectors.toList());
        req.setAttribute("groups", listOfGroup);
        req.setAttribute("students", listofStudent);
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").include(req, resp);
    }
}