package com.ycz.thread;/*
 @author ycz
 @date 2021-10-08-15:55  
*/

public class TackRunnable implements Runnable{

    private Deck deck;

    public TackRunnable(Deck deck) {
        this.deck = deck;
    }
    @Override
    public  void run() {
        while (true){
            deck.tack();
        }
    }
}
