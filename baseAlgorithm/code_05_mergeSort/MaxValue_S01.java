package code_05_mergeSort;

public class MaxValue_S01 {
    public static void getMaxValueInArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        System.out.println("The MaxValue in the array is : " + maxValue(arr, 0, arr.length - 1));

    }

    public static int maxValue(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int midIndex = (l + r) / 2;
        int maxLeft = maxValue(arr, l, midIndex);
        int maxRight = maxValue(arr, midIndex + 1, r);
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 9, 4, 5, 895, 45,41259};
        getMaxValueInArray(arr);
    }
}
