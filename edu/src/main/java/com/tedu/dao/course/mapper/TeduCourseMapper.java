package com.tedu.dao.course.mapper;

import java.util.List;
import java.util.Map;

import com.tedu.domain.course.TeduCourse;

import jnr.ffi.types.int16_t;

public interface TeduCourseMapper {
    /**
     *
     * @mbg.generated 2018-10-10
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-10
     */
    int insert(TeduCourse record);

    /**
     *
     * @mbg.generated 2018-10-10
     */
    int insertSelective(TeduCourse record);

    /**
     *
     * @mbg.generated 2018-10-10
     */
    TeduCourse selectByPrimaryKey(Integer id);

    List<TeduCourse> getList(TeduCourse record);
    
    List<TeduCourse>  getPageList(Map<String, Object> param);
    
    List<TeduCourse> getLastestRecordGroupByUserIdAndBy(Map<String, Object> param);
    
    int getTotal();
    
    List<TeduCourse> searchLikeTile(String title);
    
    /**
     *
     * @mbg.generated 2018-10-10
     */
    int updateByPrimaryKeySelective(TeduCourse record);

    /**
     *
     * @mbg.generated 2018-10-10
     */
    int updateByPrimaryKey(TeduCourse record);
}