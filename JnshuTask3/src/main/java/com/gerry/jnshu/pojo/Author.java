package com.gerry.jnshu.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "author")
public class Author {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 作者名
     */
    private String name;

    /**
     * 操作人id
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
     * 作者简介
     */
    private String deccription;

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
     * 获取作者名
     *
     * @return name - 作者名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置作者名
     *
     * @param name 作者名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取作者简介
     *
     * @return deccription - 作者简介
     */
    public String getDeccription() {
        return deccription;
    }

    /**
     * 设置作者简介
     *
     * @param deccription 作者简介
     */
    public void setDeccription(String deccription) {
        this.deccription = deccription == null ? null : deccription.trim();
    }
}