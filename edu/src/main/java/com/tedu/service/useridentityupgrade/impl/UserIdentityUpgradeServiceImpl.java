package com.tedu.service.useridentityupgrade.impl;

import java.awt.List;
import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.useridentityupgrade.mapper.UserIdentityUpgradeMapper;
import com.tedu.domain.user.User;
import com.tedu.service.user.impl.UserServiceImpl;


/**
 * 
 * 申请成为讲师
 * @author mc  qq:776355102
 * @since 2018年9月2日
 * 	
 */
@Service
@Transactional
public class UserIdentityUpgradeServiceImpl {

	@Autowired
	private UserIdentityUpgradeMapper mapper;
	
	@Autowired
	private UserServiceImpl userService;
	
	/**
	 * 申请成为讲师
	 * @throws Exception 
	 */
	public void UserIdentityUpgrade(Integer userId) throws Exception {
		com.tedu.domain.useridentityupgrade.UserIdentityUpgrade userIdentityUpgrade = new com.tedu.domain.useridentityupgrade.UserIdentityUpgrade();
		userIdentityUpgrade.setUserId(userId);
		userIdentityUpgrade.setDate(new Date());
		userIdentityUpgrade.setStatus(1);
		userIdentityUpgrade.setIsPass(false);
		mapper.insertSelective(userIdentityUpgrade);
		
		String debug = com.tedu.common.core.SysProperties.getProperty("tedu_proj_status");
		if (debug!=null && debug.equals("debug")) {
			//临时申请直接通过
			User user = new User();
			user.setId(userId);
			user.setIdentity(2);
			userService.getUpdate(user);
		}

	}
	
	/**
	 * 获取申请讲师未通过的列表
	 * @return
	 */
	public java.util.List<com.tedu.domain.useridentityupgrade.UserIdentityUpgrade> getFuturePassUserList(){
		java.util.List<com.tedu.domain.useridentityupgrade.UserIdentityUpgrade> futureIdentityUpgrades = mapper.getFutureIdentityUpgrades();
		return futureIdentityUpgrades;
		
	}
	
	/**
	 * 更新申请未通过者的数据状态
	 */
	public void updateIsPassStatus(int id) {
		com.tedu.domain.useridentityupgrade.UserIdentityUpgrade userIdentityUpgrade = new com.tedu.domain.useridentityupgrade.UserIdentityUpgrade();
		userIdentityUpgrade.setId(id);
		userIdentityUpgrade.setIsPass(true);
		userIdentityUpgrade.setStatus(0);
		mapper.updateByPrimaryKey(userIdentityUpgrade);
	}
	
	
}
