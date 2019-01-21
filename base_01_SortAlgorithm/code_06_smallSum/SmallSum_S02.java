package code_06_smallSum;

public class SmallSum_S02 {
    public static int getSmallSum(int[] arr){
        if (arr == null || arr.length < 2 ){
            return 0;
        }
        return calculateSmallSum(arr,0,arr.length - 1);

    }

    //在数组的排序过程中，实现求和。基本步骤为，分解、合并。
    // 求和操作再merge过程中实现。

    public static int calculateSmallSum(int[] arr,int left, int right){
        // 递归出口
        if(left == right){
            return 0;
        }

        int mid = (left + right) / 2;
        // 将原问题进行划分
        int valueLeft = calculateSmallSum(arr,left,mid);
        int valueRight = calculateSmallSum(arr,mid + 1, right);
        int valueMerge = merge(arr,left,mid,right);
        return valueLeft+valueRight+valueMerge;
    }

    /*
    记住归并排序的四大组件：
    help数字及其指针；
    左右两指针；
    * */
    public static int merge(int[] arr, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int result = 0;

        while (p1 <= mid && p2 <= right){
            if (arr[p1] < arr[p2]){
                result += arr[p1] * (right - p2 + 1);
                help[i++] = arr[p1++];
            }else {
                help[i++] = arr[p2++];
            }
        }

        while (p1<= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= right){
            help[i++] = arr[p2++];
        }

        for( i=0;i < right-left + 1;i++){
            arr[left+i] = help[i];
        }
        return result;
    }

    public static void main(String[] args){

        int[] arr = {1,3,4,2,5};
        System.out.println(getSmallSum(arr));

    }
}
