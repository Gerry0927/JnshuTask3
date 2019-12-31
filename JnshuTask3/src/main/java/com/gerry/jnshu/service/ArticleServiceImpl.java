package com.gerry.jnshu.service;

import com.gerry.jnshu.mapper.ArticleMapper;
import com.gerry.jnshu.mapper.CommentMapper;
import com.gerry.jnshu.mapper.ImageInfoMapper;
import com.gerry.jnshu.mapper.ReplyMapper;
import com.gerry.jnshu.pojo.Article;
import com.gerry.jnshu.pojo.Comment;
import com.gerry.jnshu.pojo.ImageInfo;
import com.gerry.jnshu.pojo.Reply;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ImageInfoMapper imageInfoMapper;

    @Override
    public PageInfo<Article> getArticleList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Article> studentList = articleMapper.queryAllArticle();
        PageInfo<Article> pageInfo = new PageInfo<Article>(studentList);
        return pageInfo;
    }

    @Override
    public Integer saveArticleInfo(Article article) {
        Integer articleId = articleMapper.insertSelective(article);
        if(articleId>0){
            List<String> imgUrls = article.getImgUrlInfo();
            List<ImageInfo> imageInfos = new ArrayList<>();
            for (String url : imgUrls) {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setRelationId(articleId);
                imageInfo.setType(1);
                imageInfo.setImagePath(url);
                imageInfos.add(imageInfo);
            }
            imageInfoMapper.insertImageUrls(imageInfos);
        }
        return articleId;
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    @Transactional
    public int deleteArticle(Integer id) {
        int rowIds= articleMapper.deleteByPrimaryKey(id);
        Example example = new Example(ImageInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("relationId",id);
        imageInfoMapper.deleteByExample(example);
        return rowIds;
    }
}
