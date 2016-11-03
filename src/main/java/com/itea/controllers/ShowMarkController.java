package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Lesson;
import com.itea.entity.Mark;
import com.itea.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowMarkController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/showMark", method = RequestMethod.GET)
    public String createCertificate(@RequestParam(value = "student", required = false) String studentId, HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user instanceof Student){
            studentId = String.valueOf(((Student) user).getId());
        }
        Student student;
        try {
            student = dao.findStudent(Integer.parseInt(studentId));
        }
        catch (NumberFormatException e){
            return "error";
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
        model.addAttribute("lessons", lessons);
        model.addAttribute("student", student);
        model.addAttribute("marks", marks);
        model.addAttribute("avg", avgMark);
        model.addAttribute("avgMark", avgMarkForAll);
        return "showMark";
    }
    private double toSystem(double f){
        if(f < 2.5) return 0;
        else if(f < 3.5) return 60+(f-2.5)*15;
        else if(f < 4.5) return 75+(f-3.5)*15;
        else if(f <= 5) return 90+(f-4.5)*20;
        return 0;
    }
}
