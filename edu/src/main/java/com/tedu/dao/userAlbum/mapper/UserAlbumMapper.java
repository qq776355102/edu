package com.tedu.dao.userAlbum.mapper;

import org.apache.ibatis.annotations.Param;

import com.tedu.domain.userAlbum.UserAlbum;

public interface UserAlbumMapper {
    /**
     *
     * @mbg.generated 2018-09-11
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    int insert(UserAlbum record);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    int insertSelective(UserAlbum record);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    UserAlbum selectByPrimaryKey(Integer id);
    
    UserAlbum selectByUserIdAndAlbumId(@Param("userId")Integer userId,@Param("albumId")int albumId);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    int updateByPrimaryKeySelective(UserAlbum record);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    int updateByPrimaryKey(UserAlbum record);
}