package ThreadTest;

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
        User user5=new User(16,"e",27);
        List<User> list= Arrays.asList(user1,user2,user3,user4,user5);
        //输出ID为偶数，年龄大于24，用户名转为大写，用户名倒排序,只输出一个用户名字
        list.stream().filter(s->{return s.getId()%2==0;})
                .filter(s->{return s.getAge()>24;})
                .map(s->{return s.getUsername().toUpperCase();})
                .sorted((o1,o2)->{return o2.compareTo(o1);})
                .limit(1)
                .forEach(System.out::println);


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

        //函数式接口：Supplier<T> String get()
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

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
