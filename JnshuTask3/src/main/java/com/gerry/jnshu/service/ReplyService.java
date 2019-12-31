package com.gerry.jnshu.service;

import com.gerry.jnshu.pojo.CategoryInfo;
import com.gerry.jnshu.pojo.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {


    PageInfo<Comment> getCommentList(Integer pageSize, Integer pageNum, Integer articleId);
//    List<Comment> getCommentList(Integer pageSize, Integer pageNum, Integer articleId);

    Integer saveCommentInfo(Comment comment);

    int deleteCommentInfo(Integer id);
}
