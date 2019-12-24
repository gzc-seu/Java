package ThreadTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StreamDemo {
    public static void main(String[] args) {
        User user1=new User(11,"a",23);
        User user2=new User(12,"b",24);
        User user3=new User(13,"c",25);
        User user4=new User(14,"d",26);
        List<User> list= Arrays.asList(user1,user2,user3,user4);

        //函数式接口：Function<T,R>, R apply(T,t)
        Function<String,Integer>function=new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 1024;
            }
        };
        Function<String,Integer> function1=s->{return 10244;}; //(String s)->{return 10244;}进一步省略
        System.out.println(function.apply("abd"));
        System.out.println(function1.apply("abd"));

        //函数式接口：Predicate<T>,boolean test(T,t)
        Predicate<String> predicate=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        Predicate<String> predicate1=s->{return s.isEmpty();};
        System.out.println(predicate.test("aa"));
        System.out.println(predicate1.test("bb"));

        //函数式接口：Consumer<T> void accept(T)
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("匿名内部类"+s);
            }
        };
        Consumer<String> consumer1=s->{ System.out.println("lemada表达式"+s);};
        consumer.accept("a");
        consumer1.accept("b");

        //函数式接口：
        Supplier<String> supplier=new Supplier<String>() {
            @Override
            public String get() {
                return "a";
            }
        };
        Supplier<String> supplier1=()->{return "b";};
        System.out.println(supplier.get());
        System.out.println(supplier1.get());
    }
}

class User{
    private int id;
    private String username;
    private int age;

    public User(int id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
