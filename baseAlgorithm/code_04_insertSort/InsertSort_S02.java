package code_04_insertSort;

import static utils.utils.PrintfArray;
import static utils.utils.swap;

/*
* 插入排序，将前面的数列看做有序的，不断地往前插入
* 如何插入呢？
* 0,1，2,3,4  以及index5上面的数
* 前5位已经是有序的，index5如何插入？
    * 不同于直接选择一个插入的位置，因为数据时存在数组里，不是链表里，没有多余的空间。
* 插入的办法
    * 使用相邻位置交换的方法
        * 比如：1,5,3,2,7
        *  1，3,5,2,7
        *  2插入 1,3,5的基本方法是：
            * 1,3,2,5
            * 1,2,3,5
            * 经过两次交换，才得以实现插入到有序序列中！

* */
public class InsertSort_S02 {
    public static void insertSort(int[] arr){
        for (int i=1; i < arr.length; i++){
            for(int j = i;j > 0; j--){
                // 若后一个数比前一个数小，则交换
                if( arr[j] < arr[j-1] )
                {
                    swap(arr,j,j-1);
                }
            }

        }
    }

    public static void main(String[] args){

        int[] numbers = {1,3,2,5,7,90};
        System.out.print("The origin is:");
        PrintfArray(numbers);
        insertSort(numbers);
        System.out.print("The sorted is:");
        PrintfArray(numbers);
    }
}
