package com.tedu.domain.czaddress;

public class ChongzhiAddress {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户以太坊充值地址
     */
    private String ethAddress;

    /**
     * 用户以太坊分红地址
     */
    private String fenhongAddress;

    /**
     * 数据状态
     */
    private Integer status;

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
     * 用户以太坊充值地址
     * @return eth_address 用户以太坊充值地址
     */
    public String getEthAddress() {
        return ethAddress;
    }

    /**
     * 用户以太坊充值地址
     * @param ethAddress 用户以太坊充值地址
     */
    public void setEthAddress(String ethAddress) {
        this.ethAddress = ethAddress == null ? null : ethAddress.trim();
    }

    /**
     * 用户以太坊分红地址
     * @return fenhong_address 用户以太坊分红地址
     */
    public String getFenhongAddress() {
        return fenhongAddress;
    }

    /**
     * 用户以太坊分红地址
     * @param fenhongAddress 用户以太坊分红地址
     */
    public void setFenhongAddress(String fenhongAddress) {
        this.fenhongAddress = fenhongAddress == null ? null : fenhongAddress.trim();
    }

    /**
     * 数据状态
     * @return status 数据状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 数据状态
     * @param status 数据状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}