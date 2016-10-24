package com.itea.servlet;

import com.itea.dao.EntityDao;
import com.itea.entity.Lesson;
import com.itea.entity.Mark;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showMark")
public class ShowMarkServlet extends HttpServlet {

    @Autowired
    private EntityDao dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("student");
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user instanceof Student){
            studentId = String.valueOf(((Student) user).getId());
        }
        Student student =new Student();
        try {
            student = dao.findStudent(Integer.parseInt(studentId));
        }
        catch (NumberFormatException e){
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        List<Lesson> lessons = dao.getLessonsByGroup(student.getGroup().getNumber());
        List<List<Mark>> marks = new ArrayList<>();
        List<Integer> avgMark = new ArrayList<>();
        double avgMarkForAll = 0.0;
        int count = 0;
        for(Lesson l:lessons){
            List<Mark> markList = dao.getMarksByStudent(student.getId(),l.getId());
            double avg = 0.0;
            for(Mark m:markList){
                avg+=m.getMark();
            }
            avg = avg/markList.size();
            if(!Double.isNaN(avg)) {
                avgMarkForAll += avg;
                count++;
            }
            avgMark.add((int)toSystem(avg));
            marks.add(markList);
        }
        avgMarkForAll = avgMarkForAll/count;
        req.setAttribute("lessons", lessons);
        req.setAttribute("student", student);
        req.setAttribute("marks", marks);
        req.setAttribute("avg", avgMark);
        req.setAttribute("avgMark", avgMarkForAll);
        req.getRequestDispatcher("/WEB-INF/jsp/showMark.jsp").include(req, resp);
    }
    double toSystem(double f){
        if(f < 2.5) return 0;
        else if(f < 3.5) return 60+(f-2.5)*15;
        else if(f < 4.5) return 75+(f-3.5)*15;
        else if(f <= 5) return 90+(f-4.5)*20;
        return 0;
    }
}
