package code_09_NetherlandsFlags;

import static utils.Comparator.*;
import static utils.utils.*;

public class NetherLandsFlags_19_01_19 {

    public static void netherlandsFlags(int[] arr,int left, int right,int num){
        if (arr == null ){
            return;
        }
        //采用分区的思想来处理荷兰国旗问题
        int less = left -1;
        int more = right + 1;
        int cur = left;

        while (cur < more){ // 写成了less < more
            if (arr[cur] < num){
                swap(arr,cur++,++less);
            }else if (arr[cur] > num){
                swap(arr,cur,--more);
            }else {
                cur++;
            }
        }
    }

    public static void main(String[] args){
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = duplicateArray(arr1);
            netherlandsFlags(arr1,0,arr1.length-1,50);
            NLFCompatator.partition(arr2,0,arr2.length-1,50);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!you passed!" : "you passed!");

        int[] arr = generateRandomArray(10,100);
        printfArray(arr);
        netherlandsFlags(arr,0,arr.length-1,50);
        printfArray(arr);
    }
}
