package com.ycz.client;/*
 @author ycz
 @date 2021-10-11-17:00
*/


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveUrlThread extends Thread{



    @Override
    public void run() {

        try {
            ServerSocket accept=new ServerSocket(8003);
            Socket socket=accept.accept();
            InputStream in = socket.getInputStream();
            byte[] bytes=new byte[1024];
            int len;
            while ((len=in.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
            accept.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
