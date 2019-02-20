package code_02_bubbleSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class BubbleSort_S03 {

    public static void  bubbleSort(int[] arr){
        // 冒泡排序，时间复杂度为O(n^2)
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length -1 -i;j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] numbers = {1,3,2,5,7};
        System.out.print("The origin is:");
        printfArray(numbers);
        bubbleSort(numbers);
        System.out.print("The sorted is:");
        printfArray(numbers);
    }
}
