package com.example.mbs;

import com.example.mbs.pojo.User;
import com.example.mbs.service.CodeServiceImpl;
import com.example.mbs.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MbsApplicationTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        List<User> list = userService.getAllUser();
        System.out.println(list.toString());
    }

    @Test
    public void test1(){
        User user = new User(1,"311252","123456","雨","管理部",1,"3112520587@qq.com",null);
        int is = userService.addUser(user);
        if (is == 1){
            System.out.println("添加成功");
        }
    }

}
