package code_10_quickSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class QuickSort_S02 {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int l ,int r){
        if( l < r){
            int[] p = partition(arr,l,r);
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[1]+1,r);
        }
    }

    public static int[] partition(int[] arr,int l ,int r){
        int less = l-1;
        int more = r+1;
        int num =arr[r];
        int cur = l;

        while (cur < more){
            if(arr[cur] < num){
                swap(arr,cur++,++less);
            }else if(arr[cur] > num){
                swap(arr,cur,--more);
            }else {
                cur++;
            }
        }
        //返回的是等于区间的下标值。
        return new int[]{less+1,more-1};
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,9,5};
        System.out.print("The origin is:");
        printfArray(arr);
        quickSort(arr);
        System.out.print("The sorted is:");
        printfArray(arr);

    }
}
