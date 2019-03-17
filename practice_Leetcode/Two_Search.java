public class Two_Search {

    /*
    * 二分查找法，最后插入函数的位置，和数组的状态有关。
    *
    * 如果数组是偶数个，则插入位置在最终的start。
    * 如果数组是奇数个，则最终插入的位置，在最终start
    *
    *
    * */
    public static int search(int[] nums, int target) {
        if (nums == null){
            return -1;
        }

        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = (end + start)/2;

            if (target == nums[mid]){
                return mid;
            }else if (target < nums[mid]){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        System.out.println("The insert position is" + nums[start]);
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{ 0,3,4,5,9,12,15,65,87,89,99};
        search(arr,8);
    }
}

