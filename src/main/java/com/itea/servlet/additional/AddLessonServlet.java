package com.itea.servlet.additional;

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
import java.util.List;

@WebServlet("/addLesson")
public class AddLessonServlet extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<Group> listOfGroup = dao.getAllGroups();
        req.setAttribute("groups", listOfGroup);
        List<Teacher> teachers = dao.getAllTeachers();
        req.setAttribute("teachers", teachers);
        req.getRequestDispatcher("/WEB-INF/jsp/addLesson.jsp").include(req, resp);
    }
}
