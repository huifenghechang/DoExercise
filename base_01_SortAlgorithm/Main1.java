import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n%2 !=0){
            return ;
        }
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int[] sum = new int[n/2];
        int i= 0,j =n-1;
        while (i<j){
            sum[i] =(arr[i++]+arr[j--]);
        }
        int result = sum[0] - sum[sum.length - 1];
        System.out.print(result);
    }
}
