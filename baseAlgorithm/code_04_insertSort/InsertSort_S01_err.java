package code_04_insertSort;


import static utils.utils.PrintfArray;

/*

没有写出来的原因，没有理解“新数据是如何插入到之前拍好序的数组中的！”

* 插入排序，将前面的数列看做有序的，不断地往前插入
* 最主要的操作，就是插入
* 下标1  插入 0 数列
* 下标2  插入 0,1数列
*  ...
* 下标N  插入 0,1,..N-1数列
*
* i = 1
* i = 2
* ...
* i = n ,插入
*
* 插入排序的插入操作，不会写
* */
public class InsertSort_S01_err {
    public static void insertSort(int[] arr){
        for (int i=1; i < arr.length; i++){
               insert(arr,i-1,i);
        }
    }

    public static void insert(int[]arr, int endIndex,int kIndex){
        for(int k = 0; k < endIndex-1; k++){
            if(arr[k] < arr[kIndex] && arr[k+1] > arr[kIndex] ){
                swap(arr,k,kIndex);
            }
        }
    }

    public static void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        int[] numbers = {1,3,2,5,7};
        System.out.print("The origin is:");
        PrintfArray(numbers);
        insertSort(numbers);
        System.out.print("The sorted is:");
        PrintfArray(numbers);
    }
}
