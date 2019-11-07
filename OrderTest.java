package ObjectTest;

/**
 * 编写Order类，有int型的orderId，String型的orderName，
 * 相应的getter()和setter()方法，两个参数的构造器，
 * 重写父类的equals()方法：public boolean equals(Object obj)，
 * 并判断测试类中创建的两个对象是否相等。

 **/
public class OrderTest {
    public static void main(String[] args)
    {
        Order one=new Order(100,"AA");
        Order two=new Order(100,"BB");
        System.out.println(one.equals(two));
        Order three = new Order(100, new String("BB"));
        System.out.println(two.equals(three));
    }
}

 class Order {
    private int orderId;
    private String orderName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }
    public boolean equals(Object obj)
    {
        if(this==obj) return true;
        if(obj instanceof Order)
        {
            Order order=(Order)obj;
            return (this.orderId==order.orderId)&&(this.orderName.equals(order.orderName));//涉及基本数据类型的比较，可以用==，涉及到引用类型，要用equals
        }
        return false;
    }
}
