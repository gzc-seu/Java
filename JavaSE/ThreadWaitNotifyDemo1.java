package ThreadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程，可以操作初始值为0的变量，一个线程加一，一个线程减一
 * 多线程交互中国，必须防止虚假唤醒，也就是判断只能用while，不能用if
 *
 * 使用JUC新版本的写法
 */
public class ThreadWaitNotifyDemo1 {
    public static void main(String[] args) {
        AirConditioner1 airConditioner=new AirConditioner1();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(200);
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(300);
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(400);
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() -> {
            for(int i=1;i<=10;i++){
                try {
                    Thread.sleep(500);
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }

}

class AirConditioner1{
    private int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while(number!=0){
                condition.await(); //this.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll(); //this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while(number==0){
                condition.await();//this.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll(); //this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }
    }
}
