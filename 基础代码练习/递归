package RecursionTest;

/*
 * 递归方法的使用（了解）
 * 1.递归方法：一个方法体内调用它自身。
 * 2. 方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
 * 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环。
 *
 */

public class RecursionTest {
    public static void main(String[] args)
    {
        RecursionTest test=new RecursionTest();
        int sum1=test.getsum(100);
        System.out.println(sum1);
        int sum2=test.getsum1(10);
        System.out.println(sum2);
        int sum3=test.f(10);
        System.out.println(sum3);
    }
    // 例1：计算1-n之间所有自然数的和
    public int getsum(int n)
    {
        if(n==1) return n;
        else
        {
            return n+getsum(n-1);
        }
    }
    // 例2：计算1-n之间所有自然数的乘积:n!
    public int getsum1(int n)
    {
        if(n==1) return n;
        else
        {
            return n*getsum(n-1);
        }
    }
    //例3：已知有一个数列：f(0) = 1,f(1) = 4,f(n+2)=2*f(n+1) + f(n),
    //其中n是大于0的整数，求f(10)的值。
    public int f(int n)
    {
        if(n==0) return 1;
        else if(n==1) return 4;
        else return 2*f(n-1)+f(n-2);
    }
}
