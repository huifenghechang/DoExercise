package code_08_arrayDivide;

import static code_02_bubbleSort.BubbleSort_Test.printArray;
import static utils.utils.swap;

/*
* 写代码的时候，现有思路。
* 思路有了之后，就可以先把变量定义好。这样算法就会十分方便的写出来了。
* */
public class ArrayDivide_S01 {

    public static void arrayDivide(int[] arr,int number){
        if (arr ==null || arr.length < 2){
            return;
        }
        int cur = 0;
        int l = cur-1; // l代表小于等于number的边界
        int r = arr.length; // r代表大于number的边界

        // 循环操作的之中条件是指针碰到右边界
        // cur指针，代表当前的指向数字。
        while (cur < r){
            if(arr[cur] <= number){
                // 若当前数比number小，则将其与L的下一个数交换，指针向下移动
                swap(arr,cur++,++l);
            }else {
                // 若当前数比 number 大，则将其余r的前一个数交换，指针不移动
                swap(arr,cur,--r);
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1,0,4};
        int number = 1;
        arrayDivide(arr,number);
        printArray(arr);

    }

}
