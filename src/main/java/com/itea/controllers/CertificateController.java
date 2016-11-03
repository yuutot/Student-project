package com.itea.controllers;

import com.itea.dao.EntityDao;
import com.itea.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CertificateController {

    @Autowired
    private EntityDao dao;

    @RequestMapping(value = "/createCertificate", method = RequestMethod.POST)
    public String createCertificatePost(@RequestParam(value = "student", required = false) String id,
                                        HttpServletRequest req,
                                        Model model){
        return createCertificate(id,req,model);
    }

    @RequestMapping(value = "/createCertificate", method = RequestMethod.GET)
    public String createCertificate(@RequestParam(value = "student", required = false) String id,
                                    HttpServletRequest req,
                                    Model model){
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user instanceof Student) {
            id = String.valueOf(((Student) user).getId());
        }
        Student student;
        try {
            student = dao.findStudent(Integer.parseInt(id));
        }
        catch (NumberFormatException e){
            return "error";
        }
        if (student == null) {
            return "error";
        } else {
            model.addAttribute("student", student);
            return "certificate";
        }
    }
}
