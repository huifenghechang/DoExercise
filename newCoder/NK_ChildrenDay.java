package NewCoder;

import java.util.Arrays;
import java.util.Scanner;

public class NK_ChildrenDay {



        public static void main(String[] args){
           /* Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[] h = new int[n];
            for(int i=0 ; i< n; i++){
                h[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            int[] w = new int[m];
            for(int i=0 ; i< m; i++){
                w[i] = sc.nextInt();
            }*/

           int[] h = new int[]{2,2,3};
           int[] w = new int[]{3,1};
           System.out.println(getChildNum2(h,w));
        }

        public static int getChildNum(int[] h, int[] w){
            Arrays.sort(h);
            Arrays.sort(w);
            int counter = 0;
            int child = -1;
            for(int i=0; i < w.length;i++){
                for(int j = child+1; j< h.length;j++){
                    if(w[i] >= h[j]){
                        counter ++;
                        child = j;
                    }
                    break;
                }
            }
            return counter;
        }

        public static int getChildNum1(int[] h, int[] w){
        Arrays.sort(h);
        Arrays.sort(w);
        int counter = 0;
        int child = 0;
        for(int i=0; i < w.length;i++){
           if (child < h.length && h[child] < w[i]){
               child++;
               counter++;
           }
        }
        return counter;
    }

        public static int getChildNum2(int[]h, int[] w){
            Arrays.sort(h);
            Arrays.sort(w);
            int j=0;
            for (int i=0; i< w.length;i++){
                if (j < h.length && h[j]< w[i]){
                    j++;
                }
            }
            return j;
        }
}
