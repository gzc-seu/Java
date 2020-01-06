package InterfaceTest;

public class InterfaceTest {
    public static void main(String[] args) {


        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.6);

        int compareValue = c1.compareTo(c2);
        if(compareValue > 0){
            System.out.println("c1对象大");
        }else if(compareValue < 0){
            System.out.println("c2对象大");
        }else{
            System.out.println("c1与c2一样大");
        }


        int compareValue1 = c1.compareTo(new String("AA"));
        System.out.println(compareValue1);
    }
}

interface CompareObject {
    //若返回值是 0 , 代表相等; 若为正数，代表当前对象大；负数代表当前对象小
    public int compareTo(Object o);
}

class Circle {

    private Double radius;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle() {
        super();
    }

    public Circle(Double radius) {
        super();
        this.radius = radius;
    }
}

class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(double radius) {
        super(radius);
    }
    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if(o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle)o;
            //正确的方式一：
//			if(this.getRadius() > c.getRadius()){
//				return 1;
//			}else if(this.getRadius() < c.getRadius()){
//				return -1;
//			}else{
//				return 0;
//			}
            //当属性radius声明为Double类型时，可以调用包装类的方法
            //正确的方式二：
            return this.getRadius().compareTo(c.getRadius());
        }else{
//			return 0;
            throw new RuntimeException("传入的数据类型不匹配");
        }

    }

}