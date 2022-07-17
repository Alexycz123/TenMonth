package com.ycz.client;/*
 @author ycz
 @date 2021-10-11-17:11
*/

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileClientOperation {

    public static void downPicture(String fileName, InputStream in) throws IOException {

        ServerSocket accept=new ServerSocket(8002);
        Socket socket=accept.accept();
        InputStream in2 = socket.getInputStream();

        File file=new File(fileName);


        byte[] bytes=new byte[1024];
        int len;
        OutputStream picOut=new FileOutputStream(file);
        System.out.println("正在接受");
        while ((len=in2.read(bytes))!=-1){
            //System.out.println("接收到的:..."+new String(bytes,0,len));
            picOut.write(bytes,0,len);
        }
       // in.close();
        picOut.close();

    }

}
