package com.example.mbs.service;

import com.example.mbs.dao.CommentsMapper;
import com.example.mbs.pojo.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService{
    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public int addComments(Comments comments) {
        return commentsMapper.addComments(comments);
    }

    @Override
    public List<Comments> queryCommentsByMessageId(int messageId) {
        return commentsMapper.queryCommentsByMessageId(messageId);
    }

    @Override
    public List<Comments> queryAllComments() {
        return commentsMapper.queryAllComments();
    }

    @Override
    public List<Comments> queryCommentsByUserId(int userId) {
        return commentsMapper.queryCommentsByUserId(userId);
    }

    @Override
    public int deleteComments(int commentsId) {
        return commentsMapper.deleteComments(commentsId);
    }

    @Override
    public int deleteAllCommentsByMessageId(int messageId) {
        return commentsMapper.deleteAllCommentsByMessageId(messageId);
    }
}
