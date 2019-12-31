package com.gerry.jnshu.service;

import com.gerry.jnshu.pojo.BannerInfo;
import com.gerry.jnshu.pojo.CategoryInfo;
import com.gerry.jnshu.pojo.ImageInfo;

import java.util.List;

public interface CategoryService {


     List<CategoryInfo> getCategoryList();

     Integer saveCategoryInfo(CategoryInfo categoryInfo);

     int updateCategoryInfo(CategoryInfo categoryInfo);

     int deleteCategoryInfo(Integer id);
}
