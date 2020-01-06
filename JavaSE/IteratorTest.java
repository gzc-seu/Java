package Collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    /**
     * 集合元素的遍历操作，使用迭代器Iterator接口
     * 1.内部的方法：hasNext() 和  next()
     * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
     * 默认游标都在集合的第一个元素之前。
     * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
     *
     */
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("AA");
        coll.add("BB");
        Iterator iterator =coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    // 再调用remove都会报IllegalStateException。
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("AA");
        coll.add("BB");
        coll.add(new String("Tom"));
        Iterator iterator =coll.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals("Tom")){
                iterator.remove();
            }
        }
        iterator =coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("AA");
        coll.add("BB");
        coll.add(new String("Tom"));
        //for(集合元素的类型 局部变量 : 集合对象)
        for(Object obj:coll){
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        IteratorTest test=new IteratorTest();
        test.test1();
        test.test2();
        test.test3();
    }
}
