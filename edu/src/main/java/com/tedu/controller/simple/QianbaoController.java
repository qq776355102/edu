package com.tedu.controller.simple;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.common.exception.MedicalException;
import com.tedu.common.model.ResponseDTO;
import com.tedu.domain.qbalance.QBalance;
import com.tedu.domain.user.BaseUser;
import com.tedu.domain.user.User;
import com.tedu.service.qbaobalance.QBalanceServiceImpl;
import com.tedu.service.qianbao.QianbaoServiceImpl;
import com.tedu.service.tixiansill.TixianServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;

import net.sf.json.JSONObject;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/tedu/a/v/qinabao")
public class QianbaoController extends BaseController{

	@Autowired
	private QianbaoServiceImpl qianbaoService;
	
	@Autowired
	private TixianServiceImpl tixianService;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private QBalanceServiceImpl qBalanceService;
	
	
	/**
	 * 获取Token余额及财务明细
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getTokenBalanceAndDetail")
	public Object getTokenBalanceAndDetail(@RequestParam(defaultValue = "1")int offset,@RequestParam(defaultValue =  "10")int rows,@RequestParam(defaultValue="ETH")String coinType) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null)
			throw new MedicalException("请登录之后再操作");
		JSONObject bd = qianbaoService.getTokenBalanceAndDetail(baseUser.getId(), offset, rows,coinType);
		return ResponseDTO.setStaticResult(bd);
	}
	
	/**
	 * 	提现
	 * @param amount
	 * @param coinType
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("tixian")
	public Object tixian(@RequestParam(required = true)String amount,@RequestParam(defaultValue="ETH")String coinType) throws Exception {
		if (new BigDecimal(amount).compareTo(BigDecimal.ZERO) <= 0 )
			throw new MedicalException("体现金额必须大于0");
		BaseUser baseUser = getBaseUser();
		if (baseUser == null)
			throw new MedicalException("请登录之后再操作");
		String sill = tixianService.getTixianSillByCoinType(coinType);
		User u = userService.getUserInfoById(baseUser.getId());
		String address = "";
		if (u != null) {
			address = u.getAddress();
		}else {
			throw new MedicalException("用户不存在");
		}
		/*QBalance qBalance = qBalanceService.getQBalance(baseUser.getId(), address, coinType);
		if (qBalance!= null) {
			BigDecimal valibleBalance = new BigDecimal(qBalance.getTotalBalance()).subtract(new BigDecimal(qBalance.getFreezeBalance()));
			if (valibleBalance.compareTo(new BigDecimal(amount)) < 0) {
				throw new MedicalException("体现金额不能高于"+valibleBalance.toPlainString());
			}
		}else {
			throw new MedicalException("体现失败，请稍后再试或联系客服");
		}*/
		if (new BigDecimal(amount).compareTo(new BigDecimal(sill)) >= 0) {
			//可以体现
			//TODO
			
			
			
			
			
		} else
			throw new MedicalException("体现失败,体现金额必须大于"+sill);
		return "";
	}
}
