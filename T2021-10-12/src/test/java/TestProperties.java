
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TestProperties {

    @Test
    public void t1() throws Exception{
        File file=new File("db.properties") ;
        Properties properties=new Properties();
        properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("servername"));
    }


    /**\
     * 无参构造与有参构造
     * @throws Exception
     */
    @Test
    public void t2() throws Exception{
        File file=new File("db.properties") ;
        Properties properties=new Properties();
        properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("servername"));

        Class<?> aClass = Class.forName(properties.getProperty("servername"));

        System.out.println(aClass.getConstructor());
        Object obj =
                aClass.getConstructor(String.class, String.class).newInstance
                        (properties.getProperty("name"), properties.getProperty("pwd")).toString();
        System.out.println(obj);

        try(Socket socket=new Socket(InetAddress.getLocalHost(),8001)){
            OutputStream outputStream = socket.getOutputStream();
            String str= (String) obj;
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){

        }
    }
    @Test
    public void t3(){
        try {
            ServerSocket serverSocket=new ServerSocket(8001);
            Socket socket= serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes=new byte[1024];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
