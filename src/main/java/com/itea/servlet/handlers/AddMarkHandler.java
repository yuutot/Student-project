package com.itea.servlet.handlers;

import com.itea.dao.EntityDao;
import com.itea.entity.*;
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

@WebServlet("/handlerAddMark")
public class AddMarkHandler extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = dao.findStudent(Integer.parseInt(req.getParameter("idStudent")));
        Teacher teacher = dao.findTeacher(Integer.parseInt(req.getParameter("teacher")));
        Lesson lesson = dao.findLesson(Integer.parseInt(req.getParameter("lesson")));
        Integer mark = Integer.parseInt(req.getParameter("Mark"));
        Integer date = Integer.parseInt(req.getParameter("Date"));
        List<Lesson> lessons = dao.getLessonsByGroup(student.getGroup().getNumber());
        if(lessons.contains(lesson)) {
            Mark mark1 = new Mark();
            mark1.setStudent(student);
            mark1.setTeacher(teacher);
            mark1.setMark(mark);
            mark1.setLesson(lesson);
            mark1.setDate(date);
            dao.insertMark(mark1);
            req.getRequestDispatcher("/home").forward(req, resp);
        }
        else{
            resp.getWriter().print("Error! Not found lesson in this group");

        }
    }
}
