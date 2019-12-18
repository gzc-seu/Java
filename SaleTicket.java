package ThreadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//高内聚低耦合 线程，操作，资源类
//三个售票员 卖30张票
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<40;i++){
                    ticket.sale();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<40;i++){
                    ticket.sale();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<40;i++){
                    ticket.sale();
                }
            }
        }, "C").start();

        new Thread(()->{for(int i=1;i<40;i++)ticket.sale(); },"D").start();

    }
}

class Ticket{
    private int number=30;

    Lock lock=new ReentrantLock();

    public void sale(){
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出第："+(number--)+"还剩下："+(number));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
