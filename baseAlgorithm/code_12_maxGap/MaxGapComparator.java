package code_12_maxGap;

import java.util.Arrays;

import static utils.Comparator.duplicateArray;
import static utils.Comparator.generateRandomArray;
import static utils.utils.printfArray;

public class MaxGapComparator {

    public static int maxGap(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        int len = arr.length;
        int min = getMin(arr);
        int max = getMax(arr);
        if (min == max){
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len +1];

        int bid = 0;
        for (int i=0; i<len;i++){
            bid = bucket(arr[i],len,min,max);
            mins[bid] = hasNum[bid]? Math.min(mins[bid],arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],arr[i]) : arr[i];
            hasNum[bid] = true;
        }

        int res = 0;
        int lastMax = maxs[0];
        for(int i = 1; i < arr.length; i++){
            if (hasNum[i] == true){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static  int bucket(long num, long len,long min, long max){
        return (int)((num-min)*len / (max - min));
    }

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i  < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length;i++){
            min = Math.min(min,arr[i]);
        }
        return min;
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = duplicateArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(10, maxValue);
        printfArray(arr);
        System.out.println("The maxGap is" + comparator(arr));
        printfArray(arr);

    }




}
