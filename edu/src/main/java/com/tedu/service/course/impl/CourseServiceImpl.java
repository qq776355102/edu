package com.tedu.service.course.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.omg.CORBA.TCKind;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.repository.query.RedisOperationChain.NearPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.page.PageMethod;
import com.tedu.common.core.Constant;
import com.tedu.common.exception.MedicalException;
import com.tedu.dao.course.mapper.TeduCourseMapper;
import com.tedu.domain.album.Album;
import com.tedu.domain.course.TeduCourse;
import com.tedu.domain.course.vo.CourseCata;
import com.tedu.domain.course.vo.TeduCourseVo;
import com.tedu.domain.courseorder.CourseOrder;
import com.tedu.domain.user.Fans;
import com.tedu.domain.user.User;
import com.tedu.domain.userAlbum.UserAlbum;
import com.tedu.service.album.AlbumServiceImpl;
import com.tedu.service.courseorder.CourserOrderServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;
import com.tedu.service.userAlbum.impl.UserAlbumServiceImpl;
import com.tedu.service.userfans.impl.UserfansServiceImpl;

import jnr.ffi.types.int16_t;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
@Transactional
public class CourseServiceImpl{

	@Autowired
	private TeduCourseMapper mapper;

	@Autowired
	private AlbumServiceImpl albumService;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserfansServiceImpl userfansService;
	
	@Autowired
	private UserAlbumServiceImpl userAlbumService;
	
	@Autowired
	private CourserOrderServiceImpl courserOrderService;

	/**
	 * 添加课程
	 * 
	 * @param course
	 * @throws Exception
	 */
	public TeduCourse courseInsert(TeduCourse course) throws Exception {
		TeduCourse teduCourse = new TeduCourse();
		BeanUtils.copyProperties(course, teduCourse);
		teduCourse.setDate(null);
		teduCourse.setResource(null);
		teduCourse.setPicture(null);
		List<TeduCourse> checkBy = mapper.getList(teduCourse);
		if (checkBy.size() >= 1) {
			return course;
		} else {
			course.setStatus(Constant.STATUS_1);
			int insertSelective = mapper.insertSelective(course);
		}
		return course;
	}

	/**
	 * 课程分页查询 <br>
	 * [键1] bean - (实体) <br>
	 * [键2] offset - 偏移量 (分页信息) <br>
	 * [键3] rows - 数目 (分页信息)
	 * 
	 * @throws Exception
	 */
	public List<CourseCata> getCourseList(int currentUserId, Map<String, Object> param) throws Exception {

		// 最新课程列表
		List<TeduCourse> pageList = mapper.getLastestRecordGroupByUserIdAndBy(param);
		// 要显示在前台的信息
		List<CourseCata> ccList = new ArrayList<CourseCata>();
		for (TeduCourse teduCourse : pageList) {
			CourseCata courseCata = new CourseCata();
			int userCourseId = teduCourse.getUserId();
			Fans fans = new Fans();
			fans.setUserId(userCourseId);
			fans.setFanId(currentUserId + "");
			// 设置是否是粉丝
			int b = userfansService.checkUserfans(fans);
			if (b >= 0) {
				courseCata.setIsFan(true);
			} else {
				courseCata.setIsFan(false);
			}
			// 设置课程列表的大小
//			int sizeOfCourseList = courselistService.getSizeOfCourseList(teduCourse.getId());
			int sizeOfCourseList = getCountByUserIdAndCategory(teduCourse.getUserId(), teduCourse.getCategory());
			courseCata.setCourseListSize(sizeOfCourseList);
			// 设置课程id
			courseCata.setCourseId(teduCourse.getId());
			// 设置课程标题
			courseCata.setCourseTitle(teduCourse.getTitle());
			// 设置课程简介
			courseCata.setCourseIntroduction(teduCourse.getIntroduction());
//			List<TeduCourseList> lastOneOfCourseList = courselistService.getLastOneOfCourseList(teduCourse.getId());
			// 设置课程时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			System.currentTimeMillis()
			// 设置要显示的日期
			courseCata.setCourseLatestUpdateDate(sdf.format(teduCourse.getDate()));

//			BigInteger subtract = BigInteger.valueOf(System.currentTimeMillis()).subtract(BigInteger.valueOf(st.getTime()));
			// 设置课程开发者相关信息
			User userInfoOfCourse = userService.getUserInfoById(teduCourse.getUserId());
//			courseCata.setCourseUserId(teduCourse.getUserId());
			courseCata.setCourseUserName(userInfoOfCourse.getName());
		}
		return ccList;
	}

	/**
	 * 查询用户专辑的大小
	 * 
	 * @param userId
	 * @param category
	 * @throws Exception
	 */
	public int getCountByUserIdAndCategory(int userId, int category) throws Exception {
		TeduCourse teduCourse = new TeduCourse();
		teduCourse.setUserId(userId);
		teduCourse.setCategory(category);
		List<TeduCourse> count = mapper.getList(teduCourse);
		if (count != null) {
			return count.size();
		}
		return 0;
	}

	/**
	 * 根据课程id查询课程
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public TeduCourse getTeduCourseById(int id) throws Exception {
		TeduCourse course = mapper.selectByPrimaryKey(id);
		if (course == null) {
			throw new MedicalException("课程不存在");
		}
		return course;
	}
	
	public int getTotal() {
		return mapper.getTotal();
	}
	/**
	 * 获取专辑课程列表
	 * @param category
	 * @throws Exception
	 */
	public JSONObject getAlbumCourseList(int currentUserId,int category,int offset,int rows) throws Exception {
		Album album = albumService.getAlbumById(category);
		JSONObject jsonObject = new JSONObject();
		Integer courseUserId = album.getUserId();
		User u = userService.getUserInfoById(courseUserId);
		//主讲人
		jsonObject.put("courseUserName",u.getName());
		//课程专辑id
		jsonObject.put("courseAlbumId", album.getId());
		//专辑名
		jsonObject.put("albumName", album.getName());
		//发布专辑的日期
		String date = DateFormatUtils.format(album.getDate(), "yyyy-MM-dd HH:mm");
		jsonObject.put("date",date);
		//专辑图片路径
		if (album.getPicture() != null) {
			jsonObject.put("picture", album.getPicture());
		}
//		Fans fans = new Fans();
//		fans.setUserId(album.getUserId());
//		fans.setFanId(currentUserId+"");
//		fans.setStatus(1);
//		int i = userfansService.checkUserfans(fans);
		UserAlbum ua = userAlbumService.getGuanzhuByUserIdAndAlbumId(currentUserId, album.getId());
		boolean b = false;
		//是否关注
		if (ua != null) {
			b = ua.getGuanzhu();
			jsonObject.put("isBuyed", ua.getIsBuyed());
		}else {
			//是否购买专辑
			jsonObject.put("isBuyed", false);
		}
		jsonObject.put("guanzhu", b);
		TeduCourse teduCourse = new TeduCourse();
		teduCourse.setUserId(album.getUserId());
		teduCourse.setCategory(category);
		teduCourse.setStatus(1);
		PageMethod.offsetPage(offset, rows);
		List<TeduCourse> courseList = mapper.getList(teduCourse);
		List<JSONObject> arrayList = new ArrayList<JSONObject>();
		for (TeduCourse tc : courseList) {
			JSONObject jo = new JSONObject();
			jo.put("tile", tc.getTitle());
			jo.put("id", tc.getId());
			if (tc.getBofangCount() == null) {
				jo.put("bofangCount", 0);
			}else {
				jo.put("bofangCount",tc.getBofangCount());
			}
			jo.put("length", tc.getLength());
			jo.put("date", tc.getDate());
			arrayList.add(jo);
		}
		//设置课程价格
		if (album.getPrice() != null && !album.getPrice().equals("-1")) {
			jsonObject.put("price", album.getPrice());
		}else {
				BigDecimal price =  BigDecimal.ZERO;
				for (TeduCourse tc : courseList) {
					String cost = tc.getCost();
					price = new BigDecimal(cost).add(price);
				}
				jsonObject.put("price", price.toPlainString());
		}
		//课程列表
		jsonObject.put("courseList", arrayList);
		return jsonObject;
	}
	
	/**
	 * 根据用户id或课程列表
	 * @param userId
	 * @param offset
	 * @param rows
      	 * <br>[键1] bean -  (实体)
	     * <br>[键2] offset - 偏移量 (分页信息)
	     * <br>[键3] rows - 数目 (分页信息)
	 * @throws Exception 
	 */
	public List<TeduCourseVo> getPageListById(int userId,int offset,int rows) throws Exception {
		TeduCourse teduCourse = new TeduCourse();
		teduCourse.setUserId(userId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bean", teduCourse);
		map.put("offset", offset);
		map.put("rows", rows);
		List<TeduCourse> teduCourseList = mapper.getPageList(map);
		List<TeduCourseVo> list = new ArrayList<TeduCourseVo>();
		for (TeduCourse tc : teduCourseList) {
			TeduCourseVo teduCourseVo = new TeduCourseVo();
			String cost = tc.getCost();
			Album album = new Album();
			if (cost==null || cost.equals("null")) {
				int id = tc.getCategory();
				album = albumService.getAlbumById(id);
				String price = album.getPrice();
				if (price ==null) {
					tc.setCost("0");
				}else {
					tc.setCost(album.getPrice());
				}
			}
			BeanUtils.copyProperties(tc, teduCourseVo);
			teduCourseVo.setCategoryDesc(album.getName());
			CourseOrder courseOrderByid = courserOrderService.getCourseOrderByid(tc.getId());
			teduCourseVo.setOrder(courseOrderByid.getOrder());
			list.add(teduCourseVo);
		}
		return list;
	}
	
	/**
	 * 获取我的作品列表
	 * @param userId
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public JSONArray getProductionList(Integer userId,int offset,int rows) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		TeduCourse teduCourse = new TeduCourse();
		teduCourse.setUserId(userId);
		map.put("bean", teduCourse);
		map.put("offset", offset);
		map.put("rows", rows);
		List<TeduCourse> list = mapper.getPageList(map);
		JSONArray jsonArray = new JSONArray();
		for (TeduCourse tc : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("title", tc.getTitle());
			jsonObject.put("userId", tc.getUserId());
			jsonObject.put("albumId", tc.getCategory());
			jsonObject.put("date", tc.getDate().toString());
			jsonObject.put("status", tc.getStatus());
			jsonObject.put("courseId", tc.getId());
			CourseOrder courseOrder = courserOrderService.getCourseOrderByid(tc.getId());
			if (courseOrder!= null) {
				jsonObject.put("order", courseOrder.getOrder());
			}else {
				jsonObject.put("order", "");
			}
			Album album = albumService.getAlbumById(tc.getCategory());
			if (album != null) {
				if (tc.getCost() != null) {
					if (tc.getCost().equals("-1")) {
						jsonObject.put("cost", tc.getCost());
					}else {
						jsonObject.put("cost", album.getPrice());
					}
				}else {
					jsonObject.put("cost", album.getPrice());
				}
			}
			jsonObject.put("albumName", album.getName());
			CourseOrder courseOrderByid = courserOrderService.getCourseOrderByid(tc.getId());
			jsonObject.put("order", courseOrderByid.getOrder());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	
	/**
	 *  删除我的作品某一课程
	 * @param courseId
	 * @throws Exception 
	 */
	public void deleteMyCourse(int courseId) throws Exception {
		TeduCourse teduCourse = new TeduCourse();
		teduCourse.setId(courseId);
		teduCourse.setStatus(0);
		int update = mapper.updateByPrimaryKey(teduCourse);
	}
	
	public List getListTest(TeduCourse teduCourse) {
		List<TeduCourse> list = mapper.getList(teduCourse);
		return list;
	}
	
	public List<TeduCourse> getList(TeduCourse teduCourse){
		return  mapper.getList(teduCourse);
	}

	public List<JSONObject> searchLikeTile(int userId,String title,String url,int offset,int rows) throws Exception {
		PageMethod.offsetPage(offset, rows);
		List<TeduCourse> searchLikeTile = mapper.searchLikeTile(title);
		List<JSONObject> arrayList = new ArrayList<JSONObject>();
		for (TeduCourse tc : searchLikeTile) {
			JSONObject jsonObject = new JSONObject();
			Integer ui = tc.getUserId();
			User u = userService.getUserInfoById(ui);
			jsonObject.put("picture", url+u.getPortrait());
			jsonObject.put("name", u.getName());
			jsonObject.put("userId", ui);
			jsonObject.put("courseId", tc.getId());
			CourseOrder courseOrderByid = courserOrderService.getCourseOrderByid(tc.getId());
			jsonObject.put("albumName", courseOrderByid.getAlbumName());
			jsonObject.put("order", courseOrderByid.getOrder());
			String formateTime = albumService.formateTime(tc.getDate().getTime());
			jsonObject.put("time",formateTime);
			TeduCourse teduCourse = new TeduCourse();
			teduCourse.setUserId(ui);
			teduCourse.setCategory(tc.getCategory());
			List<TeduCourse> list = getList(teduCourse);
			jsonObject.put("albumCount",list.size());
			if (tc.getCost().equals("-1")) {
				if (tc.getCost().equals("0")) {
					jsonObject.put("price",0);
				}else {
					Album albumById = albumService.getAlbumById(tc.getCategory());
					jsonObject.put("price",albumById.getPrice());
				}
			}
			Fans fans = new Fans();
			fans.setUserId(ui);
			fans.setFanId(userId+"");
			int checkUserfans = userfansService.checkUserfans(fans);
			if (checkUserfans>0) {
				jsonObject.put("guanhzu",true);
			}else {
				jsonObject.put("guanhzu",true);
			}
			jsonObject.put("title",tc.getTitle());
			arrayList.add(jsonObject);
		}
		return arrayList;
	}
}
