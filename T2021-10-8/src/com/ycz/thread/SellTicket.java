package com.ycz.thread;/*
 @author ycz
 @date 2021-10-08-11:13  
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable {


    private static int ticketNum=1000;

    public static Object obj=new Object();
    @Override
    public void run() {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countE = 0;
        try {
            while (true){
               // lock.lock();
                synchronized (obj){
                    if (ticketNum>0){
                        System.out.println(Thread.currentThread().getName()+"卖了一张票，还剩下"+ticketNum--);
                        String ticketName = Thread.currentThread().getName();
                        if (ticketName.equals("窗口A")) {
                            countA++;
                        } else if (ticketName.equals("窗口B")) {
                            countB++;
                        } else if (ticketName.equals("窗口C")) {
                            countC++;
                        }else if (ticketName.equals("窗口D")) {
                            countC++;
                        }else if (ticketName.equals("窗口E")) {
                            countC++;
                        }
                    }
                    //Thread.sleep(100);
                    if (ticketNum<=0){
                        System.out.println("票卖完了");
                        System.out.println("窗口A卖了" + countA);
                        System.out.println("窗口B卖了" + countB);
                        System.out.println("窗口C卖了" + countC);
                        System.out.println("窗口D卖了" + countD);
                        System.out.println("窗口E卖了" + countE);
                        break;
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误");
        }finally {
           // lock.unlock();
        }



    }
}
