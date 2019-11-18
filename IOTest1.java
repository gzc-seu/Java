package IOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest1 {

    public static void main(String[] args) {
        IOTest1 test=new IOTest1();
        test.testFileInputOutputStream();
        test.testCopyFile();
    }

    public void testFileInputOutputStream(){
        FileInputStream fis=null;
        FileOutputStream fop=null;
        try {
            File file1=new File("爱情与友情.jpg");
            File file2=new File("爱情与友情1.jpg");
            fis=new FileInputStream(file1);
            fop=new FileOutputStream(file2);
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                    fop.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fop!=null)
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis=null;
        FileOutputStream fop=null;
        try {
            File file1=new File(srcPath);
            File file2=new File(destPath);
            fis=new FileInputStream(file1);
            fop=new FileOutputStream(file2);
            byte[] buffer=new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fop.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fop!=null)
                    fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void testCopyFile(){

        long start = System.currentTimeMillis();
        String srcPath = "C:\\Users\\Administrator\\Desktop\\1.jpg";
        String destPath = "C:\\Users\\Administrator\\Desktop\\2.jpg";
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));

    }
}
