package code_06_CompleteTreeNodeNumber;

public class CompleteTreeNodeNumber_19_03_04 {

    public static class  Node {
        int value;
        Node left;
        Node right;

        public Node(int data){
            this.value = data;
        }
    }

    // 主函数
    public static int mainCounter(Node head){
        if (head == null){
            return 0;
        }else {
            int high = getLeftestNums(head,1);
            return countNodes(head,1,high);
        }
    }


    /*
    * 主要处理步骤：
    *
    *   1. 遍历左边界，得到高度；
    *   2. 遍历右子树，得到高度；
    *   3.比较之，分两种情况讨论
    *
    *  这里的一个关键要点，就是如何设计递归函数。这是编程中的一个重点！！！
    *       递归函数的设计；
    *           1.递归发生的条件
    *           2.递归的出口
    *           3.
    * */
    public static int countNodes(Node node,int level,int high){
        // 递归函数的递归出口
        if (level == high ){
            return 1;
        }
        // 求二叉树右子树的高度
        int rHigh = getLeftestNums(node.right,level+1);

        if (rHigh == high ){
            return (1<<(high - level )) + countNodes(node.right,level+1,high);
        }else
            // 在这种情况下，head节点的右子树为满二叉树
            {
                return (1<<(high - level - 1)) + countNodes(node.left,level+1,high);
        }
    }

    /*
    * 该函数设计的巧妙之处： 当 右子树为空时，能够返回当前数的高度为1。
    * 这说明，一个精巧的子函数，可以省去很多复杂的逻辑判断。
    * 因为在这些代码中，已经隐含着判断。
    * */

    public static int getLeftestNums(Node head,int level){
        while (head != null){
            level++;
            head = head.left;
        }
        return level - 1;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
//        head.right.left = new Node(6);

        System.out.println("The number of the completed tree is " + mainCounter(head));
    }
}
