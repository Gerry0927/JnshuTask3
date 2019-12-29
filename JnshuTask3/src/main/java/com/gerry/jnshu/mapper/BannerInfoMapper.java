package com.gerry.jnshu.mapper;

import com.gerry.jnshu.pojo.BannerInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BannerInfoMapper extends Mapper<BannerInfo> {
    List<BannerInfo> queryAllBanners();

}