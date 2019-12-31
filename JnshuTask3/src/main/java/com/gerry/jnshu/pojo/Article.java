package com.gerry.jnshu.pojo;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "article")
public class Article {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 作品名称
     */
    private String name;

    /**
     * 作者id
     */
    @Column(name = "authorId")
    private Integer authorid;

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
     * 操作人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 作品简介
     */
    private String description;

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
     * 获取分类id
     *
     * @return category_id - 分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id
     *
     * @param categoryId 分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取作品名称
     *
     * @return name - 作品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置作品名称
     *
     * @param name 作品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取作者id
     *
     * @return authorId - 作者id
     */
    public Integer getAuthorid() {
        return authorid;
    }

    /**
     * 设置作者id
     *
     * @param authorid 作者id
     */
    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
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
     * 获取操作人id
     *
     * @return user_id - 操作人id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置操作人id
     *
     * @param userId 操作人id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取作品简介
     *
     * @return description - 作品简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置作品简介
     *
     * @param description 作品简介
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Transient
    public List<String> imgUrlInfo;
    @Transient
    private String imgUrls;

    public List<String> getImgUrlInfo() {
        return imgUrlInfo;
    }

    public void setImgUrlInfo(List<String> imgUrlInfo) {
        this.imgUrlInfo = imgUrlInfo;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }
}