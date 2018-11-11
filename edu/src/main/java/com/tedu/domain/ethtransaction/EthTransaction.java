package com.tedu.domain.ethtransaction;

public class EthTransaction {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer blockNumber;

    /**
     * 
     */
    private String blockHash;

    /**
     * 
     */
    private String timeStamp;

    /**
     * 
     */
    private String hash;

    /**
     * 
     */
    private Integer nonce;

    /**
     * 
     */
    private Integer transactionIndex;

    /**
     * 
     */
    private String from;

    /**
     * 
     */
    private String to;

    /**
     * 
     */
    private String value;

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
    private String input;

    /**
     * 
     */
    private String contractAddress;

    /**
     * 
     */
    private String cumulativeGasUsed;

    /**
     * 
     */
    private Integer txreceiptStatus;

    /**
     * 
     */
    private String gasUsed;

    /**
     * 
     */
    private Integer confirmations;

    /**
     * 
     */
    private Integer iserror;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
    private Integer status;

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
     * 
     * @return block_number 
     */
    public Integer getBlockNumber() {
        return blockNumber;
    }

    /**
     * 
     * @param blockNumber 
     */
    public void setBlockNumber(Integer blockNumber) {
        this.blockNumber = blockNumber;
    }

    /**
     * 
     * @return block_hash 
     */
    public String getBlockHash() {
        return blockHash;
    }

    /**
     * 
     * @param blockHash 
     */
    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash == null ? null : blockHash.trim();
    }

    /**
     * 
     * @return time_stamp 
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * 
     * @param timeStamp 
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp == null ? null : timeStamp.trim();
    }

    /**
     * 
     * @return hash 
     */
    public String getHash() {
        return hash;
    }

    /**
     * 
     * @param hash 
     */
    public void setHash(String hash) {
        this.hash = hash == null ? null : hash.trim();
    }

    /**
     * 
     * @return nonce 
     */
    public Integer getNonce() {
        return nonce;
    }

    /**
     * 
     * @param nonce 
     */
    public void setNonce(Integer nonce) {
        this.nonce = nonce;
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
     * @return from 
     */
    public String getFrom() {
        return from;
    }

    /**
     * 
     * @param from 
     */
    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    /**
     * 
     * @return to 
     */
    public String getTo() {
        return to;
    }

    /**
     * 
     * @param to 
     */
    public void setTo(String to) {
        this.to = to == null ? null : to.trim();
    }

    /**
     * 
     * @return value 
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value 
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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
     * @return contract_address 
     */
    public String getContractAddress() {
        return contractAddress;
    }

    /**
     * 
     * @param contractAddress 
     */
    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress == null ? null : contractAddress.trim();
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
     * @return txreceipt_status 
     */
    public Integer getTxreceiptStatus() {
        return txreceiptStatus;
    }

    /**
     * 
     * @param txreceiptStatus 
     */
    public void setTxreceiptStatus(Integer txreceiptStatus) {
        this.txreceiptStatus = txreceiptStatus;
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
     * @return isError 
     */
    public Integer getIserror() {
        return iserror;
    }

    /**
     * 
     * @param iserror 
     */
    public void setIserror(Integer iserror) {
        this.iserror = iserror;
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