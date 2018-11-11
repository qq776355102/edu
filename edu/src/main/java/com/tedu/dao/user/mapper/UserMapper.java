package com.tedu.dao.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.alibaba.dubbo.config.support.Parameter;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.tedu.domain.user.User;

import jnr.ffi.types.int16_t;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2018-09-07
     */
    int deleteByPrimaryKey(Integer id);

    public User getUserByPhoneNumber(String phone) ;
    int insertSelective(User record);
    /**
     * identity
     * @param param
     * @return
     */
    int getCountBy(Map<String, Object> param);
    public User getUserByPhoneAndPassWord(@Param("phone")String phone,@Param("passWord")String passWord) ;
    
    List<User> searchLikeInstructor(@Param("search")String search,@Param("identity")int identity);
    /**
     *
     * @mbg.generated 2018-09-07
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2018-09-07
     */

    
    User checkUserByPassWord(@Param("userId")Integer userId,@Param("passWord")String oldPassword);

    /**
     *
     * @mbg.generated 2018-09-07
     */
    User selectByPrimaryKey(Integer id);

    public void getUpdateByUser(com.tedu.domain.user.User user) throws Exception;

    /**
     *
     * @mbg.generated 2018-09-07
     */
    int updateByPrimaryKey(User record);
}