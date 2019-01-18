package code_10_quickSort;

import static utils.Comparator.*;
import static utils.Comparator.generateRandomArray;
import static utils.utils.printfArray;
import static utils.utils.swap;

public class QuickSortComparator {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr,int left, int right){
        if( left < right) {
            int[] bound = partition(arr,left,right);
            quickSort(arr,left,bound[0]);
            quickSort(arr,bound[1],right);
        }
    }

    public static int[] partition(int[] arr, int left, int right){
//        int p = arr[(int)((right - left+1) * Math.random())];
        int p = arr[right];
        int less = left -1;
        int more = right + 1;
        int cur = left;
        while ( cur < more){
            if(arr[cur] < p){
                swap(arr,cur++,++less);
            }else if (arr[cur] > p){
                swap(arr,cur,--more);
            }else {
                cur++;
            }
        }
        return new int[]{less,more};
    }

    public static void main(String[] args){
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = duplicateArray(arr1);
            quickSort(arr1);
            sortComparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice boy ! you passed!" : "you error");

        int[] arr = generateRandomArray(10,100);
        printfArray(arr);
        quickSort(arr);
        printfArray(arr);
    }


}
