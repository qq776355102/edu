package com.tedu.common.core;

import com.tedu.domain.user.BaseUser;

public class UserCache
{
    public static final ThreadLocal<BaseUser> ThreadLocal_USER = new ThreadLocal<BaseUser>();

    public static BaseUser getUser()
    {
        BaseUser obj = ThreadLocal_USER.get();
        return obj;
    }

    public static void setUser(BaseUser user)
    {
        ThreadLocal_USER.set(user);
    }

    public static BaseUser getDefaultUser()
    {
        BaseUser user = new BaseUser();
        
        return user;
    }
}
