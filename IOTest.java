package IOTest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args){
        IOTest test=new IOTest();
        test.testFileReader1();
        test.testFileWriter();
        test.testFileReaderFileWriter();
    }
    /**
   说明点：
   1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
   2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
   3. 读入的文件一定要存在，否则就会报FileNotFoundException。
    */
    public void testFileReader(){
        FileReader fr= null;  //2.提供具体的流
        try {
            //File file=new File("F:\\Java\\Java test\\test\\hii.txt");   //1.实例化File类的对象，指明要操作的文件
            File file=new File("hello.txt");   //1.实例化File类的对象，指明要操作的文件,相较于当前Module
            fr = new FileReader(file);
            int data=fr.read();   //3.数据的读入
            while(data!=-1){
                System.out.print((char)data);
                data=fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {     //4.流的关闭操作
            try {
                if(fr!=null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testFileReader1(){
        FileReader fr= null;
        try {
            File file=new File("hello.txt");
            fr = new FileReader(file);
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf=new char[5];
            int len;
            while((len=fr.read(cbuf))!=-1){
                for(int i=0;i<len;i++){  //错误的写法,cbuf.length
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr!=null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
       从内存中写出数据到硬盘的文件里。
       说明：
       1. 输出操作，对应的File可以不存在的。并不会报异常
       2.
            File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
            File对应的硬盘中的文件如果存在：
                   如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                   如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
        */
    public void testFileWriter(){
        FileWriter fr=null;
        try {
            File file = new File("hello1.txt");  //1.提供File类的对象，指明写出到的文件
            fr=new FileWriter(file,true);  //2,提供FileWriter的对象，用于数据的写出
            fr.write("I have a dream!\n");
            fr.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testFileReaderFileWriter(){
        FileReader fr=null;
        FileWriter fw=null;
        try {
            File file1=new File("hello.txt");  //1.创建file类的对象
            File file2=new File("hello2.txt");
            fr=new FileReader(file1);    //2.创建输入流和输出流的对象
            fw=new FileWriter(file2);
            //3.数据的读入和写出操作
            char[] cbuf=new char[5];
            int len;
            while((len=fr.read(cbuf))!=-1){
                for(int i=0;i<len;i++){  //错误的写法,cbuf.length
                    fw.write(cbuf,0,len);   //每次写出len个字符
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//不能使用字符流来处理图片等字节数据
