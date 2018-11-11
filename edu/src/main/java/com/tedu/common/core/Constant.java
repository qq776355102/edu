package com.tedu.common.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 暴露对外接口通用常量
 * 
 * @author Administrator
 */
/**
 * @author mc
 * @since 2018年8月25日
 * @	
 */
public class Constant
{
    /**
     * 数据状态-否
     */
    public static final int STATUS_0 = 0;

    /**
     * 数据状态-是
     */
    public static final int STATUS_1 = 1;

    /**
     * 数据状态-删除状态
     */
    public static final int STATUS_2 = 2;

    /**
     * 数据状态-禁用状态
     */
    public static final int STATUS_3 = 3;

    
    public static final String SUCCESS="110";  				//成功
    public static final String ERROR="111";	   				//错误
    public static final String TIMEOUT="112";  			//token过期
    public static final String WRONGFUL="113"; 			//token不合法
    public static final String ABNORMAL="114"; 			//接口异常
    
    public static final String  TED = "TED";
    public static final String  ETH = "ETH";
		
	

    /**
     * 系统部署环境
     */
//    public static String SYSTEM_DEPLOY_ENV = SysProperties.getProperty("2yuanlian_proj_status",
//        "debug");
    
    // 平台登录
    public static final int LOGIN_TYPE_0 = 0;
    // 外部登录
    public static final int LOGIN_TYPE_1 = 1;
    
    /**
     * 短信注册
     */
    public static int SMS_REGISTERED = 1;
    /**
     * 短信登陆
     */
    public static Integer SMS_LOGIN =2;
    /**
     * 转账
     */
    public static int SMS_TRANSFER = 3;
    /**
     * 提现
     */
    public static int SMS_WITHDRAW = 4;
    
    /**
     * 找回密码
     */
    public static int SMS_RETRIEVEPASSWORD = 5;
    
    
    
    public static List<String> PICTURE_FORMAT = new ArrayList<String>();
    static
    {
    	PICTURE_FORMAT.add("jpg");
    	PICTURE_FORMAT.add("gif");
    	PICTURE_FORMAT.add("png");
    	PICTURE_FORMAT.add("bmp");
    	PICTURE_FORMAT.add("jpeg");
    }
}
