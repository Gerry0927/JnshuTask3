package com.gerry.jnshu.pojo;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "banner")
public class BannerInfo {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 状态 0 为上架，1为下架
     */
    private Integer status;

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
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    @Transient
    public List<String> imgInfo;



    public List<String> getImgInfo() {
        return imgInfo;
    }

    public void setImgInfo(List<String> imgUrlInfo) {
        this.imgInfo = imgUrlInfo;
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
     * 获取状态 0 为上架，1为下架
     *
     * @return status - 状态 0 为上架，1为下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0 为上架，1为下架
     *
     * @param status 状态 0 为上架，1为下架
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}