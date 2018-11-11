package com.tedu.domain.user;

public class User {
    /**
     * 
     */
    private int id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户别称
     */
    private String alias;

    /**
     * 用户肖像
     */
    private String portrait;

    /**
     * 性别（0,男；1女）
     */
    private int sex;

    /**
     * 用户生日
     */
    private String birthday;

    /**
     * 用户所在地区
     */
    private String area;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份；1，普通用户；2，讲师
     */
    private int identity;

    /**
     * 讲师等级；1普通讲师
     */
    private int rank;

    /**
     * 个人简介
     */
    private String introduction;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 数据状态
     */
    private int status;
    
    /**
     * eth地址
     * 
     */
    private String address;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return name 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 用户名
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 用户别称
     * @return alias 用户别称
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 用户别称
     * @param alias 用户别称
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * 用户肖像
     * @return portrait 用户肖像
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * 用户肖像
     * @param portrait 用户肖像
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

    /**
     * 性别（0,男；1女）
     * @return sex 性别（0,男；1女）
     */
    public int getSex() {
        return sex;
    }

    /**
     * 性别（0,男；1女）
     * @param i 性别（0,男；1女）
     */
    public void setSex(int i) {
        this.sex = i;
    }

    /**
     * 用户生日
     * @return birthday 用户生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 用户生日
     * @param birthday 用户生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 用户所在地区
     * @return area 用户所在地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 用户所在地区
     * @param area 用户所在地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 密码
     * @return pass_word 密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 密码
     * @param passWord 密码
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * 手机号
     * @return phone 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 身份；1，普通用户；2，讲师
     * @return Identity 身份；1，普通用户；2，讲师
     */
    public int getIdentity() {
        return identity;
    }

    /**
     * 身份；1，普通用户；2，讲师
     * @param i 身份；1，普通用户；2，讲师
     */
    public void setIdentity(int i) {
        this.identity = i;
    }

    /**
     * 讲师等级；1普通讲师
     * @return rank 讲师等级；1普通讲师
     */
    public int getRank() {
        return rank;
    }

    /**
     * 讲师等级；1普通讲师
     * @param i 讲师等级；1普通讲师
     */
    public void setRank(int i) {
        this.rank = i;
    }

    /**
     * 个人简介
     * @return Introduction 个人简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 个人简介
     * @param introduction 个人简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * 身份证号
     * @return id_card 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 数据状态
     * @return status 数据状态
     */
    public int getStatus() {
        return status;
    }

    /**
     * 数据状态
     * @param status 数据状态
     */
    public void setStatus(int status) {
        this.status = status;
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}