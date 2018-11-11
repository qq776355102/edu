package com.tedu.common.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.common.core.Constant;
import com.tedu.common.core.SysProperties;
import com.tedu.common.exception.MedicalException;

import audio.ConvertingAnyAudioToMp3_Example2;
import audio.ReadAudio;
import net.sf.json.JSONObject;

public class AudioFileUtil {

	/**
	 * 
	 * 课程图片保存
	 * 
	 * @param image
	 * @return 保存图片的的路径
	 * @throws MedicalException
	 * @throws IOException
	 */
	public static String SavePicture(MultipartFile image) throws MedicalException, IOException {
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

	/**
	 * 
	 * 所有音频格式转MP3,并返回音频保存的路径
	 * 
	 * @param audio
	 * @return 音频保存的路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public static JSONObject SaveAudio(MultipartFile audio) throws IllegalStateException, IOException {

		// 原生音频文件转MP3格式后保存的完整文件MP3格式最终路径
		String course_audio_target_path = "";
		// 生成uuid作为文件名称
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		// 获取原始音频文件名
		String audioName = audio.getOriginalFilename();
		// 原始音频文件临时保存后缀
		String suffix = audioName.substring(audioName.lastIndexOf("."));
		// 设置最终音频保存路径的文件夹位置
		String final_audio_base_dir = SysProperties.getProperty("final_audio_base_dir");
		// 原始音频文件转到MP3格式后完整最终保存路径
		course_audio_target_path = final_audio_base_dir + uuid + "_" + "." + "mp3";
		// 原始音频文件临时保存前缀
		String prefix = uuid + "_";
		// 原始音频临时保存位置
		final File tempFile = File.createTempFile(prefix, suffix);
		if (!tempFile.exists()) {
			// 先得到文件的上级目录，并创建上级目录，在创建文件
			tempFile.getParentFile().mkdir();
			try {
				// 创建文件
				tempFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		audio.transferTo(tempFile);
		// 业务逻辑 音频格式转换
		File target_file = new File(course_audio_target_path);
		ConvertingAnyAudioToMp3_Example2 conv = new ConvertingAnyAudioToMp3_Example2();
		// 格式转换
		conv.ConvertingAnyAudioToMp3WithAProgressListener(tempFile, target_file);
		// 获取视频时长
		String audioLength = ReadAudio.getAudioLength(target_file);
		// 程序结束时，删除临时文件
		deleteFile(tempFile);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("length", audioLength);
		jsonObject.put("path", course_audio_target_path);
		return jsonObject;
	}

	/**
	 * 删除 文件
	 * 
	 * @param files 要删除的文件
	 */
	public static void deleteFile(File... files) {
		for (File file : files) {
			if (file.exists()) {
				file.delete();
			}
		}
	}

}
