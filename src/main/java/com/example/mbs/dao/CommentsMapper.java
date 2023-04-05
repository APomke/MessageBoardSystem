package com.example.mbs.dao;

import com.example.mbs.pojo.Comments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentsMapper {
    //添加评论
    int addComments(Comments comments);
    //添加二级评论
    int addComments2(Comments comments);
    //根据留言id查询评论
    List<Comments> queryCommentsByMessageId(@Param("messageId") int messageId);
    //查询所有评论
    List<Comments> queryAllComments();
    //根据用户id查询评论
    List<Comments> queryCommentsByUserId(@Param("userId") int userId);
    //删除评论根据评论id
    int deleteComments(@Param("commentsId") int commentsId);
    //删除留言下所有评论
    int deleteAllCommentsByMessageId(@Param("messageId") int messageId);
    //通过id查询出对应的评论
    Comments queryGetCommentsById(@Param("commentsId") int commentsId);
}
