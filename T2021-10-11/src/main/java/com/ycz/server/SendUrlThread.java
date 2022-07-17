package com.ycz.server;/*
 @author ycz
 @date 2021-10-11-20:27
*/

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SendUrlThread extends Thread{


    private String fileName;

    public SendUrlThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public synchronized void run() {
        try {
            Socket socket=new Socket("192.168.1.72",8003);

            OutputStream out = socket.getOutputStream();
            File file=new File(this.fileName);

            if (file.exists()){
                File[] files = file.listFiles();
                for (File file1 : files) {
                    System.out.println(file1.getName());
                    out.write(file1.getName().getBytes(StandardCharsets.UTF_8));
                }

            }

            socket.shutdownOutput();
          //  socket.close();




        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
