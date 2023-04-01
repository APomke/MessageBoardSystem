package com.example.mbs.dao;

import com.example.mbs.pojo.Code;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CodeMapper {
    //获取最新验证码
    Code getNewCode();
    //存入最新验证码
    int addCode(@Param("code") String code);
}
