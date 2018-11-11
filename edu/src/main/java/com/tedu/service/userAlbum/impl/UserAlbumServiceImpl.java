package com.tedu.service.userAlbum.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.userAlbum.mapper.UserAlbumMapper;
import com.tedu.domain.userAlbum.UserAlbum;

/**
 * @author mc  qq:776355102
 * @since 2018年9月11日
 * 	
 * 用户与专辑关系表：用户————关注————专辑
 */
@Service
@Transactional
public class UserAlbumServiceImpl {

	@Autowired
	private UserAlbumMapper mapper;
	
	/**
	 * 查询用户是否关注此专辑
	 * @param userId
	 * @param albumId
	 * @return
	 */
	public UserAlbum getGuanzhuByUserIdAndAlbumId(int userId,int albumId) {
		UserAlbum ua = mapper.selectByUserIdAndAlbumId(userId, albumId);
		return ua;
	}
	
	/**
	 * 插入记录
	 * @param userAlbum
	 * @return
	 */
	public UserAlbum insertUserAlbumSelective(UserAlbum userAlbum) {
		UserAlbum ua = mapper.selectByUserIdAndAlbumId(userAlbum.getUserId(), userAlbum.getAlbumId());
		if (ua == null) {
			int i = mapper.insertSelective(userAlbum);
		}
		return userAlbum;
	}
	
}
