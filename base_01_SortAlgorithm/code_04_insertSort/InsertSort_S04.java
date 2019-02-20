package code_04_insertSort;

import static utils.utils.printfArray;
import static utils.utils.swap;

public class InsertSort_S04 {
    /*
    * 插入排序，从原来数组中的第二位数字开始插入，所以起始下标为1
    * 插入排序具备稳定性 ~
    * */

    public static void insertSort(int[] arr){

        // 输入的合法性判断
        if(arr == null || arr.length < 2){
            return;
        }

        // 正式开始排序
        for(int i = 1; i < arr.length; i++){
            // 将数字插入到前面 0 至 i-1 的有序序列中
            for(int j = i-1 ; j >= 0; j--){
                if (arr[j+1] < arr[j]){
                    swap(arr,j+1,j);
                }
            }
        }
    }

    public static void main(String[] args){

        int[] numbers = {1,3,2,5,7,99,-9,0};
        System.out.print("The origin is:");
        printfArray(numbers);
        insertSort(numbers);
        System.out.print("The sorted is:");
        printfArray(numbers);
    }
}
