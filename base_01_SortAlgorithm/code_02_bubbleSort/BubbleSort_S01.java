package code_02_bubbleSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class BubbleSort_S01 {

    public static void bubble(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int end = arr.length-1;end > 0;end--){
            for(int i = 0;i < end; i++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }


    public static void main(String[] args){
        int[] numbers = {1,3,2,5,7};
        System.out.print("The origin is:");
        printfArray(numbers);
        bubble(numbers);
        System.out.print("The sorted is:");
        printfArray(numbers);

    }
}
