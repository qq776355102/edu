package com.tedu.dao.usercourse.mapper;

import com.tedu.domain.usercourse.UserCourse;

public interface UserCourseMapper {
    /**
     *
     * @mbg.generated 2018-09-04
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-04
     */
    int insert(UserCourse record);

    /**
     *
     * @mbg.generated 2018-09-04
     */
    int insertSelective(UserCourse record);

    /**
     *
     * @mbg.generated 2018-09-04
     */
    UserCourse selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-04
     */
    int updateByPrimaryKeySelective(UserCourse record);

    /**
     *
     * @mbg.generated 2018-09-04
     */
    int updateByPrimaryKey(UserCourse record);
    
    int checkIsBuyed(UserCourse record);
}