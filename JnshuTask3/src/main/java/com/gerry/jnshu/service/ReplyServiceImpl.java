package com.gerry.jnshu.service;

import com.gerry.jnshu.mapper.CommentMapper;
import com.gerry.jnshu.mapper.ReplyMapper;
import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.pojo.Reply;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private ReplyMapper replyMapper;
    @Override
    public PageInfo<Reply> getReplyList(Integer pageNum, Integer pageSize, Integer commentId) {

        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Reply.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("commentId",commentId);
        List<Reply> replyList = replyMapper.selectByExample(example);
        PageInfo<Reply> pageInfo = new PageInfo<Reply>(replyList);
        return pageInfo;
    }

    @Override
    public Integer saveReplyInfo(Reply comment) {
        Integer commentId = replyMapper.insertSelective(comment);
        return commentId;
    }

    @Override
    public int deleteReplyInfo(Integer id) {
        return replyMapper.deleteByPrimaryKey(id);
    }
}
