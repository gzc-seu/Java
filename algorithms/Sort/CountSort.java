package SortTest;

import java.util.Arrays;

/**
 * 给定一个数组，先统计各个元素出现的次数，用元素的值做下标，得到一个新的数组。
 * 然后扫描这个数组，对于数组的每个下标，如果它对应值不为0，说明原来数组中就有几个这样的值。
 * 由于下标的天然递增，依次将这些值展开就得到排序后的数组。
 * 计数排序的时间复杂度为 O(N)，空间复杂度为 O(M)
 */
public class CountSort {
    public static void bucketSort(int[] arr){
        if (arr == null || arr.length < 2) return ;
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            max=arr[i]>max?arr[i]:max;
        }
        int[] bucket=new int[max+1];
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        int n=0;
        for(int j=0;j<bucket.length;j++){
            while(bucket[j]>0){
                arr[n++]=j;
                bucket[j]--;
            }
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
        int maxValue = 150;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bucketSort(arr1);
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
        bucketSort(arr);
        printArray(arr);

    }
}
