package ThreadTest;

/**
 * 两个线程，可以操作初始值为0的变量，一个线程加一，一个线程减一
 * 多线程交互中国，必须防止虚假唤醒，也就是判断只能用while，不能用if
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner=new AirConditioner();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    try {
                        Thread.sleep(200);
                        airConditioner.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    try {
                        Thread.sleep(300);
                        airConditioner.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    try {
                        Thread.sleep(400);
                        airConditioner.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    try {
                        Thread.sleep(500);
                        airConditioner.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"D").start();

    }
}

class AirConditioner{
    private int number=0;
    public synchronized void increment() throws InterruptedException {
        while(number!=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while(number==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }
}