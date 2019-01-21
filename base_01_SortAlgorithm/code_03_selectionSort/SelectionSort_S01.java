package code_03_selectionSort;


import static utils.utils.printfArray;
import static utils.utils.swap;

/*
* 选择排序基本思路：
* 0--->N 选择最小的，放到0位置
* 1--->N 选择最小的，放到1位置
* ...
* N-1-->N选择最小的，放到N-1位置
*
* */
public class SelectionSort_S01 {

    public static void selectionSort(int[] arr){
        if (arr==null || arr.length < 2){
            return;
        }

        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i+1;j < arr.length; j++){
                /*对于简单的if判断语句，可以用三目运算符来进行简化*/
                /*if (arr[j] < min){
                    min = j;
                }*/
                minIndex = arr[j]<arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }

    }
    public static void main(String[] args){

        int[] numbers = {1,3,2,5,7,98,46};
        System.out.print("The origin is:");
        printfArray(numbers);
        selectionSort(numbers);
        System.out.print("The sorted is:");
        printfArray(numbers);
    }
}
