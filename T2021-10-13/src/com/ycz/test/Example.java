package com.ycz.test;/*
 @author ycz
 @date 2021-10-13-17:01
*/

import java.util.Date;

public class Example extends Date {
    public static void main(String[] args) {
        new Example().test();
    }
    public void test(){
        System.out.println(super.getClass().getName());
    }
}
