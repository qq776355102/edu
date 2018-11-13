package com.tedu.common.timer;

import org.springframework.stereotype.Component;

import cn.cmc.http.HttpClientUtil;

@Component
public class ChongzhiEth {

	public void chongzhiEth(int userId,String toAddress) {
		//根据地址查询最后充值块高
		String url = "https://api.etherscan.io/api?action=txlist&address="+
				toAddress
	+ "&startblock="
	+ "0"
	+ "&endblock="
	+ "99999999"
	+ "&page=1&offset=50&sort=asc&apikey=86KCV5GY545QR78USA4XAH5YDU9IFRCK9D&module=account";
		String sendHttpGet = HttpClientUtil.getInstance().sendHttpGet(url);
		System.out.println(sendHttpGet);
	}
	public static void main(String[] args) {
		String url = "https://api.etherscan.io/api?action=txlist&address=0x54124f579f85B445fBE89CdE2B661942A5110CD9&startblock=0&endblock=99999999&page=1&offset=50&sort=asc&apikey=YourApiKeyToken&module=account";
		String sendHttpGet = HttpClientUtil.getInstance().sendHttpGet(url);
		System.out.println(sendHttpGet);
	}
}
