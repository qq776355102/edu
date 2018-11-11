package com.tedu.domain.user;

import java.io.Serializable;

public class BaseUser implements Serializable {

	private static final long serialVersionUID = -2990168135790653043L;

	/**
	 * 用户id
	 */
	private Integer id;

	/**
	 * UUID
	 */
	private String uuId;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 
	 */
	private String phone;

	/**
	 * 密码
	 */
	private String pwd;

	/**
	 * 角色
	 */
	private int identity;
	
	/**
	 * 令牌
	 */
	private String token;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



}
