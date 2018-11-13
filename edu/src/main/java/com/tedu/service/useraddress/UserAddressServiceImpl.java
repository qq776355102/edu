package com.tedu.service.useraddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.useraddress.mapper.UserAddressMapper;
import com.tedu.domain.useraddress.UserAddress;

@Service
@Transactional
public class UserAddressServiceImpl {

	@Autowired
	private UserAddressMapper mapper;
	
	public UserAddress getByAddress(String address) {
		 return  mapper.selectByAddress(address);
	}
	
	public UserAddress getByUserId(int userId) {
		return mapper.selectByUserId(userId);
	}
}
