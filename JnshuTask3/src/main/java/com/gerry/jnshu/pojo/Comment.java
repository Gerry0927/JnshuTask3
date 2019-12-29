package com.gerry.jnshu.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "comment")
public class Comment {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 作品id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 编辑人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取作品id
     *
     * @return article_id - 作品id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置作品id
     *
     * @param articleId 作品id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取编辑人id
     *
     * @return user_id - 编辑人id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置编辑人id
     *
     * @param userId 编辑人id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}