package code_11_heapSort;

import static utils.Comparator.*;
import static utils.utils.printfArray;
import static utils.utils.swap;

public class HeapSortComparator {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0 ;i < arr.length; i++){
            heapInsert(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while (size > 0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }

    }

    // 将数组调整为大根堆,将第一个数视为一个大根堆.
    // 向上调整，形成大根堆
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }

    // 将堆顶元素变换后，向下调整，成为大根堆
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]? left + 1: left;
            largest = arr[largest] > arr[index]? largest : index;

            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1; //此行代码代表着继续向下调整。
        }
    }

    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = duplicateArray(arr1);
            heapSort(arr1);
            sortComparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printfArray(arr);
        heapSort(arr);
        printfArray(arr);
    }
}
