package com.example.mbs.controller;

import com.example.mbs.pojo.BgImage;
import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.BgImageServiceImpl;
import com.example.mbs.service.MessageServiceImpl;
import com.example.mbs.service.UserServiceImpl;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BgImageServiceImpl bgImageService;

    @GetMapping("/message/search")
    public String search(String text, Model model, HttpServletRequest request){
        System.out.println("获取到要搜索的标题是：" + text);
        //通过标题获取留言
        Message message = messageService.queryMessageByTitle(text);
        //根据用户id获取用户头像
        User userId = userService.getUserById(message.getMasterId());
        if (userId != null) {
            message.setImagePath(userId.getAvatarUrl());
        }
        model.addAttribute("message",message);
        //获取session
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        //获取个性化背景图
        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }
        return "search";
    }
}
