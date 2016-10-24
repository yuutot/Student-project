package com.itea.servlet.handlers;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Lesson;
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

@WebServlet("/handlerAddLesson")
public class AddLessonHandler extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("LessonTitle");
        String room = req.getParameter("LessonRoom");
        Teacher teacher = dao.findTeacher(Integer.parseInt(req.getParameter("teacher")));
        Group group = dao.findGroup(Integer.parseInt(req.getParameter("group")));
        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        lesson.setTeacher(teacher);
        lesson.setGroup(group);
        lesson.setRoom(room);
        dao.insertLesson(lesson);
        req.getRequestDispatcher("/home").forward(req,resp);
    }
}
