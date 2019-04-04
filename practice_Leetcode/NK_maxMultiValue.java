import java.util.Arrays;
import java.util.Scanner;

public class NK_maxMultiValue {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] arr = new long[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static long getMaxMul(long[] arr){
        int n = arr.length;
        long max1 = 0;
        long max2 = 0;
        long max3 = 0;
        long min1 = 0;
        long min2 = 0;
        for (int i=0; i< n;i++){
            if (arr[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }else if (arr[i]>max2){
                max3 = max2;
                max2 = arr[i];
            }else if (arr[i]>max3){
                max3 = arr[i];
            }
            if (arr[i]< min1){
                min2 = min1;
                min1 = arr[i];
            }else if (arr[i] < min2){
                min2 = arr[i];
            }
        }
        long x = max1*max2*max3;
        long y = max1*min1*min2;
        return x > y ? x: y;
    }
}
