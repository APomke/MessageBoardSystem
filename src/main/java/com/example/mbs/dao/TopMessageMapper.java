package com.example.mbs.dao;

import com.example.mbs.pojo.TopMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TopMessageMapper {
    //获取所有置顶留言
    List<TopMessage> getAllTopMessage();

    //添加置顶留言
    int addTopMessage(TopMessage topMessage);

    //移除置顶留言
    int deleteTopMessage(@Param("messageIds") int messageId);

}
