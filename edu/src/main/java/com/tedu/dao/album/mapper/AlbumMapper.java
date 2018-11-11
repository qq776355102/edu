package com.tedu.dao.album.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tedu.domain.album.Album;

public interface AlbumMapper {
    /**
     *
     * @mbg.generated 2018-09-11
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    int insert(Album record);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    int insertSelective(Album record);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    Album selectByPrimaryKey(Integer id);
    
    List<Album> getAlbumList(String search);
    
    public List<Album>  selectByUserId(Integer userId);
    
    Album selectByUserIdAndName(@Param("userId")int userId,@Param("name")String name);

    
    List<Album> searchLikeAlbum(@Param("albumName") String albumName,@Param("offset")int offset,@Param("rows")int rows);
    /**
     *
     * @mbg.generated 2018-09-11
     */
    int updateByPrimaryKeySelective(Album record);

    /**
     *
     * @mbg.generated 2018-09-11
     */
    int updateByPrimaryKey(Album record);
}