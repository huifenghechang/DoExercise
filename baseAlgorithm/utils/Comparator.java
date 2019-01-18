package utils;

import code_05_mergeSort.MaxValue;

import java.util.Arrays;

import static utils.utils.printfArray;

public class Comparator {
    public static void sortComparator(int[] arr){
        Arrays.sort(arr);
    }

    //随机数发生器
    public static int[] generateRandomArray(int maxSize, int maxValue){
        // 产生随机长度的数组
        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        // 产生随机数
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue+1)*Math.random())-(int)((maxValue)*Math.random());
        }
        return arr;
    }

    public static int[] duplicateArray(int[] arrA){
        if(arrA == null){
            return null;
        }
        int[] arrB = new int[arrA.length];
        for (int j = 0;j < arrA.length;j++){
            arrB[j] = arrA[j];
        }
        return arrB;
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null)|| (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void sortTest(int testTime, int maxSize, int maxValue){
        boolean succeed = true;
        for (int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = duplicateArray(arr1);
            // 具体的排序算法，处理arr1
            sortComparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }

        int[] arr = generateRandomArray(maxSize, maxValue);
        printfArray(arr);
        // 调用所写的排序算法来计算
        printfArray(arr);
    }
}
