package com.example.mbs.controller;

import com.example.mbs.pojo.BgImage;
import com.example.mbs.pojo.Department;
import com.example.mbs.pojo.Message;
import com.example.mbs.pojo.User;
import com.example.mbs.service.BgImageServiceImpl;
import com.example.mbs.service.DepartMentServiceImpl;
import com.example.mbs.service.MessageServiceImpl;
import com.example.mbs.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class DataAnalySis {
    @Autowired
    private BgImageServiceImpl bgImageService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private DepartMentServiceImpl departMentService;

    @RequestMapping("/analysis")
    public String analysis(Model model, HttpServletRequest request){
        //从session中取出user
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        model.addAttribute("user",user);

        BgImage bgImage = bgImageService.getImageByUserId(user.getId());
        if (bgImage != null) {
            model.addAttribute("backgroundImagePath",bgImage.getImagePath());
        }
        //获取各分类的数目
        //获取全部留言
        List<Message> messageList = messageService.queryAllMessage();
        int publicServiceCount = 0;
        int lifeCount = 0;
        int notificationCount = 0;
        int otherCount = 0;

        for (Message message:messageList){
            if (message.getTypeId() == 1){
                publicServiceCount++;
            }else if (message.getTypeId() == 2){
                notificationCount++;
            }else if (message.getTypeId() == 3){
                otherCount++;
            }else if (message.getTypeId() == 4){
                lifeCount++;
            }
        }
        model.addAttribute("publicServiceCount",publicServiceCount);
        model.addAttribute("lifeCount",lifeCount);
        model.addAttribute("notificationCount",notificationCount);
        model.addAttribute("otherCount",otherCount);

        //获取各个部门的人数
        List<Department> departmentList = departMentService.getAllDept();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (Department department:departmentList){
            if (department.getDeptId() == 1){
                count1 = department.getDeptSize();
            }else if (department.getDeptId() == 2){
                count2 = department.getDeptSize();
            }else if (department.getDeptId() == 3){
                count3 = department.getDeptSize();
            }else if (department.getDeptId() == 4){
                count4 = department.getDeptSize();
            }
        }
        List<Integer> data1 = Arrays.asList(count1, count2, count3, count4);
        model.addAttribute("data", data1);

        //获取1到7号的留言数目
        //获取全部留言
        List<Message> messageList2 = messageService.queryAllMessage();
        int day1 = 0;
        int day2 = 0;
        int day3 = 0;
        int day4 = 0;
        int day5 = 0;
        int day6 = 0;
        int day7 = 0;
        for (Message message:messageList2){
            if (message.getTime().contains("2023-01-01")){
                day1++;
            }else if (message.getTime().contains("2023-04-02")){
                day2++;
            }else if (message.getTime().contains("2023-04-03")){
                day3++;
            }else if (message.getTime().contains("2023-04-04")){
                day4++;
            }else if (message.getTime().contains("2023-04-05")){
                day5++;
            }else if (message.getTime().contains("2023-04-06")){
                day6++;
            }else if (message.getTime().contains("2023-04-07")){
                day7++;
            }
        }
        List<Integer> data2 = Arrays.asList(day1, day2, day3, day4,day5,day6,day7);
        model.addAttribute("data2", data2);

        return "dataAnalySis";
    }
}
