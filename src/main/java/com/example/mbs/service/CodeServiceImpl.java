package com.example.mbs.service;

import com.example.mbs.dao.CodeMapper;
import com.example.mbs.pojo.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService{
    @Autowired
    private CodeMapper emailMapper;

    @Override
    public Code getNewCode() {
        return emailMapper.getNewCode();
    }

    @Override
    public int addCode(String code) {
        return emailMapper.addCode(code);
    }
}
