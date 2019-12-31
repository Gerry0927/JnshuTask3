package com.gerry.jnshu.service;

import com.gerry.jnshu.pojo.BannerInfo;

import java.util.List;

public interface BannerService {

    List<BannerInfo> getBannerList();
    Integer saveBannerInfo(BannerInfo bannerInfo);

    int updateBanneStatus(Integer bannerId,Integer status);

    int deleteBannerInfo(Integer bannerId);
}
