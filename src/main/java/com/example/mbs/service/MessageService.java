package com.example.mbs.service;

import com.example.mbs.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageService {
    //发布留言
    int addMessage(Message message);
    //点赞留言
    int likesMessage(Message message);
    //删除留言
    int deleteMessage(int id);
    //根据标题查询留言
    Message queryMessageByTitle(String title);
    //查询出用户的所有留言
    List<Message> queryMessageByUser(int userId);
    //查询所有留言
    List<Message> queryAllMessage();
    //查询前5条留言
    List<Message> queryMessageLimitFive();
    //根据类型查询留言
    List<Message> queryMessageByType(int typeId);
    //通过id查询留言
    Message getMessageById(int id);
    //通过评论id获取留言id
    Message getMessageByCommentsId(int messageId);
}
