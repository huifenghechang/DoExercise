package code_10_quickSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class QuickSort_S03 {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }

        int[] ltRt = partition(arr, left,right);

        quickSort(arr,left,ltRt[0]);
        quickSort(arr,ltRt[1],right);
    }

    public static int[] partition(int[] arr, int left, int right){

        // 随机选择数组中的一个数作为枢轴。注意！这里枢轴下标的取法！
        int pivot = left + (int)((right -left + 1) * Math.random());
        int pNum = arr[pivot];

        // 设置三个指针，对数组进行划分
        int less = left - 1;   // 表示小于部分的最后一个
        int more = right + 1;  // 表示大于部分的第一个
        int cur = left;

        while (cur < more){
            if (arr[cur] < pNum){
                swap(arr,cur++,++less);
            }else if (arr[cur] >pNum){
                swap(arr,cur,--more);
            }else {
                cur++;
            }
        }
        // 划分好之后，返回小于部分与大于部分的边界
        return new int[]{less,more};
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,2,9,5,56,88,99,-8};
        System.out.print("The origin is:");
        printfArray(arr);
        quickSort(arr);
        System.out.print("The sorted is:");
        printfArray(arr);

    }
}
