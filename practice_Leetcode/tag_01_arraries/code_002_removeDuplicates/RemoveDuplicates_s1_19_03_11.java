package tag_01_arraries.code_002_removeDuplicates;

import java.util.Arrays;

import static utils.utils.printfArray;

public class RemoveDuplicates_s1_19_03_11 {

    public int removeDuplicates(int[] nums) {

        if (nums == null){
            throw new IllegalArgumentException("The nums is empty");
        }

        // 对数组进行排序 --- think一下，如何调用系统函数进行排序。
        bubbleSort(nums);

        // 采用双指针进行排除重复元素
        int p1 = 0;  // p1指向最后不相同元素中的最后一个元素
        int p2 = 0;

        while (p2 < nums.length){
            if (nums[p1]==nums[p2]){
                p2++;
            }else {
                nums[++p1] = nums[p2];
            }
        }

        // 数组的长度为p1的下标 + 1
        return p1+1;
    }

    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length;i++){
            int endIndex = arr.length -1 -i;
            for (int j = 0; j < endIndex;j++ ){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sort(int[] arr){
        Arrays.sort(arr);
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,5,2,0};
        Arrays.sort(arr);
        printfArray(arr);

    }
}
