package com.gerry.jnshu.mapper;

import com.gerry.jnshu.pojo.Comment;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface CommentMapper extends Mapper<Comment> {
}