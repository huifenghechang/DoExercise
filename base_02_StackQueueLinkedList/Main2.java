import java.util.Scanner;

public class Main2 {

    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int[] use_times = new int[10];
        for (int i = 0; i < 10; i++) {
            use_times[i] = scanner.nextInt();
        }
        int len1, len2;
        len1 = scanner.nextInt();
        len2 = scanner.nextInt();
        scanner.close();
//        System.out.print(minMultiply(use_times,len1,len2));
    }

    /*public static int minMultiply(int[] use_times, int len1,int len2){
        int[] num1 = new int[len1];
        int[] num2 = new int[len2];
        for (int i=0; i< use_times.length;i++){
            for (int k=0; k < use_times[i];k++){

            }
        }


    }*/
}
