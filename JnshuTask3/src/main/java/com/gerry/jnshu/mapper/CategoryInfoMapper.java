package com.gerry.jnshu.mapper;

import com.gerry.jnshu.pojo.CategoryInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface CategoryInfoMapper extends Mapper<CategoryInfo> {

    List<CategoryInfo> queryAllCategory();
    CategoryInfo queryCategoryById(Integer id);
}