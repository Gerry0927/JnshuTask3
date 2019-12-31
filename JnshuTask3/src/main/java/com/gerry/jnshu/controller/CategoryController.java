package com.gerry.jnshu.controller;

import com.gerry.jnshu.pojo.CategoryInfo;
import com.gerry.jnshu.response.Result;
import com.gerry.jnshu.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("category")
@RestController
@Validated
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Result<Object> updateCategory(@NotNull @PathVariable Integer id, @Valid CategoryInfo categoryInfo){
        categoryInfo.setId(id);
        categoryService.updateCategoryInfo(categoryInfo);
        return Result.success(null,"更新成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> addCategory(@Valid CategoryInfo categoryInfo){
        Integer categoryId = categoryService.saveCategoryInfo(categoryInfo);
        return Result.success(categoryId,"保存成功");
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Result<List<CategoryInfo>> queryCategory(){
        List<CategoryInfo> categoryList = categoryService.getCategoryList();
        return Result.success(categoryList,"查询成功");
    }

}
