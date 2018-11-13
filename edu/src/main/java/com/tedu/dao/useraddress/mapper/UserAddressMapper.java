package com.tedu.dao.useraddress.mapper;

import com.tedu.domain.useraddress.UserAddress;

public interface UserAddressMapper {
    /**
     *
     * @mbg.generated 2018-10-24
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int insert(UserAddress record);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int insertSelective(UserAddress record);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    UserAddress selectByUserId(Integer userId);
    
    UserAddress selectByAddress(String address);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int updateByPrimaryKeySelective(UserAddress record);

    /**
     *
     * @mbg.generated 2018-10-24
     */
    int updateByPrimaryKey(UserAddress record);
}