package com.ycz.thread;/*
 @author ycz
 @date 2021-10-08-15:52  
*/

public class Deck {
    private int count=0;

    public synchronized void put(){

        while (count>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // if (count<=0){
            count++;
            System.out.println(Thread.currentThread().getName()+"厨师放了一盘菜");
           // notify();
            //
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
      //  }
        notifyAll();

    }

    public synchronized void tack(){

        while (count<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       // if (count>=1){
            count--;
            System.out.println(Thread.currentThread().getName()+"服务员拿了一盘菜");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       // }
        notify();
    }


}
