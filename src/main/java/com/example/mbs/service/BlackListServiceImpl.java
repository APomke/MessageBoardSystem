package com.example.mbs.service;

import com.example.mbs.dao.BlackListMapper;
import com.example.mbs.pojo.BlackList;
import com.example.mbs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlackListServiceImpl implements BlackListService{

    @Autowired
    private BlackListMapper blackListMapper;

    @Override
    public List<User> getBlackListAll() {
        return blackListMapper.getBlackListAll();
    }

    @Override
    public int addBlackList(BlackList blackList) {
        return blackListMapper.addBlackList(blackList);
    }

    @Override
    public int deleteBlackList(int userId) {
        return blackListMapper.deleteBlackList(userId);
    }
}
