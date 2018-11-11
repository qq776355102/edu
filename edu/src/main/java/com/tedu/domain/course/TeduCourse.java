package com.tedu.domain.course;

import java.util.Date;

public class TeduCourse {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 课程标题
     */
    private String title;

    /**
     * 课程上传者
     */
    private Integer userId;

    /**
     * 作品简介
     */
    private String introduction;

    /**
     * 课程发布日期
     */
    private Date date;

    /**
     * 购买须知
     */
    private String notesBuy;

    /**
     * 课程图片
     */
    private String picture;

    /**
     * 课程费用
     */
    private String cost;

    /**
     * 课程资源地址
     */
    private String resource;

    /**
     * 课程类别
     */
    private int category;

    /**
     * 课程状态
     */
    private int status;

    /**
     * 课程播放次数
     */
    private Integer bofangCount;

    /**
     * 课程时长
     */
    private String length;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 课程标题
     * @return title 课程标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 课程标题
     * @param title 课程标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 课程上传者
     * @return user_id 课程上传者
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 课程上传者
     * @param userId 课程上传者
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 作品简介
     * @return introduction 作品简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 作品简介
     * @param introduction 作品简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 课程发布日期
     * @return date 课程发布日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 课程发布日期
     * @param date 课程发布日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 购买须知
     * @return notes_buy 购买须知
     */
    public String getNotesBuy() {
        return notesBuy;
    }

    /**
     * 购买须知
     * @param notesBuy 购买须知
     */
    public void setNotesBuy(String notesBuy) {
        this.notesBuy = notesBuy == null ? null : notesBuy.trim();
    }

    /**
     * 课程图片
     * @return picture 课程图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 课程图片
     * @param picture 课程图片
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * 课程费用
     * @return cost 课程费用
     */
    public String getCost() {
        return cost;
    }

    /**
     * 课程费用
     * @param cost 课程费用
     */
    public void setCost(String cost) {
        this.cost = cost == null ? null : cost.trim();
    }

    /**
     * 课程资源地址
     * @return resource 课程资源地址
     */
    public String getResource() {
        return resource;
    }

    /**
     * 课程资源地址
     * @param resource 课程资源地址
     */
    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    /**
     * 课程类别
     * @return category 课程类别
     */
    public int getCategory() {
        return category;
    }

    /**
     * 课程类别
     * @param category 课程类别
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * 课程状态
     * @return status 课程状态
     */
    public int getStatus() {
        return status;
    }

    /**
     * 课程状态
     * @param status 课程状态
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 课程播放次数
     * @return bofang_count 课程播放次数
     */
    public Integer getBofangCount() {
        return bofangCount;
    }

    /**
     * 课程播放次数
     * @param bofangCount 课程播放次数
     */
    public void setBofangCount(Integer bofangCount) {
        this.bofangCount = bofangCount;
    }

    /**
     * 课程时长
     * @return length 课程时长
     */
    public String getLength() {
        return length;
    }

    /**
     * 课程时长
     * @param length 课程时长
     */
    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }
}