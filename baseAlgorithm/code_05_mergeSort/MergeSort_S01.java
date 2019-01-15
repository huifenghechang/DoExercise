package code_05_mergeSort;


import static code_02_bubbleSort.BubbleSort.PrintfArray;

public class MergeSort_S01 {

    public static void mergeSort(int[] arr){
        if(arr.length < 2 || arr == null){
            return;
        }
        mergeSort(arr,0,arr.length-1);

    }

    public static void mergeSort(int[] arr,int left,int right){
        if(left == right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid + 1,right); //原代码为mergeSort(arr,mid,right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr, int left,int mid, int right){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid+1;
        int i = 0; //help数组的初始下标

        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; //原代码为help[i++] = arr[p1++] < arr[p2++] ? arr[p1++] : arr[p2++];

        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= right){
            help[i++] = arr[p2++];
        }

        for (int k=0; k< right-left+1;k++){
            arr[left+k] = help[k]; // 原代码为：arr[k] = help[k]
        }
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,9,5};
        System.out.print("The origin is:");
        PrintfArray(arr);
        mergeSort(arr);
        System.out.print("The sorted is:");
        PrintfArray(arr);

    }
}
