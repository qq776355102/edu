package com.tedu.domain.user;


import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 * @实体名称 
 * @数表名称 USER_COURSE
 * @开发日期 2018-08-15
 */
public class UserCourse implements Serializable {

    /**
     * 主键id(必填项)(主键ID)
     */
    private int id                = -1;
    /**
     * 用户id
     */
    private int userId            = -1;
    /**
     * 课程id
     */
    private int courseId          = -1;
    /**
     * 是否已关注课程
     */
    private int guanzhu           = -1;
    /**
     * 是否已购买课程
     */
    private int isPurchased       = -1;
    /**
     * 购买课程的日期
     */
    private Date purchasedDate    = null;
    /**
     * 排序
     */
    private String orderBy        = null;

    /*
     *--------------------------------------------------
     * Getter方法区
     *--------------------------------------------------
     */

    /**
     * 主键id(必填项)(主键ID)
     */
    public int getId() {
        return id;
    }
    /**
     * 用户id
     */
    public int getUserId() {
        return userId;
    }
    /**
     * 课程id
     */
    public int getCourseId() {
        return courseId;
    }
    /**
     * 是否已关注课程
     */
    public int getGuanzhu() {
        return guanzhu;
    }
    /**
     * 是否已购买课程
     */
    public int getIsPurchased() {
        return isPurchased;
    }
    /**
     * 购买课程的日期
     */
    public Date getPurchasedDate() {
        return purchasedDate;
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
     * 主键id(必填项)(主键ID)
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * 用户id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * 课程id
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    /**
     * 是否已关注课程
     */
    public void setGuanzhu(int guanzhu) {
        this.guanzhu = guanzhu;
    }
    /**
     * 是否已购买课程
     */
    public void setIsPurchased(int isPurchased) {
        this.isPurchased = isPurchased;
    }
    /**
     * 购买课程的日期
     */
    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
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
     * 购买课程的日期(起始日期)
     */
    private String purchasedDateBegin    = null;
    /**
     * 购买课程的日期(结束日期)
     */
    private String purchasedDateEnd      = null;

    /**
     * 购买课程的日期(起始日期)
     */
    public String getPurchasedDateBegin() {
        return trim(purchasedDateBegin);
    }
    public void setPurchasedDateBegin(String purchasedDateBegin) {
        this.purchasedDateBegin = purchasedDateBegin;
    }
    /**
     * 购买课程的日期(结束日期)
     */
    public String getPurchasedDateEnd() {
        return trim(purchasedDateEnd);
    }
    public void setPurchasedDateEnd(String purchasedDateEnd) {
        this.purchasedDateEnd = purchasedDateEnd;
    }
    /**
     * 购买课程的日期(格式化)
     */
    public String getPurchasedDateChar() {
        return getDate(purchasedDate);
    }
    public void setPurchasedDateChar(String purchasedDateChar) {
        this.purchasedDate = getDate(purchasedDateChar);
    }
    /**
     * 购买课程的日期(格式化)
     */
    public String getPurchasedDateCharAll() {
        return getDateTime(purchasedDate);
    }
    public void setPurchasedDateCharAll(String purchasedDateCharAll) {
        this.purchasedDate = getDate(purchasedDateCharAll);
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
UserCourse userCourse = new UserCourse();

// 主键id(必填项)(主键ID)
userCourse.setId(  );
// 用户id
userCourse.setUserId(  );
// 课程id
userCourse.setCourseId(  );
// 是否已关注课程
userCourse.setGuanzhu(  );
// 是否已购买课程
userCourse.setIsPurchased(  );
// 购买课程的日期
userCourse.setPurchasedDate(  );


//------ 自定义部分 ------

// 购买课程的日期(起始日期)
userCourse.setPurchasedDateBegin(  );
// 购买课程的日期(结束日期)
userCourse.setPurchasedDateEnd(  );
// 购买课程的日期(格式化)
userCourse.setPurchasedDateChar(  );


------------------------------------------------------------------------------------------------------------
  Getter方法
------------------------------------------------------------------------------------------------------------

// 
UserCourse userCourse = new UserCourse();

// 主键id(必填项)(主键ID)
userCourse.getId();
// 用户id
userCourse.getUserId();
// 课程id
userCourse.getCourseId();
// 是否已关注课程
userCourse.getGuanzhu();
// 是否已购买课程
userCourse.getIsPurchased();
// 购买课程的日期
userCourse.getPurchasedDate();


//------ 自定义部分 ------

// 购买课程的日期(起始日期)
userCourse.getPurchasedDateBegin();
// 购买课程的日期(结束日期)
userCourse.getPurchasedDateEnd();
// 购买课程的日期(格式化)
userCourse.getPurchasedDateChar();


------------------------------------------------------------------------------------------------------------
  Getter Setter方法
------------------------------------------------------------------------------------------------------------

// 
UserCourse userCourse = new UserCourse();

// 主键id(必填项)(主键ID)
userCourse.setId( userCourse2.getId() );
// 用户id
userCourse.setUserId( userCourse2.getUserId() );
// 课程id
userCourse.setCourseId( userCourse2.getCourseId() );
// 是否已关注课程
userCourse.setGuanzhu( userCourse2.getGuanzhu() );
// 是否已购买课程
userCourse.setIsPurchased( userCourse2.getIsPurchased() );
// 购买课程的日期
userCourse.setPurchasedDate( userCourse2.getPurchasedDate() );


//------ 自定义部分 ------

// 购买课程的日期(起始日期)
userCourse.setPurchasedDateBegin( userCourse2.getPurchasedDateBegin() );
// 购买课程的日期(结束日期)
userCourse.setPurchasedDateEnd( userCourse2.getPurchasedDateEnd() );
// 购买课程的日期(格式化)
userCourse.setPurchasedDateChar( userCourse2.getPurchasedDateChar() );



------------------------------------------------------------------------------------------------------------
 HTML标签区
------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------
  属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键id -->
<input name="id" value="" type="text" maxlength="11"/>
<!-- 用户id -->
<input name="userId" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input name="courseId" value="" type="text" maxlength="11"/>
<!-- 是否已关注课程 -->
<input name="guanzhu" value="" type="text" maxlength="1"/>
<!-- 是否已购买课程 -->
<input name="isPurchased" value="" type="text" maxlength="1"/>
<!-- 购买课程的日期 -->
<input name="purchasedDate" value="" type="text"/>


------------------------------------------------------------------------------------------------------------
  表名 + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键id -->
<input name="userCourse.id" value="" type="text" maxlength="11"/>
<!-- 用户id -->
<input name="userCourse.userId" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input name="userCourse.courseId" value="" type="text" maxlength="11"/>
<!-- 是否已关注课程 -->
<input name="userCourse.guanzhu" value="" type="text" maxlength="1"/>
<!-- 是否已购买课程 -->
<input name="userCourse.isPurchased" value="" type="text" maxlength="1"/>
<!-- 购买课程的日期 -->
<input name="userCourse.purchasedDate" value="" type="text"/>


------------------------------------------------------------------------------------------------------------
  ID + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键id -->
<input id="UC_ID" name="id" value="" type="text" maxlength="11"/>
<!-- 用户id -->
<input id="UC_USER_ID" name="userId" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input id="UC_COURSE_ID" name="courseId" value="" type="text" maxlength="11"/>
<!-- 是否已关注课程 -->
<input id="UC_GUANZHU" name="guanzhu" value="" type="text" maxlength="1"/>
<!-- 是否已购买课程 -->
<input id="UC_IS_PURCHASED" name="isPurchased" value="" type="text" maxlength="1"/>
<!-- 购买课程的日期 -->
<input id="UC_PURCHASED_DATE" name="purchasedDate" value="" type="text"/>


------------------------------------------------------------------------------------------------------------
  ID + 表名 + 属性区
------------------------------------------------------------------------------------------------------------

<!-- 主键id -->
<input id="UC_ID" name="userCourse.id" value="" type="text" maxlength="11"/>
<!-- 用户id -->
<input id="UC_USER_ID" name="userCourse.userId" value="" type="text" maxlength="11"/>
<!-- 课程id -->
<input id="UC_COURSE_ID" name="userCourse.courseId" value="" type="text" maxlength="11"/>
<!-- 是否已关注课程 -->
<input id="UC_GUANZHU" name="userCourse.guanzhu" value="" type="text" maxlength="1"/>
<!-- 是否已购买课程 -->
<input id="UC_IS_PURCHASED" name="userCourse.isPurchased" value="" type="text" maxlength="1"/>
<!-- 购买课程的日期 -->
<input id="UC_PURCHASED_DATE" name="userCourse.purchasedDate" value="" type="text"/>




--------------------------------------------------------
 */


    