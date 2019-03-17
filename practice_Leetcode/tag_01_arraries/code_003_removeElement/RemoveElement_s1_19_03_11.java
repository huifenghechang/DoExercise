package tag_01_arraries.code_003_removeElement;

public class RemoveElement_s1_19_03_11 {

    public int removeElement_err(int[] nums, int val) {
        if (nums == null ){
            throw  new IllegalArgumentException("The arr is null");
        }

        int more = nums.length;
        int cur = 0;

        while (cur < nums.length){
            if (nums[cur] == val){
                swap(nums,cur,--more);
            }else {
                cur++;
            }
        }
        return more;

    }

    public void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 删除元素，使用双指针法
    /*
    * 若快指针所指向的值，等于val,则继续往前走；
    * 若快指针指向的值，不等于val,则将指向的值复制给慢指针，两者一起往前走。
    * */
    public int removeElement(int[] nums, int val) {
        if (nums == null){
            throw  new  IllegalArgumentException("The argment is illegal");
        }
        int p0 = 0;
        int p1 = 0;
        while (p1 < nums.length){
            if (nums[p1] == val){
                p1++;
            }else {
                nums[p0++] = nums[p1++];
            }
        }
        return p0;
    }

    public static void main(String[] args){

    }
}
