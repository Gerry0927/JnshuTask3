package com.gerry.jnshu.controller;

import com.gerry.jnshu.pojo.Article;
import com.gerry.jnshu.pojo.ArticleDTO;
import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.pojo.CommentDTO;
import com.gerry.jnshu.response.Result;
import com.gerry.jnshu.service.ArticleService;
import com.gerry.jnshu.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping("article")
@RestController
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public Result<ArticleDTO> getCommentList(@RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        ArticleDTO commentDTO = new ArticleDTO();

        PageInfo<Article> pageInfo = articleService.getArticleList(pageNum,pageSize);

        commentDTO.setCurrentPage(pageInfo.getPageNum());
        commentDTO.setTotalPages(pageInfo.getPages());
        commentDTO.setTotalNum(pageInfo.getTotal());
        commentDTO.setLit(pageInfo.getList());
        return Result.success(commentDTO,"查询成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result<Integer> deleteBannerInfo(@PathVariable Integer id){
        int rowIds = articleService.deleteArticle(id);
        if(rowIds<=0){
            return Result.success(null,"删除失败,记录不存在");
        }
        return Result.success(null,"删除成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> addCategory(@Valid Article comment){
        Integer categoryId = articleService.saveArticleInfo(comment);
        return Result.success(categoryId,"保存成功");
    }
}
