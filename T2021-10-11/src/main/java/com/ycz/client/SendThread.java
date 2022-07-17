package com.ycz.client;/*
 @author ycz
 @date 2021-10-11-19:21
*/

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    private int choose;
    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    @Override
    public void run() {
        try(Socket socket=new Socket(InetAddress.getLocalHost(),8001)) {
           OutputStream out= socket.getOutputStream();
            out.write(this.choose);
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
