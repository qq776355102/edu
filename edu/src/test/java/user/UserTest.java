package user;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.domain.album.Album;
import com.tedu.domain.user.Fans;
import com.tedu.domain.user.User;
import com.tedu.service.user.impl.UserServiceImpl;

public class UserTest {

	
	@Test
	public void name() throws  Exception{
		 ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 UserServiceImpl bean = applicationContext.getBean(UserServiceImpl.class);
		 Fans fans = new Fans();
		 fans.setUserId(1);
		 List<Fans> userFanList = bean.getUserFanList(fans);
		 for (Fans fans2 : userFanList) {
			
		}
	}
}
