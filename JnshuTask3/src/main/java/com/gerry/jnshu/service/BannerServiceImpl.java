package com.gerry.jnshu.service;

import com.gerry.jnshu.mapper.BannerInfoMapper;
import com.gerry.jnshu.mapper.ImageInfoMapper;
import com.gerry.jnshu.pojo.BannerInfo;
import com.gerry.jnshu.pojo.ImageInfo;
import com.gerry.jnshu.pojo.Reply;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerInfoMapper bannerMapper;

    @Resource
    private ImageInfoMapper imageInfoMapper;

    @Override
    public List<BannerInfo> getBannerList() {
        List<BannerInfo> bannerInfos = bannerMapper.queryAllBanners();
        return bannerInfos;
    }

    @Override
    public Integer saveBannerInfo(BannerInfo bannerInfo) {
        int bannerId = bannerMapper.insertSelective(bannerInfo);
        if(bannerId>0){
            List<String> imgUrls = bannerInfo.getImgInfo();
            List<ImageInfo> imageInfos = new ArrayList<>();
            for (String url : imgUrls) {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setRelationId(bannerId);
                imageInfo.setType(0);
                imageInfo.setImagePath(url);
                imageInfos.add(imageInfo);
            }
            imageInfoMapper.insertImageUrls(imageInfos);
        }
        return bannerId;
    }

    @Override
    public int updateBanneStatus(Integer bannerId, Integer status) {
        BannerInfo bannerInfo = new BannerInfo();
        bannerInfo.setId(bannerId);
        bannerInfo.setStatus(status);
        int rowIds = bannerMapper.updateByPrimaryKeySelective(bannerInfo);
        return rowIds;
    }


    @Override
//    @Transactional
    public int deleteBannerInfo(Integer bannerId) {
        int rowIds = bannerMapper.deleteByPrimaryKey(bannerId);
        Example example = new Example(ImageInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("relationId",bannerId);
        imageInfoMapper.deleteByExample(example);
        return rowIds;
    }
}
