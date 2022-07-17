package com.ycz.server;/*
 @author ycz
 @date 2021-10-11-16:07
*/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class PirServer {
    public static void main(String[] args) throws IOException {
        ServerSocket acceptSocket=null;
        Socket socket=null;
        try {
            while (true){
                //我是服务端，端口号是8001
                acceptSocket = new ServerSocket(8001);
                //设置接受的字节数组
                byte[] bytes = new byte[1024];
                int len;
                //开始接受
                // OutputStream out=new FileOutputStream(file);
                socket = acceptSocket.accept();
                // 接受要读取的
                InputStream in = socket.getInputStream();
                while ((len = in.read(bytes)) != -1) {
                    System.out.println("接收到的:..." + new String(bytes, 0, len));
                    // out.write(bytes,0,len);
                }
                OutputStream out = socket.getOutputStream();

                out.write("请选择你的操作".getBytes(StandardCharsets.UTF_8));
                out.write("1、查看图片".getBytes(StandardCharsets.UTF_8));
                out.write("2、选择要下载的图片".getBytes(StandardCharsets.UTF_8));
                out.write("3、选择要上传的图片".getBytes(StandardCharsets.UTF_8));
                socket.shutdownOutput();

                socket = acceptSocket.accept();
                in = socket.getInputStream();
                int i = in.read();
                switch (i) {
                    case 1:
                        System.out.println("客户端选择了查看图片");
                        SendUrlThread sendUrlThread = new SendUrlThread("T2021-10-11\\aa");
                        sendUrlThread.start();
                        break;
                    case 2:
                        System.out.println("客户端选择了下载图片");
                        ServerSendPicture serverSendPicture =
                                new ServerSendPicture("T2021-10-11\\aa\\ycz.jpg");
                        serverSendPicture.start();
                        //FileServerOperation.SendPicture("T2021-10-11\\aa\\ycz.jpg");
                        break;
                    case 3:
                        System.out.println("客户端选择了上传图片");
                        ReceivePictureThread receivePictureThread =
                                new ReceivePictureThread("T2021-10-11\\bb\\ycz-copy"
                                        +new Date().getTime() +".jpg");
                        receivePictureThread.start();
                        break;
                    default:
                        System.out.println("error");
                }
            }


           // socket.shutdownOutput();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            acceptSocket.close();socket.close();
        }

    }
}
