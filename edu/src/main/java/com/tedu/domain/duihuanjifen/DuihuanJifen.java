package com.tedu.domain.duihuanjifen;

import java.util.Date;

public class DuihuanJifen {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String rate;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return rate 
     */
    public String getRate() {
        return rate;
    }

    /**
     * 
     * @param rate 
     */
    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    /**
     * 
     * @return date 
     */
    public Date getDate() {
        return date;
    }

    /**
     * 
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 
     * @return status 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     * @return user_id 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}