package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Student;
import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String auth() {
        return "auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String authPost() {
        return auth();
    }

    @RequestMapping(value = "/authHandler", method = RequestMethod.POST, params = "UserType=1")
    public String studentAuth(@ModelAttribute Student student,
                              HttpServletRequest req) {
        HttpSession session = req.getSession();
        student = dao.getStudentByPassword(student.getEmail(), student.getPassword());
        if (student == null) {
            return "error";
        } else {
            session.setAttribute("user", student);
            return "redirect:student";
        }
    }

    @RequestMapping(value = "/authHandler", method = RequestMethod.POST, params = "UserType=2")
    public String teacherAuth(@ModelAttribute Teacher teacher,
                              HttpServletRequest req) {
        HttpSession session = req.getSession();
        teacher = dao.getTeacherByPassword(teacher.getEmail(), teacher.getPassword());
        if (teacher == null) {
            return "error";
        } else {
            session.setAttribute("user", teacher);
            return "redirect:home";
        }
    }

    @RequestMapping(value = "/logoutHandler", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        return "auth";
    }
}
