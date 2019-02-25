package code_13_shellSort;

import static utils.Comparator.generateRandomArray;
import static utils.utils.printfArray;

public class ShellSort_S01 {
    // 希尔排序，可以看做是引入了“增量”gap的一种插入排序
    public static void shellSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        /* 设置gap
        *  通过对gap从 N/2 递减到 1， 每次对分组中的数字进行插入排序
        *  进行log2N次希尔排序之后，数组就已经达到基本有序的状态了。
        *  当gap =1 时，便是最后对数字进行一次插排就可以了
        * */

        int N = arr.length;

        for (int gap = N/2; gap > 0; gap /= 2 ){
            // 对各个分组中的数据，进行插入排序
            for (int i = gap; i < N; i++){
                // 将arr[i[插入到所在分组的正确位置上
                insertI(arr,gap,i);
            }
        }
    }

    public static void insertI(int[] arr, int gap,int i){
        // 带插入数字arr[i],分组中前面排列好的序列为：
        // arr[i - gap],arr[i - 2*gap],...
        int inserted = arr[i];
        int j;

        for (j= i - gap;j >= 0 && inserted < arr[j]; j -= gap){
            // 若小于，则组内的前一个数字向后移动，找到带插入的位置
            arr[j+gap] = arr[j];
        }
        // 将带插入的数字，插入到指定位置。
        arr[j + gap] = inserted;
    }

    public static void main(String [] args){
        int[] arr = generateRandomArray(12, 50);
        printfArray(arr);
        shellSort(arr);
        printfArray(arr);
    }
}
