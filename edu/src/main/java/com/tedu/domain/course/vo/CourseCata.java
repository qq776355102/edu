package com.tedu.domain.course.vo;

import java.io.Serializable;

/**
 * @author mc qq_776355102
 * @since JDK1.8
 * @version 1.0
 * @date 2018年8月31日
 * 
 * 用户查询课程列表
 * 
 */
public class CourseCata implements Serializable{


	private static final long serialVersionUID = -6594139579330235517L;
	
	

    /*
     *--------------------------------------------------
     * 课程相关
     *--------------------------------------------------
     */
	
	
	/**
	 * 	课程id 
	 */
	private int courseId;
	
	/**
	 *  课程标题
	 */
	private String courseTitle;
	
	/**
	 * 课程简介
	 */
	private String courseIntroduction;
	
	/**
	 * 	课程列表大小
	 */
	private int courseListSize;

	/**
	 * 	课程开发者 用户id
	 */
	private int courseUserId;
	
	
	/**
	 * 	课程开发者用户名
	 */
	private String courseUserName;
	
	/**
	 *  开发者头像名
	 */
	private String courseUserPortrait;
	
	/**
	 *  课程最新更新日期
	 */
	private String courseLatestUpdateDate;

	

    /*
     *--------------------------------------------------
     * 当前用户与课程开发者之间的关系
     *--------------------------------------------------
     */
	
	
	
	/**
	 * 当前用用户是否是此课程开发者粉丝/当前用户是否关注此课程作者
	 *
	 */
	private boolean isFan;
	
	
	
    /*
     *--------------------------------------------------
     * 当前用户与课程之间的关系
     *--------------------------------------------------
     */
	
	/**
	 *  是否已购买
	 */
	private boolean isPurchased;
	
	
	
	
	
	
	/**
	 *  当前用户id
	 */
	private int userId;






	public int getCourseId() {
		return courseId;
	}






	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}






	public String getCourseTitle() {
		return courseTitle;
	}






	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}






	public int getCourseListSize() {
		return courseListSize;
	}






	public void setCourseListSize(int courseListSize) {
		this.courseListSize = courseListSize;
	}






	public int getCourseUserId() {
		return courseUserId;
	}






	public void setCourseUserId(int courseUserId) {
		this.courseUserId = courseUserId;
	}






	public String getCourseUserPortrait() {
		return courseUserPortrait;
	}






	public void setCourseUserPortrait(String courseUserPortrait) {
		this.courseUserPortrait = courseUserPortrait;
	}






	public String getCourseLatestUpdateDate() {
		return courseLatestUpdateDate;
	}






	public void setCourseLatestUpdateDate(String courseLatestUpdateDate) {
		this.courseLatestUpdateDate = courseLatestUpdateDate;
	}






	public boolean getIsFan() {
		return isFan;
	}






	public void setIsFan(boolean isFan) {
		this.isFan = isFan;
	}






	public boolean isPurchased() {
		return isPurchased;
	}






	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}






	public int getUserId() {
		return userId;
	}






	public void setUserId(int userId) {
		this.userId = userId;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	public String getCourseUserName() {
		return courseUserName;
	}






	public void setCourseUserName(String courseUserName) {
		this.courseUserName = courseUserName;
	}






	public String getCourseIntroduction() {
		return courseIntroduction;
	}






	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}
	
	

}
