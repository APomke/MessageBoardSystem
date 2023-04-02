package com.example.mbs.service;

import com.example.mbs.pojo.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsService {
    //添加评论
    int addComments(Comments comments);
    //根据留言id查询评论
    List<Comments> queryCommentsByMessageId(int messageId);
    //查询所有评论
    List<Comments> queryAllComments();
    //根据用户id查询评论
    List<Comments> queryCommentsByUserId(int userId);
    //删除评论根据评论id
    int deleteComments(int commentsId);
    //删除留言下所有评论
    int deleteAllCommentsByMessageId(int messageId);
}
