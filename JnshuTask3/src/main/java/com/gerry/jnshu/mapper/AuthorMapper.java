package com.gerry.jnshu.mapper;

import com.gerry.jnshu.pojo.Author;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface AuthorMapper extends Mapper<Author> {
}