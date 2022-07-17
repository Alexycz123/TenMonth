package com.ycz.client;/*
 @author ycz
 @date 2021-10-13-11:19
*/

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入服务器的ip");
        String ip=sc.next();
        System.out.println("请输入服务器的端口");
        int port=sc.nextInt();
        try {
            while (true){
                Socket socket=new Socket(InetAddress.getByName(ip), port);
                OutputStream out = socket.getOutputStream();
                out.write("hello".getBytes(StandardCharsets.UTF_8));


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
