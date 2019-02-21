package code_11_heapSort;

import static utils.Comparator.generateRandomArray;
import static utils.utils.printfArray;
import static utils.utils.swap;

public class HeapSort_S02 {
    /*
    * 堆排序的操作
    *
    * 一个数组，在逻辑上对应一棵完全二叉树。
    *
    * */

    public static void heapSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        // 将数组最初始看做长度为0 的大根堆
        // 最终的目的是 建立一个长度为arr.length的大根堆
        for (int i = 0; i < arr.length; i++ ){
            heapInsert(arr,i);
        }

        // 建立好大根堆之后，要想使得数组内的数字有序，则需要依次弹出堆顶。
       /*
       * 下面这一部分的代码顺序是很重要的·
       * */
        int heapSize = arr.length;
        // 堆中的最后一个元素的下标在数组中的下标为 heapsize - 1
        swap(arr,0,--heapSize);

        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);

        }


    }

    /*
    * 完全二叉树中，所有的节点，都可以看做是有父节点的。
    * 巧妙的是，根节点的父节点由公式（0- 1）/ 2 = 0 ,可以看做是它自身。
    *
    * 建立大根堆，是在完全二叉树的基础上建立的。
    * 相当于在完全二叉树上，增加一个节点。若节点的值大于父节点，则向上交换之。
    * */
    public static void heapInsert(int[] arr,int index){
        while (arr[(index - 1)/2] < arr[index]){
            swap(arr,(index - 1)/2, index);
            index = (index - 1)/2;
        }
    }

    /*
    * heapify 向下调整，重新调整为大根堆；
    * 传入三个参数：
    * 其中，heapSize 变量标识大根堆的大小，用以判断是否越界。
    * index 用以标识需要调整的节点下标
    *
    * 堆顶元素被换，需要一次向下调整。
    * 主要是和该元素的左右孩子作比较。
    * */
    public static void heapify(int[] arr,int index,int heapSize){
        int left =  2 * index + 1;
        int right = 2 * index + 2;

        // 判断是否越界，并从中找出左右孩子以及index中最大的一个
        // 出现的问题1： right 与 heapSize的大小关系比较：
        // 这里需要注意的是，right为右节点的下标，size为长度，两者之间的判断是否越界的条件为right < size 而不是 right <= heapSize.
        while (left < heapSize){
            int largest = right < heapSize && arr[right] > arr[left] ? right : left;
            largest = arr[index] > arr[largest] ? index : largest;

            // 若堆顶元素仍然为最大，则无需替换。
            if (largest == index){
                break;
            }

            // 若堆顶元素不是最大，则向下调整
            swap(arr,index,largest);
            index = largest;
            left = 2 * index + 1;
        }

    }

    public static void main(String [] args){
        int[] arr = generateRandomArray(12, 50);
        printfArray(arr);
        heapSort(arr);
        printfArray(arr);
    }

}
