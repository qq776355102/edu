package com.tedu.dao.qbalance.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tedu.domain.qbalance.QBalance;

public interface QBalanceMapper {
    /**
     *
     * @mbg.generated 2018-09-29
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-29
     */
    int insert(QBalance record);

    /**
     *
     * @mbg.generated 2018-09-29
     */
    int insertSelective(QBalance record);

    /**
     * userId   address   coinType
     * @mbg.generated 2018-09-29
     */
   /* QBalance selectByUserIdAndAddress(Map<String, Object>param);*/

    /**
     *
     * @mbg.generated 2018-09-29
     */
    int updateByAddressAndCoinTypeSelective(QBalance record);

    /**
     *
     * @mbg.generated 2018-09-29
     */
    int updateByPrimaryKey(QBalance record);
}