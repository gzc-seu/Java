package FileTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public void test1(){
        File file1=new File("hello.txt");
        File file2=new File("F:\\Java\\Java test\\hi.txt");
/**
public String getAbsolutePath()：获取绝对路径
public String getPath() ：获取路径
public String getName() ：获取名称
public String getParent()：获取上层文件目录路径。若无，返回null
public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
public long lastModified() ：获取最后一次的修改时间，毫秒值

如下的两个方法适用于文件目录：
public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组

 public boolean isDirectory()：判断是否是文件目录
 public boolean isFile() ：判断是否是文件
 public boolean exists() ：判断是否存在
 public boolean canRead() ：判断是否可读
 public boolean canWrite() ：判断是否可写
 public boolean isHidden() ：判断是否隐藏
*/
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

        File file3 = new File("F:\\Java\\Java test","hi3");
        File file4 = new File(file3,"hi4.txt");
        System.out.println(file3);
        System.out.println(file4);

       /* String[] list=file3.list();
        for(String s:list){
            System.out.println(s);
        }

        File[] file=file4.listFiles();
        for(File f:file){
            System.out.println(f);
        }*/
    }
    /**
       创建硬盘中对应的文件或文件目录
   public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
   public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
   public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

       删除磁盘中的文件或文件目录
   public boolean delete()：删除文件或者文件夹
       删除注意事项：Java中的删除不走回收站。

        */
    public void test2() throws IOException {
        File file1 = new File("hii.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    public static void main(String[] args) throws IOException {
        FileTest test=new FileTest();
        test.test1();
        test.test2();
    }
}
