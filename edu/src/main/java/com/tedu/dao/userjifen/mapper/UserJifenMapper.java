package com.tedu.dao.userjifen.mapper;

import com.tedu.domain.userjifen.UserJifen;

public interface UserJifenMapper {
    /**
     *
     * @mbg.generated 2018-10-24
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int insert(UserJifen record);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int insertSelective(UserJifen record);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    UserJifen selectByPrimaryKey(Integer id);
    
    UserJifen selectByUserId(Integer userId);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int updateByUserId(UserJifen record);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int updateByPrimaryKey(UserJifen record);
}