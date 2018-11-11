package com.tedu.dao.fankui.mapper;

import com.tedu.domain.fankui.Fankui;

public interface FankuiMapper {
    /**
     *
     * @mbg.generated 2018-09-23
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-23
     */
    int insert(Fankui record);

    /**
     *
     * @mbg.generated 2018-09-23
     */
    int insertSelective(Fankui record);

    /**
     *
     * @mbg.generated 2018-09-23
     */
    Fankui selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-23
     */
    int updateByPrimaryKeySelective(Fankui record);

    /**
     *
     * @mbg.generated 2018-09-23
     */
    int updateByPrimaryKey(Fankui record);
}