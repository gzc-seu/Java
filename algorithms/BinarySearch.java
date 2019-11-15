package BinarySearchTest;

public class BinarySearch {
    public static void main(String[] args) {
        int N = 10000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = i;

        long startTime = System.currentTimeMillis();
        int v = BinarySearch1.find1(arr, 100);
        long endTime = System.currentTimeMillis();
        System.out.println("Binary Search (Without Recursion): " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        int vv=BinarySearch2.find2(arr, 100);
        endTime = System.currentTimeMillis();
        System.out.println("Binary Search (With Recursion): " + (endTime - startTime) + "ms");
    }
}

// 非递归的二分查找算法
class BinarySearch1{
    public  static int find1(Comparable[] arr, Comparable target) {
        int lo=0,hi=arr.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid].compareTo(target)==0) return mid;
            if(arr[mid].compareTo(target)>0) hi=mid-1;
            else lo=mid+1;
        }
        return -1;
    }
}

// 递归的二分查找算法
class BinarySearch2{
    public  static int find2(Comparable[] arr, Comparable target){
        return find2(arr,0,arr.length-1,target);
    }
    private static int find2(Comparable[] arr, int lo, int hi, Comparable target){
        if(lo>hi) return -1;
        int mid=lo+(hi-lo)/2;
        if(arr[mid].compareTo(target)==0) return mid;
        else{
            if(arr[mid].compareTo(target)>0) return find2(arr,lo,mid-1,target);
            else return find2(arr,mid+1,hi,target);
        }
    }
}

