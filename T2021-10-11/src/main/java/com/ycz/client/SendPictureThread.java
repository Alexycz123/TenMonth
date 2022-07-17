package com.ycz.client;/*
 @author ycz
 @date 2021-10-12-8:44
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SendPictureThread extends Thread{

    private String fileName;

    public SendPictureThread(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public void run() {
        try {
            Socket socket=new Socket(InetAddress.getLocalHost(),8004);
            InputStream in=new FileInputStream(fileName);
            OutputStream out = socket.getOutputStream();
            byte[] bytes=new byte[1024];
            int len;
            while ((len=in.read(bytes))!=-1){
                out.write(bytes,0,len);
            }

            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
