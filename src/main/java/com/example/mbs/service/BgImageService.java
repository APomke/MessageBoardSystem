package com.example.mbs.service;

import com.example.mbs.pojo.BgImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BgImageService {
    //根据用户id获取背景图
    BgImage getImageByUserId(int userId);
    //获取所有背景图
    List<BgImage> getAllImage();
    //添加背景图
    int addImage(BgImage bgImage);
    //删除背景图
    int deleteImageByUserId(int userId);
    //修改背景图
    int updateImage(BgImage bgImage);
}
