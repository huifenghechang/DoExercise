package code_03_selectionSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class SelectionSort_S02 {
    public static void selectionSort(int[] arr){
        if (arr.length < 2 || arr ==null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i+1; j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args){

        int[] numbers = {1,3,2,5,7,0,89};
        System.out.print("The origin is:");
        printfArray(numbers);
        selectionSort(numbers);
        System.out.print("The sorted is:");
        printfArray(numbers);
    }
}
