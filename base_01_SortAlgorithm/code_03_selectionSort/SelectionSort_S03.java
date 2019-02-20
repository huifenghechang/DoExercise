package code_03_selectionSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

/*
* 选择排序是不稳定的。
* 举例： 5，5，5，1，0.在第一次的排序中，稳定性就被破坏掉了！
*
* 任何情况下的复杂度，均为 O(n^2)
*
* */
public class SelectionSort_S03 {
    public static void selectionSort(int[] arr){
        // 合法性检验
        if(arr == null || arr.length < 2){
            return ;
        }

        // 对数据的数据进行排序,对于n个数，找到n-1次最小值，便可以将整个数列排好序
        for (int i = 0 ; i < arr.length -1; i++){
            int minIndex = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // 将一次遍历中的最小数，放在第i个位置上
            swap(arr,minIndex,i);
        }
    }

    public static void main(String[] args){

        int[] numbers = {1,3,2,5,7,0,89,98,25,-8};
        System.out.print("The origin is:");
        printfArray(numbers);
        selectionSort(numbers);
        System.out.print("The sorted is:");
        printfArray(numbers);
    }
}
