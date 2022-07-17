package com.ycz.util;/*
 @author ycz
 @date 2021-10-10-21:54
*/

public class People {
    String name;
    public People(){
        System.out.println(1);
    }
    public People(String name){
        System.out.println(2);
        this.name=name;
    }
}
