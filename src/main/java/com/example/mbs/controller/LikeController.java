package com.example.mbs.controller;

import com.example.mbs.pojo.Message;
import com.example.mbs.service.MessageServiceImpl;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {
    @Autowired
    private MessageServiceImpl messageService;

    @PostMapping("like-tweet")
    public ResponseEntity<ApiResponse> likeTweet(@RequestParam("tweetId") Long tweetId) {
        System.out.println("提交了一次点赞");
        //为对应留言添加点赞

        //获取留言现在的点赞数
        Message message = messageService.getMessageById(Math.toIntExact(tweetId));
        //添加点赞
        int likes = message.getLikes() + 1;
        message.setLikes(likes);
        messageService.likesMessage(message);
        // 处理点赞请求，并返回响应数据
        ApiResponse response = new ApiResponse(true, "点赞成功！",likes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static class ApiResponse {
        private final boolean success;
        private final String message;
        private final int likeCount;

        public ApiResponse(boolean success, String message,int likeCount) {
            this.success = success;
            this.message = message;
            this.likeCount = likeCount;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public int getLikeCount(){
            return likeCount;
        }
    }
}
