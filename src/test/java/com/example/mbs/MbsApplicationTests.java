package com.example.mbs;

import com.example.mbs.dao.CommentsMapper;
import com.example.mbs.pojo.Comments;
import com.example.mbs.pojo.Department;
import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.omg.CORBA.PUBLIC_MEMBER;
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

    @Autowired
    private DepartMentServiceImpl departMentService;

    @Test
    public void test2(){
        List<Department> list = departMentService.getAllDept();
        System.out.println(list.toString());

    }

    @Autowired
    private MessageServiceImpl messageService;



    @Test
    public void messageTest3(){
        Message message = messageService.queryMessageByTitle("第一次留言");
        System.out.println(message);
    }
    @Test
    public void messageTest4(){
        List<Message> messageList = messageService.queryMessageLimitFive();
        System.out.println(messageList.toString());
    }

    @Test
    public void messageTest5(){
        User user = userService.getUserById(3);
        System.out.println(user.toString());
    }

    @Autowired
    private CommentsServiceImpl commentsService;

//    @Test
//    public void commentsTest1(){
//        Comments comments = new Comments(0,1,101,"第一次评论",1,"2023-04-02");
//        int s =  commentsService.addComments(comments);
//        if (s == 1){
//            System.out.println("评论添加成功");
//        }else{
//            System.out.println("评论添加失败");
//        }
//    }

    @Test
    public void commentsTest2(){
        List<Comments> list = commentsService.queryCommentsByUserId(101);

        System.out.println(list.toString());
    }

}
