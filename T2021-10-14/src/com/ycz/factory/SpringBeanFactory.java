package com.ycz.factory;/*
 @author ycz
 @date 2021-10-14-15:19
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SpringBeanFactory {

    private static Properties pp;
    static {
        try {
            pp=new Properties();
            pp.load(ClassLoader.getSystemResourceAsStream("db.properties"));
         //   String studentServiceImpl = pp.getProperty("StudentServiceImpl");
           // System.out.println(studentServiceImpl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String BeanName) throws Exception {
        String bean = pp.getProperty(BeanName);
        Class<?> aClass = Class.forName(bean);
        Object obj = aClass.getDeclaredConstructor().newInstance();
        return obj;


    }

}
