package com.example.mbs.controller;

import com.example.mbs.pojo.BgImage;
import com.example.mbs.pojo.BlackList;
import com.example.mbs.pojo.User;
import com.example.mbs.service.BgImageServiceImpl;
import com.example.mbs.service.BlackListServiceImpl;
import com.example.mbs.service.UserServiceImpl;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private BgImageServiceImpl bgImageService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BlackListServiceImpl blackListService;

    @RequestMapping("/userList")
    public String userList(Model model, HttpServletRequest request){
        //从session中取出user
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);

        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }
        //获取用户列表
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);

        return "userList";
    }

    @RequestMapping("/blacklist")
    public String blacklist(Model model, HttpServletRequest request){

        //从session中取出user
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);

        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }

        //获取黑名单用户列表
        List<User> userList = blackListService.getBlackListAll();
        model.addAttribute("userList",userList);
        return "blacklist";
    }

    @PostMapping("/add-black")
    public ResponseEntity<ApiResponse> addBlack(@RequestParam("tweetId") Long tweetId){
        System.out.println("把一个用户加入了黑名单");
        BlackList blackList = new BlackList(Math.toIntExact(tweetId));
        int s = blackListService.addBlackList(blackList);
        if (s == 1){
            ApiResponse response = new ApiResponse(true, "加入黑名单成功！");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response = new ApiResponse(false, "该用户无法加入黑名单");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/cancel-black")
    public ResponseEntity<ApiResponse> cancelBlack(@RequestParam("tweetId") Long tweetId){
        System.out.println("把一个用户取消加入了黑名单");
        int s = blackListService.deleteBlackList(Math.toIntExact(tweetId));
        if (s == 1){
            ApiResponse response = new ApiResponse(true, "取消加入黑名单成功！");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response = new ApiResponse(false, "该用户不在黑名单");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


    public static class ApiResponse {
        private final boolean success;
        private final String message;

        public ApiResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
