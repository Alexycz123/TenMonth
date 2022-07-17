package com.ycz.util;/*
 @author ycz
 @date 2021-10-08-11:07
*/

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
//        Runnable runnable=new SellTicket();
//        Thread thread1=new Thread(runnable);
//        Thread thread2=new Thread(runnable);
//        Thread thread3=new Thread(runnable);
//
//        thread1.setName("窗口A");
//        thread2.setName("窗口B");
//        thread3.setName("窗口C");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();


        List<Integer> ints=new ArrayList<>();
        ints.add(10);
        ints.add(14124);
        ints.add(100);
        ints.add(01);
        ints.add(12);
        ints.add(1123);
        ints.add(131231);
        ints.add(143423);
        ints.add(113);
        ints.add(143);
        ints.add(1131);

        for(int i=0;i<ints.size();i++){
            for (int j=0;j<ints.size();j++){
                if (ints.get(i)>ints.get(j)){
                    int temp=ints.get(i);
                    ints.set(i,ints.get(j));
                    ints.set(j,temp);

                }
            }
        }

        System.out.println(ints);

    }


}
