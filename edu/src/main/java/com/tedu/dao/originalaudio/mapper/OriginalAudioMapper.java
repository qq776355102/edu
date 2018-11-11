package com.tedu.dao.originalaudio.mapper;

import java.util.List;
import java.util.Map;

import com.tedu.domain.originalaudio.OriginalAudio;

public interface OriginalAudioMapper {
	/**
	 *
	 * @mbg.generated 2018-10-09
	 */
	int deleteByPrimaryKey(Integer ginal);

	/**
	 *
	 * @mbg.generated 2018-10-09
	 */
	int insert(OriginalAudio record);

	/**
	 *
	 * @mbg.generated 2018-10-09
	 */
	int insertSelective(OriginalAudio record);

	/**
	 *
	 * @mbg.generated 2018-10-09
	 */
	OriginalAudio selectByPrimaryKey(Integer ginal);

	/**
	 * 
	 * userId originalFileName fileLength
	 * 
	 * @param param
	 * @return
	 */
	List<OriginalAudio> selectByMap(Map<String, Object> param);

	/**
	 *
	 * @mbg.generated 2018-10-09
	 */
	int updateByPrimaryKeySelective(OriginalAudio record);

	/**
	 *
	 * @mbg.generated 2018-10-09
	 */
	int updateByPrimaryKey(OriginalAudio record);
}