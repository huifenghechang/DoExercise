package code_02_bubbleSort;

import static utils.utils.PrintfArray;
import static utils.utils.swap;

public class BubbleSort_S02 {
    public static void bubbleSort(int[] arr){
        if (arr ==null || arr.length < 2){
            return;
        }
        for(int i=0; i < arr.length-1; i++){
            for(int j=0;j < arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] numbers = {1,3,2,5,7};
        System.out.print("The origin is:");
        PrintfArray(numbers);
        bubbleSort(numbers);
        System.out.print("The sorted is:");
        PrintfArray(numbers);
    }
}
