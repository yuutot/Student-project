package com.itea.servlet;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Student;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class MainServlet extends HttpServlet {

   // @Autowired
   // private EntityDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        EntityDao dao = context.getBean(EntityDao.class);
        resp.setContentType("text/html");
        List<Group> listOfGroup = dao.getAllGroups();
        List<List<Student>> listofStudent = new ArrayList<>();
        for (Group group:listOfGroup) {
            listofStudent.add(dao.getStudentByGroup(group.getNumber()));
        }
        req.setAttribute("groups",listOfGroup);
        req.setAttribute("students", listofStudent);
        req.getRequestDispatcher("/home.jsp").include(req,resp);
    }
}
