package com.example.mbs.service;

import com.example.mbs.pojo.BlackList;
import com.example.mbs.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlackListService {
    //获取黑名单里的全部用户，使用连表查询
    List<User> getBlackListAll();
    //添加用户进黑名单
    int addBlackList(BlackList blackList);
    //把用户从黑名单中移除
    int deleteBlackList(int userId);
}
