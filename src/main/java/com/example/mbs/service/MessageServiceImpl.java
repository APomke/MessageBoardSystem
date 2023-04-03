package com.example.mbs.service;

import com.example.mbs.dao.MessageMapper;
import com.example.mbs.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    @Override
    public int likesMessage(Message message) {
        return messageMapper.likesMessage(message);
    }

    @Override
    public int deleteMessage(int id) {
        return messageMapper.deleteMessage(id);
    }

    @Override
    public Message queryMessageByTitle(String title) {
        return messageMapper.queryMessageByTitle(title);
    }

    @Override
    public List<Message> queryMessageByUser(int userId) {
        return messageMapper.queryMessageByUser(userId);
    }

    @Override
    public List<Message> queryAllMessage() {
        return messageMapper.queryAllMessage();
    }

    @Override
    public List<Message> queryMessageLimitFive() {
        return messageMapper.queryMessageLimitFive();
    }

    @Override
    public List<Message> queryMessageByType(int typeId) {
        return messageMapper.queryMessageByType(typeId);
    }

    @Override
    public Message getMessageById(int id) {
        return messageMapper.getMessageById(id);
    }
}
