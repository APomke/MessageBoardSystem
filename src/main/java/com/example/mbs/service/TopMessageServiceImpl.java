package com.example.mbs.service;

import com.example.mbs.dao.TopMessageMapper;
import com.example.mbs.pojo.TopMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopMessageServiceImpl implements TopMessageService{
    @Autowired
    private TopMessageMapper topMessageMapper;

    @Override
    public List<TopMessage> getAllTopMessage() {
        return topMessageMapper.getAllTopMessage();
    }

    @Override
    public int addTopMessage(TopMessage topMessage) {
        return topMessageMapper.addTopMessage(topMessage);
    }

    @Override
    public int deleteTopMessage(int messageId) {
        return topMessageMapper.deleteTopMessage(messageId);
    }
}
