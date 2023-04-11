package com.example.mbs.service;

import java.util.List;

public interface TopMessageService {

    //获取所有置顶留言
    List<com.example.mbs.pojo.TopMessage> getAllTopMessage();

    //添加置顶留言
    int addTopMessage(com.example.mbs.pojo.TopMessage topMessage);

    //移除置顶留言
    int deleteTopMessage(int messageId);
}
