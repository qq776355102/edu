package com.tedu.service.qianbao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.common.core.Constant;
import com.tedu.dao.qbalance.mapper.QBalanceMapper;
import com.tedu.dao.qianbao.mapper.QianbaoMapper;
import com.tedu.domain.qbalance.QBalance;
import com.tedu.domain.qianbao.Qianbao;
import com.tedu.domain.user.User;
import com.tedu.service.qbaobalance.QBalanceServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class QianbaoServiceImpl {

	@Autowired
	private QianbaoMapper mapper;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private QBalanceMapper qBalanceMapper;
	
	@Autowired
	private QBalanceServiceImpl qBalanceService;
	
	public JSONObject getTokenBalanceAndDetail(Integer userId,int offset,int rows,String coinType) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Qianbao qianbao = new Qianbao();
		User u = userService.getUserInfoById(userId);
		String address = u.getAddress();
		qianbao.setFromAddress(address);
		qianbao.setUserid(userId);
		if (coinType.equals("ETH")) {
			qianbao.setCoinType(Constant.ETH);
		}else {
			qianbao.setCoinType(Constant.TED);
		}
		map.put("bean", qianbao);
		map.put("offset", offset);
		map.put("rows", rows);
		List<Qianbao> pageList = mapper.getPageList(map);
		//TODO
		/*QBalance qBalance = qBalanceMapper.selectByUserIdAndAddress(userId, address);*/
		//更新
		qBalanceService.getUpdateTedBalnace(address,coinType);
		JSONObject jo = new JSONObject();
		/*jo.put("balance", qBalance.getTotalBalance());
		jo.put("freedzeBalance", qBalance.getFreezeBalance());
		JSONArray jsonArray = new JSONArray();
		for (Qianbao qb : pageList) {
			JSONObject jsonObject = new JSONObject();
			switch (qb.getType()) {
			case 0:
				jsonObject.put("content", "转账");
				break;
			case 1:
				jsonObject.put("content", "充值");
				break;
			case 2:
				jsonObject.put("content", "课程收入");
					break;
			case 3:
				jsonObject.put("content", "体现");
				break;
			case 4:
				jsonObject.put("content", "课程购买");
				break;
			case 5:
				jsonObject.put("content", "冻结");
				break;
			case 6:
				jsonObject.put("content", "分红");
					break;
			default:
				break;
			}
			if (qb.getContent() != null && qb.getContent() != "") {
				jsonObject.put("content", qb.getContent());
			}
			jsonObject.put("date", qb.getDate());
			jsonObject.put("amount", qb.getBalance());
			if (qb.getStatus() == 0) {
				jsonObject.put("statusDesc", "失败");
			}else if (qb.getStatus() == 1) {
				jsonObject.put("statusDesc", "处理中");
			}else if (qb.getStatus() == 2) {
				jsonObject.put("statusDesc", "成功");
			}
			jsonArray.add(jsonObject);
		}
		jo.put("transactionDetail", jsonArray);*/
		return jo;
	}
	

}
