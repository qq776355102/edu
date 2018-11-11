package com.tedu.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.axis2.databinding.types.soapencoding.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.common.exception.MedicalException;
import com.tedu.dao.user.mapper.FansMapper;
import com.tedu.dao.user.mapper.UserMapper;
import com.tedu.domain.course.TeduCourse;
import com.tedu.domain.user.Fans;
import com.tedu.domain.user.User;
import com.tedu.service.userfans.impl.UserfansServiceImpl;

import jnr.ffi.types.int16_t;
import net.sf.json.JSONObject;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private FansMapper fanMapper;

	@Autowired
	private UserfansServiceImpl userfansService;

	/**
	 * 新增一个用户
	 * 
	 * @param user
	 * @throws Exception
	 */
	public User insertSelective(User user) throws Exception {
		User userByPhone = mapper.getUserByPhoneNumber(user.getPhone());
		if (userByPhone != null) {
			throw new MedicalException("用户已注册");
		}
		mapper.insertSelective(user);
		return user;
	}

	/**
	 * 根据用户手机号查询用户是否登录
	 * 
	 * @param phone
	 * @return
	 * @throws MedicalException
	 */
	public User getUserByPhonenumber(String phone) throws MedicalException {
		User user = mapper.getUserByPhoneNumber(phone);
		if (user == null) {
			throw new MedicalException("未注册，请勿直接登录");
		}
		return user;
	}

	/**
	 * 根据身份统计数量 identity
	 * 
	 * @param param
	 * @return
	 */
	public int getCountBy(Map<String, Object> param) {
		return mapper.getCountBy(param);
	}

	/**
	 * 根据手机号和密码查询登录状态正否正确
	 * 
	 * @param phone
	 * @param passWord
	 * @return
	 * @throws MedicalException
	 */
	public User getUserByPhoneAndPassWord(String phone, String passWord) throws MedicalException {
		User user = mapper.getUserByPhoneAndPassWord(phone, passWord);
		if (user == null) {
			throw new MedicalException("账号不存在或密码有误");
		}
		return user;
	}

	public void updateIdentityByUserId(int id) throws Exception {
		User user = new User();
		user.setId(id);
		user.setIdentity(2);
		user.setRank(1);
		mapper.getUpdateByUser(user);
	}

	/**
	 * 根据主键id查询用户相关信息
	 * 
	 * @param id 用户表主键id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public User getUserInfoById(int id) throws Exception {
		User bean = mapper.selectByPrimaryKey(id);
		return bean;
	}

	public List<JSONObject> searchUser(int userId, String search, int identity, int offset, int rows, String url) throws Exception {
		List<User> searchLikeInstructor = mapper.searchLikeInstructor(search, identity);
		List<JSONObject> list = new ArrayList<JSONObject>();
		for (User user : searchLikeInstructor) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", user.getId());
			if (user.getPortrait() != null) {
				jsonObject.put("picture", url + user.getPortrait());
			} else {
				jsonObject.put("picture", "");
			}
			jsonObject.put("name", user.getName());
			Fans fans = new Fans();
			fans.setUserId(user.getId());
			fans.setFanId(userId + "");
			int checkUserfans = userfansService.checkUserfans(fans);
			if (checkUserfans > 0) {
				jsonObject.put("guanhzu", true);
			} else {
				jsonObject.put("guanhzu", false);
			}
			if (user.getIntroduction() == null) {
				jsonObject.put("introduction", "");
			} else {
				jsonObject.put("introduction", user.getIntroduction());
			}
			list.add(jsonObject);
		}
		return list;
	}

	/**
	 * 用户更新操作
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void getUpdate(User user) throws Exception {
		mapper.getUpdateByUser(user);
	}

	/**
	 * 根据用户id查询粉丝数量
	 * 
	 * @param userId
	 * @return
	 */
	public int getFansCountByUserId(Map<String, String> param) {
		return fanMapper.getCountByUserIdOrFanId(param);
	}

	/**
	 * 条件列表查询
	 * 
	 * @param fans
	 * @return
	 * @throws Exception
	 */
	public List<Fans> getUserFanList(Fans fans) throws Exception {
		return fanMapper.getList(fans);
	}

	/**
	 * 通过旧密码更改新密码
	 * 
	 * @param oldPassWord
	 * @param newPassWord
	 * @throws MedicalException
	 */
	public void updatePassWord(Integer userId, String oldPassWord, String newPassWord) throws MedicalException {
		User i = mapper.checkUserByPassWord(userId, oldPassWord);
		if (i != null) {
			User user = new User();
			user.setId(userId);
			user.setPassWord(newPassWord);
			try {
				mapper.getUpdateByUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new MedicalException("密码有误");
		}
	}

	/**
	 * 更改密码（通过短信验证码）
	 * 
	 * @param userId
	 * @param passWord
	 */
	public void updateBySmscode(int userId, String passWord) {
		User user = new User();
		user.setId(userId);
		user.setPassWord(passWord);
		try {
			mapper.getUpdateByUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
