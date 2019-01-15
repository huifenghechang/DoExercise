package utils;

public class utils {
    public static void PrintfArray(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"、");
        }
        System.out.println();
    }

    public static void swap(int[] arr ,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
