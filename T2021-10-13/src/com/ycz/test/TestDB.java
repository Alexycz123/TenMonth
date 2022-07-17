package com.ycz.test;/*
 @author ycz
 @date 2021-10-13-16:35
*/

import com.ycz.annotation.ImportDbProperties;
import com.ycz.pojo.Student;
import com.ycz.util.DbUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;


public class TestDB {
    @Test
    public void t1() throws Exception{
        Class<DbUtil> dbUtilClass = DbUtil.class;
        ImportDbProperties annotation = dbUtilClass.getAnnotation(ImportDbProperties.class);
        String value = annotation.value();
        System.out.println(value);
        Properties properties=new Properties();
        properties.load(new FileInputStream(new File(value)));

        DbUtil dbUtil=new DbUtil();
        dbUtil.setProperties(properties);
        dbUtil.show();
    }



    @Test
    public  void t2() throws Exception{
        Class<?> aClass = Class.forName("com.ycz.pojo.Student");
        Object obj = aClass.getConstructor().newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj,"ycz");
        Field age = aClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(obj,18);

        System.out.println(obj.toString());
    }
}
