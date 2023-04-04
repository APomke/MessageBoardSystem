package com.example.mbs.controller;

import com.example.mbs.pojo.Code;
import com.example.mbs.pojo.Comments;
import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.*;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Session;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private CodeServiceImpl codeService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private CommentsServiceImpl commentsService;


    @PostMapping("/message/index")
    public String login(User user, Model model, HttpServletRequest request){
        //判断是否已登入
        User user1 = new User();
        if (request.getSession().getAttribute(Constants.USER_SESSION) != null){
            user1 = (User) request.getSession().getAttribute(Constants.USER_SESSION);
            model.addAttribute("user",user1);
            //获取前5条留言
            List<Message> messageList = messageService.queryMessageLimitFive();
            List<Message> newMessageList = new ArrayList<>();
            //根据用户id获取用户头像
            for (Message message:messageList){
                User userId = userService.getUserById(message.getMasterId());
                if (userId != null) {
                    message.setImagePath(userId.getAvatarUrl());
                    newMessageList.add(message);
                }
            }
            model.addAttribute("messageList",newMessageList);
            return "index";
        }
        //判断是否有该用户
        user1 = userService.getUserByAccountAndPassword(user.getAccount(),user.getPassword());
        if (user1 != null){
            //添加session
            request.getSession().setAttribute(Constants.USER_SESSION,user1);
            model.addAttribute("user",user1);
            List<Message> messageList = messageService.queryMessageLimitFive();
            List<Message> newMessageList = new ArrayList<>();
            //根据用户id获取用户头像
            for (Message message:messageList){
                User userId = userService.getUserById(message.getMasterId());
                if (userId != null) {
                    message.setImagePath(userId.getAvatarUrl());
                    newMessageList.add(message);
                }
            }
            model.addAttribute("messageList",newMessageList);
            return "index";
        }
        model.addAttribute("msg","登入失败，请检查账号密码是否正确");
        return "login";
    }

    @GetMapping("/message/index")
    public String index(Model model, HttpServletRequest request) {
        // 判断用户是否已登录
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        if (user == null) {
            // 如果用户尚未登录，则跳转到登录页面
            return "login";
        } else {
            // 如果用户已经登录，则返回首页
            model.addAttribute("user", user);
            List<Message> messageList = messageService.queryMessageLimitFive();
            List<Message> newMessageList = new ArrayList<>();
            //根据用户id获取用户头像
            for (Message message:messageList){
                User userId = userService.getUserById(message.getMasterId());
                if (userId != null) {
                    message.setImagePath(userId.getAvatarUrl());
                    newMessageList.add(message);
                }
            }
            model.addAttribute("messageList",newMessageList);
            return "index";
        }
    }


    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }



    @PostMapping("/registration/email")
    public String email(@RequestParam("avatar") MultipartFile avatarFile,User user,Model model) throws IOException {
        // 获取文件名
        String fileName = avatarFile.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + suffixName;
        // 将文件保存到指定路径下
        File destFile = new File(resourceLoader.getResource("classpath:").getFile().getPath() + "/static/images/" + newFileName);
        avatarFile.transferTo(destFile);
        user.setAvatarUrl("images/" + newFileName);

        System.out.println("获取到的注册信息为：" + user.toString());
        //添加用户到数据库
        int s = userService.addUser(user);
        if (s == 1){
            return "email";
        }
        model.addAttribute("msg","用户注册失败，用户可能已存在或部门id不存在");
        return "registration";
    }


    @RequestMapping("/login/email")
    public String emailto(String code, Model model){
        //判断验证码是否正确
        Code code1 = codeService.getNewCode();
        if (code1.getCode().equals(code)){
            return "login";
        }
        model.addAttribute("msg","验证码错误");
        return "email";
    }
    @RequestMapping("/sendVerificationCode")
    public ResponseEntity<String> sendVerificationCode(@RequestBody Map<String, String> requestBody){
        // 从请求体中获取邮箱地址和验证码
        String email = requestBody.get("email");
        String code = requestBody.get("code");
        System.out.println("邮箱为：" + email);
        System.out.println("验证码为：" + code);
        //把验证码保存到数据库
        codeService.addCode(code);

        // 发送验证码
        boolean result = emailService.sendVerificationCode(email, "你的验证码为",code);
        // 根据发送结果返回响应
        if (result) {
            return ResponseEntity.ok("验证码已发送至您的邮箱，请查收。");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("发送验证码失败");
        }
    }
}
