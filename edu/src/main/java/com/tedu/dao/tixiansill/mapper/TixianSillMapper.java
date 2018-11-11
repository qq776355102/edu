package com.tedu.dao.tixiansill.mapper;

import com.tedu.domain.tixiansill.TixianSill;

public interface TixianSillMapper {
    /**
     *
     * @mbg.generated 2018-09-30
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-30
     */
    int insert(TixianSill record);

    /**
     *
     * @mbg.generated 2018-09-30
     */
    int insertSelective(TixianSill record);

    /**
     *
     * @mbg.generated 2018-09-30
     */
    TixianSill selectByCoinType(String coinType);

    /**
     *
     * @mbg.generated 2018-09-30
     */
    int updateByPrimaryKeySelective(TixianSill record);

    /**
     *
     * @mbg.generated 2018-09-30
     */
    int updateByPrimaryKey(TixianSill record);
}