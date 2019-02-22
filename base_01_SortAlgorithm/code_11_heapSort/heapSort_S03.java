package code_11_heapSort;

import static utils.Comparator.generateRandomArray;
import static utils.utils.printfArray;
import static utils.utils.swap;

public class heapSort_S03 {

    public static void heapSort(int[] arr){

        // 输入的合法性检验
        if (arr == null || arr.length < 2){
            return;
        }

        // 将完全二叉树调整为大根堆
        for (int i= 0; i < arr.length; i++){
            heapInsert(i,arr);
        }

        // 依次从栈顶弹出大根堆，实现对原数组的排序
        int heapSize = arr.length; // 经过上述调整，heapSize的长度为数字的长度。
        // 需要注意的是，数组的长度与下标之间相差 1

        // 此时，堆排序的第一步，是将堆顶置换到之后一位，然后堆的长度减小1
        while (heapSize > 0 ){
            swap(arr,0,--heapSize);
            heapify(0,arr,heapSize);
        }
    }

    // 这里，将数字插入大根堆中，需要判断
    /*
    * 1.只有在数字比其父节点大的时候，才有移动的必要
    * 2.当数字交换到达堆顶是，则无需交换了。
    * 这里，实现这两个限制的，用一个条件即可限制了：
    * arr[index] > arr[(index - 1) / 2]
    *
    * */
    public static void heapInsert(int index, int[] arr){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }

    }

    // 栈顶元素被替换后，向下调整为大根堆
    public static void heapify(int index, int[] arr ,int heapSize){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        // 被替换的堆顶元素至少存在左孩子的情况下， 才需要调整
        while (left < heapSize){
            int largest = right < heapSize && arr[right] > arr[left] ? right : left;
            largest = arr[index] > arr[largest]? index : largest;

            if (largest == index){
                break;
            }

            // 将最大值上移到栈顶
            swap(arr,largest,index);
            // 将新移动的数字，用index标记
            index = largest; // largest 为栈顶的左孩子或者右孩子
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
