public class findDuplicates_NoChangeArray {
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2){
            return -1;
        }

        int start = 1;
        int end = nums.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;
            int count = getCount(nums,start,mid);
            if (end == start){
                if (count > 1){
                    return start;
                }else {
                    break;
                }
            }
            if (count > (mid-start+1)){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return -1;

    }

    public static int getCount(int[] arr, int start, int end){
        int count = 0;
        for (int i=0; i< arr.length;i++){
            if (arr[i]>=start && arr[i]<=end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[] arr = new int[]{3,1,3,4,2};
        int k = findDuplicate(arr);
        System.out.println(k);
    }
}
