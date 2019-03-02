package code_09_NetherlandsFlags;

import static code_02_bubbleSort.BubbleSort_Test.printArray;
import static utils.utils.swap;

public class NetherlandsFlags_19_02_21 {

    // 将数组中的数字分为小于num,等于num以及大于num这三部分！
    public static void netherlandsFlags(int[] arr, int num){
        if (arr == null || arr.length < 2){
            return;
        }

        // 设置三个指针，对其进行处理
        int less = -1;
        int more = arr.length;
        int cur = 0;

        // 扫描数组进行处理
        while (cur < more){
            // cur表示数组中正在扫描的数字。一共有三种情况，小于，等于，以及大于。
            if (arr[cur] < num){
                swap(arr,++less,cur++);
            }else if(arr[cur] == num){
                cur ++;
            }else {
                swap(arr,--more,cur);
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {4,5,3,1,9,25,7,8,6};
        netherlandsFlags(arr,6);
        printArray(arr);
    }
}
