package code_11_heapSort;

import static utils.Comparator.*;
import static utils.utils.printfArray;
import static utils.utils.swap;

public class HeapSort_S01 {
    public static void heapSort(int[] arr){
        if ( arr == null || arr.length < 2){
            return;
        }

        for (int i=0; i < arr.length; i++){
            heapInsert(arr,i);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while ( heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapInsert(int[] arr,int index){
        while (arr[(index-1)/2] < arr[index]){
            swap(arr,(index-1)/2,index);
            index = (index-1)/2;
        }
    }

    // 将根换为一个新的数，向下调整为一个大根堆
    public static void heapify(int[] arr,int index,int heapSize){
        int left = 2 * index + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1 : left;
            largest =  arr[index] < arr[largest] ? largest : index;
            swap(arr,index,largest);
            if(largest == index){
                break;
            }
            index = largest;
            left = 2 * index + 1;
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
