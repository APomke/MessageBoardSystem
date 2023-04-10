package com.example.mbs.service;

import com.example.mbs.dao.BgImageMapper;
import com.example.mbs.pojo.BgImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BgImageServiceImpl implements BgImageService {
    @Autowired
    private BgImageMapper bgImageMapper;

    @Override
    public BgImage getImageByUserId(int userId) {
        return bgImageMapper.getImageByUserId(userId);
    }

    @Override
    public List<BgImage> getAllImage() {
        return bgImageMapper.getAllImage();
    }

    @Override
    public int addImage(BgImage bgImage) {
        return bgImageMapper.addImage(bgImage);
    }

    @Override
    public int deleteImageByUserId(int userId) {
        return bgImageMapper.deleteImageByUserId(userId);
    }

    @Override
    public int updateImage(BgImage bgImage) {
        return bgImageMapper.updateImage(bgImage);
    }
}
