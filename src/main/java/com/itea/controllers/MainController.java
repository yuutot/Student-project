package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String mainPost(Model model){
        return main(model);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String main(Model model){
        List<Group> listOfGroup = dao.getAllGroups();
        List<List<Student>> listofStudent = listOfGroup.stream().map(group -> dao.getStudentByGroup(group.getNumber())).collect(Collectors.toList());
        model.addAttribute("groups", listOfGroup);
        model.addAttribute("students", listofStudent);
        return "home";
    }

}
