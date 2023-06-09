package com.example.mbs.controller;

import com.example.mbs.pojo.*;
import com.example.mbs.service.*;
import com.example.mbs.utils.Constants;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
import java.util.*;

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

    @Autowired
    private BgImageServiceImpl bgImageService;

    @Autowired
    private TopMessageServiceImpl topMessageService;

    @Autowired
    private DepartMentServiceImpl departMentService;


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

            //检测是否有置顶留言
            List<Message> tempMessageList = new ArrayList<>();
            List<TopMessage> toList = topMessageService.getAllTopMessage();
            if (!toList.isEmpty()){
                for (TopMessage topMessage:toList){
                    tempMessageList.add(messageService.getMessageById(topMessage.getMessageId()));
                    //如果最先获取到的5条留言里有置顶留言则移除
                    messageList.removeAll(tempMessageList);
                    messageList.add(0,messageService.getMessageById(topMessage.getMessageId()));
                }
            }

            //根据用户id获取用户头像
            for (Message message:messageList){
                User userId = userService.getUserById(message.getMasterId());
                if (userId != null) {
                    message.setImagePath(userId.getAvatarUrl());
                    newMessageList.add(message);
                }
            }
            //获取个性化背景图
            BgImage bgImage = bgImageService.getImageByUserId(user1.getId());
            if (bgImage != null) {
                model.addAttribute("backgroundImagePath",bgImage.getImagePath());
            }
            model.addAttribute("messageList",newMessageList);
            return "index";
        }
        //判断是否有该用户
        user1 = userService.getUserByAccountAndPassword(user.getAccount(),user.getPassword());
        if (user1 != null){
            //添加session
            request.getSession().setAttribute(Constants.USER_SESSION,user1);
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //封装用户的登入数据
            UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(),user.getPassword());

            try {
                subject.login(token);//执行登入的方法,会使用UserRealm的方法
//                return "index";
            }catch (UnknownAccountException e){//用户名不存在
                model.addAttribute("msg","用户名错误");
                return "login";
            }catch (IncorrectCredentialsException e){//密码错误
                model.addAttribute("msg","密码错误");
                return "login";
            }

            model.addAttribute("user",user1);
            List<Message> messageList = messageService.queryMessageLimitFive();
            List<Message> newMessageList = new ArrayList<>();


            //检测是否有置顶留言
            List<Message> tempMessageList = new ArrayList<>();
            List<TopMessage> toList = topMessageService.getAllTopMessage();
            if (!toList.isEmpty()){
                for (TopMessage topMessage:toList){
                    tempMessageList.add(messageService.getMessageById(topMessage.getMessageId()));
                    //如果最先获取到的5条留言里有置顶留言则移除
                    messageList.removeAll(tempMessageList);
                    messageList.add(0,messageService.getMessageById(topMessage.getMessageId()));
                }
            }

            //根据用户id获取用户头像
            for (Message message:messageList){
                User userId = userService.getUserById(message.getMasterId());
                if (userId != null) {
                    message.setImagePath(userId.getAvatarUrl());
                    newMessageList.add(message);
                }
            }
            BgImage bgImage = bgImageService.getImageByUserId(user1.getId());
            if (bgImage != null) {
                model.addAttribute("backgroundImagePath",bgImage.getImagePath());
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

            //检测是否有置顶留言
            List<Message> tempMessageList = new ArrayList<>();
            List<TopMessage> toList = topMessageService.getAllTopMessage();
            if (!toList.isEmpty()){
                for (TopMessage topMessage:toList){
                    tempMessageList.add(messageService.getMessageById(topMessage.getMessageId()));
                    //如果最先获取到的5条留言里有置顶留言则移除
                    messageList.removeAll(tempMessageList);
                    messageList.add(0,messageService.getMessageById(topMessage.getMessageId()));
                }
            }

            //根据用户id获取用户头像
            for (Message message:messageList){
                User userId = userService.getUserById(message.getMasterId());
                if (userId != null) {
                    message.setImagePath(userId.getAvatarUrl());
                    newMessageList.add(message);
                }
            }
            BgImage bgImage = bgImageService.getImageByUserId(user.getId());
            if (bgImage != null) {
                model.addAttribute("backgroundImagePath",bgImage.getImagePath());
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
        //获取对应部门人数
        Department department = departMentService.getDeptById(user.getDeptId());
        int count = department.getDeptSize();
        count++;
        department.setDeptSize(count);
        departMentService.addDeptCount(department);
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

    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request){
        //移除session
        request.getSession().removeAttribute(Constants.USER_SESSION);

        return "login";
    }
}
