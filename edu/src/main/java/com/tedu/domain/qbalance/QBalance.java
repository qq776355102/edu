package com.tedu.domain.qbalance;

public class QBalance {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 地址
     */
    private String address;

    /**
     * 最终余额
     */
    private String totalBalance;

    /**
     * 冻结的余额
     */
    private String freezeBalance;

    /**
     * 币的类型
     */
    private String coinType;

    /**
     * 合约id
     */
    private String contractId;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
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
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 最终余额
     * @return total_balance 最终余额
     */
    public String getTotalBalance() {
        return totalBalance;
    }

    /**
     * 最终余额
     * @param totalBalance 最终余额
     */
    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance == null ? null : totalBalance.trim();
    }

    /**
     * 冻结的余额
     * @return freeze_balance 冻结的余额
     */
    public String getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 冻结的余额
     * @param freezeBalance 冻结的余额
     */
    public void setFreezeBalance(String freezeBalance) {
        this.freezeBalance = freezeBalance == null ? null : freezeBalance.trim();
    }

    /**
     * 币的类型
     * @return coin_type 币的类型
     */
    public String getCoinType() {
        return coinType;
    }

    /**
     * 币的类型
     * @param coinType 币的类型
     */
    public void setCoinType(String coinType) {
        this.coinType = coinType == null ? null : coinType.trim();
    }

    /**
     * 合约id
     * @return contract_id 合约id
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * 合约id
     * @param contractId 合约id
     */
    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }
}