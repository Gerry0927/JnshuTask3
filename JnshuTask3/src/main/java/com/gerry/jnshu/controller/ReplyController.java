package com.gerry.jnshu.controller;


import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.pojo.CommentDTO;
import com.gerry.jnshu.pojo.Reply;
import com.gerry.jnshu.pojo.ReplyDTO;
import com.gerry.jnshu.response.Result;
import com.gerry.jnshu.service.CommentService;
import com.gerry.jnshu.service.ReplyService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping("reply")
@RestController
public class ReplyController {


    @Resource
    private ReplyService replyService;

    @RequestMapping(value = "/{commentId}",method = RequestMethod.GET)
    public Result<ReplyDTO> getCommentList(@PathVariable  Integer commentId,@RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        ReplyDTO commentDTO = new ReplyDTO();

        PageInfo<Reply> commentPageInfo = replyService.getReplyList(pageNum,pageSize,commentId);

        commentDTO.setCurrentPage(commentPageInfo.getPageNum());
        commentDTO.setTotalPages(commentPageInfo.getPages());
        commentDTO.setTotalNum(commentPageInfo.getTotal());
        commentDTO.setLit(commentPageInfo.getList());
        return Result.success(commentDTO,"查询成功");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result<Integer> deleteBannerInfo(@PathVariable Integer id){
        int rowIds = replyService.deleteReplyInfo(id);
        if(rowIds<=0){
            return Result.success(null,"删除失败,记录不存在");
        }
        return Result.success(null,"删除成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Result<Object> addCategory(@Valid Reply comment){
        Integer categoryId = replyService.saveReplyInfo(comment);
        return Result.success(categoryId,"保存成功");
    }

}
