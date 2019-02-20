package code_05_mergeSort;

import static utils.utils.printfArray;

public class MergeSort_S02 {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        partition(arr,0,arr.length - 1);
    }

    public static void partition(int[] arr, int left, int right){
        if(left == right){
            return;
        }
        int midIndex  = (left + right) / 2;
        partition(arr,left,midIndex);
        partition(arr,midIndex+1,right);
        merge(arr,left,midIndex,right);
    }

    public static void merge(int[] arr,int left, int midIndex,int right){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = midIndex +1;
        int hIndex = 0;
        // 合并操作
        while (p1 <= midIndex && p2 <= right){
            help[hIndex++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= midIndex){
            help[hIndex++] = arr[p1++];
        }

        while (p2 <= right){
            help[hIndex++] = arr[p2++];
        }

        for (hIndex=0;hIndex < right-left+1;hIndex++){
            arr[left+hIndex] = help[hIndex];
        }
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,9,5,78,56};
        System.out.print("The origin is:");
        printfArray(arr);
        mergeSort(arr);
        System.out.print("The sorted is:");
        printfArray(arr);

    }
}
