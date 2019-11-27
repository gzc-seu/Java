package SortTest;
/**
荷兰国旗问题：给定一个数组和一个数P，要求把小于P的数放左边，等于的数放中间，大于P得数放右边。要求时间复杂度：O(n)，额外空间复杂度O(1)
 */
public class NetherlandsFlag {
    public static int[] partition(int[] arr, int l, int r, int p){
        int less=l-1,more=r+1;
        while(l<more){
            if(arr[l]<p){
                swap(arr,l++,++less);
            }else if(arr[l]==p){
                l++;
            }else {
                swap(arr,l,--more);
            }
        }
        return arr;
    }
    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
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

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(res);

    }
}
