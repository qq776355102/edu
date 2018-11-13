package com.tedu.service.qianbao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.common.core.Constant;
import com.tedu.dao.qbalance.mapper.QBalanceMapper;
import com.tedu.dao.qianbao.mapper.QianbaoMapper;
import com.tedu.dao.useraddress.mapper.UserAddressMapper;
import com.tedu.domain.qbalance.QBalance;
import com.tedu.domain.qianbao.Qianbao;
import com.tedu.domain.user.User;
import com.tedu.domain.useraddress.UserAddress;
import com.tedu.service.qbaobalance.QBalanceServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;
import com.tedu.service.useraddress.UserAddressServiceImpl;

import cn.cmc.http.HttpClientUtil;
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
	
	@Autowired
	private UserAddressServiceImpl userAddressService;
	
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
	
	public void chongzhi(int userId) {
		//根据地址查询最后充值块高

		
		UserAddress userAddress = userAddressService.getByUserId(userId);
		
		if (userAddress!=null && userAddress.getEthAddress()!="") {

			String endblockHex = HttpClientUtil.getInstance().sendHttpGet("https://api.etherscan.io/api?module=proxy&action=eth_blockNumber&apikey=86KCV5GY545QR78USA4XAH5YDU9IFRCK9D");
			endblockHex= JSONObject.fromObject(endblockHex).getString("result");
			endblockHex =new BigInteger( endblockHex.substring(1), 16).toString(10);
			String toAddress = userAddress.getEthAddress();
			Qianbao qianbao = mapper.selectLastByAddress(toAddress);
			String startblock = qianbao.getBlockNumber();
		String url = "https://api.etherscan.io/api?action=txlist&address="+
				toAddress
	+ "&startblock="
	+ startblock
	+ "&endblock="
	+ endblockHex
	+ "&page=1&offset=60&sort=asc&apikey=86KCV5GY545QR78USA4XAH5YDU9IFRCK9D&module=account";
		String sendHttpGet = HttpClientUtil.getInstance().sendHttpGet(url);
		JSONArray result = JSONObject.fromObject(sendHttpGet).getJSONArray("result");
		for (Object object : result) {
			JSONObject transaction = JSONObject.fromObject(object);
			String input = transaction.getString("input");
			if(input.equals("0x")) { //eth交易
				//插入记录
				Qianbao qb = new Qianbao();
				String blockNumber = transaction.getString("blockNumber");
				String from = transaction.getString("from");
				String to = transaction.getString("to");
				String gas = transaction.getString("gas");
				String gasUsed = transaction.getString("gasUsed");
				String txreceipt_status = transaction.getString("txreceipt_status");
				String hash = transaction.getString("hash");
				String timeStamp = transaction.getString("timeStamp");
				timeStamp = timeStamp2Date(timeStamp,null);
				String value = transaction.getString("value");
				value = new BigDecimal(value).divide(BigDecimal.valueOf(1e18)).toPlainString();
				
				
				qb.setBlockNumber(blockNumber);
				qb.setFromAddress(from);
				qb.setToAddress(to);
				qb.setBalance(value);
				qb.setDate(timeStamp);
				qb.setCoinType("ETH");
				qb.setTxid(hash);
				qb.setStatus(Integer.valueOf(txreceipt_status));
				qb.setUserid(userId);
				qb.setContractId("");
				if (transaction.getString("to").equals(toAddress)) { //eth充值
					qb.setType(1);
					qb.setContent("充值");
				}else {
					qb.setType(-1);
					qb.setContent("");
				}
				Qianbao selectBytxid = mapper.selectBytxid(hash);
				if (selectBytxid == null) {
					mapper.insert(qb);
				}

				
			}
		}
		}
		
		

	}

public static void main(String[] args) {
	String bigInteger = new BigInteger("663373", 16).toString(10);
	System.err.println(bigInteger);
	BigDecimal.valueOf(1e18);
}
/** 
6      * 时间戳转换成日期格式字符串 
7      * @param seconds 精确到秒的字符串 
8      * @param formatStr 
9      * @return 
10      */  
    public static String timeStamp2Date(String seconds,String format) {  
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
            return "";  
        }  
         if(format == null || format.isEmpty()){
             format = "yyyy-MM-dd HH:mm:ss";
        }   
         SimpleDateFormat sdf = new SimpleDateFormat(format);  
         return sdf.format(new Date(Long.valueOf(seconds+"000")));  
     }  
}
