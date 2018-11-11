package com.tedu.controller.simple;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.common.exception.MedicalDebugException;
import com.tedu.common.exception.MedicalException;
import com.tedu.common.model.ResponseDTO;
import com.tedu.common.util.AudioFileUtil;
import com.tedu.domain.album.Album;
import com.tedu.domain.course.TeduCourse;
import com.tedu.domain.course.vo.CourseCata;
import com.tedu.domain.courseorder.CourseOrder;
import com.tedu.domain.originalaudio.OriginalAudio;
import com.tedu.domain.user.BaseUser;
import com.tedu.domain.user.User;
import com.tedu.domain.userAlbum.UserAlbum;
import com.tedu.service.album.AlbumServiceImpl;
import com.tedu.service.course.impl.CourseServiceImpl;
import com.tedu.service.courseorder.CourserOrderServiceImpl;
import com.tedu.service.originalaudio.OriginalAudioServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;
import com.tedu.service.userAlbum.impl.UserAlbumServiceImpl;
import com.tedu.service.usercourse.impl.UserCourseServiceImpl;

import jnr.ffi.types.int16_t;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/tedu/a/v/course")
public class CourseController extends BaseController {

	@Autowired
	private CourseServiceImpl courseService;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private AlbumServiceImpl albumService;

	@Autowired
	private UserCourseServiceImpl userCourseService;
	
	@Autowired
	private UserAlbumServiceImpl userAlbumService;
	
	@Autowired
	private OriginalAudioServiceImpl originalAudioService;
	
	@Autowired
	private CourserOrderServiceImpl courserOrderService;

	/**
	 * 
	 * 上传课程(专辑课程数量不大于2个)
	 * 
	 * 专辑不定价，课程定价
	 * @param categoryId   所属专辑
	 * @param introduction 专辑简介
	 * @param title        课程标题
	 * @param audio        音频
	 * @param image        图片
	 * @param cost         课程价格
	 * @throws Exception
	 */
	@RequestMapping("/uploadCourse")
	public Object uploadCourse(@RequestParam(value = "categoryId", required = true) Integer categoryId,
			@RequestParam(value = "introduction", required = true) String introduction,
			@RequestParam(value = "title", required = true) String title, String userId, MultipartFile audio,
			MultipartFile image, @RequestParam(defaultValue = "0") String cost, HttpServletRequest request)
			throws Exception {

		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登录之后再操作");
		}
		uploadaudioAsc(categoryId, introduction, title, userId, audio, image, cost, baseUser);
		return ResponseDTO.setStaticResult("上传成功");

	}

	@Async
	private void uploadaudioAsc(Integer categoryId, String introduction, String title, String userId,
			MultipartFile audio, MultipartFile image, String cost, BaseUser baseUser)
			throws Exception, MedicalException, IOException {
		User u = userService.getUserInfoById(baseUser.getId());
		if (u.getIdentity() != 2) {
			throw new MedicalException("请先申请成为讲师");
		}
		TeduCourse teduCourse = new TeduCourse();
		// 保存音频
		if (audio != null) {
			originalAudioService.checkOriginalAudio(userId, audio.getOriginalFilename(), String.valueOf(audio.getSize()));
			
			JSONObject courseAudio = AudioFileUtil.SaveAudio(audio);
			teduCourse.setResource(courseAudio.getString("path"));
			// 获取课程时长
			teduCourse.setLength(courseAudio.getString("length"));
		}
		// 课程图片保存
		if (image != null) {
			String coursePicturePath = AudioFileUtil.SavePicture(image);
			teduCourse.setPicture(coursePicturePath);
		}
		// 设置课程价格
		teduCourse.setCost(cost);
		// 设置课程标题
		teduCourse.setTitle(title);
		// 设置简介
		teduCourse.setIntroduction(introduction);
		// 设置专辑分类
		teduCourse.setCategory(categoryId);
		teduCourse.setUserId(baseUser.getId());
		teduCourse.setDate(new Date());
		
		TeduCourse courseInsert = courseService.courseInsert(teduCourse);
		OriginalAudio originalAudio = new OriginalAudio();
		originalAudio.setUserId(baseUser.getId());
		originalAudio.setFileLength(String.valueOf(audio.getSize()));
		originalAudio.setOriginalFileName(audio.getOriginalFilename());
		originalAudio.setStatus(1);
		originalAudio.setDate(new Date());
		originalAudioService.insertOriginalAudio(originalAudio);
		
		if (courseInsert.getId() != null) {
			CourseOrder courseOrder = new CourseOrder();
			courseOrder.setId(courseInsert.getId());
			Album albumById = albumService.getAlbumById(categoryId);
			courseOrder.setAlbumName(albumById.getName());
			int count = courseService.getCountByUserIdAndCategory(courseInsert.getUserId(), categoryId);
			courseOrder.setOrder(count);
			courseOrder.setStatus(1);
			courserOrderService.insertCourseOrder(courseOrder);
		}
	}

	/**
	 * @param courseId     课程id
	 * @param courseListId
	 * @throws Exception 
	 */
//	public void downLoadCourse(int courseId,int courseListId) throws MedicalException {
//		BaseUser baseUser = getBaseUser();
//		if (baseUser == null) {
//			throw new MedicalException("请先登录在操作");
//		}
//		
//		
//	}
	/**
	 * 	上传课程，专辑课程数量大于2
	 * 专辑定价，课程不定价
	 * @param categoryId
	 * @param title
	 * @param userId
	 * @param audio
	 * @param image
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadCourses")
	public Object uploadCourses(@RequestParam(value = "categoryId", required = true) Integer categoryId,
			@RequestParam(value = "title", required = true) String title, String userId, MultipartFile audio,
			MultipartFile image, HttpServletRequest request) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登录之后再操作");
		}
		User u = userService.getUserInfoById(baseUser.getId());
		if (u.getIdentity() != 2) {
			throw new MedicalException("请先申请成为讲师");
		}
		insertCourseMoreThan2(categoryId, title, userId, audio, image, baseUser);
		return ResponseDTO.setStaticResult("上传成功");
	}

	@Async
	private void insertCourseMoreThan2(Integer categoryId, String title, String userId, MultipartFile audio,
			MultipartFile image, BaseUser baseUser) throws MedicalException, IOException, Exception {
		TeduCourse teduCourse = new TeduCourse();
		// 保存音频
		if (audio != null) {
			originalAudioService.checkOriginalAudio(userId, audio.getOriginalFilename(), String.valueOf(audio.getSize()));
			JSONObject courseAudio = AudioFileUtil.SaveAudio(audio);
			teduCourse.setResource(courseAudio.getString("path"));
			// 获取课程时长
			teduCourse.setLength(courseAudio.getString("length"));
		}
		// 课程图片保存
		if (image != null) {
			String coursePicturePath = AudioFileUtil.SavePicture(image);
			teduCourse.setPicture(coursePicturePath);
		}
		// 设置课程价格
		teduCourse.setCost("-1");
		// 设置课程标题
		teduCourse.setTitle(title);
		// 设置专辑分类
		teduCourse.setCategory(categoryId);
		
		TeduCourse courseInsert = courseService.courseInsert(teduCourse);

		OriginalAudio originalAudio = new OriginalAudio();
		originalAudio.setUserId(baseUser.getId());
		originalAudio.setFileLength(String.valueOf(audio.getSize()));
		originalAudio.setOriginalFileName(audio.getOriginalFilename());
		originalAudio.setStatus(1);
		originalAudio.setDate(new Date());
		originalAudioService.insertOriginalAudio(originalAudio);
		
		if (courseInsert.getId() != null) {
			CourseOrder courseOrder = new CourseOrder();
			courseOrder.setId(courseInsert.getId());
			Album albumById = albumService.getAlbumById(categoryId);
			courseOrder.setAlbumName(albumById.getName());
			int count = courseService.getCountByUserIdAndCategory(courseInsert.getUserId(), categoryId);
			courseOrder.setOrder(count);
			courseOrder.setStatus(1);
			courserOrderService.insertCourseOrder(courseOrder);
		}
	}

	
	/**
	 * 显示课程列表
	 * 
	 * @param courseCategory 课程分类
	 * @param courseCost     课程价格
	 * @param isfan          是否关注
	 * @param offset         起始页
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getCourseList")
	public Object listCourse(@RequestParam("courseCategory") int courseCategory,
			@RequestParam("courseCost") String courseCost, @RequestParam("isfan") int isfan,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "rows", defaultValue = "5") int rows) throws Exception {

		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登录账户");
		}
		// 查询所有课程列表
		TeduCourse bean = new TeduCourse();
		bean.setCategory(courseCategory);
		bean.setCost(courseCost);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bean", bean);
		map.put("offset", offset);
		map.put("rows", rows);
		map.put("orderBy", "date");
		List<CourseCata> courseList = courseService.getCourseList(baseUser.getId(), map);
		return ResponseDTO.setStaticResult(courseList);
	}

	/**
	 * 根据专辑id获取专辑课程列表
	 * 
	 * @param category
	 * @throws Exception
	 */
	@RequestMapping("getAlbumCourseList")
	@SuppressWarnings("unused")
	private Object getCourseAlbumListByAlbumId(@RequestParam(required = true) int courseAlbumId,@RequestParam(defaultValue="0")Integer offset,@RequestParam(defaultValue="10")Integer rows) throws Exception {
		BaseUser bu = getBaseUser();
		if (bu == null) {
			throw new MedicalException("请先登录之后再操作");
		}
		JSONObject jo = courseService.getAlbumCourseList(bu.getId(), courseAlbumId,offset,rows);
		return ResponseDTO.setStaticResult(jo);
	}

	/**
	 * 课程下载
	 * 
	 * @param courseId
	 * @throws Exception
	 */
	@RequestMapping("downLoadCourse")
	public void downLoadCourse(@RequestParam(required = true) int courseId, HttpServletResponse response)
			throws Exception {
		BaseUser bu = getBaseUser();
		if (bu == null) {
			throw new MedicalException("请登录之后再操作");
		}
		TeduCourse course = courseService.getTeduCourseById(courseId);
		// 获得课程费用
		String cost = course.getCost();
		String resource = course.getResource();
		BufferedInputStream buf = null;
		OutputStream out = null;
		if (cost.equals("0")) { // 课程免费
			// 输出 mp3 IO流
			try {
				response.setHeader("Content-Type", "audio/mp3");
				File file = new File(resource);
				int len_l = (int) file.length();
				buf = new BufferedInputStream(new FileInputStream(file));
				out = response.getOutputStream();
				byte[] buffer = new byte[1024];
				// while循环一直读取缓冲流中的内容到输出的对象中
				while (buf.read(buffer) != -1) {
					out.write(buffer);
				}
				out.flush();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (buf != null)
					buf.close();
				if (out != null)
					out.close();
			}
		} else {// 检查课程是否购买
			boolean b = userCourseService.checkIsBuyed(bu.getId(), courseId, course.getCategory());
			if (b) { // 已经购买此课程
				try {
					response.setHeader("Content-Type", "audio/mp3");
					File file = new File(resource);
					int len_l = (int) file.length();
					buf = new BufferedInputStream(new FileInputStream(file));
					out = response.getOutputStream();
					byte[] buffer = new byte[1024];
					// while循环一直读取缓冲流中的内容到输出的对象中
					while (buf.read(buffer) != -1) {
						out.write(buffer);
					}
					out.flush();
				} catch (Exception e) {
					System.out.println(e);
				} finally {
					if (buf != null)
						buf.close();
					if (out != null)
						out.close();
				}
			}
			throw new MedicalException("请先购买此专辑或课程");
		}

		return;
	}

	/**
	 *  根据专辑id获取专辑详情
	 * 
	 * @param courseAlbumId 课程专辑id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("getAlbumInfo")
	public Object getAlbumInfo(@RequestParam(name = "courseAlbumId",required = true) int courseAlbumId) throws Exception {
		Album album = albumService.getAlbumById(courseAlbumId);
		User user = userService.getUserInfoById(album.getUserId());
		JSONObject jsonObject = new JSONObject();
		UserAlbum userAlbum = userAlbumService.getGuanzhuByUserIdAndAlbumId(user.getId(), courseAlbumId);
		if (userAlbum != null) {
			jsonObject.put("guanzhu", userAlbum.getGuanzhu());
		}else {
			jsonObject.put("guanzhu", false);
		}
		jsonObject.put("courseAlbumId",courseAlbumId);
		jsonObject.put("courseUserName", user.getName());
		jsonObject.put("date", album.getDate().toString());
		try {
			boolean b = userAlbum.getIsBuyed();
			jsonObject.put("isPurchased", b);
		} catch (Exception e) {
			// TODO: handle exception
			jsonObject.put("isPurchased", false);
		}
		if (album.getPrice().equals("-1")) {
			jsonObject.put("cost",0);
		}else {
			jsonObject.put("cost", album.getPrice());
		}
		jsonObject.put("albumIntroduction", album.getIntroduction());
		if (user.getIntroduction() != null) {
			jsonObject.put("JiangshiIntroduction",user.getIntroduction());
		}else {
			jsonObject.put("JiangshiIntroduction","");
		}
		if (album.getNotesTobuy() != null) {
			jsonObject.put("notesBuy", album.getNotesTobuy());
		}else {
			jsonObject.put("notesBuy", "");
		}
		if (album.getPicture() != null) {
			jsonObject.put("picture", getUrl()+album.getPicture());
		}
		return ResponseDTO.setStaticResult(jsonObject);
	}

	/**
	 * 	根据课程id获取免费试听课程
	 * @param courseId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("getFreeAudio")
	public void getFreeAudio(int courseId, HttpServletResponse response) throws Exception {
		TeduCourse course = courseService.getTeduCourseById(courseId);
		String cost = course.getCost();
		String resource = course.getResource();
		BufferedInputStream buf = null;
		OutputStream out = null;
		response.setHeader("Content-Type", "audio/mp3");
		File file = new File(resource);
		byte[] buffer = new byte[512];
		if (cost == null || cost.equals("0")) { // 课程免费
			// 输出 mp3 IO流
			try {
				buf = new BufferedInputStream(new FileInputStream(file));
				out = response.getOutputStream();

				// while循环一直读取缓冲流中的内容到输出的对象中
				while (buf.read(buffer) != -1) {
					out.write(buffer);
				}
				out.flush();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (buf != null)
					buf.close();
				if (out != null)
					out.close();
			}
		} else { // 课程不免费
					// 这里使用默认的MP3比特率128比特率,具体以音频源
			int end = 983040;// 128kbps*60s*1024/8=983040
			int tatol = 0;
			// 输入流
			buf = new BufferedInputStream(new FileInputStream(file));
			// 缓冲字节输出流（true表示可以在流的后面追加数据，而不是覆盖！！）
			out = response.getOutputStream();
			// 第一首歌剪切、写入
			int len = 0;
			while ((len = buf.read(buffer)) != -1) {
				tatol += len; // 累积tatol
				out.write(buffer); // 写入的都是在我们预先指定的字节范围之内
				if (tatol >= end) { // 当tatol的值超过预先设定的范围，则立刻刷新bos流对象，并结束循环
					out.flush();
					break;
				}
			}
			if (buf != null)
				buf.close();
			if (out != null)
				out.close();
		}

	}
	
	
	/**
	 *  查找相似专辑
	 * @throws Exception 
	 */
	@RequestMapping("searchLikeAlbum")
	public Object searchLikeAlbum(@RequestParam(name="albumName",required =true)String albumName,@RequestParam(defaultValue  ="0")int offset,@RequestParam(defaultValue="10")int rows) throws Exception {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请登录之后再操作");
		}
		
		List list = albumService.searchLikeAlbum(baseUser.getId(), albumName, offset, rows,getUrl());
		return ResponseDTO.setStaticResult(list);
	}
	
	/**
	 * 搜索获得专辑列表
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAlbumList")
	public Object getAlbumList(@RequestParam(required=true)String search,@RequestParam(defaultValue  ="0")int offset,@RequestParam(defaultValue="10")int rows) throws Exception {
		String url = getUrl();
		BaseUser baseUser = getBaseUser();
		if (baseUser==null) {
			throw new MedicalException("请登录之后再操作");
		}
		JSONObject albumList = albumService.getAlbumList(search,baseUser.getId(),offset,rows,url);
		return ResponseDTO.setStaticResult(albumList);
	}


	/**
	 * 搜索获得课程内容列表
	 * @param search
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCourseContentList")
	public Object getCourseContentList(@RequestParam(required=true)String search,@RequestParam(defaultValue  ="0")int offset,@RequestParam(defaultValue="10")int rows) throws Exception {
		String url = getUrl();
		BaseUser baseUser = getBaseUser();
		if (baseUser==null) {
			throw new MedicalException("请登录之后再操作");
		}
		return courseService.searchLikeTile(baseUser.getId(), search, url,offset,rows);
	}
	

}
