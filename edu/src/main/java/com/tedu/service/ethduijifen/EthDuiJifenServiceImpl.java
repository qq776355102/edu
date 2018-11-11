package com.tedu.service.ethduijifen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.dao.duihuanjifen.mapper.DuihuanJifenMapper;
import com.tedu.domain.duihuanjifen.DuihuanJifen;


@Service
@Transactional
public class EthDuiJifenServiceImpl {

	@Autowired
	private DuihuanJifenMapper mapper;
	
	public DuihuanJifen getLast() {
		return mapper.getLast();
	}
}
