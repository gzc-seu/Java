package InternetTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 */
public class TCPTest2 {
    //客户端
    @Test
    public void client(){
        Socket socket=null;
        OutputStream os=null;
        FileInputStream fis=null;
        try {
            InetAddress inet=InetAddress.getByName("127.7.7.1");
            socket=new Socket(inet,8899);
            os=socket.getOutputStream();
            fis=new FileInputStream(new File("爱情与友情.jpg"));
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(os!=null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //服务端
    @Test
    public void server(){
        ServerSocket ss=null;
        Socket socket=null;
        InputStream is=null;
        FileOutputStream fos=null;
        try {
            ss=new ServerSocket(8899);
            socket=ss.accept();
            is=socket.getInputStream();
            fos=new FileOutputStream(new File("爱情与友情1.jpg"));
            byte[] buffer=new byte[2014];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ss!=null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
