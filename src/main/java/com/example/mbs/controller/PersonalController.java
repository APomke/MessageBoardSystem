package com.example.mbs.controller;

import com.example.mbs.pojo.BgImage;
import com.example.mbs.pojo.User;
import com.example.mbs.service.BgImageServiceImpl;
import com.example.mbs.service.UserServiceImpl;
import com.example.mbs.utils.Constants;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Session;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class PersonalController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BgImageServiceImpl bgImageService;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/personal")
    public String personal(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);

        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }
        return "personal";
    }

    @RequestMapping("/customize-settings")
    public String settings(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);
        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }
        return "settings";
    }

    @PostMapping("/settingsto")
    public String processSettingsForm(@RequestParam("avatar") MultipartFile avatar,
                                      @RequestParam("bj") MultipartFile background, HttpServletRequest request,Model model) throws IOException {
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        if (avatar.isEmpty()){
            System.out.println("没有设置修改头像");
        }else {
            //获取头像
            // 获取文件名
            String fileName = avatar.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成新的文件名
            String newFileName = UUID.randomUUID().toString() + suffixName;
            // 将文件保存到指定路径下
            File destFile = new File(resourceLoader.getResource("classpath:").getFile().getPath() + "/static/images/" + newFileName);
            avatar.transferTo(destFile);
            //修改用户的头像路径
            user.setAvatarUrl("images/" + newFileName);
            int s = userService.update(user);
            if (s == 1){
                System.out.println("头像修改成功");
            }else {
                System.out.println("头像修改失败");
            }
        }
        if (background.isEmpty()) {
            System.out.println("没有设置修改背景");
        }else {
            //获取背景
            // 获取文件名
            String fileName = background.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成新的文件名
            String newFileName = UUID.randomUUID().toString() + suffixName;
            // 将文件保存到指定路径下
            File destFile = new File(resourceLoader.getResource("classpath:").getFile().getPath() + "/static/images/" + newFileName);
            background.transferTo(destFile);
            //判断用户是否设置过背景
            int userId = user.getId();
            BgImage bgImage = bgImageService.getImageByUserId(userId);
            if (bgImage.getImagePath() != null) {
                //修改
                bgImage.setImagePath("images/" + newFileName);
                bgImageService.updateImage(bgImage);
            }else {
                //添加
                BgImage bgImage1 = new BgImage(userId,user.getNickname(),"images/" + newFileName);
                int s1 = bgImageService.addImage(bgImage1);
                if (s1 == 1){
                    System.out.println("背景添加成功");
                }else {
                    System.out.println("背景添加失败");
                }
            }
        }



        model.addAttribute("user",user);

        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }

        return "personal";
    }

}
