package ToStringTest;

/**
 * Object类中toString()的使用：
 *
 * 1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 *
 * 2. Object类中toString()的定义：
 *   public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }
 *
 * 3. 像String、Date、File、包装类等都重写了Object类中的toString()方法。
 *    使得在调用对象的toString()时，返回"实体内容"信息
 *
 * 4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
 **/
public class ToStringTest {
    public static void main(String[] args){
        Customer cust1 = new Customer("Tom",21);
        //System.out.println(cust1.toString());
        //System.out.println(cust1);     //当我们输出一个对象的引用时，实际上就是调用当前对象的toString(),未重写
        System.out.println(cust1.toString()); //重写后
    }
}

 class Customer {

    private String name;
    private int age;

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
    public Customer() {
        super();
    }
    public Customer(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //自动生成的equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }



    //重写的原则：比较两个对象的实体内容(即：name和age)是否相同
    //手动实现equals()的重写
//	@Override
//	public boolean equals(Object obj) {
//
////		System.out.println("Customer equals()....");
//		if (this == obj) {
//            return true;
//        }
//
//		if(obj instanceof Customer){
//			Customer cust = (Customer)obj;
//			//比较两个对象的每个属性是否都相同
////			if(this.age == cust.age && this.name.equals(cust.name)){
////				return true;
////			}else{
////				return false;
////			}
//
//			//或
//			return this.age == cust.age && this.name.equals(cust.name);
//		}else{
//			return false;
//
//		}
//
//	}
    //手动实现
//	@Override
//	public String toString() {
//		return "Customer[name = " + name + ",age = " + age + "]";
//	}
    //自动实现
    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + "]";
    }

}
