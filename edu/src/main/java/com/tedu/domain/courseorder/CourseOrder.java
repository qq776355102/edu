package com.tedu.domain.courseorder;

public class CourseOrder {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 专辑名
     */
    private String albumName;

    /**
     * 第几讲
     */
    private Integer order;

    /**
     * 状态
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
     * 专辑id
     * @return album_id 专辑id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 专辑id
     * @param albumId 专辑id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 专辑名
     * @return album_name 专辑名
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * 专辑名
     * @param albumName 专辑名
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    /**
     * 第几讲
     * @return order 第几讲
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 第几讲
     * @param order 第几讲
     */
    public void setOrder(Integer order) {
        this.order = order;
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