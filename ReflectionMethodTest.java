package ReflectionTest;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.*;

public class ReflectionMethodTest {
    /**
     * 获取当前运行时类的属性结构
     */
    @Test
    public void FieldTest(){
        Class clazz=People.class;
        Field[] field = clazz.getFields();  //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        for(Field f:field){
            System.out.println(f);
        }
        Field[] declaredFields = clazz.getDeclaredFields();  //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        for(Field f:declaredFields){
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");
            //3.变量名
            String fName = f.getName();
            System.out.print(fName);
        }
    }
    /**
     * 获取运行时类的方法结构
     */
    @Test
    public void MethodTest(){
        Class clazz=People.class;
        //getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();
        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            //1.获取方法声明的注解
//            Annotation[] annos = m.getAnnotations();
//            for(Annotation a : annos){
//                System.out.println(a);
//            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName());
            System.out.print("(");
            //5.形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(int i = 0;i < parameterTypes.length;i++){

                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }

                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }

            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print("throws ");
                for(int i = 0;i < exceptionTypes.length;i++){
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }

                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
        }
    }

    @Test
    public void OtherTest(){
        Class clazz = People.class;
         //获取构造器结构
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //获取运行时类的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        System.out.println();
        //获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for(Class c:interfaces){
            System.out.println(c);
        }
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c:interfaces1){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类所在的包
        Package pack = clazz.getPackage();
        System.out.println(pack);
        //获取运行时类声明的注解
//        Annotation[] annotations = clazz.getAnnotations();
//        for(Annotation annos : annotations){
//            System.out.println(annos);
//        }
    }
}


class People extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public People(){}

    private People(String name){
        this.name = name;
    }

    People(String name,int age){
        this.name = name;
        this.age = age;
    }

    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests,int age) throws NullPointerException,ClassCastException{
        return interests + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
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

class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}

interface MyInterface {
    void info();
}