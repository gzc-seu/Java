package IOTest;
import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 3.要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *
 * 4.序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种
 * 二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 * 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 */
public class ObjectInputOutputStreamTest {

    public static void main(String[] args) {
        ObjectInputOutputStreamTest test=new ObjectInputOutputStreamTest();
        test.testObjectOutputStream();
        test.testObjectInputStream();
    }

    /*序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去 使用ObjectOutputStream实现*/
    @org.junit.Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos=null;
        try {
            oos=new ObjectOutputStream(new FileOutputStream("hello.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作
            oos.writeObject(new Person("王铭",23,01));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos!=null)
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*反序列化：将磁盘文件中的对象还原为内存中的一个java对象,使用ObjectInputStream来实现*/
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("hello.dat"));
            Object obj=ois.readObject();
            String str = (String) obj;
            System.out.println(str);
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois!=null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Person需要满足如下的要求，方可序列化
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
 *   也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 */
class Person implements Serializable {
    public static final long serialVersionUID = 475463534532L;  //值随便写
    private String name;
    private int age;
    private int id;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
