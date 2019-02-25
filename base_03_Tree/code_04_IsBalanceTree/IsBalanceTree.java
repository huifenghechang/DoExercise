package code_04_IsBalanceTree;

public class IsBalanceTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    // 判断一棵树，是否为平衡二叉树

    // 返回类型
    public static class ReturnData{
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h){
            this.isB = isB;
            this.h = h;
        }
    }

     public static boolean isBalanceTree(Node head){
        return process(head).isB;
     }

    public static ReturnData process(Node head){
        if (head == null){
            return new ReturnData(true,0);
        }

        // 判断左子树是否为平衡二叉树
        ReturnData leftData = process(head.left);
        if (!leftData.isB){
            return new ReturnData(false,0);
        }
        ReturnData rightData = process(head.right);

        if (!rightData.isB){
            return new ReturnData(false,0);
        }

        // 如果左右子树，均为平衡树时，若高度大于1 ，则不是平衡树
        if (Math.abs(leftData.h - rightData.h) > 1){
            return new ReturnData(false,0);
        }

        // 第四种情况，该节点为根的树，是平衡二叉树，则返回其高度
        int treeHigh = Math.max(leftData.h,rightData.h)+ 1;
        return new ReturnData(true,treeHigh);
    }

}
