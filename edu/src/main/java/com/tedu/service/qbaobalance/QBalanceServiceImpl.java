package com.tedu.service.qbaobalance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mc.web3j.balance.TokenBalance;
import com.tedu.dao.qbalance.mapper.QBalanceMapper;
import com.tedu.domain.qbalance.QBalance;


@Service
public class QBalanceServiceImpl {

	/*@Autowired
	private QBalanceMapper mapper;*/
	
	/**
	 * 查询Ted余额，并更新Qbalance表
	 * @param address
	 * @throws IOException 
	 */
	@Async
	public void getUpdateTedBalnace(String  address,String coinType) throws IOException {
		//TODO
		/*String tedBalance = TokenBalance.getTedBalance(address);
		QBalance qB = new QBalance();
		qB.setAddress(address);
		qB.setTotalBalance(tedBalance);
		if (coinType.equals("ETH")) {
			qB.setCoinType("ETH");
		}else {
			qB.setCoinType("TED");
		}
		mapper.updateByAddressAndCoinTypeSelective(qB);*/
	}
	
/*	public QBalance getQBalance(int userId,String address,String coinType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("address", address);
		param.put("coinType", coinType);
		QBalance qBalance = mapper.selectByUserIdAndAddress(param);
		return qBalance;
	}*/
}
