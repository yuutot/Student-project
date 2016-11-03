package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Lesson;
import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddLessonController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/addLesson", method = RequestMethod.GET)
    public String addLesson(Model model){
        List<Group> listOfGroup = dao.getAllGroups();
        model.addAttribute("groups", listOfGroup);
        List<Teacher> teachers = dao.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "addLesson";
    }

    @RequestMapping(value = "/handlerAddLesson", method = RequestMethod.POST)
    public String addLessonHandler(@RequestParam(value = "LessonTitle") String title,
                                  @RequestParam(value = "LessonRoom") String room,
                                  @RequestParam(value = "teacher") String teach,
                                  @RequestParam(value = "group") String gr){
        Teacher teacher = dao.findTeacher(Integer.parseInt(teach));
        Group group = dao.findGroup(Integer.parseInt(gr));
        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        lesson.setTeacher(teacher);
        lesson.setGroup(group);
        lesson.setRoom(room);
        dao.insertLesson(lesson);
        return "redirect:home";
    }
}
