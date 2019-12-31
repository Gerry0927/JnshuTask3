package com.gerry.jnshu.service;

import com.gerry.jnshu.mapper.CommentMapper;
import com.gerry.jnshu.mapper.ReplyMapper;
import com.gerry.jnshu.pojo.Article;
import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.pojo.Reply;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private ReplyMapper replyMapper;
    @Override
    public PageInfo<Comment> getCommentList( Integer pageNum,Integer pageSize,Integer articleId) {

        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Comment.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("articleId",articleId);
        List<Comment> studentList = commentMapper.selectByExample(example);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(studentList);
        return pageInfo;
    }

    @Override
    public Integer saveCommentInfo(Comment comment) {
        Integer commentId = commentMapper.insertSelective(comment);
        return commentId;
    }

    @Override
    public int deleteCommentInfo(Integer id) {
        commentMapper.deleteByPrimaryKey(id);

        Example example = new Example(Reply.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("commentId",id);
        int rowId = replyMapper.deleteByExample(example);
        return rowId;
    }

}
