package com.ycz.thread;/*
 @author ycz
 @date 2021-10-08-15:54  
*/

public class PutRunnable implements Runnable{

    private Deck deck;

    public PutRunnable(Deck deck) {
        this.deck = deck;
    }

    @Override
    public  void run() {
        while (true){
            deck.put();
        }




    }
}
