package com.tedu.common.timer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tedu.domain.useridentityupgrade.UserIdentityUpgrade;
import com.tedu.service.user.impl.UserServiceImpl;
import com.tedu.service.useridentityupgrade.impl.UserIdentityUpgradeServiceImpl;

@Component
public class UserIndentityUpgradeTimer {

	@Autowired
	private UserIdentityUpgradeServiceImpl userIdentityUpgradeService;
	
	@Autowired
	private UserServiceImpl userService;
	/**
	 * 每天临晨3点自动审核通过，成为讲师
	 * @throws Exception 
	 */
	@Scheduled(cron = "0 0 3 * * ?")
	public void UserIndentityUpgradePass() throws Exception {
		List<UserIdentityUpgrade> futurePassUserList = userIdentityUpgradeService.getFuturePassUserList();
		for (UserIdentityUpgrade userIdentityUpgrade : futurePassUserList) {
			userIdentityUpgradeService.updateIsPassStatus(userIdentityUpgrade.getId());
			userService.updateIdentityByUserId(userIdentityUpgrade.getUserId());
		}
	}
}
