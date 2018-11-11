package com.tedu.service.userfans.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.page.PageMethod;
import com.tedu.dao.user.mapper.FansMapper;
import com.tedu.domain.user.Fans;


@Service
@Transactional
public class UserfansServiceImpl {

	@Autowired
	private FansMapper fansMapper;
	
	/**
	 *	检查数据记录是否存在
	 * @param fans
	 * @return
	 * @throws Exception
	 */
	public int checkUserfans(Fans fans) throws Exception {
		return fansMapper.getCheckBy(fans);
	}
	
	/**
	 * 根据用于id查询
	 * @param userId
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public List<Fans> getPageListByUserId(int userId,int offset,int rows) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Fans fans = new Fans();
		fans.setUserId(userId);
		PageMethod.offsetPage(offset, rows);
		List<Fans> fansList = fansMapper.getList(fans);
		return fansList;
	}
	
	/**
	 * 关注/取消关注用户
	 * 
	 * @param guanzhuUserId
	 * @param userId
	 * @throws Exception 
	 */
	public void updateGuanzhu(int guanzhuUserId,int userId) throws Exception {
		Fans fans = new Fans();
		fans.setFanId(userId+"");
		fans.setUserId(userId);
		fans.setStatus(0);
		int update = fansMapper.updateByPrimaryKey(fans);
	}
	
}
