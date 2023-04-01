package com.example.mbs.service;

import com.example.mbs.pojo.Code;

public interface CodeService {
    //获取最新验证码
    Code getNewCode();
    //存入最新验证码
    int addCode(String code);
}
