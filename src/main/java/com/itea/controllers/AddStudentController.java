package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddStudentController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(Model model){
        List<Group> listOfGroup = dao.getAllGroups();
        model.addAttribute("groups", listOfGroup);
        return "addStudent";
    }

    @RequestMapping(value = "/handlerAddStudent", method = RequestMethod.POST)
    public String addStudentHandler(@RequestParam(value = "StudentName") String name,
                                  @RequestParam(value = "StudentSurname") String surname,
                                  @RequestParam(value = "StudentPhone") String stPhone,
                                  @RequestParam(value = "StudentEmail") String email,
                                  @RequestParam(value = "StudentPassword") String password,
                                  @RequestParam(value = "StudentTickets") String stTickets,
                                  @RequestParam(value = "group") String stGroup){
        Student student = new Student();
        Integer phone = Integer.parseInt(stPhone);
        Integer tickets = Integer.parseInt(stTickets);
        Group group = dao.findGroup(Integer.parseInt(stGroup));
        student.setEmail(email);
        student.setName(name);
        student.setSurname(surname);
        student.setGroup(group);
        student.setNumber(phone);
        student.setTickets(tickets);
        student.setPassword(password);
        dao.insertStudent(student);
        return "redirect:home";
    }
}
