package com.tedu.domain.qianbao;

import java.util.Date;

public class Qianbao {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userid;

    /**
     * 发送地址
     */
    private String fromAddress;

    /**
     * 接受地址
     */
    private String toAddress;

    /**
     * 0:转账;1:充值;2：课程收入;3:体现;4:购买;5:冻结
     */
    private Integer type;

    /**
     * 类型描述
     */
    private String content;

    /**
     * 时间
     */
    private String date;

    /**
     * 币种
     */
    private String coinType;

    /**
     * 交易hash
     */
    private String txid;

    /**
     * 块高
     */
    private String blockNumber;

    /**
     * 合约id
     */
    private String contractId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 余额
     */
    private String balance;

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
     * @return userId 用户id
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 用户id
     * @param userid 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 发送地址
     * @return from_address 发送地址
     */
    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * 发送地址
     * @param fromAddress 发送地址
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress == null ? null : fromAddress.trim();
    }

    /**
     * 接受地址
     * @return to_address 接受地址
     */
    public String getToAddress() {
        return toAddress;
    }

    /**
     * 接受地址
     * @param toAddress 接受地址
     */
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress == null ? null : toAddress.trim();
    }

    /**
     * 0:转账;1:充值;2：课程收入;3:体现;4:购买;5:冻结
     * @return type 0:转账;1:充值;2：课程收入;3:体现;4:购买;5:冻结
     */
    public Integer getType() {
        return type;
    }

    /**
     * 0:转账;1:充值;2：课程收入;3:体现;4:购买;5:冻结
     * @param type 0:转账;1:充值;2：课程收入;3:体现;4:购买;5:冻结
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 类型描述
     * @return content 类型描述
     */
    public String getContent() {
        return content;
    }

    /**
     * 类型描述
     * @param content 类型描述
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 时间
     * @return date 时间
     */
    public String getDate() {
        return date;
    }

    /**
     * 时间
     * @param date 时间
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 币种
     * @return coin_type 币种
     */
    public String getCoinType() {
        return coinType;
    }

    /**
     * 币种
     * @param coinType 币种
     */
    public void setCoinType(String coinType) {
        this.coinType = coinType == null ? null : coinType.trim();
    }

    /**
     * 交易hash
     * @return txid 交易hash
     */
    public String getTxid() {
        return txid;
    }

    /**
     * 交易hash
     * @param txid 交易hash
     */
    public void setTxid(String txid) {
        this.txid = txid == null ? null : txid.trim();
    }

    /**
     * 块高
     * @return block_number 块高
     */
    public String getBlockNumber() {
        return blockNumber;
    }

    /**
     * 块高
     * @param blockNumber 块高
     */
    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
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

    /**
     * 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 余额
     * @return balance 余额
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 余额
     * @param balance 余额
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }
}