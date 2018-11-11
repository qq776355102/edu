package com.tedu.dao.courseorder.mapper;

import com.tedu.domain.courseorder.CourseOrder;

public interface CourseOrderMapper {
    /**
     *
     * @mbg.generated 2018-10-11
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-11
     */
    int insert(CourseOrder record);

    /**
     *
     * @mbg.generated 2018-10-11
     */
    int insertSelective(CourseOrder record);

    /**
     *
     * @mbg.generated 2018-10-11
     */
    CourseOrder selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-11
     */
    int updateByPrimaryKeySelective(CourseOrder record);

    /**
     *
     * @mbg.generated 2018-10-11
     */
    int updateByPrimaryKey(CourseOrder record);
}