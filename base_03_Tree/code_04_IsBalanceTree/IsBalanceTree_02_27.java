package code_04_IsBalanceTree;

public class IsBalanceTree_02_27 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }

    public static class ReturnData{
        public boolean isB;
        public int h;
        public ReturnData(boolean isB, int h){
            this.isB = isB;
            this.h = h;
        }
    }

    public static ReturnData process(Node head){
        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        if (!leftData.isB){
            return new ReturnData(false,0);
        }

        if (!rightData.isB){
            return new ReturnData(false,0);
        }

        if (Math.abs(leftData.h - rightData.h) > 1){
            return new ReturnData(false,0);
        }

        return new ReturnData(true,Math.max(leftData.h,rightData.h)+ 1);
    }


}
