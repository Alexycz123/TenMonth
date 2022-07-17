package com.ycz.annotation;/*
 @author ycz
 @date 2021-10-13-16:33
*/


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.RUNTIME)
public @interface ImportDbProperties {
    String value();

}
