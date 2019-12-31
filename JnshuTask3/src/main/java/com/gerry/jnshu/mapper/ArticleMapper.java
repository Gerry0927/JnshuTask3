package com.gerry.jnshu.mapper;

import com.gerry.jnshu.pojo.Article;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ArticleMapper extends Mapper<Article> {

    List<Article> queryAllArticle();
}