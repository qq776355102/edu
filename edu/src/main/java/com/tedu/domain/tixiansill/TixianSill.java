package com.tedu.domain.tixiansill;

import java.util.Date;

public class TixianSill {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 币种类型
     */
    private String coinType;

    /**
     * 操作者用户id
     */
    private Integer userId;

    /**
     * 操作日期
     */
    private Date date;

    /**
     * 阀值
     */
    private String sill;

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
     * 币种类型
     * @return coin_type 币种类型
     */
    public String getCoinType() {
        return coinType;
    }

    /**
     * 币种类型
     * @param coinType 币种类型
     */
    public void setCoinType(String coinType) {
        this.coinType = coinType == null ? null : coinType.trim();
    }

    /**
     * 操作者用户id
     * @return user_id 操作者用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 操作者用户id
     * @param userId 操作者用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 操作日期
     * @return date 操作日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 操作日期
     * @param date 操作日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 阀值
     * @return sill 阀值
     */
    public String getSill() {
        return sill;
    }

    /**
     * 阀值
     * @param sill 阀值
     */
    public void setSill(String sill) {
        this.sill = sill == null ? null : sill.trim();
    }
}