package com.tedu.domain.tokentransaction;

public class TokenTransaction {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 块高
     */
    private Integer blockNumber;

    /**
     * 时间戳
     */
    private String timeStamp;

    /**
     * hash
     */
    private String hash;

    /**
     * 
     */
    private String nonce;

    /**
     * 块hash
     */
    private String blockHash;

    /**
     * 发送地址
     */
    private String from;

    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 接受地址
     */
    private String to;

    /**
     * 发送金额
     */
    private String value;

    /**
     * 
     */
    private String tokenName;

    /**
     * 
     */
    private String tokenSymbol;

    /**
     * 
     */
    private String tokenDecimal;

    /**
     * 
     */
    private Integer transactionIndex;

    /**
     * 
     */
    private String gas;

    /**
     * 
     */
    private String gasPrice;

    /**
     * 
     */
    private String gasUsed;

    /**
     * 
     */
    private String cumulativeGasUsed;

    /**
     * 
     */
    private String input;

    /**
     * 
     */
    private Integer confirmations;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
    private Integer status;

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
     * 块高
     * @return block_number 块高
     */
    public Integer getBlockNumber() {
        return blockNumber;
    }

    /**
     * 块高
     * @param blockNumber 块高
     */
    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    /**
     * 时间戳
     * @return time_stamp 时间戳
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * 时间戳
     * @param timeStamp 时间戳
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp == null ? null : timeStamp.trim();
    }

    /**
     * hash
     * @return hash hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * hash
     * @param hash hash
     */
    public void setHash(String hash) {
        this.hash = hash == null ? null : hash.trim();
    }

    /**
     * 
     * @return nonce 
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * 
     * @param nonce 
     */
    public void setNonce(String nonce) {
        this.nonce = nonce == null ? null : nonce.trim();
    }

    /**
     * 块hash
     * @return block_hash 块hash
     */
    public String getBlockHash() {
        return blockHash;
    }

    /**
     * 块hash
     * @param blockHash 块hash
     */
    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash == null ? null : blockHash.trim();
    }

    /**
     * 发送地址
     * @return from 发送地址
     */
    public String getFrom() {
        return from;
    }

    /**
     * 发送地址
     * @param from 发送地址
     */
    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    /**
     * 合约地址
     * @return contract_address 合约地址
     */
    public String getContractAddress() {
        return contractAddress;
    }

    /**
     * 合约地址
     * @param contractAddress 合约地址
     */
    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress == null ? null : contractAddress.trim();
    }

    /**
     * 接受地址
     * @return to 接受地址
     */
    public String getTo() {
        return to;
    }

    /**
     * 接受地址
     * @param to 接受地址
     */
    public void setTo(String to) {
        this.to = to == null ? null : to.trim();
    }

    /**
     * 发送金额
     * @return value 发送金额
     */
    public String getValue() {
        return value;
    }

    /**
     * 发送金额
     * @param value 发送金额
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 
     * @return token_name 
     */
    public String getTokenName() {
        return tokenName;
    }

    /**
     * 
     * @param tokenName 
     */
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName == null ? null : tokenName.trim();
    }

    /**
     * 
     * @return token_symbol 
     */
    public String getTokenSymbol() {
        return tokenSymbol;
    }

    /**
     * 
     * @param tokenSymbol 
     */
    public void setTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol == null ? null : tokenSymbol.trim();
    }

    /**
     * 
     * @return token_decimal 
     */
    public String getTokenDecimal() {
        return tokenDecimal;
    }

    /**
     * 
     * @param tokenDecimal 
     */
    public void setTokenDecimal(String tokenDecimal) {
        this.tokenDecimal = tokenDecimal == null ? null : tokenDecimal.trim();
    }

    /**
     * 
     * @return transaction_index 
     */
    public Integer getTransactionIndex() {
        return transactionIndex;
    }

    /**
     * 
     * @param transactionIndex 
     */
    public void setTransactionIndex(Integer transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    /**
     * 
     * @return gas 
     */
    public String getGas() {
        return gas;
    }

    /**
     * 
     * @param gas 
     */
    public void setGas(String gas) {
        this.gas = gas == null ? null : gas.trim();
    }

    /**
     * 
     * @return gas_price 
     */
    public String getGasPrice() {
        return gasPrice;
    }

    /**
     * 
     * @param gasPrice 
     */
    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice == null ? null : gasPrice.trim();
    }

    /**
     * 
     * @return gas_used 
     */
    public String getGasUsed() {
        return gasUsed;
    }

    /**
     * 
     * @param gasUsed 
     */
    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed == null ? null : gasUsed.trim();
    }

    /**
     * 
     * @return cumulative_gas_used 
     */
    public String getCumulativeGasUsed() {
        return cumulativeGasUsed;
    }

    /**
     * 
     * @param cumulativeGasUsed 
     */
    public void setCumulativeGasUsed(String cumulativeGasUsed) {
        this.cumulativeGasUsed = cumulativeGasUsed == null ? null : cumulativeGasUsed.trim();
    }

    /**
     * 
     * @return input 
     */
    public String getInput() {
        return input;
    }

    /**
     * 
     * @param input 
     */
    public void setInput(String input) {
        this.input = input == null ? null : input.trim();
    }

    /**
     * 
     * @return confirmations 
     */
    public Integer getConfirmations() {
        return confirmations;
    }

    /**
     * 
     * @param confirmations 
     */
    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    /**
     * 
     * @return type 
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
     * @param type 
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     * @return status 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}