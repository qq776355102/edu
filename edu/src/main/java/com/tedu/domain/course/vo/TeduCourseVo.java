package com.tedu.domain.course.vo;

import com.tedu.domain.course.TeduCourse;


public class TeduCourseVo extends TeduCourse{
	private static final long serialVersionUID = -821734229045770642L;

	/**
	 * 
	 */
	private String categoryDesc;
	
	private int order;

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
