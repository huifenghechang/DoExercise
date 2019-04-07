public class T376_WiggleMaxLength {

    public int wiggleMaxLength190407(int[] nums) {

        /*
        *在使用switch--case结构的时候，设置case情况，需要设置一个变量来负责跳转！！！
        *
        * */

        if(nums.length < 2){
            return nums.length;
        }
        final int START = 1;
        final int UP = 2;
        final int DOWN = 3;

        int STATE = START;
        int length = 1;

        for (int i=1; i< nums.length;i++){
            switch (STATE){
                case START:{
                    if (nums[i] > nums[i-1]){
                        STATE = UP;
                        length++;
                    }else if (nums[i] < nums[i-1]){
                        STATE = DOWN;
                        length++;
                    }
                    break;
                }
                case UP:{
                    if (nums[i] < nums[i-1]){
                        STATE = DOWN;
                        length++;
                    }
                    break;
                }
                case DOWN:{
                    if (nums[i] > nums[i-1]){
                        STATE = UP;
                        length++;
                    }
                }
            }
        }
        return length;
    }

    public int wiggleMaxLength190331(int[] nums){
        final int START = 0;
        final int UP = 1;
        final int DOWN = 2;
        int STATE = START;
        int length = 1;
        for (int i = 1; i < nums.length; i++){
            switch (STATE){
                case START:
                    if (nums[i-1] < nums[i]){
                        STATE = UP;
                        length++;
                    }else if (nums[i-1] > nums[i]){
                        STATE = DOWN;
                        length++;
                    }
                    break;
                case UP:
                    if (nums[i-1] > nums[i]){
                        STATE = DOWN;
                        length++;
                    }
                    break;
                case DOWN:
                    if (nums[i-1] < nums[i]){
                        STATE = UP;
                        length++;
                    }
                    break;
            }
        }
        return length;
    }

    public int wiggleMaxLength190328(int[] nums) {

        /*
         * 摆动序列：
         * 所谓摆动序列的长度，其实就是两者连线之后，趋势UP 和 Down交替。
         * */

         final int BEGIN = 0;
         final int UP = 1;
         final int DOWN = 2;
         int STATE = BEGIN;
         int maxLength = 1;

         for (int i=1; i < nums.length;i++){
             switch (STATE){
                 case BEGIN:
                     if (nums[i-1] < nums[i]){
                         STATE = UP;
                         maxLength++;
                     }
                     else if (nums[i-1] > nums[i]){
                         STATE = DOWN;
                         maxLength++;
                     }
                     break;
                 case UP:
                     if (nums[i-1] < nums[i]){
                         STATE = DOWN;
                         maxLength++;
                     }
                     break;
                 case DOWN:
                     if (nums[i-1] > nums[i]){
                         STATE = UP;
                         maxLength++;
                     }
                     break;
             }
         }

         return maxLength;

    }
}
