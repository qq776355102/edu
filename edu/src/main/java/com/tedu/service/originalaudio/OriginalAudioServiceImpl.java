package com.tedu.service.originalaudio;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tedu.common.exception.MedicalException;
import com.tedu.dao.originalaudio.mapper.OriginalAudioMapper;
import com.tedu.domain.originalaudio.OriginalAudio;

/**
 * @author mc qq:776355102
 * @since 2018年10月9日
 * 
 */
@Service
public class OriginalAudioServiceImpl {

	@Autowired
	private OriginalAudioMapper mapper;

	/**
	 * 检查源文件是否已经上传
	 * 
	 * @param userId
	 * @param originalFileName
	 * @param fileLength
	 * @throws MedicalException
	 */
	public void checkOriginalAudio(String userId, String originalFileName, String fileLength) throws MedicalException {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("originalFileName", originalFileName);
		param.put("length", fileLength);
		List<OriginalAudio> list = mapper.selectByMap(param);
		if (list.size() > 0 ) {
			throw new MedicalException("已经上传，请勿重复操作");
		}
	}

	/**
	 * 添加新的原音频记录
	 * 
	 * @param originalAudio
	 */
	public void insertOriginalAudio(OriginalAudio originalAudio) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("userId", originalAudio.getUserId());
		param.put("originalFileName", originalAudio.getOriginalFileName());
		param.put("length", originalAudio.getFileLength());
		List<OriginalAudio> list = mapper.selectByMap(param);
		if (list == null || list.size() ==0) {
			mapper.insertSelective(originalAudio);
		}
	}

}
