package com.example.mbs.dao;

import com.example.mbs.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //获取全部用户
    List<User> getAllUser();
    //通过id获取用户
    User getUserById(@Param("userId") int userId);
    //通过账号密码获取用户
    User getUserByAccountAndPassword(String account,String password);
    //通过昵称获取用户
    User getUserByNickname(String nickname);
    //通过用户名获取用户
    User getUserByAccount(@Param("Account") String account);

    //添加用户
    int addUser(User user);
    //修改用户
    int update(User user);
    //删除用户
    int deleteUser(int id);
}
