package com.gerry.jnshu.controller;


import com.gerry.jnshu.pojo.CategoryInfo;
import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.pojo.CommentDTO;
import com.gerry.jnshu.response.Result;
import com.gerry.jnshu.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping("comment")
@RestController
public class CommentController {


    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)
    public Result<CommentDTO> getCommentList(@PathVariable  Integer articleId,@RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        CommentDTO commentDTO = new CommentDTO();

        PageInfo<Comment> commentPageInfo = commentService.getCommentList(pageNum,pageSize,articleId);

        commentDTO.setCurrentPage(commentPageInfo.getPageNum());
        commentDTO.setTotalPages(commentPageInfo.getPages());
        commentDTO.setTotalNum(commentPageInfo.getTotal());
        commentDTO.setLit(commentPageInfo.getList());
        return Result.success(commentDTO,"查询成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result<Integer> deleteBannerInfo(@PathVariable Integer id){
        int rowIds = commentService.deleteCommentInfo(id);
        if(rowIds<=0){
            return Result.success(null,"删除失败,记录不存在");
        }
        return Result.success(null,"删除成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> addCategory(@Valid Comment comment){
        Integer categoryId = commentService.saveCommentInfo(comment);
        return Result.success(categoryId,"保存成功");
    }

}
