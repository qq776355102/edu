package com.tedu.dao.duihuanjifen.mapper;

import com.tedu.domain.duihuanjifen.DuihuanJifen;

public interface DuihuanJifenMapper {
    /**
     *
     * @mbg.generated 2018-10-23
     */
    int deleteByPrimaryKey(Integer id);
    


    /**
     *
     * @mbg.generated 2018-10-23
     */
    int insert(DuihuanJifen record);

    /**
     *
     * @mbg.generated 2018-10-23
     */
    int insertSelective(DuihuanJifen record);

    /**
     *
     * @mbg.generated 2018-10-23
     */
    DuihuanJifen selectByPrimaryKey(Integer id);
   

    /**
     *
     * @mbg.generated 2018-10-23
     */
    int updateByPrimaryKeySelective(DuihuanJifen record);

    /**
     *
     * @mbg.generated 2018-10-23
     */
    int updateByPrimaryKey(DuihuanJifen record);



	DuihuanJifen getLast();
}