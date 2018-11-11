package com.tedu.domain.userjifen;

import java.math.BigDecimal;
import java.util.Date;

public class UserJifen {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户积分
     */
    private String jifen;

    /**
     * 积分充值日期
     */
    private Date date;

    /**
     * 积分来源;0:充值以太坊;1:充值tedu
     */
    private Integer type;

    /**
     * 数据状态
     */
    private Integer status;

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
     * 用户积分
     * @return jifen 用户积分
     */
    public String getJifen() {
        return jifen;
    }

    /**
     * 用户积分
     * @param jifen 用户积分
     */
    public void setJifen(String jifen) {
        this.jifen = jifen;
    }

    /**
     * 积分充值日期
     * @return date 积分充值日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 积分充值日期
     * @param date 积分充值日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 积分来源;0:充值以太坊;1:充值tedu
     * @return type 积分来源;0:充值以太坊;1:充值tedu
     */
    public Integer getType() {
        return type;
    }

    /**
     * 积分来源;0:充值以太坊;1:充值tedu
     * @param type 积分来源;0:充值以太坊;1:充值tedu
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 数据状态
     * @return status 数据状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 数据状态
     * @param status 数据状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}