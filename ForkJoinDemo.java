package ThreadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并框架：
 * ForkJoinPool,
 * ForkJoinTask, 从池子里完成后分支合并
 * RecursiveTask
 */
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask=new MyTask(0,100);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Integer> forkjointask = forkJoinPool.submit(myTask);
        System.out.println(forkjointask.get());
        forkJoinPool.shutdown();
    }
}

class MyTask extends RecursiveTask<Integer>{
    private  static final int count=10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end-begin)<=count){
            for(int i=begin;i<=end;i++){
                result+=i;
            }
        }else{
            int middle=(begin+end)/2;
            MyTask myTask1=new MyTask(begin,middle);
            MyTask myTask2=new MyTask(middle+1,end);
            myTask1.fork();
            myTask2.fork();
            result=myTask1.join()+myTask2.join();
        }
        return result;
    }
}
