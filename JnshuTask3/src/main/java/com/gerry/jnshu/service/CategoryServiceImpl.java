package com.gerry.jnshu.service;

import com.gerry.jnshu.mapper.ImageInfoMapper;
import com.gerry.jnshu.pojo.ImageInfo;

import javax.annotation.Resource;
import java.util.List;


public class ImageInfoServiceImpl implements ImageInfoService {

    @Resource
    private ImageInfoMapper imageMapper;
    @Override
    public int saveImageInfo(List<ImageInfo> imagePaths) {
        int result = imageMapper.insertImageUrls(imagePaths);
        return result;
    }
}
