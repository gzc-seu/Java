package IOTest;

import java.io.*;
/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流的基础上。
 */
public class BufferTest {

    public static void main(String[] args) {
        BufferTest test=new BufferTest();
       // test.BufferedStreamTest();
        //test.testCopyFileWithBuffered();
        test.testBufferedReaderBufferedWriter();
    }
    //实现非文本文件的复制
    public void BufferedStreamTest(){
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            File file1=new File("爱情与友情.jpg");
            File file2=new File("爱情与友情2.jpg");
            FileInputStream fis=new FileInputStream(file1);
            FileOutputStream fos=new FileOutputStream(file2);
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);

            byte[] buffer=new byte[5];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {   //要求：先关闭外层的流，再关闭内层的流
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
        }
    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try {
            File file1=new File(srcPath);
            File file2=new File(destPath);
            FileInputStream fis=new FileInputStream(file1);
            FileOutputStream fos=new FileOutputStream(file2);
            bis=new BufferedInputStream(fis);
            bos=new BufferedOutputStream(fos);

            byte[] buffer=new byte[5];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {   //要求：先关闭外层的流，再关闭内层的流
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
        }
    }

    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Administrator\\Desktop\\1.jpg";
        String destPath = "C:\\Users\\Administrator\\Desktop\\2.jpg";
        copyFileWithBuffered(srcPath,destPath);
        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//3591-106
    }

    //使用BufferedReader和BufferedWriter实现文本文件的复制
    public void testBufferedReaderBufferedWriter(){
        BufferedReader bis=null;
        BufferedWriter bos=null;
        try {
            File file1=new File("F:\\Java\\java基础视频\\Java 基础到高级-宋红康-零基础自学Java-尚硅谷\\5_代码\\第2部分：Java高级编程\\JavaSenior\\day09\\dbcp.txt");
            File file2=new File("F:\\Java\\java基础视频\\Java 基础到高级-宋红康-零基础自学Java-尚硅谷\\5_代码\\第2部分：Java高级编程\\JavaSenior\\day09\\dbcp1.txt");
            FileReader fr=new FileReader(file1);
            FileWriter fw=new FileWriter(file2);
            bis=new BufferedReader(fr);
            bos=new BufferedWriter(fw);
            char[] buff=new char[1024];
            int len;
            while((len=bis.read(buff))!=-1){
                bos.write(buff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bis!=null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos!=null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
