package InternetTest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 * 并关闭相应的连接。
 */
public class TCPTest3 {
    //客户端
    @Test
    public void client(){
        Socket socket=null;
        OutputStream os=null;
        InputStream is=null;
        FileInputStream fis=null;
        ByteArrayOutputStream bos=null;
        try {
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            socket=new Socket(inet,9988);
            os=socket.getOutputStream();
            fis=new FileInputStream(new File("爱情与友情.jpg"));
            byte[] buffer=new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();
            //5.接收来自于服务器端的数据，并显示到控制台上
            is=socket.getInputStream();
            bos=new ByteArrayOutputStream();
            byte[] buffer1=new byte[5];
            int len1;
            while((len1=is.read(buffer1))!=-1){
                bos.write(buffer1,0,len1);
            }
            System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos!=null)
                    bos.close();
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
        OutputStream os=null;
        FileOutputStream fos=null;
        try {
            ss=new ServerSocket(9988);
            socket=ss.accept();
            is=socket.getInputStream();
            fos=new FileOutputStream(new File("爱情与友情2.jpg"));
            byte[] buffer=new byte[2014];
            int len;
            while((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("图片传输完成");
            //6.服务器端给予客户端反馈
            os=socket.getOutputStream();
            os.write("照片我已收到".getBytes());
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
            try {
                if(os!=null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
