package sms;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.common.exception.MedicalException;
import com.tedu.service.sms.impl.SmsServiceImpl;

public class SmsTest {

	@Test
	public void name() throws MedicalException {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SmsServiceImpl bean = applicationContext.getBean(SmsServiceImpl.class);
//		String identifyCode = bean.getIdentifyCode("17607117571", 1);
//		System.err.println(identifyCode);
	}
}
