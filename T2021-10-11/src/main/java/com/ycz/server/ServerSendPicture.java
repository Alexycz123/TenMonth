package com.ycz.server;/*
 @author ycz
 @date 2021-10-11-20:18
*/

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ServerSendPicture extends Thread{

    private String fileName;

    public ServerSendPicture(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public synchronized void run() {
        Socket socket = null;
        try {
           socket= new Socket("192.168.1.72",8002);
            File file=new File(fileName);
            //读取文件
            InputStream inPicture = null;
            //获取文件名
            //设置接受的字节数组
            byte[] bytes=new byte[1024];
            int len;
            if (file.exists()){
                inPicture  =new FileInputStream(file);
            }else {
                System.out.println("图片不存在");
            }

            OutputStream out = socket.getOutputStream();

            //发送读取图片的字节
            while (true){
                assert inPicture != null;
                if ((len = inPicture.read(bytes)) == -1) break;
                // System.out.println(new String(bytes,0,len)); 有数据
                out.write(bytes,0,len);
            }
            socket.shutdownOutput();
    }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}}
