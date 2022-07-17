import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Test2 {
    @Test
    public void t2() throws IOException {

        DatagramSocket socket=new DatagramSocket(8001);

        byte[] bytes=new byte[1024];



        DatagramPacket packet=new DatagramPacket(bytes,bytes.length);

        socket.receive(packet);

        String str=new String(bytes,0,packet.getLength());

        System.out.println(str);
    }
}
