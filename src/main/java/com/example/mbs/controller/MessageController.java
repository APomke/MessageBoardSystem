package com.example.mbs.controller;

import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.MessageServiceImpl;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@RestController
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    @PostMapping("/addMessage")
    public ResponseEntity<ApiResponse> addMessage(@RequestParam("message") String message, @RequestParam("title") String title, @RequestParam("type") String type, HttpServletRequest request) {
        System.out.println("添加了一条留言");
        System.out.println("获取的内容是：" + message);
        System.out.println("获取的标签是：" + type);
        int typeId = 0;
        if (Objects.equals(type, "公务")){
            typeId = 1;
        }else if (Objects.equals(type, "通知")){
            typeId = 2;
        }else if (Objects.equals(type, "其它")){
            typeId = 3;
        }else if (Objects.equals(type, "生活")){
            typeId = 4;
        }
        System.out.println("获取的标题的：" + title);
        // 将留言保存到数据库
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        Date date = new Date(); // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 创建一个日期格式化对象
        String now = dateFormat.format(date); // 将日期对象转化为字符串

        Message message1 = new Message(0,user.getId(),title,message,0,typeId,0,"无",now,user.getNickname());
        int s = messageService.addMessage(message1);
        // 然后返回相应的响应
        if (s == 1){
            ApiResponse response = new ApiResponse(true, "添加成功");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            ApiResponse response = new ApiResponse(false, "添加失败");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    public static class ApiResponse {
        private final boolean success;
        private final String message;

        public ApiResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
