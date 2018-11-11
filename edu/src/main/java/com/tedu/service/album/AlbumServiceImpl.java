package com.tedu.service.album;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.repository.query.RedisOperationChain.NearPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import com.sun.org.apache.regexp.internal.recompile;
import com.tedu.common.core.Constant;
import com.tedu.common.exception.MedicalException;
import com.tedu.common.util.StringUtils;
import com.tedu.dao.album.mapper.AlbumMapper;
import com.tedu.domain.album.Album;
import com.tedu.domain.course.TeduCourse;
import com.tedu.domain.user.User;
import com.tedu.domain.userAlbum.UserAlbum;
import com.tedu.service.course.impl.CourseServiceImpl;
import com.tedu.service.user.impl.UserServiceImpl;
import com.tedu.service.userAlbum.impl.UserAlbumServiceImpl;

import jnr.ffi.types.int16_t;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
@Transactional
public class AlbumServiceImpl<E> {

	@Autowired
	private AlbumMapper mapper;

	@Autowired
	private UserAlbumServiceImpl userAlbumService;

	@Autowired
	private CourseServiceImpl courseService;

	@Autowired
	private UserServiceImpl userService;

	/**
	 * 添加专辑
	 * 
	 * @param userId
	 * @param name
	 * @throws MedicalException
	 */
	public void albumInsert(Integer userId, String name, String price, String picture) throws MedicalException {
		if (userId == null) {
			throw new MedicalException("userId不能为空");
		}
		if (StringUtils.isEmpty(name)) {
			throw new MedicalException("name不能为空");
		}
		Album abl = mapper.selectByUserIdAndName(userId, name);
		if (abl == null) {
			Album album = new Album();
			album.setName(name);
			album.setStatus(Constant.STATUS_1);
			album.setUserId(userId);
			album.setPrice(price);
			album.setDate(new Date());
			album.setPicture(picture);
			mapper.insert(album);
		} else {
			abl.setPrice(price);
			abl.setPicture(picture);
			mapper.updateByPrimaryKey(abl);
		}
	}

	/**
	 * 获取专辑列表
	 * 
	 * @param userId
	 * @return
	 * @throws MedicalException
	 */
	public List albumList(Integer userId) throws MedicalException {
		List<JSONObject> voList = new ArrayList<JSONObject>();
		List<Album> list = mapper.selectByUserId(userId);
		for (Album album : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", album.getId());
			jsonObject.put("name", album.getName());
			voList.add(jsonObject);
		}
		return voList;
	}

	/**
	 * 删除专辑
	 * 
	 * @param id
	 * @throws MedicalException
	 */
	public void albumDelete(Integer id) throws MedicalException {
		if (id == null) {
			throw new MedicalException("id不能为null");
		}
		Album album = new Album();
		album.setId(id);
		mapper.updateByPrimaryKeySelective(album);
	}

	/**
	 * 更新新专辑
	 * 
	 * @param id
	 * @param userId
	 * @param name
	 */
	public void albumUpdate(Integer id, Integer userId, String name) {
		Album album = new Album();
		album.setId(id);
		album.setName(name);
		album.setUserId(userId);
		mapper.updateByPrimaryKeySelective(album);
	}

	public List<Album> albumSelect(int userId) {
		return mapper.selectByUserId(userId);
	}

	/**
	 * 根据专辑查询专辑详情
	 * 
	 * @param id
	 * @return
	 * @throws MedicalException
	 */
	public Album getAlbumById(int id) throws MedicalException {
		Album album = mapper.selectByPrimaryKey(id);
		if (album == null)
			throw new MedicalException("此专辑不存在");
		return album;
	}

	/**
	 * 
	 * 查找相似专辑
	 * 
	 * @param albumName
	 * @param offset
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public List searchLikeAlbum(int userId, String albumName, int offset, int rows, String url) throws Exception {
		List<Album> list = mapper.searchLikeAlbum(albumName, offset, rows);
		List<JSONObject> lists = new ArrayList<JSONObject>();
		for (Album album : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", album.getId());
			jsonObject.put("name", album.getName());
			jsonObject.put("count", album.getCount());
			jsonObject.put("picture", url + album.getPicture());
			UserAlbum ua = userAlbumService.getGuanzhuByUserIdAndAlbumId(userId, album.getId());
			if (ua != null) {
				jsonObject.put("guanzhu", ua.getGuanzhu());
			} else {
				jsonObject.put("guanzhu", false);
			}
			int i = courseService.getCountByUserIdAndCategory(userId, album.getId());
			jsonObject.put("albumSize", i);
			jsonObject.put("price", album.getPrice());
			lists.add(jsonObject);
		}
		return lists;
	}

	public JSONObject getAlbumList(String search,int userId, int offset, int rows, String url) throws Exception {
		List<Album> list = mapper.searchLikeAlbum(search, offset, rows);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("albumlTotal", list.size());
		int i = courseService.getTotal();
		jsonObject.put("courseTotal", i);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("identity", 2);
		int jiangshiCount = userService.getCountBy(param);
		jsonObject.put("jiangshiCount", jiangshiCount);
		param.put("identity", "");
		int userCount = userService.getCountBy(param);
		jsonObject.put("userCount", userCount);
		JSONArray jsonArray = new JSONArray();
		for (Album album : list) {
			JSONObject jo = new JSONObject();
			jo.put("id", album.getId());
			User user = userService.getUserInfoById(album.getUserId());
			String name = user.getName();
			if (name != null) {
				jo.put("userName", user.getName());
			} else {
				jo.put("userName", "");
			}
			jo.put("name", album.getName());
			if (album.getPicture() != null) {
				jo.put("picture", url + album.getPicture());
			} else {
				jo.put("picture", "");
			}
			UserAlbum userAlbum = userAlbumService.getGuanzhuByUserIdAndAlbumId(userId, album.getId());
			jo.put("guanzhu", userAlbum.getGuanzhu());
			if (album.getPrice().equals("-1")) {
				TeduCourse teduCourse = new TeduCourse();
				teduCourse.setUserId(album.getUserId());
				teduCourse.setCategory(album.getId());
				List<TeduCourse> courseList = courseService.getList(teduCourse);
				BigDecimal price = BigDecimal.ZERO;
				for (TeduCourse tc : courseList) {
					if (!tc.getCost().equals("-1")) {
						price = new BigDecimal(tc.getCost()).add(price);
					}
				}
				jo.put("price", price);
			}
			jo.put("price", album.getPrice());
			long time = new Date().getTime();
			String formateTime = formateTime(time);
			jo.put("time", formateTime);
			jsonArray.add(jo);
//			if (BigInteger.valueOf(time).subtract(BigInteger.valueOf(album.getDate().getTime()))
//					.compareTo(BigInteger.valueOf(24 * 60 * 60 * 1000)) > 0) {
//				BigInteger divide = BigInteger.valueOf(time).subtract(BigInteger.valueOf(album.getDate().getTime()))
//						.divide(BigInteger.valueOf(24 * 60 * 60 * 1000));
//				jo.put("time", divide.toString(10) + "天前");
//			} else {
//
//			}
//			-album.get
		}
		jsonObject.put("albumList", jsonArray);
		return jsonObject;
	}

	public String formateTime(Long time) {
		Date dateparam = new Date(time);

		Date currentTime = new Date( System.currentTimeMillis());

		switch (currentTime.getDate() - dateparam.getDate()) {
		case 0:
			int i = currentTime.getHours() - dateparam.getHours();
			if (i > 0) {
				int i2 = currentTime.getMinutes() - dateparam.getMinutes();
				if (i2 > 0)
					return i + "小时前";
				else if (i2 > -60)
					return 60 + i2 + "分钟前";
				else
					return "刚刚";
			} else {
				int i1 = currentTime.getMinutes() - dateparam.getMinutes();
				if (i1 > 0) {
					return i1 + "分钟前";
				} else
					return "刚刚";
			}
		case 1:
			return "昨天" + formateStr(dateparam.getHours() + "") + ":" + formateStr(dateparam.getMinutes() + "") + ":"
					+ formateStr("" + dateparam.getSeconds());
		case 2:
			return "前天" + formateStr(dateparam.getHours() + "") + ":" + formateStr(dateparam.getMinutes() + "") + ":"
					+ formateStr("" + dateparam.getSeconds());
		default:
			return currentTime.getDate() - dateparam.getDate() + "天前";
		}
	}

	private String formateStr(String str) {
		return new String().format("%02d", str);
	}

}
