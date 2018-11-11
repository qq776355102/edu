package course;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.page.PageMethod;
import com.tedu.domain.course.TeduCourse;
import com.tedu.domain.user.User;
import com.tedu.service.course.impl.CourseServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;

public class CourseTest {

	@Test
	public void name() throws  Exception{
		 ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 CourseServiceImpl bean = applicationContext.getBean(CourseServiceImpl.class);
			TeduCourse teduCourse = new TeduCourse();
			teduCourse.setUserId(1);
			teduCourse.setCategory(2);
			teduCourse.setStatus(1);
			PageMethod.offsetPage(0, 10);
			List listTest = bean.getListTest(teduCourse);
			System.out.println(listTest.size());
	}
}
