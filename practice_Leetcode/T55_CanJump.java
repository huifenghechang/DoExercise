public class T55_CanJump {
    public boolean canJump(int[] nums) {
        if (nums== null){
            return false;
        }

        int size = nums.length;
        int[] index = new int[size];

        for (int i=0; i<size;i++){
            index[i] = nums[i]+i; // 统计每一步可到的最大位置
        }

        // 初始化状态
        int max_Index =  index[0];
        int jump = 0;
        while (jump < index.length && jump < max_Index){  // 多个循环条件，需要用while来循环
            if (max_Index < index[jump]){
                max_Index = jump;
            }
            jump++;
        }
        if (jump== index.length){
            return true;
        }
        return false;
    }
}
