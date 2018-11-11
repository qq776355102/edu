package com.tedu.service.transaction.ethreceive;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.common.exception.MedicalException;
import com.tedu.dao.ethtransaction.mapper.EthTransactionMapper;
import com.tedu.domain.czaddress.ChongzhiAddress;
import com.tedu.domain.duihuanjifen.DuihuanJifen;
import com.tedu.domain.ethtransaction.EthTransaction;
import com.tedu.domain.useraddress.UserAddress;
import com.tedu.domain.userjifen.UserJifen;
import com.tedu.service.ethduijifen.EthDuiJifenServiceImpl;
import com.tedu.service.useraddress.UserAddressServiceImpl;
import com.tedu.service.userjifen.UserJifenServiceImpl;

import cn.cmc.http.HttpPost;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
@Transactional
public class EthreceiveServiceImpl {

	@Autowired
	private EthTransactionMapper ethMapper;
	
	@Autowired
	private EthDuiJifenServiceImpl ethDuiJifenService;
	
	@Autowired
	private UserAddressServiceImpl userAddressService;
	
	@Autowired
	private UserJifenServiceImpl userJifenService;

	/**
	 * 充值ETH 判断地址地址是否有充值
	 *
	 * 收款eth最新块高
	 * 
	 * @param address 接受地址
	 * @throws MedicalException 
	 */
	public void chongZhiEth(String address) throws MedicalException {
		UserAddress userAddress = userAddressService.getByAddress(address);
		// 获得最新块高
		EthTransaction ethTransaction = ethMapper.selectByToOfLast(address);
		String blockNumber = ethTransaction.getBlockNumber().toString();
		String url = "https://api.etherscan.io/api?module=account&action=txlist&address=".concat(address)
				.concat("&startblock=").concat(blockNumber)
				.concat("&endblock=999999999&sort=desc&apikey=86KCV5GY545QR78USA4XAH5YDU9IFRCK9D");
		String sendGetRequest = HttpPost.sendGetRequest(url);
		JSONObject jo = JSONObject.fromObject(sendGetRequest);
		if (jo.getString("status").equals("1")) {
			// eth充值
			BigInteger ethChongzhi = BigInteger.ZERO;
			JSONArray jsonArray = jo.getJSONArray("result");
			for (Object object : jsonArray) {
				JSONObject fromObject = JSONObject.fromObject(object);
				if (fromObject.getString("gasUsed").equals("21000")) { // ETH

					EthTransaction ethTrans = new EthTransaction();
					ethTrans.setBlockNumber(fromObject.getInt("blockNumber"));
					ethTrans.setTimeStamp(fromObject.getString("timeStamp"));
					ethTrans.setHash(fromObject.getString("hash"));
					ethTrans.setNonce(fromObject.getInt("nonce"));;
					ethTrans.setBlockHash(fromObject.getString("blockHash"));
					ethTrans.setTransactionIndex(fromObject.getInt("transactionIndex"));
					ethTrans.setFrom(fromObject.getString("from"));
					ethTrans.setTo(fromObject.getString("to"));
					ethTrans.setValue(fromObject.getString("value"));
					ethTrans.setGas(fromObject.getString("gas"));
					ethTrans.setGasPrice(fromObject.getString("gasPrice"));
					ethTrans.setIserror(fromObject.getInt("isError"));
					ethTrans.setTxreceiptStatus(fromObject.getInt("txreceipt_status"));
					ethTrans.setInput(fromObject.getString("input"));
					ethTrans.setContractAddress(fromObject.getString("contractAddress"));
					ethTrans.setCumulativeGasUsed(fromObject.getString("cumulativeGasUsed"));
					ethTrans.setGasUsed(fromObject.getString("gasUsed"));
					ethTrans.setConfirmations(fromObject.getInt("confirmations"));
					ethTrans.setStatus(1);
					ethTrans.setType(1);
					
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("hash", fromObject.getString("hash"));
					map.put("transactionIndex", fromObject.getInt("transactionIndex"));
					EthTransaction selectByMap = ethMapper.selectByMap(map);
					if (selectByMap == null) {
						//充值
						if (fromObject.getString("to").equals(address)) {
							ethChongzhi = ethChongzhi.add(BigInteger.valueOf(fromObject.getInt("value")));
						}
						//插入eth交易记录
						ethMapper.insertSelective(ethTrans);
					}
					
				} 
				
				

			}
			//充值tedu积分
			if (ethChongzhi.compareTo(BigInteger.ZERO) > 0) {
				Integer userId = userAddress.getUserId();
				chongzhiJifen(address,ethChongzhi.toString(),userId);
			}
		}

	}
	
	/**
	 * 充值积分
	 * @param address
	 * @param value
	 * @throws MedicalException 
	 */
	public void chongzhiJifen(String address,String value,int userId) throws MedicalException {
		UserJifen byUserId = userJifenService.getByUserId(userId);
		DuihuanJifen last = ethDuiJifenService.getLast();
		if (byUserId == null) {
			UserJifen userJifen = new UserJifen();
			String rate = last.getRate();
			BigDecimal bigDecimal = new BigDecimal(value);
			BigDecimal bigDecimal1 = new BigDecimal(last.getRate());
			BigDecimal multiply = bigDecimal.multiply(bigDecimal1);
			userJifen.setJifen(multiply.toPlainString());
			userJifen.setDate(new Date());
			userJifen.setType(0);
			userJifen.setUserId(userId);
			
			userJifenService.insert(userJifen);
		}else {
			UserJifen userJifen = new UserJifen();
			BigDecimal bigDecimal = new BigDecimal(value);
			BigDecimal bigDecimal1 = new BigDecimal(last.getRate());
			BigDecimal multiply = bigDecimal.multiply(bigDecimal1);
			userJifen.setJifen(multiply.toPlainString());
			userJifen.setDate(new Date());
			userJifen.setType(0);
			userJifen.setUserId(userId);
			
			userJifenService.updatejifenByUserId(userJifen);
			
		}
		
	}
}
