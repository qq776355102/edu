package com.tedu.service.userjifen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.userjifen.mapper.UserJifenMapper;
import com.tedu.domain.duihuanjifen.DuihuanJifen;
import com.tedu.domain.userjifen.UserJifen;

@Service
@Transactional
public class UserJifenServiceImpl {

	@Autowired
	private UserJifenMapper mapper;
	
	public UserJifen getByUserId(int userId) {
		return mapper.selectByUserId(userId);
	}
	
	public void updatejifenByUserId(UserJifen record) {
		mapper.updateByUserId(record);
	}
	
	public void insert(UserJifen userJifen) {
		mapper.insert(userJifen);
	}
	
}
