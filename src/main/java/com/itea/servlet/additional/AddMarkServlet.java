package com.itea.servlet.additional;

import com.itea.dao.EntityDao;
import com.itea.entity.Lesson;
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
import java.util.List;

@WebServlet("/addMark")
public class AddMarkServlet extends HttpServlet {

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
        Student student =new Student();
        try {
            student = dao.findStudent(Integer.parseInt(req.getParameter("student")));
        }
        catch (NumberFormatException e){
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
        req.setAttribute("student",student);
        HttpSession session = req.getSession();
        Teacher user = (Teacher) session.getAttribute("user");
        req.setAttribute("teacher", user);
        List<Lesson> lessons = dao.getLessonsByTeacher(user.getId(), student.getGroup().getNumber());
        req.setAttribute("lessons",lessons);
        req.getRequestDispatcher("/WEB-INF/jsp/addMark.jsp").include(req, resp);
    }
}
