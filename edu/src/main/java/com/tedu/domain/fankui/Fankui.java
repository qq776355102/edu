package com.tedu.domain.fankui;

import java.util.Date;

public class Fankui {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 账户
     */
    private String acount;

    /**
     * 内容
     */
    private String conten;

    /**
     * 时间
     */
    private Date date;

    /**
     * 状态
     */
    private Integer status;

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
     * 账户
     * @return acount 账户
     */
    public String getAcount() {
        return acount;
    }

    /**
     * 账户
     * @param acount 账户
     */
    public void setAcount(String acount) {
        this.acount = acount == null ? null : acount.trim();
    }

    /**
     * 内容
     * @return conten 内容
     */
    public String getConten() {
        return conten;
    }

    /**
     * 内容
     * @param conten 内容
     */
    public void setConten(String conten) {
        this.conten = conten == null ? null : conten.trim();
    }

    /**
     * 时间
     * @return date 时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 时间
     * @param date 时间
     */
    public void setDate(Date date) {
        this.date = date;
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
}