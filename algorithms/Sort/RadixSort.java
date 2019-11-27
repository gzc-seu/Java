package SortTest;

import java.util.Arrays;

/**基数排序：
 * 1. 将所有待排序整数（注意，必须是非负整数）统一为位数相同的整数，位数较少的前面补零。一般用10进制，
 * 2. 也可以用16进制甚至2进制。所以前提是能够找到最大值，得到最长的位数，设 k 进制下最长为位数为 d 。
 * 3. 从最低位开始，依次进行一次稳定排序。这样从最低位一直到最高位排序完成以后，整个序列就变成了一个有序序列。
 * 时间复杂度为 O(N)，空间复杂度为 O(M)
 */
public class RadixSort {

    public static void radixSort(int[] arr){
        if (arr == null || arr.length < 2) return ;
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    //求数组中最大数的位数
    public static int maxbits(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            max=arr[i]>max?arr[i]:max;
        }
        int res=0;
        while(max>0){
            res++;
            max /= 10;
        }
        return res;
    }

    //每一位的数据
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    //基数排序
    public static void radixSort(int[] arr,int begin,int end,int digit){
        final int radix = 10;
        int digit_num;
        //count[i]表示某一位是0~i的数有几个
        //count[1] 某位是0~1的个数，count[2] 某位是0~2的个数.。。。。
        int[] count=new int[radix];
        int[] bucket=new int[end-begin+1];
        for(int d=1;d<=digit;d++){  //d=1表示个位，d=2表示十位...
            for(int i=0;i<radix;i++) count[i]=0;
            for(int i=begin;i<=end;i++){
                digit_num=getDigit(arr[i], d);
                count[digit_num]++;
            }
            for(int i=1;i<radix;i++) count[i]+=count[i-1];
            //for(int i=begin;i<=end;i++){
            for (int i = end; i >= begin; i--) {  //要从后往前遍历，因为每次要先让上次排序中位数大的数先进桶
                digit_num=getDigit(arr[i], d);
                bucket[count[digit_num]-1]=arr[i];
                count[digit_num]--;
            }
            for(int i=begin,j=0;i<=end;i++,j++) arr[i]=bucket[j];
        }
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        radixSort(arr);
        printArray(arr);

    }
}
