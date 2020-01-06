package ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassTest {
    @Test
    public void test1() throws Exception{
        Class clazz=Person.class;
        //1.通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("tom", 12);
        Person p=(Person)obj;
        System.out.println(p.toString());
        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*******************************");
        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1=(Person) cons1.newInstance("terry");
        System.out.println(p1.toString());
        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"meimie");
        System.out.println(p1.toString());
        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation= (String) showNation.invoke(p1, "China");  //相当于String nation = p1.showNation("中国")
        System.out.println(nation);
    }
    /**
        关于java.lang.Class类的理解
        1.类的加载过程：
        程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
        接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
        加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
        运行时类，就作为Class的一个实例。

        2.换句话说，Class的实例就对应着一个运行时类。
        3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
         */
    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test2() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1=Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象,调用getClass()
        Person p=new Person();
        Class clazz2=p.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3=Class.forName("ReflectionTest.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);  //获取的都是同一个运行时类
        System.out.println(clazz1 == clazz3);
    }
}


class Person {
    private String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("Person()");
    }

    public void show(){
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
}

