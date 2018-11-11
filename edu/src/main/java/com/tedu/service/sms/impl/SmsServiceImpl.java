package com.tedu.service.sms.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alicom.dysms.api.AliyunSms;
import com.aliyuncs.exceptions.ClientException;
import com.tedu.common.exception.MedicalException;
import com.tedu.dao.sms.mapper.SmsMapper;
import com.tedu.domain.sms.Sms;

@Service
@Transactional
public class SmsServiceImpl{

	
	@Autowired
	private SmsMapper mapper;
	
	
	/* (non-Javadoc)
	 * @see com.tedu.service.sms.ISmsService#getIdentifyCode(java.lang.String, int)
	 * 返回短信验证码
	 */
	public void getIdentifyCode(String phoneNumber,int type) throws MedicalException {
		Sms sms = mapper.selectByPrimaryKey(phoneNumber);
		if (sms == null) {
			String code = generateIdentifyCode();
			Sms smsNew = new Sms();
			smsNew.setIdenifyCode(code);
			smsNew.setPhonenumber(phoneNumber);
			smsNew.setStatus(1);
			smsNew.setType(type);
			try {
				AliyunSms.sendSms(phoneNumber, code, type);
				mapper.insertSelective(smsNew);
			} catch (Exception e) {
				throw new MedicalException("系统异常，获取信验证码失败");
			}
		}else {
			Date date = sms.getDate();
			long now = System.currentTimeMillis();
			Long oldl = date.getTime();
				BigInteger subtract = BigInteger.valueOf(now).subtract(BigInteger.valueOf(oldl));
				int i = BigInteger.valueOf(300000L).compareTo(subtract);
				//验证码在5分钟内有效
				if (i > 0) { //验证码有效
				}else {
					String code = generateIdentifyCode();
					Sms smsNew = new Sms();
					smsNew.setIdenifyCode(code);
					smsNew.setPhonenumber(phoneNumber);
					smsNew.setStatus(1);
					smsNew.setType(type);
					try {
						AliyunSms.sendSms(phoneNumber, code, type);
						mapper.insertSelective(smsNew);
					} catch (Exception e) {
						throw new MedicalException("系统异常，获取信验证码失败");
					}
				} 
		}
	}

	/**
	 * 更新短信数据状态为否
	 * @param phoneNumber
	 */
	public void updateIdentifyCodeStatus(String phoneNumber,String idenifyCode) {
		Sms sms = new Sms();
		sms.setPhonenumber(phoneNumber);
		sms.setIdenifyCode(idenifyCode);
		sms.setStatus(0);
		mapper.updateByPrimaryKeySelective(sms);
	}
	//生成短信验证码
	private String generateIdentifyCode() {
		return String.valueOf(new Random().nextInt(899999) + 100000);
	}
	
	public void insert(Sms sms) {
		mapper.insert(sms);
	}
	
	
	/**
	 * 
	 * 获取最新一条短信
	 * @param phoneNumber
	 * @return
	 * @throws MedicalException
	 */
	public Sms getLastestCode(String phoneNumber) throws MedicalException {
		Sms sms = mapper.selectByPrimaryKey(phoneNumber);
		if (sms == null) {
			throw new MedicalException("请重新获取短信验证码");
		}else {
			Date date = sms.getDate();
			long now = System.currentTimeMillis();
			Long oldl = date.getTime();
				BigInteger subtract = BigInteger.valueOf(now).subtract(BigInteger.valueOf(oldl));
				int i = BigInteger.valueOf(300000L).compareTo(subtract);
				//验证码在5分钟内有效
				if (i > 0) { //验证码有效
					return sms;
				}else {
					throw new MedicalException("短信验证码失效,请重新获取");
				}
		}
	}
	
}
