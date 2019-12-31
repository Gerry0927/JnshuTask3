package com.gerry.jnshu.service;

import com.gerry.jnshu.mapper.CategoryInfoMapper;
import com.gerry.jnshu.mapper.ImageInfoMapper;
import com.gerry.jnshu.pojo.CategoryInfo;
import com.gerry.jnshu.pojo.ImageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryInfoMapper categoryInfoMapper;

    @Override
    public List<CategoryInfo> getCategoryList() {
        return categoryInfoMapper.queryAllCategory();
    }

    @Override
    public Integer saveCategoryInfo(CategoryInfo categoryInfo) {
        return categoryInfoMapper.insertSelective(categoryInfo);
    }

    @Override
    public int updateCategoryInfo(CategoryInfo categoryInfo) {
        return categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo);
    }

    @Override
    public int deleteCategoryInfo(Integer id) {
        List<CategoryInfo> categoryInfo = categoryInfoMapper.queryCategoryById(id).getSeCategories();
        int result= -1;
        if(categoryInfo.size()>0){
            for (CategoryInfo info : categoryInfo) {
                deleteCategoryInfo(info.getId());
            }
            result =  categoryInfoMapper.deleteByPrimaryKey(id);
        }
        else{
            result =  categoryInfoMapper.deleteByPrimaryKey(id);
        }

        return result;
    }
}
