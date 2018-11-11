package com.tedu.common.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) 
public @interface TeduMethodAnnotation {
    public String getMethodSimpCode();
    public String getMethodSimpDesc();
    public int getAppPerm(); 
}
