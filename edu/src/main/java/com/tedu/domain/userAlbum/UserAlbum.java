package com.tedu.domain.userAlbum;

import java.util.Date;

public class UserAlbum {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 专辑id
     */
    private Integer albumId;

    /**
     * 更新日期
     */
    private Date date;

    /**
     * 用户关注了此专辑：true;否则：false
     */
    private Boolean guanzhu;
    
    /**
     *  是否已购买此专辑
     */
    private boolean isBuyed;

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 专辑id
     * @return album_id 专辑id
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 专辑id
     * @param albumId 专辑id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 更新日期
     * @return date 更新日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 更新日期
     * @param date 更新日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 用户关注了此专辑：true;否则：false
     * @return guanzhu 用户关注了此专辑：true;否则：false
     */
    public Boolean getGuanzhu() {
        return guanzhu;
    }

    /**
     * 用户关注了此专辑：true;否则：false
     * @param guanzhu 用户关注了此专辑：true;否则：false
     */
    public void setGuanzhu(Boolean guanzhu) {
        this.guanzhu = guanzhu;
    }

	public boolean getIsBuyed() {
		return isBuyed;
	}

	public void setIsBuyed(boolean isBuyed) {
		this.isBuyed = isBuyed;
	}
}