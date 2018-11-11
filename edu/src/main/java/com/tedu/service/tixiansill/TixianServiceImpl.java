package com.tedu.service.tixiansill;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.tixiansill.mapper.TixianSillMapper;
import com.tedu.domain.tixiansill.TixianSill;

import jnr.ffi.Struct.int16_t;

@Service
@Transactional
public class TixianServiceImpl {

	@Autowired
	private TixianSillMapper mapper;

	/**
	 * 查体现阀值
	 * 
	 * @param coinType
	 * @return
	 */
	public String getTixianSillByCoinType(String coinType) {
		TixianSill selectByCoinType = mapper.selectByCoinType(coinType);
		if (selectByCoinType != null) {
			return selectByCoinType.getSill();
		}
		return "0";
	}

	/**
	 * 	修改或新增体现阀值
	 * @param userId
	 * @param sill
	 * @param coinType
	 */
	public void insertSelective(int userId,String sill,String coinType) {
		TixianSill tixianSill = new TixianSill();
		tixianSill.setCoinType(coinType);
		tixianSill.setDate(new Date());
		tixianSill.setUserId(userId);
		tixianSill.setSill(sill);
		mapper.insertSelective(tixianSill);
	}

}
