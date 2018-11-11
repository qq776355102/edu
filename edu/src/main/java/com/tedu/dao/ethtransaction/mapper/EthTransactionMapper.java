package com.tedu.dao.ethtransaction.mapper;

import java.util.Map;

import com.tedu.domain.ethtransaction.EthTransaction;

public interface EthTransactionMapper {
    /**
     *
     * @mbg.generated 2018-10-21
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    int insert(EthTransaction record);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    int insertSelective(EthTransaction record);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    EthTransaction selectByPrimaryKey(Integer id);
    
    EthTransaction selectByToOfLast(String toAddress);

    EthTransaction selectByMap(Map<String,Object> map);
    /**
     *
     * @mbg.generated 2018-10-21
     */
    int updateByPrimaryKeySelective(EthTransaction record);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    int updateByPrimaryKey(EthTransaction record);
}