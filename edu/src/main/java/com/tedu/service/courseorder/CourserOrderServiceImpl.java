package com.tedu.service.courseorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.courseorder.mapper.CourseOrderMapper;
import com.tedu.domain.courseorder.CourseOrder;


@Service
@Transactional
public class CourserOrderServiceImpl {

	@Autowired
	private CourseOrderMapper mapper;
	
	public CourseOrder getCourseOrderByid(int courseId) {
		return mapper.selectByPrimaryKey(courseId);
	}
	
	public void insertCourseOrder(CourseOrder courseOrder) {
		mapper.insertSelective(courseOrder);
	}
}
