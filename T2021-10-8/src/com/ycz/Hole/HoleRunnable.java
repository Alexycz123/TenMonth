package com.ycz.Hole;/*
 @author ycz
 @date 2021-10-08-16:47  
*/

import java.util.ArrayList;
import java.util.List;

public class HoleRunnable implements Runnable{
    private int count=10;

    @Override
    public synchronized void run() {
        List<Character> characters=new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
            characters.add((char) ('a'+i));
        }
       // System.out.println(characters);
        while (true){
            if (count>0){
                StringBuilder builder=new StringBuilder();

                for (int i = 0; i <4 ; i++) {
                    builder.append(characters.get((int) (Math.random()*26)));
                }
              //  System.out.println(builder);

                System.out.println("过去了"+builder+"，还剩下"+count--);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("全部过去了");
                break;
            }
        }



    }
}
