package com.example.mbs.dao;

import com.example.mbs.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    //发布留言
    int addMessage(Message message);
    //点赞留言
    int likesMessage(Message message);
    //删除留言
    int deleteMessage(@Param("messageId") int id);
    //根据标题查询留言
    Message queryMessageByTitle(@Param("title") String title);
    //查询出用户的所有留言
    List<Message> queryMessageByUser(@Param("userId") int userId);
    //查询所有留言
    List<Message> queryAllMessage();
    //查询前5条留言
    List<Message> queryMessageLimitFive();
    //根据类型查询留言
    List<Message> queryMessageByType(@Param("typeId") int typeId);
    //通过id查询留言
    Message getMessageById(@Param("messageIds") int id);

}
