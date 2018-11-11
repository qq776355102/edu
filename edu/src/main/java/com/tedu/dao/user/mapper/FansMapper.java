package com.tedu.dao.user.mapper;

import java.util.List;
import java.util.Map;

import com.tedu.domain.user.Fans;

public interface FansMapper {
    /**
     *
     * @mbg.generated 2018-10-14
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-14
     */
    int insert(Fans record);

    /**
     *
     * @mbg.generated 2018-10-14
     */
    int insertSelective(Fans record);

    /**
     *
     * @mbg.generated 2018-10-14
     */
    Fans selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-10-14
     */
    int updateByPrimaryKeySelective(Fans record);

    /**
     *
     * @mbg.generated 2018-10-14
     */
    int updateByPrimaryKey(Fans record);
    

	public int getCountByUserIdOrFanId(Map<String, String> param);

	/**
	 * 5.条件查询 注: 支持多条件查询、模糊查询、日期比较查询等操作.
	 * 
	 * @param fans -
	 * @return List<Fans> - 执行结果
	 * @throws Exception - 异常捕捉
	 */
	public List<Fans> getList(Fans fans) throws Exception;
	
  /**
  * 11.验证多条件数据是否存在
  * 注: 根据多条件验证该数据是否存在 ,并返回数据量.
  * @param fans        - 
  * @return int        - 存在数量
  * @throws Exception  - 异常捕捉
  */
 public int getCheckBy(Fans fans) throws Exception;
}