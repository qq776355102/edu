package com.tedu.domain.useridentityupgrade;

import java.util.Date;

/**
 * 申请成为讲师
 * @author mc
 * @since 2018年9月2日
 * 
 */
public class UserIdentityUpgrade {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 申请时间
     */
    private Date date;

    /**
     * 是否通过
     */
    private Boolean isPass;

    /**
     * 不通过原因
     */
    private String reason;

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
     * 申请时间
     * @return date 申请时间
     */
    public Date getDate() {
        return date;
    }

    /**
     * 申请时间
     * @param date 申请时间
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 是否通过
     * @return is_pass 是否通过
     */
    public Boolean getIsPass() {
        return isPass;
    }

    /**
     * 是否通过
     * @param isPass 是否通过
     */
    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }

    /**
     * 不通过原因
     * @return reason 不通过原因
     */
    public String getReason() {
        return reason;
    }

    /**
     * 不通过原因
     * @param reason 不通过原因
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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