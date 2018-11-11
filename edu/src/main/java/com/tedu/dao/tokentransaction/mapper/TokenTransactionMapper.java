package com.tedu.dao.tokentransaction.mapper;

import com.tedu.domain.tokentransaction.TokenTransaction;

public interface TokenTransactionMapper {
    /**
     *
     * @mbg.generated 2018-10-21
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    int insert(TokenTransaction record);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    int insertSelective(TokenTransaction record);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    TokenTransaction selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    int updateByPrimaryKeySelective(TokenTransaction record);

    /**
     *
     * @mbg.generated 2018-10-21
     */
    int updateByPrimaryKey(TokenTransaction record);
}