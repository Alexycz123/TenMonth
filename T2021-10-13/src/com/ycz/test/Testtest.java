package com.ycz.test;/*
 @author ycz
 @date 2021-10-13-17:14
*/


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Testtest {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.ycz.test.Test");

            Object obj = aClass.getDeclaredConstructor().newInstance();//先构造

            Method method = aClass.getMethod("method2", int.class);

            Object invoke = method.invoke(obj,2);

            Method method1 = aClass.getDeclaredMethod("method");

            Object invoke1=method1.invoke(obj);

            Method method3 = aClass.getDeclaredMethod("method3");
            method3.setAccessible(true);
            Object invoke2 = method3.invoke(obj);

            Field s = aClass.getDeclaredField("s");
            s.setAccessible(true);
            s.set(obj,"哈哈");
            Object o = s.get(obj);
            System.out.println(o);


            System.out.println(invoke);
            System.out.println(invoke1);
            System.out.println(invoke2);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
