package com.tedu.controller.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.common.exception.MedicalException;
import com.tedu.domain.user.User;
import com.tedu.service.user.impl.UserServiceImpl;

@Controller
@RequestMapping("/test")
public class test {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@ResponseBody
	@RequestMapping("/1")
	public String test1() throws MedicalException {
		User userByPhonenumber = userServiceImpl.getUserByPhonenumber("17607117571");
		System.err.println("userByPhonenumber");
		return "sds";
	}
}
