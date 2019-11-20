package InternetTest;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class DCPTest {
    //发送端
    @Test
    public void sender(){
        DatagramSocket socket=null;
        try {
            socket=new DatagramSocket();
            String str = "我是UDP方式发送的导弹";
            byte[] bytes = str.getBytes();
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            DatagramPacket packet=new DatagramPacket(bytes,0,bytes.length,inet,8899);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
    //接收端
    @Test
    public void receiver(){
        DatagramSocket socket=null;
        try {
            socket=new DatagramSocket(8899);
            byte[] buffer=new byte[1024];
            DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}
