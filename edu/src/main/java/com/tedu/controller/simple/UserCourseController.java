package com.tedu.controller.simple;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.domain.user.BaseUser;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/appservice/v1/usercourse/api")
public class UserCourseController extends BaseController{


	/**
	 * 购买课程
	 * @param albumId
	 * @param courseId
	 */
	public void buyCourse(String albumId,String courseId) {
		BaseUser baseUser = getBaseUser();
		
	}
}
