package code_06_smallSum;

public class SmallSum_S01 {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        int result = mergeSort(arr,0,arr.length - 1);
        System.out.println("The small Sum is "+result);
    }

    public static int mergeSort(int[] arr,int l, int r){
        if(l == r){
            return 0;
        }
        int mid = (l + r)/2;
        return  mergeSort(arr,l,mid)+ mergeSort(arr,mid+1,r)+ merge(arr,l,mid,r);
    }

    public static int merge(int[] arr, int l ,int m, int r){
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;  //原代码为int p2 = r
        int res = 0;
        while (p1 <= m && p2 <= r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] :0; //这一行代码未想出来！
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m){
            help[i++] = arr[p1++];
        }

        while (p2 <= r){ // 原代码的循环条件为p2 <= r
            help[i++] = arr[p2++];
        }

        for (i=0;i<r-l+1;i++){
            arr[l + i] = help[i];
        }
        return res;
    }
    public static void main(String[] args){

        int[] arr = {1,3,4,2,5};
        mergeSort(arr);

    }
}
