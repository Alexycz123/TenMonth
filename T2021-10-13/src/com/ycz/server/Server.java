package com.ycz.server;/*
 @author ycz
 @date 2021-10-13-11:18
*/

import javax.xml.bind.annotation.XmlAccessOrder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket=new ServerSocket(6666);
            while (true){
                Socket socket= serverSocket.accept();
                OutputStream out = socket.getOutputStream();
                out.write(("欢迎访问图片服务器\r\n1. 查看图片\r\n2." +
                        " 下载图片\r\n3. 上传图片\r\n请输入你的选择：").getBytes(StandardCharsets.UTF_8));

                InputStream inputStream = socket.getInputStream();
                byte[] bytes=new byte[1024];
                int len;
                while ((len=inputStream.read(bytes))!=-1){
                    System.out.println(new String(bytes,0,len));
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
