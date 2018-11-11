package album;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.domain.album.Album;
import com.tedu.service.album.AlbumServiceImpl;

public class AlbumTest {

	@Test
	public void name() throws  Exception{
		 ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 AlbumServiceImpl bean = applicationContext.getBean(AlbumServiceImpl.class);
//		 List<Album> albumSelect = bean.albumSelect(1);
//		 for (Album album : albumSelect) {
//			 System.out.println(album);
//			
//		}
		 bean.albumInsert(1, "张三", "-1", "dsd");
	}
}
