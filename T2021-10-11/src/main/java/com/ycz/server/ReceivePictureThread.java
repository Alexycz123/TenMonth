package com.ycz.server;/*
 @author ycz
 @date 2021-10-12-8:48
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceivePictureThread extends Thread{

    private String fileName;

    public ReceivePictureThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public  synchronized void run() {

        try {
            ServerSocket acceptSocket=new ServerSocket(8004);
            Socket socket= acceptSocket.accept();
            InputStream in = socket.getInputStream();
            byte[] bytes=new byte[1024];
            int len;
            OutputStream out=new FileOutputStream(this.fileName);
            while ((len=in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
