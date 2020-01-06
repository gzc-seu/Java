package FileTest;

import java.io.File;
import java.io.IOException;

public class FileTest1 {
    public void test1() throws IOException {
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
    /**
     * 课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
     * @author shkstart 邮箱：shkstart@126.com
     * @version  创建时间：2019年2月23日  上午1:55:59
     *
     */
    public void test2(){
        File srcFile = new File("d:\\code");

        String[] fileNames = srcFile.list();
        for(String fileName : fileNames){
            if(fileName.endsWith(".jpg")){
                System.out.println(fileName);
            }
        }

        File[] listFiles = srcFile.listFiles();
        for(File file : listFiles){
            if(file.getName().endsWith(".jpg")){
                System.out.println(file.getAbsolutePath());
            }
        }
    }
    // 列出file目录的下级内容，仅列出一级
    public static void printSubFile(File dir){
        if(dir.isDirectory()){
            String[] string=dir.list();
            for(String s:string)
                System.out.println(s);
        }else{
            System.out.println(dir + "是文件！");
        }
    }
    // 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
    // 建议使用File类的File[] listFiles()
    public static void listAllSubFiles(File dir){
        if (dir.isFile()) {
            System.out.println(dir);
        }else{
            File[] all=dir.listFiles();
            for(File f:all){
                listAllSubFiles(f);
            }
        }
    }
    // 拓展1：求指定目录所在空间的大小
    // 求任意一个目录的总大小
    public static long getDirectorySize(File dir){
        long length = 0;
        if (dir.isFile()){
            length+=dir.length();
        }else{
            File[] all=dir.listFiles();
            for(File f:all){
                length+=getDirectorySize(f);
            }
        }
        return length;
    }
    // 拓展2：删除指定的目录
    public void deleteDirectory(File file) {
        // 如果file是文件，直接delete
        // 如果file是目录，先把它的下一级干掉，然后删除自己
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // 循环删除的是file的下一级
            for (File f : all) {// f代表file的每一个下级
                deleteDirectory(f);
            }
        }
        // 删除自己
        file.delete();
    }

    public static void main(String[] args) throws IOException {
        FileTest1 test=new FileTest1();
        test.test2();
        File dir = new File("F:\\Java\\java基础视频");
        test.printSubFile(dir);
        //listAllSubFiles(dir);
        long length=getDirectorySize(dir);
        System.out.println(length);
    }
}
