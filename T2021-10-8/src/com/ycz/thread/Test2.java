package com.ycz.thread;/*
 @author ycz
 @date 2021-10-08-15:55  
*/

import java.lang.annotation.Target;

public class Test2 {
    public static void main(String[] args) {
        Deck deck=new Deck();
        PutRunnable putRunnable=new PutRunnable(deck);
        TackRunnable tackRunnable=new TackRunnable(deck);
        //TackRunnable tackRunnable=new TackRunnable(deck);

        Thread thread1=new Thread(putRunnable);
        Thread thread2=new Thread(tackRunnable);
        Thread thread3=new Thread(tackRunnable);
        Thread thread4=new Thread(putRunnable);

        thread1.setName("张大厨");
        thread4.setName("陈大厨");
        thread2.setName("小赵");
        thread3.setName("小王");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
