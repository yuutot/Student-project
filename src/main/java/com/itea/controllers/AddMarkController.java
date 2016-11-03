package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddMarkController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/addMark", method = RequestMethod.GET)
    public String addMark(Model model,
                          @RequestParam(value = "student") String st,
                          HttpServletRequest req){
        Student student;
        try {
            student = dao.findStudent(Integer.parseInt(st));
        }
        catch (NumberFormatException e){
            return "error";
        }
        model.addAttribute("student",student);
        HttpSession session = req.getSession();
        Teacher user = (Teacher) session.getAttribute("user");
        model.addAttribute("teacher", user);
        List<Lesson> lessons = dao.getLessonsByTeacher(user.getId(), student.getGroup().getNumber());
        model.addAttribute("lessons",lessons);
        return "addMark";
    }

    @RequestMapping(value = "/handlerAddMark", method = RequestMethod.POST)
    public String addMarkHandler(@RequestParam(value = "idStudent") String id,
                                  @RequestParam(value = "lesson") String less,
                                  @RequestParam(value = "teacher") String teach,
                                  @RequestParam(value = "Mark") String rMark,
                                  @RequestParam(value = "Date") String rDate){
        Student student = dao.findStudent(Integer.parseInt(id));
        Teacher teacher = dao.findTeacher(Integer.parseInt(teach));
        Lesson lesson = dao.findLesson(Integer.parseInt(less));
        Integer mark = Integer.parseInt(rMark);
        Integer date = Integer.parseInt(rDate);
        List<Lesson> lessons = dao.getLessonsByGroup(student.getGroup().getNumber());
        if(lessons.contains(lesson)) {
            Mark mark1 = new Mark();
            mark1.setStudent(student);
            mark1.setTeacher(teacher);
            mark1.setMark(mark);
            mark1.setLesson(lesson);
            mark1.setDate(date);
            dao.insertMark(mark1);
            return "redirect:home";
        }
        else{
            return "error";

        }
    }
}
