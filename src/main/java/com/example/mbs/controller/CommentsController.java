package com.example.mbs.controller;

import com.example.mbs.pojo.Comments;
import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.CommentsServiceImpl;
import com.example.mbs.service.MessageServiceImpl;
import com.example.mbs.service.UserServiceImpl;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CommentsController {

    @Autowired
    private CommentsServiceImpl commentsService;

    @Autowired
    private MessageServiceImpl messageService;

    @PostMapping("/comments/submit")
    public ResponseEntity<String> submitComment(@RequestParam("content") String content, @RequestParam("messageId") Long messageId, HttpServletRequest request) {
        // 在此处处理评论数据，将其保存到数据库

        //实现获取用户信息
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        //获取当前时间
        Date date = new Date(); // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 创建一个日期格式化对象
        String now = dateFormat.format(date); // 将日期对象转化为字符串

        int messageIds = Math.toIntExact(messageId);
        Comments comments = new Comments(0,messageIds,user.getId(),content,1,now,user.getAvatarUrl(), user.getNickname());

        System.out.println(comments.toString());

        int s = commentsService.addComments(comments);
        System.out.println("s为：" + s);
        if (s == 1){
            // 假设我们成功保存了评论，返回一个成功的响应
            System.out.println("评论添加成功");
            return new ResponseEntity<>("评论已成功发送", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("评论发送失败", HttpStatus.OK);
        }

    }

    @PostMapping("/comments/submitto")
    public ResponseEntity<ApiResponse> submitReply(@RequestParam("replyContent") String replyContent, @RequestParam("commentId") Long commentId, HttpServletRequest request) {
        // 在此处处理回复数据，将其保存到数据库
        System.out.println("获取到的要回复的评论id为：" + commentId);
        System.out.println("获取到的要回复的正文为" + replyContent);

        // 实现获取用户信息
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        // 获取当前时间
        Date date = new Date(); // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 创建一个日期格式化对象
        String now = dateFormat.format(date); // 将日期对象转化为字符串

        //通过评论id获取留言id
//        Message message = messageService.getMessageByCommentsId(Math.toIntExact(commentId));
        Comments comments1 = commentsService.queryGetCommentsById(Math.toIntExact(commentId));
        System.out.println("获取到的留言id为：" + comments1.getMessageId());
        int commentIds = Math.toIntExact(commentId);
        Comments comments = new Comments(0, comments1.getMessageId(), user.getId(), replyContent, 2, now, user.getAvatarUrl(),commentIds, user.getNickname());

        int s = commentsService.addComments2(comments);
        if (s == 1){
            // 假设我们成功保存了回复，返回一个成功的响应
            ApiResponse response = new ApiResponse(true, "添加成功");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            ApiResponse response = new ApiResponse(false, "添加失败");
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
