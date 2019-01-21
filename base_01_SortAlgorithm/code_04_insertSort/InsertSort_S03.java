package code_04_insertSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class InsertSort_S03 {
    public static void insertSort(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }

        for(int i=1; i< arr.length ;i++){
            // 插入操作
            for (int j = i-1; j > 0;j--){
                if(arr[j+1] < arr[j]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void main(String[] args){

        int[] numbers = {1,33,2,52,7,9,22};
        System.out.print("The origin is:");
        printfArray(numbers);
        insertSort(numbers);
        System.out.print("The sorted is:");
        printfArray(numbers);
    }


}
