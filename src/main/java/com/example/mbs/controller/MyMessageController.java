package com.example.mbs.controller;

import com.example.mbs.pojo.*;
import com.example.mbs.service.*;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class MyMessageController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private CommentsServiceImpl commentsService;
    @Autowired
    private BgImageServiceImpl bgImageService;

    @Autowired
    private TopMessageServiceImpl topMessageService;

    @RequestMapping("/myMessage")
    public String myMessage(Model model, HttpServletRequest request){
        //从session中取出user
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);
        //判断其是否是管理员
        List<Message> messageList = new ArrayList<>();
        if (Objects.equals(user.getRole(), "管理员")){
            //获取所有留言
            messageList = messageService.queryAllMessage();
            model.addAttribute("msg","由于你是管理员所以拥有管理所有留言的权限");
        }else {
            //获取这个用户的留言
            messageList = messageService.queryMessageByUser(user.getId());
        }
        List<Message> newMessageList = new ArrayList<>();
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
        return "mymessage";
    }
    //删除留言请求
    @PostMapping("/delete-tweet")
    public ResponseEntity<ApiResponse> deleteTweet(@RequestParam("tweetId") Long tweetId){
        System.out.println("删除了一次留言");
        messageService.deleteMessage(Math.toIntExact(tweetId));
        //同时删除留言里的评论
        commentsService.deleteAllCommentsByMessageId(Math.toIntExact(tweetId));
        // 处理删除请求，并返回响应数据
        ApiResponse response = new ApiResponse(true, "删除成功！");
        return new ResponseEntity<>(response, HttpStatus.OK);

    };

    //置顶留言请求
    @PostMapping("/top-tweet")
    public ResponseEntity<ApiResponse> topTweet(@RequestParam("tweetId") Long tweetId){
        System.out.println("置顶了一次留言");
        TopMessage topMessage = new TopMessage(Math.toIntExact(tweetId));
        topMessageService.addTopMessage(topMessage);
        // 处理置顶请求，并返回响应数据
        ApiResponse response = new ApiResponse(true, "置顶成功！");
        return new ResponseEntity<>(response, HttpStatus.OK);
    };

    //取消置顶留言请求
    @PostMapping("/cancel-tweet")
    public ResponseEntity<ApiResponse> cancelTweet(@RequestParam("tweetId") Long tweetId){
        System.out.println("取消置顶了一次留言");
        int s = topMessageService.deleteTopMessage(Math.toIntExact(tweetId));
        if (s == 1){
            ApiResponse response = new ApiResponse(true, "取消置顶成功！");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            ApiResponse response = new ApiResponse(false, "该留言并未设置置顶");
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
