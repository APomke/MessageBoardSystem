package com.example.mbs.controller;

import com.example.mbs.pojo.BgImage;
import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.BgImageServiceImpl;
import com.example.mbs.service.MessageServiceImpl;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DataAnalySis {
    @Autowired
    private BgImageServiceImpl bgImageService;

    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping("/analysis")
    public String analysis(Model model, HttpServletRequest request){
        //从session中取出user
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);

        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }
        //获取各分类的数目
        //获取全部留言
        List<Message> messageList = messageService.queryAllMessage();
        int publicServiceCount = 0;
        int lifeCount = 0;
        int notificationCount = 0;
        int otherCount = 0;

        for (Message message:messageList){
            if (message.getTypeId() == 1){
                publicServiceCount++;
            }else if (message.getTypeId() == 2){
                notificationCount++;
            }else if (message.getTypeId() == 3){
                otherCount++;
            }else if (message.getTypeId() == 4){
                lifeCount++;
            }
        }
        model.addAttribute("publicServiceCount",publicServiceCount);
        model.addAttribute("lifeCount",lifeCount);
        model.addAttribute("notificationCount",notificationCount);
        model.addAttribute("otherCount",otherCount);

        return "dataAnalySis";
    }
}
