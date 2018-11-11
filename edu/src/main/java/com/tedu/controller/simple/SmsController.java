package com.tedu.controller.simple;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.common.core.Constant;
import com.tedu.common.exception.MedicalException;
import com.tedu.common.model.ResponseDTO;
import com.tedu.service.sms.impl.SmsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/tedu/a/v/sms/")
public class SmsController {

	@Resource
	private SmsServiceImpl smsService;
	
	/**
	 * 用户注册获取短信验证码
	 * @param phoneNumber
	 * @return
	 * @throws MedicalException 
	 * @RequestParam(required = true)
	 */
	@RequestMapping("getIdentifyingCode")
	public void register(String phoneNumber) throws MedicalException {
		smsService.getIdentifyCode(phoneNumber, Constant.SMS_REGISTERED);
	}
	
}
