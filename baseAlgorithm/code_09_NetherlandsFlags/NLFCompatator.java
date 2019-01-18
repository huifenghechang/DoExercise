package code_09_NetherlandsFlags;

import static code_02_bubbleSort.BubbleSort_Test.printArray;
import static utils.utils.swap;

public class NLFCompatator {

    public static void partition(int[] arr, int l, int r,int p){
        int less = l-1;
        int more = r+1;
        int cur = l;
        while (cur < more){
            if (arr[cur] < p){
                swap(arr,cur++,++less);
            }else if (arr[cur] > p){
                swap(arr,cur,--more);
            }else {
                cur++;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {4,5,3,1,9,25,7,8,6,6,6,78,4,2,78,6};
        partition(arr,0,arr.length-1,6);
        printArray(arr);
    }
}
