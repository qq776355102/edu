 package com.tedu.controller.simple;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.common.core.Constant;
import com.tedu.common.core.SysProperties;
import com.tedu.common.exception.MedicalException;
import com.tedu.common.model.ResponseDTO;
import com.tedu.domain.sms.Sms;
import com.tedu.domain.user.BaseUser;
import com.tedu.domain.user.User;
import com.tedu.service.sms.impl.SmsServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;
import com.tedu.service.useridentityupgrade.impl.UserIdentityUpgradeServiceImpl;

import jnr.ffi.types.int16_t;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/tedu/a/v/user")
public class UserController extends BaseController{


	@Resource
	private SmsServiceImpl smsService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserIdentityUpgradeServiceImpl userIdentityUpgradeService;
	

	
	/**
	 * 用户注册短信验证码校验,同时登录
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("/register")
	public Object register2(HttpServletRequest request,@RequestParam(required = true)String phoneNumber,@RequestParam(required = true)String indentifyCode,@RequestParam(required = true)String passWord) throws Exception {
		//查询校验验证码
		Sms sms = smsService.getLastestCode(phoneNumber);
		
		User u = null;
		if (sms.getIdenifyCode().equals(indentifyCode)) {
			//注册成功,session 保存用户
			com.tedu.domain.user.User user = new com.tedu.domain.user.User();
			user.setPhone(phoneNumber);
			user.setSex(0);
			user.setIdentity(1);
			user.setPassWord(passWord);
			user.setStatus(1); //数据状态是
			//地址
			
			
			u = userService.insertSelective(user);
			BaseUser bu = new BaseUser();
			bu.setId(u.getId());
			bu.setIdentity(u.getIdentity());
			//保存session
			request.getSession().setAttribute("user", bu);
			//更改验证码状态
			smsService.updateIdentifyCodeStatus(phoneNumber,indentifyCode);
		}else {
			//验证码不正确
			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setErrorinfo("验证码有误", "5");
			return responseDTO;
		}
		return ResponseDTO.setStaticResult(u.getId());
	}
	
	
	/**
	 * 
	 * 验证码登录
	 * @throws MedicalException 
	 * 
	 */
	@RequestMapping("/loginOfIndentifyCode")
	public Object ApplyToBecomeALecturer(HttpServletRequest request,@RequestParam(required=true)String phoneNumber,@RequestParam(required = true)String indentifyCode) throws MedicalException {
		Sms sms = smsService.getLastestCode(phoneNumber);
		int id = -1;
		if (sms.getIdenifyCode().equals(indentifyCode)) {
			//登录成功 ,session,保存会话
			User u = userService.getUserByPhonenumber(phoneNumber);
			BaseUser bu = new BaseUser();
			bu.setId(u.getId());
			id = u.getId();
			bu.setIdentity(u.getIdentity());
			bu.setPhone(u.getPhone());
			request.getSession().setAttribute("user", bu);
			//更改验证码状态
			smsService.updateIdentifyCodeStatus(phoneNumber,indentifyCode);
		}else {
			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setErrorinfo("验证码有误", "5");
			return responseDTO;
		}
		return ResponseDTO.setStaticResult(id);
	}
	
	/**
	 * 密码登录
	 * 
	 * @param request
	 * @param phone
	 * @param passWord
	 * @throws MedicalException 
	 */
	@RequestMapping("/loginOfPassWord")
	public Object loginOfPassWord(HttpServletRequest request,@RequestParam(required=true)String phoneNumber,@RequestParam(required=true)String passWord) throws MedicalException {
		User u = userService.getUserByPhoneAndPassWord(phoneNumber, passWord);
		int id = -1;
		if (u != null) {
			BaseUser bu = new BaseUser();
			bu.setId(u.getId());
			id=u.getId();
			bu.setIdentity(u.getIdentity());
			bu.setPhone(u.getPhone());
			request.getSession().setAttribute("user", bu);
			return ResponseDTO.setStaticResult(id);
		}
		ResponseDTO responseDTO = new ResponseDTO();
		return responseDTO.setErrorinfo("登录失败", "6");
	}
	
	
	/**
	 * 更改用户信息
	 * @param portrait 头像
	 * @param name 名称
	 * @param introduction 介绍
	 * @param sex 性别
	 * @param birthday 出生年月
	 * @param area 地区
	 * @throws Exception 
	 */
	@RequestMapping("updateUserInfo")
	public Object updateUserInformation(MultipartFile image,@RequestParam(required = true)String name,String introduction,@RequestParam(defaultValue = "0")int sex,String birthday,String area) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登陆账户");
		}
		User user = new User();
		user.setId(baseUser.getId());
		user.setName(name);
		if (image != null) {
			String pathUrl = SavePicture(image);
			user.setPortrait(pathUrl);
		}
		user.setSex(sex);
		if (introduction!= null) {
			user.setIntroduction(introduction);
		}
		if (birthday != null) {
			user.setBirthday(birthday);
		}
		if (area != null) {
			user.setArea(area);
		}
		user.setStatus(1);
		userService.getUpdate(user);
		return ResponseDTO.setStaticResult("更新成功");
	}
	
	
	/**
	 * 
	 * 申请成为讲师
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("applyLecturer")
	@SuppressWarnings("null")
	public Object upgradeIdentity() throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登陆之后再操作");
		}
		User u = userService.getUserInfoById(baseUser.getId());
		if (u.getName() == null || u.getName() == "null") {
			throw new MedicalException("请先完善个人 资料");
		}
		userIdentityUpgradeService.UserIdentityUpgrade(baseUser.getId());
		return ResponseDTO.setStaticResult("操作成功");
	}
	
	/**
	 * 
	 *	 用户图片保存
	 * 
	 * @param image
	 * @return 保存图片的的路径
	 * @throws MedicalException
	 * @throws IOException
	 */
	private String SavePicture(MultipartFile image) throws MedicalException, IOException {
		// 图片保存的完整图片文件保存路径
		String course_picture_path = "";
		// 生成uuid作为文件名称
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		// 获得文件类型（可以判断如果不是图片，禁止上传）
		String contentType = image.getContentType();
		// 获得文件后缀名称
		String imageName = contentType.substring(contentType.indexOf("/") + 1);
		if (!Constant.PICTURE_FORMAT.contains(imageName)) {
			throw new MedicalException("图片格式有误,请上传jpg,gif,png,bmp,jpeg格式!");
		}
		// 设置图片真实存放的文件夹路径
		String course_picture_doc_base = SysProperties.getProperty("picture_base");
		// 图片访问路径
		String course_picture_access_path = SysProperties.getProperty("picture_path");
		course_picture_path = course_picture_doc_base + uuid + "." + imageName;
		// 图片访问路径除ip和端口
		String pathUrl = course_picture_access_path + uuid + "." + imageName;
		File file = new File(course_picture_path);
		if (!file.exists()) {
			// 先得到文件的上级目录，并创建上级目录，在创建文件
			file.getParentFile().mkdir();
			try {
				// 创建文件
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		image.transferTo(file);
		return pathUrl;
	}
	/**
	 *  更改密码（通过旧密码）
	 * @param olderPassword
	 * @param newPassword
	 * @throws MedicalException 
	 */
	@RequestMapping("updateByOlderPassword")
	public Object updateByOlderPassword(@RequestParam(required = true)String oldPassword,@RequestParam(required= true)String newPassword) throws MedicalException {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请登录之后再操作");
		}
		userService.updatePassWord(baseUser.getId(), oldPassword, newPassword);
		return ResponseDTO.setStaticResult("操作成功");
	}
	
	/**
	 * 	更改密码（通过短信验证码）
	 * @param phoneNumber
	 * @param code
	 * @param newPassword
	 * @throws MedicalException 
	 */
	@RequestMapping("updateBySmscode")
	public Object updateBySmscode(HttpServletRequest request,String phoneNumber,String indentifyCode,String newPassword) throws MedicalException {
		Sms sms = smsService.getLastestCode(phoneNumber);
		if (sms.getIdenifyCode().equals(indentifyCode)) {
			//登录成功 ,session,保存会话
			User u = userService.getUserByPhonenumber(phoneNumber);
			BaseUser bu = new BaseUser();
			bu.setId(u.getId());
			bu.setIdentity(u.getIdentity());
			bu.setPhone(u.getPhone());
			request.getSession().setAttribute("user", bu);
			//更改验证码状态
			smsService.updateIdentifyCodeStatus(phoneNumber,indentifyCode);
			userService.updateBySmscode(u.getId(), newPassword);
		}else {
			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setErrorinfo("验证码有误", "5");
			return responseDTO;
		}
		return ResponseDTO.setStaticResult("操作成功");
	}
	
	/**
	 * 搜索获取讲师或用于列表
	 * @param search
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getJiangshiOrUserList")
	public Object getJiangshiOrUserList(@RequestParam(required=true)String search,@RequestParam(defaultValue  ="0")int offset,@RequestParam(defaultValue="10")int rows,@RequestParam(required=true,defaultValue="0")int type) throws Exception {
		String url = getUrl();
		BaseUser baseUser = getBaseUser();
		if (baseUser==null) {
			throw new MedicalException("请登录之后再操作");
		}
		return userService.searchUser(baseUser.getId(), search, type, offset, rows, url);
	}
}
