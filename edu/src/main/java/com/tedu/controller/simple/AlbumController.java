package com.tedu.controller.simple;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.common.core.Constant;
import com.tedu.common.core.SysProperties;
import com.tedu.common.exception.MedicalException;
import com.tedu.common.model.ResponseDTO;
import com.tedu.domain.user.BaseUser;
import com.tedu.domain.userAlbum.UserAlbum;
import com.tedu.service.album.AlbumServiceImpl;
import com.tedu.service.course.impl.CourseServiceImpl;
import com.tedu.service.userAlbum.impl.UserAlbumServiceImpl;

/**
 * @author mc qq:776355102
 * @since 2018年9月2日 专辑
 */
@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/tedu/a/v/album")
public class AlbumController extends BaseController {

	@Autowired
	private AlbumServiceImpl albumService;

	@Autowired
	private UserAlbumServiceImpl userAlbumService;

	@Autowired
	private CourseServiceImpl courseService;

	/**
	 * @throws MedicalException 添加专辑
	 * @throws IOException
	 */
	@RequestMapping("addAlbum")
	public Object addAlbum(@RequestParam(required = true) String name, @RequestParam(defaultValue = "-1") String price,
			MultipartFile picture) throws MedicalException, IOException {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登陆后再操作");
		}
		// 课程图片保存
		String picPathString = "";
		if (picture != null) {
			picPathString = SavePicture(picture);
		}

		albumService.albumInsert(baseUser.getId(), name, price, picPathString);
		return ResponseDTO.setStaticResult("操作成功");
	}

	/**
	 * @param albumId 更新专辑
	 * @throws MedicalException
	 */
	@RequestMapping("updateAlbum")
	public void updateAlbum(@RequestParam(required = true) int albumId, String name) throws MedicalException {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登录之后再操作");
		}
		albumService.albumUpdate(albumId, baseUser.getId(), name);
	}

	/**
	 * 获取所属专辑列表
	 * 
	 * @return
	 * @throws MedicalException
	 */
	@RequestMapping("albumList")
	public Object albumList() throws MedicalException {
		BaseUser baseUser = getBaseUser();
		if (baseUser == null) {
			throw new MedicalException("请先登录之后再操作");
		}
		List albumList = albumService.albumList(baseUser.getId());
		return ResponseDTO.setStaticResult(albumList);
	}

	/**
	 * 关注此专辑
	 * 
	 * @param guanzhu
	 * @param courseAlbumId
	 * @throws MedicalException
	 */
	@RequestMapping("guanzu")
	public Object guanzhu(@RequestParam(name = "guanzhu", required = true, defaultValue = "1") int guanzhu,
			@RequestParam(required = true) int courseAlbumId) throws MedicalException {
		BaseUser bu = getBaseUser();
		if (bu == null) {
			throw new MedicalException("请登录之后再操作");
		}
		UserAlbum ua = new UserAlbum();
		ua.setAlbumId(courseAlbumId);
		ua.setUserId(bu.getId());
		if (guanzhu == 1) {
			ua.setGuanzhu(true);
		} else {
			ua.setGuanzhu(false);
		}
		ua.setDate(new Date());
		UserAlbum userAlbum = userAlbumService.insertUserAlbumSelective(ua);
		return ResponseDTO.setStaticResult("操作成功");
	}

	/**
	 * 
	 * 课程图片保存
	 * 
	 * @param image
	 * @return 保存图片的的路径
	 * @throws MedicalException
	 * @throws IOException
	 */
	private String SavePicture(MultipartFile image) throws MedicalException, IOException {
		// 图片保存的完整图片文件保存路径
		String course_picture_path = "";
		// 生成uuid作为文件名称
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		// 获得文件类型（可以判断如果不是图片，禁止上传）
		String contentType = image.getContentType();
		// 获得文件后缀名称
		String imageName = contentType.substring(contentType.indexOf("/") + 1);
		if (!Constant.PICTURE_FORMAT.contains(imageName)) {
			throw new MedicalException("图片格式有误,请上传jpg,gif,png,bmp,jpeg格式!");
		}
		// 设置图片真实存放的文件夹路径
		String course_picture_doc_base = SysProperties.getProperty("picture_base");
		// 图片访问路径
		String course_picture_access_path = SysProperties.getProperty("picture_path");
		course_picture_path = course_picture_doc_base + uuid + "." + imageName;
		// 图片访问路径除ip和端口
		String pathUrl = course_picture_access_path + uuid + "." + imageName;
		File file = new File(course_picture_path);
		if (!file.exists()) {
			// 先得到文件的上级目录，并创建上级目录，在创建文件
			file.getParentFile().mkdir();
			try {
				// 创建文件
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		image.transferTo(file);
		return pathUrl;
	}

}
