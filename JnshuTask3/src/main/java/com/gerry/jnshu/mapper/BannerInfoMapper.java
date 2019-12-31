package com.gerry.jnshu.mapper;

import com.gerry.jnshu.pojo.BannerInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BannerInfoMapper extends Mapper<BannerInfo> {
    List<BannerInfo> queryAllBanners();

}