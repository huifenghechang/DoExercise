package code_08_arrayDivide;

import static utils.utils.printfArray;

public class ArrayDivide_S02 {
    public static void divide(int[] arr, int number){
        if(arr == null || arr.length < 2){
            return;
        };
        divide(arr,number,0,arr.length -1);
    }

    public static void divide(int[] arr, int num, int left, int right){
        int less = left - 1;
        int more = right + 1;
        int cur = left;

        while (cur < more){
            if (arr[cur] <= num){
                swap(arr,++less,cur++);
            }else {
                swap(arr,--more,cur);
            }
        }

    }

    public static void swap(int[] arr ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,5,3,0,8,2,-3,56,4,4,4,4,58,-89,98,63,-5,4,23};
        int number = 20;
        divide(arr,number);
        printfArray(arr);

    }
}
