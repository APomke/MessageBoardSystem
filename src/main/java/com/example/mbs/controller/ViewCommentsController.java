package com.example.mbs.controller;

import com.example.mbs.pojo.Comments;
import com.example.mbs.service.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewCommentsController {

    @Autowired
    private CommentsServiceImpl commentsService;

    @PostMapping("/viewComments")
    public ResponseEntity<List<Comments>> viewComments(@RequestParam("tweetId") Long tweetId){
        System.out.println("获取留言id为：" + tweetId + "的评论");
        List<Comments> response = commentsService.queryCommentsByMessageId(Math.toIntExact(tweetId));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
