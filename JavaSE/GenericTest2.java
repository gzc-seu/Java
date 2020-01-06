package Generic;

import java.util.ArrayList;
import java.util.List;

/** 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 *
 * 1. 关于自定义泛型类、泛型接口：
 */

public class GenericTest2 {
    public static void main(String[] args) {
        GenericTest2 s=new GenericTest2();
        s.test1();
        s.test3();
    }
    //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
    //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
    public void test1(){
        Order<String> order1=new Order<String>("orderAA",1001,"order:AA");
        order1.setOrderT("order:BB");
        System.out.println(order1);
    }
    public void test2(){
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        SubOrder sub1=new SubOrder();
        SubOrder1<String> sub2=new SubOrder1<>();
    }
    public void test3(){
        Order<String> order=new Order<>();
        Integer[] arr=new Integer[]{1,2,3,4};
        List<Integer> integers = order.copyFromArrayToList(arr);
        System.out.println(integers);
    }
}

class Order<T>{
    String orderName;
    int orderId;
    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public Order() {
    }

    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list=new ArrayList<>();
        for(E e:arr){
            list.add(e);
        }
        return list;
    }
}

class SubOrder extends Order<Integer>{

    public SubOrder(String orderName, int orderId, Integer orderT) {
        super(orderName, orderId, orderT);
    }

    public SubOrder() {
        super();
    }
}
 class SubOrder1<T> extends Order<T> {//SubOrder1<T>:仍然是泛型类
}