import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class Test333 {
    @Test
    public void t1() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url="jdbc:mysql://119.23.241.183:22/car";

        String username="root";
        String password="123456";
        Connection connection= DriverManager.getConnection(url,username,password);
        PreparedStatement preparedStatement =
                connection.prepareStatement("select * from sys_user");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void t3() throws  Exception{


        DatagramSocket socket=new DatagramSocket(8888);
        //(@NotNull byte[] buf,
        //                      int offset,
        //                      int length,
        //                      InetAddress address,
        //                      int port

        byte[] bytes="你好呀，ycz".getBytes(StandardCharsets.UTF_8);

        DatagramPacket packet=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),8001);

        socket.send(packet);

        socket.close();

    }




}
