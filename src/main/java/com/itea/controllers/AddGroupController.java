package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Group;
import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddGroupController {

    @Autowired
    private EntityDao dao;


    @RequestMapping(value = "/addGroup", method = RequestMethod.GET)
    public String addGroup(Model model){
        List<Teacher> teachers = dao.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "addGroup";
    }

    @RequestMapping(value = "/handlerAddGroup", method = RequestMethod.POST)
    public String addGroupHandler(@RequestParam(value = "GroupNumber") String id,
                                  @RequestParam(value = "curator") String curator){
        Integer groupId = Integer.parseInt(id);
        Teacher teacher = dao.findTeacher(Integer.parseInt(curator));
        Group group = new Group();
        group.setNumber(groupId);
        group.setCurator(teacher);
        dao.insertGroup(group);
        return "redirect:home";
    }
}
