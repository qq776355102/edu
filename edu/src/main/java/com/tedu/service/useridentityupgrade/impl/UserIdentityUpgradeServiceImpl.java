package com.tedu.service.useridentityupgrade.impl;

import java.awt.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.useridentityupgrade.mapper.UserIdentityUpgradeMapper;

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
	
	/**
	 * 申请成为讲师
	 */
	public void UserIdentityUpgrade(Integer userId) {
		com.tedu.domain.useridentityupgrade.UserIdentityUpgrade userIdentityUpgrade = new com.tedu.domain.useridentityupgrade.UserIdentityUpgrade();
		userIdentityUpgrade.setUserId(userId);
		userIdentityUpgrade.setDate(new Date());
		userIdentityUpgrade.setStatus(1);
		userIdentityUpgrade.setIsPass(false);
		mapper.insertSelective(userIdentityUpgrade);
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
