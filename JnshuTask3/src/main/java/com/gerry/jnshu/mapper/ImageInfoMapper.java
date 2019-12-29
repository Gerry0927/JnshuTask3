package com.gerry.jnshu.mapper;

import com.gerry.jnshu.pojo.ImageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ImageInfoMapper extends Mapper<ImageInfo> {
    int insertImageUrls(@Param("list") List<ImageInfo> imageInfos);
}
