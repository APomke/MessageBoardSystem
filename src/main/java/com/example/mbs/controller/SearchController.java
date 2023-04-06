package com.example.mbs.controller;

import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.MessageServiceImpl;
import com.example.mbs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/message/search")
    public String search(String text, Model model){
        System.out.println("获取到要搜索的标题是：" + text);
        //通过标题获取留言
        Message message = messageService.queryMessageByTitle(text);
        //根据用户id获取用户头像
        User userId = userService.getUserById(message.getMasterId());
        if (userId != null) {
            message.setImagePath(userId.getAvatarUrl());
        }
        model.addAttribute("message",message);
        return "search";
    }
}
