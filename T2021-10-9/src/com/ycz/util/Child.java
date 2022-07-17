package com.ycz.util;/*
 @author ycz
 @date 2021-10-10-21:55
*/

public class Child extends People{
    People father;
    public Child(String name){
        System.out.println(3);
        this.name=name;
        father=new People(name+":F");
    }
    public Child(){
        System.out.println(4);
    }
}
