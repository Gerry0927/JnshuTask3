package com.gerry.jnshu.service;

import com.gerry.jnshu.pojo.Article;
import com.gerry.jnshu.pojo.BannerInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {

    PageInfo<Article> getArticleList(Integer pageNum, Integer pageSize);
    Integer saveArticleInfo(Article article);

    int updateArticle(Article article);

    int deleteArticle(Integer articleId);
}
