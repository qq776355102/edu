package com.tedu.service.usercourse.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.usercourse.mapper.UserCourseMapper;
import com.tedu.domain.usercourse.*;

@Service
@Transactional
public class UserCourseServiceImpl {

	@Autowired
	private UserCourseMapper mapper;
	
	/**
	 * 检查是否已经此专辑或者课程
	 * @param userId
	 * @param courseId
	 * @param albumId
	 * @return
	 */
	public boolean checkIsBuyed(int userId,int courseId,int albumId) {
		UserCourse userCourse = new UserCourse();
		userCourse.setUserId(userId);
		userCourse.setCourseId(courseId);
		userCourse.setCourseAlbumId(albumId);
		int i = mapper.checkIsBuyed(userCourse);
		if (i>0) {
			return true;
		}
		return false;
	}
	

}
