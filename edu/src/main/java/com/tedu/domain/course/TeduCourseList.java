package com.tedu.domain.course;


import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 * @实体名称 
 * @数表名称 TEDU_COURSE_LIST
 * @开发日期 2018-08-18
 */
public class TeduCourseList implements Serializable {

    /**
     * 主键(必填项)(主键ID)
     */
    private int id             = -1;
    /**
     * 课程id
     */
    private int courseId       = -1;
    /**
     * 课程下面的每一讲的标题
     */
    private String title       = null;
    /**
     * 每一上传的日期
     */
    private Date date          = null;
    /**
     * 资源地址
     */
    private String resource    = null;
    /**
     * 数据状态
     */
    private int status         = -1;
    /**
     * 排序
     */
    private String orderBy     = null;

    /*
     *--------------------------------------------------
     * Getter方法区
     *--------------------------------------------------
     */

    /**
     * 主键(必填项)(主键ID)
     */
    public int getId() {
        return id;
    }
    /**
     * 课程id
     */
    public int getCourseId() {
        return courseId;
    }
    /**
     * 课程下面的每一讲的标题
     */
    public String getTitle() {
        return trim(title);
    }
    /**
     * 每一上传的日期
     */
    public Date getDate() {
        return date;
    }
    /**
     * 资源地址
     */
    public String getResource() {
        return trim(resource);
    }
    /**
     * 数据状态
     */
    public int getStatus() {
        return status;
    }
    /**
     * 排序
     */
    public String getOrderBy() {
        return trim(orderBy);
    }

    /*
     *--------------------------------------------------
     * Setter方法区
     *--------------------------------------------------
     */

    /**
     * 主键(必填项)(主键ID)
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * 课程id
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    /**
     * 课程下面的每一讲的标题
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * 每一上传的日期
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     * 资源地址
     */
    public void setResource(String resource) {
        this.resource = resource;
    }
    /**
     * 数据状态
     */
    public void setStatus(int status) {
        this.status = status;
    }
    /**
     * 排序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }


    /*
     *--------------------------------------------------
     * 常用自定义字段
     *--------------------------------------------------
     */
    /**
     * 课程下面的每一讲的标题(全模糊)
     */
    private String titleLike          = null;
    /**
     * 课程下面的每一讲的标题(后缀模糊)
     */
    private String titleAfter         = null;
    /**
     * 每一上传的日期(起始日期)
     */
    private String dateBegin          = null;
    /**
     * 每一上传的日期(结束日期)
     */
    private String dateEnd            = null;
    /**
     * 资源地址(全模糊)
     */
    private String resourceLike       = null;
    /**
     * 资源地址(后缀模糊)
     */
    private String resourceAfter      = null;

    /**
     * 课程下面的每一讲的标题(全模糊)
     */
    public String getTitleLike() {
        return trim(titleLike);
    }
    public void setTitleLike(String titleLike) {
        this.titleLike = titleLike;
    }
    /**
     * 课程下面的每一讲的标题(后缀模糊)
     */
    public String getTitleAfter() {
        return trim(titleAfter);
    }
    public void setTitleAfter(String titleAfter) {
        this.titleAfter = titleAfter;
    }
    /**
     * 每一上传的日期(起始日期)
     */
    public String getDateBegin() {
        return trim(dateBegin);
    }
    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }
    /**
     * 每一上传的日期(结束日期)
     */
    public String getDateEnd() {
        return trim(dateEnd);
    }
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
    /**
     * 每一上传的日期(格式化)
     */
    public String getDateChar() {
        return getDate(date);
    }
    public void setDateChar(String dateChar) {
        this.date = getDate(dateChar);
    }
    /**
     * 每一上传的日期(格式化)
     */
    public String getDateCharAll() {
        return getDateTime(date);
    }
    public void setDateCharAll(String dateCharAll) {
        this.date = getDate(dateCharAll);
    }
    /**
     * 资源地址(全模糊)
     */
    public String getResourceLike() {
        return trim(resourceLike);
    }
    public void setResourceLike(String resourceLike) {
        this.resourceLike = resourceLike;
    }
    /**
     * 资源地址(后缀模糊)
     */
    public String getResourceAfter() {
        return trim(resourceAfter);
    }
    public void setResourceAfter(String resourceAfter) {
        this.resourceAfter = resourceAfter;
    }

    /*
     *--------------------------------------------------
     * 应用小方法
     *--------------------------------------------------
     */

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public String trim(String input)
    {
        return input==null?null:input.trim();
    }
    
    public String getDate(Date date)
    {
        if( null == date ) return "";
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    public String getDateTime(Date date)
    {
        if( null == date ) return "";
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
    public Date getDate(String date)
    {
        if( null == date || date.trim().isEmpty() ) return null;
        date = date.trim();
        Date result = null;
        try {
            if( date.length() >= 19 )
            {
                result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
            }
            else if( date.length() == 10 )
            {
                result = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
        }
        catch (ParseException e) 
        {
            
        }
        return result;
    }

}


/** 
------------------------------------------------------
 Copy专用区
------------------------------------------------------

------------------------------------------------------------------------------------------------------------
  Setter方法
------------------------------------------------------------------------------------------------------------

// 
TeduCourseList teduCourseList = new TeduCourseList();

// 主键(必填项)(主键ID)
teduCourseList.setId(  );
// 课程id
teduCourseList.setCourseId(  );
// 课程下面的每一讲的标题
teduCourseList.setTitle(  );
// 每一上传的日期
teduCourseList.setDate(  );
// 资源地址
teduCourseList.setResource(  );
// 数据状态
teduCourseList.setStatus(  );


//------ 自定义部分 ------

// 课程下面的每一讲的标题(全模糊)
teduCourseList.setTitleLike(  );
// 课程下面的每一讲的标题(后缀模糊)
teduCourseList.setTitleAfter(  );
// 每一上传的日期(起始日期)
teduCourseList.setDateBegin(  );
// 每一上传的日期(结束日期)
teduCourseList.setDateEnd(  );
// 每一上传的日期(格式化)
teduCourseList.setDateChar(  );
// 资源地址(全模糊)
teduCourseList.setResourceLike(  );
// 资源地址(后缀模糊)
teduCourseList.setResourceAfter(  );


------------------------------------------------------------------------------------------------------------
  Getter方法
------------------------------------------------------------------------------------------------------------

// 
TeduCourseList teduCourseList = new TeduCourseList();

// 主键(必填项)(主键ID)
teduCourseList.getId();
// 课程id
teduCourseList.getCourseId();
// 课程下面的每一讲的标题
teduCourseList.getTitle();
// 每一上传的日期
teduCourseList.getDate();
// 资源地址
teduCourseList.getResource();
// 数据状态
teduCourseList.getStatus();


//------ 自定义部分 ------

// 课程下面的每一讲的标题(全模糊)
teduCourseList.getTitleLike();
// 课程下面的每一讲的标题(后缀模糊)
teduCourseList.getTitleAfter();
// 每一上传的日期(起始日期)
teduCourseList.getDateBegin();
// 每一上传的日期(结束日期)
teduCourseList.getDateEnd();
// 每一上传的日期(格式化)
teduCourseList.getDateChar();
// 资源地址(全模糊)
teduCourseList.getResourceLike();
// 资源地址(后缀模糊)
teduCourseList.getResourceAfter();


------------------------------------------------------------------------------------------------------------
  Getter Setter方法
------------------------------------------------------------------------------------------------------------

// 
TeduCourseList teduCourseList = new TeduCourseList();

// 主键(必填项)(主键ID)
teduCourseList.setId( teduCourseList2.getId() );
// 课程id
teduCourseList.setCourseId( teduCourseList2.getCourseId() );
// 课程下面的每一讲的标题
teduCourseList.setTitle( teduCourseList2.getTitle() );
// 每一上传的日期
teduCourseList.setDate( teduCourseList2.getDate() );
// 资源地址
teduCourseList.setResource( teduCourseList2.getResource() );
// 数据状态
teduCourseList.setStatus( teduCourseList2.getStatus() );


//------ 自定义部分 ------

// 课程下面的每一讲的标题(全模糊)
teduCourseList.setTitleLike( teduCourseList2.getTitleLike() );
// 课程下面的每一讲的标题(后缀模糊)
teduCourseList.setTitleAfter( teduCourseList2.getTitleAfter() );
// 每一上传的日期(起始日期)
teduCourseList.setDateBegin( teduCourseList2.getDateBegin() );
// 每一上传的日期(结束日期)
teduCourseList.setDateEnd( teduCourseList2.getDateEnd() );
// 每一上传的日期(格式化)
teduCourseList.setDateChar( teduCourseList2.getDateChar() );
// 资源地址(全模糊)
teduCourseList.setResourceLike( teduCourseList2.getResourceLike() );
// 资源地址(后缀模糊)
teduCourseList.setResourceAfter( teduCourseList2.getResourceAfter() );



------------------------------------------------------------------------------------------------------------
 HTML标签区
------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------
  属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键 -->
<input name="id" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input name="courseId" value="" type="text" maxlength="11"/>
<!-- 课程下面的每一讲的标题 -->
<input name="title" value="" type="text" maxlength="20"/>
<!-- 每一上传的日期 -->
<input name="date" value="" type="text"/>
<!-- 资源地址 -->
<input name="resource" value="" type="text" maxlength="20"/>
<!-- 数据状态 -->
<input name="status" value="" type="text" maxlength="4"/>


------------------------------------------------------------------------------------------------------------
  表名 + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键 -->
<input name="teduCourseList.id" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input name="teduCourseList.courseId" value="" type="text" maxlength="11"/>
<!-- 课程下面的每一讲的标题 -->
<input name="teduCourseList.title" value="" type="text" maxlength="20"/>
<!-- 每一上传的日期 -->
<input name="teduCourseList.date" value="" type="text"/>
<!-- 资源地址 -->
<input name="teduCourseList.resource" value="" type="text" maxlength="20"/>
<!-- 数据状态 -->
<input name="teduCourseList.status" value="" type="text" maxlength="4"/>


------------------------------------------------------------------------------------------------------------
  ID + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键 -->
<input id="TCL_ID" name="id" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input id="TCL_COURSE_ID" name="courseId" value="" type="text" maxlength="11"/>
<!-- 课程下面的每一讲的标题 -->
<input id="TCL_TITLE" name="title" value="" type="text" maxlength="20"/>
<!-- 每一上传的日期 -->
<input id="TCL_DATE" name="date" value="" type="text"/>
<!-- 资源地址 -->
<input id="TCL_RESOURCE" name="resource" value="" type="text" maxlength="20"/>
<!-- 数据状态 -->
<input id="TCL_STATUS" name="status" value="" type="text" maxlength="4"/>


------------------------------------------------------------------------------------------------------------
  ID + 表名 + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键 -->
<input id="TCL_ID" name="teduCourseList.id" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input id="TCL_COURSE_ID" name="teduCourseList.courseId" value="" type="text" maxlength="11"/>
<!-- 课程下面的每一讲的标题 -->
<input id="TCL_TITLE" name="teduCourseList.title" value="" type="text" maxlength="20"/>
<!-- 每一上传的日期 -->
<input id="TCL_DATE" name="teduCourseList.date" value="" type="text"/>
<!-- 资源地址 -->
<input id="TCL_RESOURCE" name="teduCourseList.resource" value="" type="text" maxlength="20"/>
<!-- 数据状态 -->
<input id="TCL_STATUS" name="teduCourseList.status" value="" type="text" maxlength="4"/>




--------------------------------------------------------
 */


    