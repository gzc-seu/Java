package CircleTest;

/**
 * 定义两个类，父类GeometricObject代表几何形状，子类Circle代表圆形
 * 写一个测试类，创建两个Circle对象，判断其颜色是否相等；利用equals方法判断其半径是否相等；利用
 * toString()方法输出其半径。
 */
public class CircleTest {
    public static void main(String[] args)
    {
        Circle circle1 = new Circle(2.3);
        Circle circle2 = new Circle(new String("white"), 3.3, 2.0);
        System.out.println("颜色是否相等："+circle1.getColor().equals(circle2.getColor()));
        System.out.println("半径是否相等：" + circle1.equals(circle2));
        System.out.println(circle1.toString());
        System.out.println(circle2);
    }
}

class GeometricObject{
    protected String color;
    protected double weight;

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public GeometricObject() {
        this.color = "white";
        this.weight = 1.0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //求圆的面积
    public double findArea()
    {
        return 3.14 * radius * radius;
    }
    //比较两个圆的半径是否相等，如相等，返回true。
    public boolean equals(Object obj)
    {
        if(this == obj){
            return true;
        }
        if(obj instanceof Circle)
        {
            Circle c = (Circle)obj;
            return this.radius == c.radius;
        }
        return false;
    }
    public String toString()
    {
        return "Circle [radius=" + radius + "]";
    }

}