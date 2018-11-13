package com.tedu.controller.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.common.exception.MedicalException;
import com.tedu.common.model.ResponseDTO;
import com.tedu.domain.course.vo.TeduCourseVo;
import com.tedu.domain.fankui.Fankui;
import com.tedu.domain.user.BaseUser;
import com.tedu.domain.user.Fans;
import com.tedu.domain.user.User;
import com.tedu.service.course.impl.CourseServiceImpl;
import com.tedu.service.fankui.FankuiService;
import com.tedu.service.user.impl.UserServiceImpl;
import com.tedu.service.userfans.impl.UserfansServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/tedu/a/v/gerenCenter")
public class GeRenZhongXin extends BaseController{

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private UserfansServiceImpl userfansService;
	
	@Autowired
	private CourseServiceImpl courseService;
	
	@Autowired
	private FankuiService fankuiService;
	
	
	/**
	 * 点击我的
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getUserInfo")
	public Object getUserInfo() throws Exception {
		BaseUser baseUser = getBaseUser();
		Integer userId = baseUser.getId();
		User u = userService.getUserInfoById(userId);
		JSONObject jsonObject = new JSONObject();
		if (u.getName() !=null) {
			jsonObject.put("name", u.getName());
		}else {
			jsonObject.put("name", "");
		}
		if (u.getPortrait()!=null) {
			jsonObject.put("portrait", getUrl()+u.getPortrait());
		}else {
			jsonObject.put("portrait", "");
		}
		Map<String, String> param = new HashMap<String, String>();
		param.put("userId", userId+"");
		int fensiCount = userService.getFansCountByUserId(param);
		jsonObject.put("fensiCount", fensiCount);
		jsonObject.put("identity", u.getIdentity());
		if (u.getIntroduction()!=null) {
			jsonObject.put("introduction", u.getIntroduction());
		}else {
			jsonObject.put("introduction", "");
		}
		Map<String, String> param1 = new HashMap<String, String>();
		param1.put("fanId", userId+"");
		int guanzhuCount = userService.getFansCountByUserId(param1);
		jsonObject.put("guanzhuCount", guanzhuCount);
		return ResponseDTO.setStaticResult(jsonObject);
	}
	
	/**
	 * 获取粉丝列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getFenSiList")
	public Object getFenSiList() throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请登录之后再操作");
		}
		Fans fans = new Fans();
		fans.setUserId(baseUser.getId());
		List<Fans> userFanList = userService.getUserFanList(fans);
		List<net.sf.json.JSONObject> arrayList = new ArrayList<net.sf.json.JSONObject>();
		for (Fans fans2 : userFanList) {
			net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
			User u = userService.getUserInfoById(Integer.parseInt(fans2.getFanId()));
			if (u.getName()!= null) {
				jsonObject.put("name", u.getName());
			}else {
				jsonObject.put("name", "");
			}
			if (u.getPortrait() != null) {
				jsonObject.put("portrait", getUrl()+u.getPortrait());
			}else {
				jsonObject.put("portrait", "");
			}
			if (u.getIntroduction() != null) {
				jsonObject.put("introduction", u.getIntroduction());
			}else {
				jsonObject.put("introduction", "");
			}
			jsonObject.put("identity", u.getIdentity());
			jsonObject.put("userId", u.getId());
			Map<String, String> param = new HashMap<String, String>();
			param.put("fanId", baseUser.getId()+"");
			param.put("userId", fans2.getFanId());
			int i = userService.getFansCountByUserId(param);
			if (i>0) {
				jsonObject.put("guanzhu", true);
			}else {
				jsonObject.put("guanzhu", false);
			}
			arrayList.add(jsonObject);
		}
		return ResponseDTO.setStaticResult(arrayList);
	}
	
	/**
	 * 查看粉丝（讲师用户）的作品
	 * @param userFanId
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getOtherCourses")
	public Object getOtherCourses(@RequestParam(required=true)int userFanId,@RequestParam(defaultValue="0")int offset,@RequestParam(defaultValue="10")int rows) throws Exception {
		User u = userService.getUserInfoById(userFanId);
		net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
		if (u.getIdentity()==1) {//普通用户
			return ResponseDTO.setStaticResult(Collections.emptyList());
		}else if(u.getIdentity()==2){//讲师
			jsonObject.put("name", u.getName());
			jsonObject.put("identity", 2);
			jsonObject.put("userFanId", userFanId);
			if (u.getPortrait()!= null) {
				jsonObject.put("portrait", getUrl()+u.getPortrait());
			}
			if (u.getIntroduction()!=null) {
				jsonObject.put("introduction", u.getIntroduction());
			}
			BaseUser baseUser = getBaseUser();
			if (baseUser==null) {
				throw new MedicalException("请登录之后在操作");
			}
			Fans fan = new Fans();
			fan.setUserId(baseUser.getId());
			fan.setFanId(userFanId+"");
			int i = userfansService.checkUserfans(fan);
			if (i>0) {
				jsonObject.put("guanzhu", true);
			}else {
				jsonObject.put("guanzhu", false);
			}
			List<TeduCourseVo> courseList = courseService.getPageListById(userFanId, offset, rows);
			jsonObject.put("courseList", courseList);
		}
		return ResponseDTO.setStaticResult(jsonObject);
	}
	
	/**
	 * 查看粉丝个人资料
	 * @throws Exception 
	 * 
	 */
	@RequestMapping("getFensiZiliao")
	public Object getFensiZiliao(@RequestParam(required = true)int fanId) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser==null) {
			throw new MedicalException("请登录之后再操作");
		}
		net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
		User u = userService.getUserInfoById(fanId);
		if (u == null) {
			throw new MedicalException("请求参数有误>>fanId");
		}
		if (u.getName() != null) {
			jsonObject.put("name", u.getName());
		}else {
			jsonObject.put("name", "");
		}
		if (u.getPortrait() != null) {
			jsonObject.put("portrait", u.getPortrait());
		}else {
			jsonObject.put("portrait", "");
		}
		if (u.getIntroduction() !=null) {
			jsonObject.put("introduction", u.getIntroduction());
		}else {
			jsonObject.put("introduction", "");
		};
		jsonObject.put("identity", u.getIdentity());
		jsonObject.put("sex", u.getSex());
		if (u.getBirthday() != null) {
			jsonObject.put("birthday", u.getBirthday());
		}else {
			jsonObject.put("birthday", "");
		}
		if (u.getArea() != null) {
			jsonObject.put("area", u.getArea());
		}else {
			jsonObject.put("area", "");
		};
		Fans fans = new Fans();
		fans.setUserId(baseUser.getId());
		fans.setFanId(fanId+"");
		int i = userfansService.checkUserfans(fans);
		if (i>0) {
			jsonObject.put("guanzu", true);
		}else {
			jsonObject.put("guanzu", false);
		}
		return ResponseDTO.setStaticResult(jsonObject);
	}
	
	/**
	 * 获取关注列表
	 * @param offset
	 * @param rows
	 * @throws Exception
	 */
	@RequestMapping("getGuanzhuList")
	public Object getGuanzhuList(@RequestParam(defaultValue = "1")int offset,@RequestParam(defaultValue =  "10")int rows) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请登录之后在操作");
		}
		List<Fans> fansList = userfansService.getPageListByUserId(baseUser.getId(), offset, rows);
		JSONArray jsonArray = new JSONArray();
		for (Fans fan : fansList) {
			JSONObject jsonObject = new JSONObject();
			String fanId = fan.getFanId();
			User u = userService.getUserInfoById(Integer.valueOf(fanId));
			if (u.getName() != null) {
				jsonObject.put("name", u.getName());
			}else {
				jsonObject.put("name","");
			}
			if (u.getPortrait() != null) {
				jsonObject.put("portrait", getUrl()+u.getPortrait());
			}else {
				jsonObject.put("portrait", "");
			}
			if (u.getIntroduction() != null) {
				jsonObject.put("introduction", u.getIntroduction());
			}else {
				jsonObject.put("introduction","");
			}
			jsonObject.put("identity", u.getIdentity());
			jsonObject.put("userId", u.getId());
			jsonArray.add(jsonObject);
		}
		return ResponseDTO.setStaticResult(jsonArray);
	}
	
	/**
	 * 关注/取消关注用户
	 * @param guanzhuUserId
	 * @throws Exception 
	 */
	@RequestMapping("guanzhuFan")
	public Object guanzhuFa(int guanzhuUserId) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请登录之后再操作");
		}
		userfansService.updateGuanzhu(guanzhuUserId, baseUser.getId());
		return ResponseDTO.setStaticResult("操作成功");
	}
	
	
	/**
	 * 获取我的作品列表
	 * @param userId
	 * @throws Exception 
	 */
	@RequestMapping("getProductionList")
	public Object getProductionList(@RequestParam(defaultValue = "0")int offset,@RequestParam(defaultValue = "10")int rows) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请登录之后在操作");
		}
		JSONArray jArray = courseService.getProductionList(baseUser.getId(), offset, rows);
		return ResponseDTO.setStaticResult(jArray);
	}
	
	/**
	 * 删除我的作品某一课程
	 * @param courseId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deleteMyCourse")
	public Object deleteMyCourse(int courseId) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请登录之后在操作");
		}
		courseService.deleteMyCourse(courseId);
		return ResponseDTO.setStaticResult("操作成功");
	}
	
	/**
	 * 	意见反馈
	 * @param account
	 * @param content
	 * @return
	 */
	@RequestMapping("addFankui")
	public Object addFamkui(String account,String content) {
		fankuiService.add(account, content);
		return ResponseDTO.setStaticResult("操作成功");
	}
}
