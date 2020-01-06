package ThreadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程按顺序调用：实现A-B-C，A打印5次，B打印5次，C打印5次，循环
 * lock+condition:精准打击，精准实现
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        SharedRecourse sharedRecourse=new SharedRecourse();

        new Thread(()->{
            for(int i=1;i<=10;i++){
                sharedRecourse.printA();
            }
        },"A").start();

        new Thread(()->{
            for(int i=1;i<=10;i++){
                sharedRecourse.printB();
            }
        },"B").start();

        new Thread(()->{
            for(int i=1;i<=10;i++){
                sharedRecourse.printC();
            }
        },"C").start();
    }
}

class SharedRecourse{
    private int number=1;//A:1 B:2 C:3
    Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void printA(){
        lock.lock();
        try {
            while(number!=1){
                condition1.await();
            }
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            while(number!=2){
                condition2.await();
            }
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            while(number!=3){
                condition3.await();
            }
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
