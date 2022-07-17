package com.ycz.client;/*
 @author ycz
 @date 2021-10-11-16:07
*/

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class PirClient {
    public static void main(String[] args) {
        Socket socket=null;
        try{
            //客户端发送
            socket=new Socket(InetAddress.getLocalHost(),8001);
            OutputStream out= socket.getOutputStream();
            System.out.println("发送中");
            //客户端发送数据
            out.write("服务端，我是客户端，你收到吗？".getBytes(StandardCharsets.UTF_8));
            //客户端结束发送
            socket.shutdownOutput();
            System.out.println("发送结束");

            /**
             * 从服务端接收的选择条件
             */
            InputStream in= socket.getInputStream();
            byte[] bytes=new byte[1024];
            int len;
            while ((len=in.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }

            /**
             * 要Scanner 之后发送回去
             */

            Scanner scanner=new Scanner(System.in);
            int choose=scanner.nextInt();
            SendThread sendThread=new SendThread();
            sendThread.setChoose(choose);
            sendThread.start();

            if (choose==2){
                //下面是接受图片的线程
                FileClientOperation.downPicture("T2021-10-11\\aa\\ycz"+new Date().getTime()+".jpg",socket.getInputStream());
                System.out.println("接收图片完成");
            }else if (choose==1){
                System.out.println("选择了查看图片");
                ReceiveUrlThread receiveUrlThread=new ReceiveUrlThread();
                receiveUrlThread.start();
            }else if (choose==3){
                System.out.println("选择了上传图片");
                SendPictureThread sendPictureThread=new SendPictureThread("T2021-10-11\\bb\\ycz123.jpg");
                sendPictureThread.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
