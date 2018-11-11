package com.tedu.domain.album;

import java.math.BigDecimal;
import java.util.Date;

public class Album {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 专辑名称
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 专辑播放次数
     */
    private Integer count;

    /**
     * 专辑图片
     */
    private String picture;

    /**
     * 创建专辑的日期
     */
    private Date date;

    /**
     * 专辑简介
     */
    private String introduction;

    /**
     * 购买须知
     */
    private String notesTobuy;

    /**
     * 专辑价格
     */
    private String price;

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 专辑名称
     * @return name 专辑名称
     */
    public String getName() {
        return name;
    }

    /**
     * 专辑名称
     * @param name 专辑名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 专辑播放次数
     * @return count 专辑播放次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 专辑播放次数
     * @param count 专辑播放次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 专辑图片
     * @return picture 专辑图片
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 专辑图片
     * @param picture 专辑图片
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * 创建专辑的日期
     * @return date 创建专辑的日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 创建专辑的日期
     * @param date 创建专辑的日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 专辑简介
     * @return introduction 专辑简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 专辑简介
     * @param introduction 专辑简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 购买须知
     * @return notes_toBuy 购买须知
     */
    public String getNotesTobuy() {
        return notesTobuy;
    }

    /**
     * 购买须知
     * @param notesTobuy 购买须知
     */
    public void setNotesTobuy(String notesTobuy) {
        this.notesTobuy = notesTobuy == null ? null : notesTobuy.trim();
    }

    /**
     * 专辑价格
     * @return price 专辑价格
     */
    public String getPrice() {
        return price;
    }

    /**
     * 专辑价格
     * @param price 专辑价格
     */
    public void setPrice(String price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "Album [id=" + id + ", userId=" + userId + ", name=" + name + ", status=" + status + ", count=" + count
				+ ", picture=" + picture + ", date=" + date + ", introduction=" + introduction + ", notesTobuy="
				+ notesTobuy + ", price=" + price + "]";
	}
    
}