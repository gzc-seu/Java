package ThreadTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读-读可以共享，读-写不能共享，写-写不能共享
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache=new MyCache();
        for(int i=1;i<=5;i++){
            int finalI = i;
            new Thread(()->{
                myCache.put(finalI+" ",finalI+" ");
            },String.valueOf(i)).start();
        }
        for(int i=1;i<=5;i++){
            int finalI = i;
            new Thread(()->{
                myCache.get(finalI+" ");
            },String.valueOf(i)).start();
        }
    }
}

class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入数据"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入数据成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取数据");
            Object result=map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取数据成功"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
