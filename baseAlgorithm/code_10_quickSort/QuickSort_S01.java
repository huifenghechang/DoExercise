package code_10_quickSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class QuickSort_S01 {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int l ,int r){
        if( l < r){
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr,l,r);
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[1]+1,r);
        }
    }

    public static int[] partition(int[] arr,int l ,int r){
        int less = l-1;
        int more = r;
        int cur = l;

        while (cur < more){
            if(arr[cur] < arr[r]){
                swap(arr,cur++,++less);
            }else if(arr[cur] > arr[r]){
                swap(arr,cur,--more);
            }else {
                cur++;
            }
        }
        swap(arr,more,r); // 这一行原来没有，主要的作用，是将枢轴放置在数组的之中。必须要这么做！
        //返回的是等于区间的下标值。
        return new int[]{less+1,more};
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,9,5,56};
        System.out.print("The origin is:");
        printfArray(arr);
        quickSort(arr);
        System.out.print("The sorted is:");
        printfArray(arr);

    }
}
