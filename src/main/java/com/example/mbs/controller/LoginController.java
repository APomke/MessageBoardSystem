package com.example.mbs.controller;

import com.example.mbs.pojo.Code;
import com.example.mbs.pojo.User;
import com.example.mbs.service.CodeService;
import com.example.mbs.service.CodeServiceImpl;
import com.example.mbs.service.EmailService;
import com.example.mbs.service.UserServiceImpl;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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


    @RequestMapping("/message/index")
    public String login(User user, Model model, HttpServletRequest request){
        //判断是否有该用户
        User user1 = userService.getUserByAccountAndPassword(user.getAccount(),user.getPassword());
        if (user1 != null){
            //添加session
            request.getSession().setAttribute(Constants.USER_SESSION,user1);
            model.addAttribute("user",user1);
            return "index";
        }
        model.addAttribute("msg","登入失败，请检查账号密码是否正确");
        return "login";
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
