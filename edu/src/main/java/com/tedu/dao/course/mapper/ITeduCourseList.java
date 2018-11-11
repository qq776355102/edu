package com.tedu.dao.course.mapper;

import java.util.List;
import java.util.Map;
import com.tedu.domain.course.TeduCourseList;


/**
 * @实体名称 
 * @数据库表 TEDU_COURSE_LIST
 * @开发日期 2018-08-18
 */
public interface ITeduCourseList {

    /**
     * 1.新增一条数据
     * 注: 根据Bean实体执行新增操作.
     * @param teduCourseList  - 
     * @throws Exception      - 异常捕捉
     */
    public void getInsert(TeduCourseList teduCourseList) throws Exception;


    /**
     * 2.删除一条数据
     * 注: 根据Bean实体的主键ID执行删除操作.
     * @param id          - 主键
     * @return int        - 执行结果
     * @throws Exception  - 异常捕捉
     */
    public int getDelete(int id) throws Exception;


    /**
     * 3.变更一条数据
     * 注: 根据Bean实体的主键ID执行变更操作.
     * @param teduCourseList  - 
     * @return int            - 执行结果
     * @throws Exception      - 异常捕捉
     */
    public int getUpdate(TeduCourseList teduCourseList) throws Exception;


    /**
     * 4.获取一个Bean实体
     * 注: 根据Bean实体的主键ID获取一个Bean实体.
     * @param id               - 主键
     * @return TeduCourseList  - 执行结果
     * @throws Exception       - 异常捕捉
     */
    public TeduCourseList getBean(int id) throws Exception;


    /**
     * 5.条件查询
     * 注: 支持多条件查询、模糊查询、日期比较查询等操作.
     * @param teduCourseList         - 
     * @return List<TeduCourseList>  - 执行结果
     * @throws Exception             - 异常捕捉
     */
    public List<TeduCourseList> getList(TeduCourseList teduCourseList) throws Exception;


    /**
     * 6.分页查询
     * 注: 支持分页查询、多条件查询、模糊查询、日期比较查询等操作.
     * @param map                    - 及分页信息
     * <br>[参数说明] 如下 , map中有3个固定Key , 且区分大小写.
     * <br>[键1] bean -  (实体)
     * <br>[键2] offset - 偏移量 (分页信息)
     * <br>[键3] rows - 数目 (分页信息)
     * @return List<TeduCourseList>  - 执行结果
     * @throws Exception             - 异常捕捉
     */
    public List<TeduCourseList> getPageList(Map<String ,Object> map) throws Exception;


    /**
     * 7.删除数据
     * 注: 根据Bean实体的主键ID执行删除操作.
     * @param teduCourseList  - 
     * @return int            - 执行结果
     * @throws Exception      - 异常捕捉
     */
    public int getDeleteBean(TeduCourseList teduCourseList) throws Exception;


    /**
     * 8.删除多条数据
     * 注: 根据拼接有限个主键ID执行多条数据的删除操作.
     * @param ids         - 主键
     * @return int        - 执行结果
     * @throws Exception  - 异常捕捉
     */
    public int getDeleteIn(int[] ids) throws Exception;


    /**
     * 9.条件删除数据
     * 注: 根据多种条件执行批量删除操作.
     * @param teduCourseList  - 
     * @return int            - 执行结果
     * @throws Exception      - 异常捕捉
     */
    public int getDeleteBy(TeduCourseList teduCourseList) throws Exception;


    /**
     * 10.验证一条数据是否存在
     * 注: 根据主键ID验证该数据是否存在 ,并返回数据量.
     * @param id          - 主键
     * @return int        - 存在数量
     * @throws Exception  - 异常捕捉
     */
    public int getCheck(int id) throws Exception;


    /**
     * 11.验证多条件数据是否存在
     * 注: 根据多条件验证该数据是否存在 ,并返回数据量.
     * @param teduCourseList  - 
     * @return int            - 存在数量
     * @throws Exception      - 异常捕捉
     */
    public int getCheckBy(TeduCourseList teduCourseList) throws Exception;


    /**
     * 12.按条件变更一条数据
     * 注: 根据Bean实体的主键ID,只对部分字段执行变更操作.
     * @param teduCourseList  - 
     * @return int            - 执行结果
     * @throws Exception      - 异常捕捉
     */
    public int getUpdateBy(TeduCourseList teduCourseList) throws Exception;


    /**
     * 13.InsertBatch - 批量新增数据
     * 注: 根据List对象执行批量新增操作.
     * @param list        - List
     * @throws Exception  - 异常捕捉
     */
    public void getInsertBatch(List<TeduCourseList> list) throws Exception;


    /**
     * 14.UpdateBatch - 批量更新数据
     * 注: 根据List对象执行批量更新操作.
     * @param list        - List
     * @throws Exception  - 异常捕捉
     */
    public void getUpdateBatch(List<TeduCourseList> list) throws Exception;



}
