package com.gerry.jnshu.service;

import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.pojo.Reply;
import com.github.pagehelper.PageInfo;

public interface ReplyService {


    PageInfo<Reply> getReplyList(Integer pageSize, Integer pageNum, Integer articleId);
//    List<Comment> getCommentList(Integer pageSize, Integer pageNum, Integer articleId);

    Integer saveReplyInfo(Reply reply);

    int deleteReplyInfo(Integer id);
}
