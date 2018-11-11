package com.tedu.dao.qianbao.mapper;

import java.util.List;
import java.util.Map;

import com.tedu.domain.qianbao.Qianbao;
import com.tedu.domain.user.Fans;

public interface QianbaoMapper {
    /**
     *
     * @mbg.generated 2018-09-24
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2018-09-24
     */
    int insert(Qianbao record);

    /**
     *
     * @mbg.generated 2018-09-24
     */
    int insertSelective(Qianbao record);

    /**
     *
     * @mbg.generated 2018-09-24
     */
    Qianbao selectByPrimaryKey(Integer id);
    
    /**
     * 6.分页查询
     * 注: 支持分页查询、多条件查询、模糊查询、日期比较查询等操作.
     * @param map          - 及分页信息
     * <br>[参数说明] 如下 , map中有3个固定Key , 且区分大小写.
     * <br>[键1] bean -  (实体)
     * <br>[键2] offset - 偏移量 (分页信息)
     * <br>[键3] rows - 数目 (分页信息)
     * @return List<Fans>  - 执行结果
     * @throws Exception   - 异常捕捉
     */
    public List<Qianbao> getPageList(Map<String ,Object> map) throws Exception;
    
    /**
     *
     * @mbg.generated 2018-09-24
     */
    int updateByPrimaryKeySelective(Qianbao record);

    /**
     *
     * @mbg.generated 2018-09-24
     */
    int updateByPrimaryKeyWithBLOBs(Qianbao record);

    /**
     *
     * @mbg.generated 2018-09-24
     */
    int updateByPrimaryKey(Qianbao record);
}