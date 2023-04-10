package com.example.mbs.dao;

import com.example.mbs.pojo.BgImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BgImageMapper {
    //根据用户id获取背景图
    BgImage getImageByUserId(@Param("userId") int userId);
    //获取所有背景图
    List<BgImage> getAllImage();
    //添加背景图
    int addImage(BgImage bgImage);
    //删除背景图
    int deleteImageByUserId(@Param("userIds") int userId);
    //修改背景图
    int updateImage(BgImage bgImage);
}
