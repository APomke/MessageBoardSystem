package com.example.mbs.controller;

import com.example.mbs.pojo.User;
import com.example.mbs.service.UserServiceImpl;
import com.example.mbs.utils.Constants;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PersonalController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/personal")
    public String personal(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);
        return "personal";
    }
}
