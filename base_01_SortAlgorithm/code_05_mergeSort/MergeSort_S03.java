package code_05_mergeSort;

import static utils.utils.printfArray;

public class MergeSort_S03 {
    /*
    * 归并排序，又叫做 2-路 归并排序
    *
    * 主要分为两个部分，划分和合并。
    * 划分，是通过不断的调用自身来实现的；
    * 合并，是通过对一个辅助空间数组来实现的；
    * 需要注意的是，最后需要将对应的数据拷贝至原数组中！
    * */

    public static void  mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        partition(arr,0 ,arr.length - 1);

    }

    public static void partition(int[] arr ,int left,int right){
        // 递归退出条件
        if (left == right){
            return;
        }
        int mid = (left + right)/2;
        partition(arr,left,mid);
        partition(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    // 将两个排序好的子数列进行 合并！！！
    public static void merge(int[] arr, int left,int mid, int right){
        // 首先，设置必要的变量
        int p1 = left;
        int p2 = mid + 1;
        int[] help = new int[right - left + 1];
        int helpIndex = 0;
        while (p1 <= mid && p2 <= right){
            help[helpIndex++] = arr[p1] < arr[p2] ?  arr[p1++] : arr[p2++];
        }

        // 若p1有剩余，则将其剩余部分添加至help数组中。
         while (p1 <= mid){
             help[helpIndex++] = arr[p1++];
         }

         while (p2 <= right){
             help[helpIndex++] = arr[p2++];
         }

         //将排序好的help数组，拷贝到原来的数组中
        // 注意，这里的i 的边界如条件为 i < right - left + 1，而不能是arr.length .
        // 这是因为，我们这里，只是对部分的数据进行操作而已。而不是对整个数组。
        for (int i= 0; i < right - left + 1; i++){
            arr[left + i] = help[i];
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
