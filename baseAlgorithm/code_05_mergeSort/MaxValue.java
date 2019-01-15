package code_05_mergeSort;

public class MaxValue {

    public static void ArrayMax(int[] arr){
        if (arr == null ){
            System.out.println("empty array");
        }
        System.out.println("the Max value in array is "+ findMax(arr,0,arr.length-1));
    }
    public static int findMax(int[] arr, int l ,int r){
        if(l == r){
            return arr[r];
        }
        int m = (l + r) / 2;
        int leftMax = findMax(arr,l,m);
        int rightMax = findMax(arr,m+1, r);
        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args){
        int[] arr = {1,3,2,9,4,5,895,45};
        ArrayMax(arr);
    }
}
