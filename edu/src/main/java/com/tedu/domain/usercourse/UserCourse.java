package com.tedu.domain.usercourse;

import java.util.Date;

/**
 * @author mc qq_776355102
 * @since JDK1.8
 * @version 1.0
 * @date 2018年9月4日
 * 
 * 用户课程关系,是否购买
 */
public class UserCourse {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 是否已关注课程
     */
    private Boolean guanzhu;

    /**
     * 是否已购买课程
     */
    private Boolean isPurchased;

    /**
     * 购买课程的日期
     */
    private Date purchasedDate;

    /**
     * 课程专辑id
     */
    private Integer courseAlbumId;

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
     * 课程id
     * @return course_id 课程id
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 课程id
     * @param courseId 课程id
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 是否已关注课程
     * @return guanzhu 是否已关注课程
     */
    public Boolean getGuanzhu() {
        return guanzhu;
    }

    /**
     * 是否已关注课程
     * @param guanzhu 是否已关注课程
     */
    public void setGuanzhu(Boolean guanzhu) {
        this.guanzhu = guanzhu;
    }

    /**
     * 是否已购买课程
     * @return is_purchased 是否已购买课程
     */
    public Boolean getIsPurchased() {
        return isPurchased;
    }

    /**
     * 是否已购买课程
     * @param isPurchased 是否已购买课程
     */
    public void setIsPurchased(Boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    /**
     * 购买课程的日期
     * @return purchased_date 购买课程的日期
     */
    public Date getPurchasedDate() {
        return purchasedDate;
    }

    /**
     * 购买课程的日期
     * @param purchasedDate 购买课程的日期
     */
    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    /**
     * 课程专辑id
     * @return course_album_id 课程专辑id
     */
    public Integer getCourseAlbumId() {
        return courseAlbumId;
    }

    /**
     * 课程专辑id
     * @param courseAlbumId 课程专辑id
     */
    public void setCourseAlbumId(Integer courseAlbumId) {
        this.courseAlbumId = courseAlbumId;
    }
}