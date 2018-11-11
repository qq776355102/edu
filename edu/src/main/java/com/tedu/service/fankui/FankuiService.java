package com.tedu.service.fankui;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.fankui.mapper.FankuiMapper;
import com.tedu.domain.fankui.Fankui;

@Service
public class FankuiService {

	@Autowired
	private FankuiMapper mapper;
	public void add(String acount,String conten) {
		Fankui fankui = new Fankui();
		fankui.setAcount(acount);
		fankui.setConten(conten);
		fankui.setDate(new Date());
		fankui.setStatus(1);
		mapper.insertSelective(fankui);
	}
}
