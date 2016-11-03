package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddTeacherController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addTeacher(){
        return "addTeacher";
    }

    @RequestMapping(value = "/handlerAddTeacher", method = RequestMethod.POST)
    public String addTeacherHandler(@RequestParam(value = "TeacherName") String name,
                                  @RequestParam(value = "TeacherSurname") String surname,
                                  @RequestParam(value = "TeacherPhone") String phone,
                                  @RequestParam(value = "TeacherEmail") String email,
                                  @RequestParam(value = "TeacherPassword") String password){
        Teacher teacher = new Teacher();
        teacher.setEmail(email);
        teacher.setPhone(phone);
        teacher.setName(name);
        teacher.setSurname(surname);
        teacher.setPassword(password);
        dao.insertTeacher(teacher);
        return "redirect:home";
    }
}
