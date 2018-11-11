package com.tedu.domain.user;

public class Fans {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 被关注的用户
     */
    private Integer userId;

    /**
     * 粉丝id
     */
    private String fanId;

    /**
     * 关注状态0,取消关注；1，关注
     */
    private int status;

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
     * 被关注的用户
     * @return user_id 被关注的用户
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 被关注的用户
     * @param userId 被关注的用户
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 粉丝id
     * @return fan_id 粉丝id
     */
    public String getFanId() {
        return fanId;
    }

    /**
     * 粉丝id
     * @param fanId 粉丝id
     */
    public void setFanId(String fanId) {
        this.fanId = fanId == null ? null : fanId.trim();
    }

    /**
     * 关注状态0,取消关注；1，关注
     * @return status 关注状态0,取消关注；1，关注
     */
    public int getStatus() {
        return status;
    }

    /**
     * 关注状态0,取消关注；1，关注
     * @param status 关注状态0,取消关注；1，关注
     */
    public void setStatus(int status) {
        this.status = status;
    }
}